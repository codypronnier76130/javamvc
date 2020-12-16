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

import cesiDI19.groupe4.bean.Vilain;

@Component
public class VilainDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Vilain> getAllVilains(int page, int longeurPage){

        List<Vilain> list = new ArrayList<Vilain>();

        try {
            list = jdbcTemplate.query("SELECT VILAIN.ID_VIILAIN,VILAIN.ID_CIVIL,VILAIN.ID_SUPER,NOM_CIVIL,PRENOM_CIVIL,DATE_NAISSANCE_CIVIL,ADRESSE_CIVIL,MAIL_CIVIL,TELEPHONE_CIVIL,COMMENTAIRE_CIVIL,NOM_SUPER,POUVOIR_SUPER,POINT_FAIBLE_SUPER,COMMENTAIRE_SUPER,MALVEILLANCE_VILAIN FROM VILAIN " +
                            "INNER JOIN CIVIL ON (VILAIN.ID_VIILAIN = CIVIL.ID_VIILAIN) " +
                            "INNER JOIN SUPER ON (VILAIN.ID_VIILAIN = SUPER.ID_VIILAIN) "
                    , new Object[] {}, new VilainMapper());
        }catch(EmptyResultDataAccessException e) {
            // no result
        }

        return list;
    }

    private class VilainMapper implements RowMapper<Vilain> {

        @Override
        public Vilain mapRow(ResultSet rs, int rowNum) throws SQLException {
            // TODO Auto-generated method stub
            Vilain vilain = new Vilain();
            vilain.setId(rs.getInt("VILAIN.ID_VIILAIN"));
            vilain.setId_Super(rs.getInt("VILAIN.ID_SUPER"));
            vilain.setId_Civil(rs.getInt("VILAIN.ID_CIVIL"));
            vilain.setNom(rs.getString("NOM_CIVIL"));
            vilain.setPrenom(rs.getString("PRENOM_CIVIL"));
            //vilain.setDateNaiss(rs.getDate("DATE_NAISSANCE_CIVIL"));
            vilain.setAddresse(rs.getString("ADRESSE_CIVIL"));
            vilain.setEmail(rs.getString("MAIL_CIVIL"));
            vilain.setTelephoneNumber(rs.getString("TELEPHONE_CIVIL"));
            vilain.setCommentaires(rs.getString("COMMENTAIRE_CIVIL"));
            //hero.setActifs(rs.getBool("ACTIF_CIVIL"));


            vilain.setNom_Super(rs.getString("NOM_SUPER"));
            vilain.setPouvoir_Super(rs.getString("POUVOIR_SUPER"));
            vilain.setPoint_Faible(rs.getString("POINT_FAIBLE_SUPER"));
            vilain.setCommentaire(rs.getString("COMMENTAIRE_SUPER"));

            vilain.setMalveillance(rs.getInt("MALVEILLANCE_VILAIN"));
            return vilain;
        }
    }
}
