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

import cesiDI19.groupe4.bean.Rapport;

@Component
public class RapportDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Rapport> getAllRapport(int page, int longueurPage){
		
        List<Rapport> list = new ArrayList<Rapport>();
        
        try {
        list = jdbcTemplate.query("SELECT ID_RAPPORT, STATUS_RAPPORT FROM RAPPORT", new Object[] {}, new RapportMapper());
        }catch(EmptyResultDataAccessException e) {
            // no result
        }
        
		return list;
	}
	
	private class RapportMapper implements RowMapper<Rapport> {

		@Override
		public Rapport mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Rapport rapport = new Rapport();
			rapport.setId(rs.getInt("ID_RAPPORT"));
			rapport.setStatus_Rapport(rs.getString("STATUS_RAPPORT"));
		

			return rapport;
		}	
	}
}
