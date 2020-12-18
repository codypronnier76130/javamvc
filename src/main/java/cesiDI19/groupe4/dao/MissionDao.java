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

import cesiDI19.groupe4.bean.Mission;

@Component
@Repository
public class MissionDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
public void setTemplate(JdbcTemplate template) {
	this.jdbcTemplate = template;
}

public int save (Mission p) {
	String sql = "INSERT INTO MISSION (ID_INCIDENT, TITRE_MISSION, TYPE_MISSION, DATE_DEBUT_MISSION, " +
			"DATE_FIN_MISSION, NIVEAU_MISSION, ITINERAIRE_MISSION, DETAIL_MISSION)" +
			" VALUES (?,?,?,?,?,?,?,?)";

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat.setTimeZone(TimeZone.getDefault());

	return jdbcTemplate.update(sql, p.getId_incident(), p.getTitre_Mission(), p.getType_Mission(), dateFormat.format(p.getDate_Debut_Mission()),
			dateFormat.format(p.getDate_Fin_Mission()), p.getNiveau_Mission(), p.getItineraire_Mission(), p.getDetail_Mission());
}

public int update (Mission p) {
	String sql = "UPDATE MISSION " +
			"SET " +
			"TITRE_MISSION=?," +
			"TYPE_MISSION=?," +
			"DATE_DEBUT_MISSION=?," +
			"DATE_FIN_MISSION=?," +
			"NIVEAU_MISSION=?," +
			"ITINERAIRE_MISSION=?," +
			"DETAIL_MISSION=? " +
			"WHERE ID_MISSION = ?";

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat.setTimeZone(TimeZone.getDefault());

	return jdbcTemplate.update(sql, p.getTitre_Mission(), p.getType_Mission(), dateFormat.format(p.getDate_Debut_Mission()),
			dateFormat.format(p.getDate_Fin_Mission()), p.getNiveau_Mission(), p.getItineraire_Mission(), p.getDetail_Mission(), p.getId());
}

public int delete(int id) {
	String sql = "delete from MISSION where ID_MISSION="+id+"";
			return jdbcTemplate.update(sql);
}

public Mission getMissionById(int id) {
	String sql = "SELECT ID_MISSION as ID, ID_RAPPORT, ID_INCIDENT, TITRE_MISSION, TYPE_MISSION, DATE_DEBUT_MISSION, " +
			"DATE_FIN_MISSION, NIVEAU_MISSION, ITINERAIRE_MISSION, DETAIL_MISSION FROM MISSION where ID_MISSION=?";
	return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Mission>(Mission.class));
}
	
	public List<Mission> getAllMissions(){
		return jdbcTemplate.query("SELECT * FROM MISSION", new RowMapper<Mission>() {
				
		public Mission mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Mission mission = new Mission();
			mission.setId(rs.getInt("ID_MISSION"));
			mission.setId_incident(rs.getInt("ID_INCIDENT"));
			mission.setTitre_Mission(rs.getString("TITRE_MISSION"));
			mission.setType_Mission(rs.getString("TYPE_MISSION"));
			mission.setDate_Debut_Mission(rs.getDate("DATE_DEBUT_MISSION"));
			mission.setDate_Fin_Mission(rs.getDate("DATE_FIN_MISSION"));
			mission.setNiveau_Mission(rs.getString("NIVEAU_MISSION"));
			mission.setItineraire_Mission(rs.getString("ITINERAIRE_MISSION"));
			mission.setDetail_Mission(rs.getString("DETAIL_MISSION"));
			
			return mission;
		}
	});
}
}
