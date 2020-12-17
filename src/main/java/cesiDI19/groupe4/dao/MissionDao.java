package cesiDI19.groupe4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	String sql = "insert into MISSION(titre_mission, type_mission, date_debut_mission, date_fin_mission, niveau_mission, itineraire_mission, detail_mission)"
			+ " + values('"+p.getTitre_Mission()+"',"+p.getType_Mission()+","+p.getDate_Debut_Mission()+","+p.getDate_Fin_Mission()+","+p.getNiveau_Mission()+","+p.getItineraire_Mission()+",'"+p.getDetail_Mission()+"')";
	return jdbcTemplate.update(sql);
}

public int update (Mission p) {
	String sql = "UPDATE MISSION set titre_mission='"+p.getTitre_Mission()+"', "
			+ "type_mission="+p.getType_Mission()+",date_debut_mission="+p.getDate_Debut_Mission()+","
			+ "date_fin_mission="+p.getDate_Fin_Mission()+",niveau_mission="+p.getNiveau_Mission()+","
			+ "itineraire_mission"+p.getItineraire_Mission()+",detail_mission'"+p.getDetail_Mission()+"'"
			+ "where ID_MISSION="+p.getId()+"";
	return jdbcTemplate.update(sql);
}

public int delete(int id) {
	String sql = "delete from MISSION where ID_MISSION="+id+"";
			return jdbcTemplate.update(sql);
}

public Mission getMissionById(int id) {
	String sql = "SELECT * FROM MISSION where ID_MISSION=?";
	return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Mission>(Mission.class));
}
	
	public List<Mission> getAllMissions(){
		return jdbcTemplate.query("SELECT * FROM MISSION", new RowMapper<Mission>() {
				
		public Mission mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Mission mission = new Mission();
			mission.setId(rs.getInt("ID_MISSION"));
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
	

	public List<Mission> getAllMissions(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
}
