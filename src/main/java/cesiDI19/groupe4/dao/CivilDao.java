package cesiDI19.groupe4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import cesiDI19.groupe4.bean.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Civil;


//Création fonction récupération de tous les civils de la BDD
@Component
public class CivilDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Civil> getAllCivils(int page, int longueurPage) {

		List<Civil> list = new ArrayList<Civil>();

		try {
			list = jdbcTemplate.query(
					"SELECT ID_CIVIL, NOM_CIVIL, PRENOM_CIVIL, DATE_NAISSANCE_CIVIL, ADRESSE_CIVIL, MAIL_CIVIL, TELEPHONE_CIVIL, ACTIF_CIVIL, COMMENTAIRE_CIVIL, DATE_AJOUT_CIVIL, MDP_CIVIL, DATE_DERNIERE_MODIFICATION_CIVIL, DATE_DECES_CIVIL FROM CIVIL",
					new Object[] {}, new CivilMapper());
		} catch (EmptyResultDataAccessException e) {
			// no result
		}

		return list;
	}
	
	//Création de la fonction pour check si le login et mdp correspondent dans la BDD
	public Civil checklogin(String mail, String mdp) {
		Civil civil = null;
		try {
		 civil = jdbcTemplate.queryForObject("SELECT * FROM CIVIL WHERE MAIL_CIVIL = ? and MDP_CIVIL = ?",
				new Object[] { mail, mdp }, new CivilMapper());
		} catch (EmptyResultDataAccessException e) {
		
		}
		return civil;
	}

	//Création d'une fonction qui récupère l'ID d'un civil
	public Civil getCivilById( int idCivil) {
		Civil civil = null;
		try {
			civil = jdbcTemplate.queryForObject("SELECT * FROM CIVIL WHERE ID_CIVIL = ? ",
					new Object[] { idCivil}, new CivilMapper());
		} catch (EmptyResultDataAccessException e) {

		}
		return civil;
	}

	public Civil getCivById(int id) {
		String sql = "SELECT ID_CIVIL, NOM_CIVIL," +
				" PRENOM_CIVIL, DATE_NAISSANCE_CIVIL," +
				" ADRESSE_CIVIL, MAIL_CIVIL, TELEPHONE_CIVIL, ACTIF_CIVIL," +
				" COMMENTAIRE_CIVIL, MDP_CIVIL FROM CIVIL WHERE ID_CIVIL=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new CivilMapper());
	}

	//Création d'une fonction pour ajouter un compte dans la BDD
	public int save (Civil crt) {
		String sql = "INSERT INTO CIVIL (ID_CIVIL, NOM_CIVIL, PRENOM_CIVIL, DATE_NAISSANCE_CIVIL, " +
				"ADRESSE_CIVIL, MAIL_CIVIL, TELEPHONE_CIVIL, COMMENTAIRE_CIVIL, " +
				"MDP_CIVIL) VALUES (?,?,?,?,?,?,?,?,?)";

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getDefault());

		return jdbcTemplate.update(sql, crt.getId(), crt.getNom(), crt.getPrenom(), dateFormat.format(crt.getDateNaiss()),
				crt.getAdresse(), crt.getEmail(), crt.getTelephoneNumber(), crt.getCommentaires(),
				crt.getMdp());
	}
	
	//Création d'une fonction pour mettre à jour son profil
	public int update (Civil crt) {
		String sql = "UPDATE CIVIL " +
				"SET " +
				"NOM_CIVIL=?," +
				"PRENOM_CIVIL=?," +
				"DATE_NAISSANCE_CIVIL=?," +
				"ADRESSE_CIVIL=?," +
				"MAIL_CIVIL=?," +
				"TELEPHONE_CIVIL=?," +
				"COMMENTAIRE_CIVIL=? ," +
				"MDP_CIVIL=? " +
				"WHERE ID_CIVIL = ? ";

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getDefault());

		return jdbcTemplate.update(sql, crt.getNom(), crt.getPrenom(), dateFormat.format(crt.getDateNaiss()),
				crt.getAdresse(), crt.getEmail(), crt.getTelephoneNumber(), crt.getCommentaires(),
				crt.getMdp(), crt.getId());
	}



	private class CivilMapper implements RowMapper<Civil> {

		@Override
		public Civil mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Civil civil = new Civil();
			civil.setId(rs.getInt("ID_CIVIL"));
			civil.setNom(rs.getString("NOM_CIVIL"));
			civil.setPrenom(rs.getString("PRENOM_CIVIL"));
			civil.setDateNaiss(rs.getDate("DATE_NAISSANCE_CIVIL"));
			civil.setAdresse(rs.getString("ADRESSE_CIVIL"));
			civil.setEmail(rs.getString("MAIL_CIVIL"));
			civil.setTelephoneNumber(rs.getString("TELEPHONE_CIVIL"));
			civil.setActifs(rs.getBoolean("ACTIF_CIVIL"));
			civil.setCommentaires(rs.getString("COMMENTAIRE_CIVIL"));
			civil.setMdp(rs.getString("MDP_CIVIL"));

			return civil;
		}
	}
}
