package cesiDI19.groupe4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import com.mysql.cj.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import cesiDI19.groupe4.bean.Organisation;

@Component
@Repository
public class OrganisationDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

public void setTemplate(JdbcTemplate template) {this.jdbcTemplate = template; }

public int save (Organisation o) {
	String sql = "INSERT INTO ORGANISATION (ID_CIVIL, NOM_ORGANISATION, ADRESSE_ORGANISATION ,COMMENTAIRE_ORGANISATION, " +
			"DATE_AJOUT_ORGANISATION, DATE_DERNIERE_MODIFICATION_ORGANISATION)" +
			" VALUES (?,?,?,?,?,?)";

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat.setTimeZone(TimeZone.getDefault());

	return jdbcTemplate.update(sql, o.getNom_Organisation(), o.getAdresse_Organisation(), o.getCommentaires_Organisation(),
			dateFormat.format(o.getDate_Ajout_Organisation()), dateFormat.format(o.getDate_Derniere_Modification_Organisation()), o.getId());
}


public int update (Organisation o){
	String sql = "UPDATE ORGANISATION " +
			"SET " +
			"NOM_ORGANISATION = ?," +
			"ADRESSE_ORGANISATION = ?," +
			"COMMENTAIRE_ORGANISATION = ?," +
			"DATE_AJOUT_ORGANISATION = ?," +
			"DATE_DERNIERE_MODIFICATION_ORGANISATION = ? " +
			"WHERE ID_ORGANISATION = ?";

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat.setTimeZone(TimeZone.getDefault());

	return jdbcTemplate.update(sql, o.getNom_Organisation(), o.getAdresse_Organisation(), o.getCommentaires_Organisation(),
			dateFormat.format(o.getDate_Ajout_Organisation()), dateFormat.format(o.getDate_Derniere_Modification_Organisation()), o.getId());
}

public int delete(int id){
String sql = "DELETE FROM ORGANISATION WHERE ID_ORGANISATION="+id+"";
	return jdbcTemplate.update(sql);
}

public Organisation getOrganisationById(int id){
String sql = "SELECT ID_ORGANISATION as ID, ID_CIVIL, NOM_ORGANISATION, ADRESSE_ORGANISATION, COMMENTAIRE_ORGANISATION, DATE_AJOUT_ORGANISATION, DATE_DERNIERE_MODIFICATION_ORGANISATION FROM ORGANISATION where ID_ORGANISATION=?";
	return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Organisation>(Organisation.class));
}


public List<Organisation> getAllOrganisations(){
	return jdbcTemplate.query("SELECT * FROM ORGANISATION", new RowMapper<Organisation>() {

		public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Organisation organisation = new Organisation();
			organisation.setId(rs.getInt("ID_ORGANISATION"));
			organisation.setId_civil(rs.getInt("ID_CIVIL"));
			organisation.setNom_Organisation(rs.getString("NOM_ORGANISATION"));
			organisation.setAdresse_Organisation(rs.getString("ADRESSE_ORGANISATION"));
			organisation.setCommentaires_Organisation(rs.getString("COMMENTAIRE_ORGANISATION"));
			organisation.setDate_Ajout_Organisation(rs.getDate("DATE_AJOUT_ORGANISATION"));
			organisation.setDate_Derniere_Modification_Organisation(rs.getDate("DATE_DERNIERE_MODIFICATION_ORGANISATION"));

			return organisation;
		}
	});
}
}
