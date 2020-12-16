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

import cesiDI19.groupe4.bean.Satisfaction;

@Component
public class SatisfactionDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Satisfaction> getAllSatisfactions(int page, int longueurPage){
		
        List<Satisfaction> list = new ArrayList<Satisfaction>();
        
        try {
        list = jdbcTemplate.query("SELECT ID_SATISFACTION, NOTE_SATISFACTION, COMMENTAIRE_SATISFACTION FROM SATISFACTION", new Object[] {}, new SatisfactionMapper());
        }catch(EmptyResultDataAccessException e) {
            // no result
        }
        
		return list;
	}
	
	private class SatisfactionMapper implements RowMapper<Satisfaction> {

		@Override
		public Satisfaction mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Satisfaction satisfaction = new Satisfaction();
			satisfaction.setId(rs.getInt("ID_SATISFACTION"));
			satisfaction.setNote_Satisfaction(rs.getString("NOTE_SATISFACTION"));
			satisfaction.setCommentaire_Satisfaction(rs.getString("COMMENTAIRE_SATISFACTION"));
			
			return satisfaction;
		}	
	}
}
