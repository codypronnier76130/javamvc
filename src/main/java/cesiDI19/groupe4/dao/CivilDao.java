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

import cesiDI19.groupe4.bean.Civil;

@Component
public class CivilDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Civil> getAllCivils(int page, int longeurPage){
		
        List<Civil> list = new ArrayList<Civil>();
        
        try {
        list = jdbcTemplate.query("SELECT ID_CIVIL, NOM_CIVIL, PRENOM_CIVIL FROM CIVIL", new Object[] {}, new CivilMapper());
        }catch(EmptyResultDataAccessException e) {
            // no result
        }
        
		return list;
	}
	
	private class CivilMapper implements RowMapper<Civil> {

		@Override
		public Civil mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Civil civil = new Civil();
			civil.setId(rs.getInt("ID_CIVIL"));
			civil.setNom(rs.getString("NOM_CIVIL"));
			civil.setPrenom(rs.getString("PRENOM_CIVIL"));
			
			return civil;
		}	
	}
}
