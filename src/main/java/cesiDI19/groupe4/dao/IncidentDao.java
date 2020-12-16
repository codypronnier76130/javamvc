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

import cesiDI19.groupe4.bean.Incident;

@Component
public class IncidentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Incident> getAllIncident(int page, int longueurPage){
		
        List<Incident> list = new ArrayList<Incident>();
        
        try {
        list = jdbcTemplate.query("SELECT ID_INCIDENT, DECLARANT_INCIDENT, LIEU_INCIDENT, DATE_INCIDENT, DESCRIPTION_INCIDENT FROM INCIDENT", new Object[] {}, new IncidentMapper());
        }catch(EmptyResultDataAccessException e) {
            // no result
        }
        
		return list;
	}
	
	private class IncidentMapper implements RowMapper<Incident> {

		@Override
		public Incident mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Incident incident = new Incident();
			incident.setId(rs.getInt("ID_INCIDENT"));
			incident.setDeclarantIncident(rs.getString("DECLARANT_INCIDENT"));
			incident.setLieuIncident(rs.getString("LIEU_INCIDENT"));
			incident.setAjoutIncident(rs.getDate("DATE_INCIDENT"));
			incident.setDescriptionIncident(rs.getString("DESCRIPTION_INCIDENT"));

			
			return incident;
		}	
	}
}
