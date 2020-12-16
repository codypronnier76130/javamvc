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

import cesiDI19.groupe4.bean.Organisation;

@Component
public class OrganisationDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Organisation> getAllOrganisations(int page, int longueurPage){
		
        List<Organisation> list = new ArrayList<Organisation>();
        
        try {
        list = jdbcTemplate.query("SELECT ID_ORGANISATION, NOM_ORGANISATION, ADRESSE_ORGANISATION, COMMENTAIRE_ORGANISATION, DATE_AJOUT_ORGANISATION, DATE_DERNIERE_MODIFICATION_ORGANISATION FROM ORGANISATION", new Object[] {}, new OrganisationMapper());
        }catch(EmptyResultDataAccessException e) {
            // no result
        }
        
		return list;
	}
	
	private class OrganisationMapper implements RowMapper<Organisation> {

		@Override
		public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Organisation organisation = new Organisation();
			organisation.setId(rs.getInt("ID_ORGANISATION"));
			organisation.setNom(rs.getString("NOM_ORGANISATION"));
			organisation.setAdresse(rs.getString("ADRESSE_ORGANISATION"));
			organisation.setCommentaires(rs.getString("COMMENTAIRE_ORGANISATION"));
			organisation.setAjoutOrg(rs.getDate("DATE_AJOUT_ORGANISATION"));
			organisation.setDerniereModif(rs.getDate("DATE_DERNIERE_MODIFICATION_ORGANISATION"));
			
			return organisation;
		}	
	}
}
