package cesiDI19.groupe4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Mission;

@Component
public class MissionDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Mission> getAllMissions(int page, int longueurPage){
		
        List<Mission> list = new ArrayList<Mission>();
        
        try {
        list = jdbcTemplate.query("SELECT ID_MISSION, TITRE_MISSION, TYPE_MISSION, DATE_DEBUT_MISSION, DATE_FIN_MISSION, NIVEAU_MISSION, ITINERAIRE_MISSION, DETAIL_MISSION FROM MISSION", new Object[] {}, new MissionMapper());
        }catch(EmptyResultDataAccessException e) {
            // no result
        }
        
		return list;
	}
	
	private class MissionMapper implements RowMapper<Mission> {

		@Override
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
	}
}
