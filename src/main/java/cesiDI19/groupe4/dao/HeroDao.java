package cesiDI19.groupe4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cesiDI19.groupe4.bean.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Heros;

@Component
public class HeroDao {
    @Autowired
    JdbcTemplate jdbcTemplate;



    public int createHero (Heros p) {
        String sql = "";
        return jdbcTemplate.update(sql);
    }


    public List<Heros> getAllHeros(int page, int longeurPage){

        List<Heros> list = new ArrayList<Heros>();

        try {
            list = jdbcTemplate.query("SELECT HEROS.ID_HEROS,HEROS.ID_CIVIL,HEROS.ID_SUPER,NOM_CIVIL,PRENOM_CIVIL,DATE_NAISSANCE_CIVIL,ADRESSE_CIVIL,MAIL_CIVIL,TELEPHONE_CIVIL,ACTIF_CIVIL,COMMENTAIRE_CIVIL,NOM_SUPER,POUVOIR_SUPER,POINT_FAIBLE_SUPER,COMMENTAIRE_SUPER FROM HEROS " +
                            "INNER JOIN CIVIL ON (HEROS.ID_HEROS = CIVIL.ID_HEROS) " +
                            "INNER JOIN SUPER ON (HEROS.ID_HEROS = SUPER.ID_HEROS) "

                    , new Object[] {}, new HeroMapper());
        }catch(EmptyResultDataAccessException e) {
            // no result
        }

        return list;
    }

    public Heros getMissionById(int id) {
        String sql ="SELECT HEROS.ID_HEROS,HEROS.ID_CIVIL,HEROS.ID_SUPER,NOM_CIVIL,PRENOM_CIVIL,DATE_NAISSANCE_CIVIL,ADRESSE_CIVIL,MAIL_CIVIL,TELEPHONE_CIVIL,ACTIF_CIVIL,COMMENTAIRE_CIVIL,NOM_SUPER,POUVOIR_SUPER,POINT_FAIBLE_SUPER,COMMENTAIRE_SUPER FROM HEROS " +
                "INNER JOIN CIVIL ON (HEROS.ID_HEROS = CIVIL.ID_HEROS) " +
                "INNER JOIN SUPER ON (HEROS.ID_HEROS = SUPER.ID_HEROS) " +
                " WHERE ID_HEROS="+id+"";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Heros>(Heros.class));
    }





    public int update (Mission p) {
        String sql = "";
        return jdbcTemplate.update(sql);
    }



    public int delete(int id) {
        String sql = "delete from HEROS where ID_HEROS="+id+"";
        return jdbcTemplate.update(sql);
    }



    private class HeroMapper implements RowMapper<Heros> {

        @Override
        public Heros mapRow(ResultSet rs, int rowNum) throws SQLException {
            // TODO Auto-generated method stub
            Heros hero = new Heros();
            hero.setId(rs.getInt("HEROS.ID_HEROS"));
            hero.setId_Super(rs.getInt("HEROS.ID_SUPER"));
            hero.setId_Civil(rs.getInt("HEROS.ID_CIVIL"));
            hero.setNom(rs.getString("NOM_CIVIL"));
            hero.setPrenom(rs.getString("PRENOM_CIVIL"));
            //hero.setDateNaiss(rs.getDate("DATE_NAISSANCE_CIVIL"));
            hero.setAddresse(rs.getString("ADRESSE_CIVIL"));
            hero.setEmail(rs.getString("MAIL_CIVIL"));
            hero.setTelephoneNumber(rs.getString("TELEPHONE_CIVIL"));
            hero.setCommentaires(rs.getString("COMMENTAIRE_CIVIL"));
            //hero.setActifs(rs.getBool("ACTIF_CIVIL"));


            hero.setNom_Super(rs.getString("NOM_SUPER"));
            hero.setPouvoir_Super(rs.getString("POUVOIR_SUPER"));
            hero.setPoint_Faible(rs.getString("POINT_FAIBLE_SUPER"));
            hero.setCommentaire_Super(rs.getString("COMMENTAIRE_SUPER"));
            return hero;
        }
    }
}
