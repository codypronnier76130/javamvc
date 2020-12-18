package cesiDI19.groupe4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import cesiDI19.groupe4.bean.Incident;

@Component
@Repository
public class IncidentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	//Requête SQL permettant d'ajouter un incident dans la BDD
	public int saveincident (Incident p) {
		String sql = "INSERT INTO INCIDENT (ID_MISSION, DECLARANT_INCIDENT, LIEU_INCIDENT," +
				" DATE_INCIDENT, DESCRIPTION_INCIDENT)" +
				" VALUES (?,?,?,?,?)";

		//Fonction permettant le formatage de la Date en année/mois/jour
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getDefault());

		return jdbcTemplate.update(sql, p.getId_mission(), p.getDeclarant_Incident(), p.getLieu_Incident(),
				dateFormat.format(p.getDate_Incident()), p.getDescription_Incident());
	}

	//Requête SQL permettant la modification de l'incident via son ID
	public int update (Incident p) {
		String sql = "UPDATE INCIDENT " +
				"SET " +
				"DECLARANT_INCIDENT=?," +
				"LIEU_INCIDENT=?," +
				"DATE_INCIDENT=?," +
				"DESCRIPTION_INCIDENT=? " +
				"WHERE ID_INCIDENT = ?";

		//Fonction permettant le formatage de la Date en année/mois/jour
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getDefault());

		return jdbcTemplate.update(sql, p.getDeclarant_Incident(), p.getLieu_Incident(),
				dateFormat.format(p.getDate_Incident()), p.getDescription_Incident(),p.getId());
	}

	//Requête SQL permettant la suppresion de l'incident via son ID
	public int delete(int id) {
		String sql = "delete from INCIDENT where ID_INCIDENT="+id+"";
		return jdbcTemplate.update(sql);
	}

	//Requête SQL permettant de récupérer les données de la table Incident
	public Incident getIncidentById(int id) {
		String sql = "SELECT ID_INCIDENT as ID, ID_SATISFACTION, ID_MISSION, DECLARANT_INCIDENT, LIEU_INCIDENT," +
				" DATE_INCIDENT,DESCRIPTION_INCIDENT FROM INCIDENT where ID_INCIDENT=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Incident>(Incident.class));
	}

	//Requête SQL permettant de faire le lien avec la BDD
	public List<Incident> getAllIncident(){
		return jdbcTemplate.query("SELECT * FROM INCIDENT", new RowMapper<Incident>() {

			public Incident mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Incident incident = new Incident();
				incident.setId(rs.getInt("ID_INCIDENT"));
				incident.setId_mission(rs.getInt("ID_MISSION"));
				incident.setDeclarant_Incident(rs.getString("DECLARANT_INCIDENT"));
				incident.setLieu_Incident(rs.getString("LIEU_INCIDENT"));
				incident.setDate_Incident(rs.getDate("DATE_INCIDENT"));
				incident.setDescription_Incident(rs.getString("DESCRIPTION_INCIDENT"));

				return incident;
			}
		});
	}
}
