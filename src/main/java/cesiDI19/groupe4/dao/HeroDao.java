package cesiDI19.groupe4.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import cesiDI19.groupe4.bean.Mission;
import cesiDI19.groupe4.bean.Vilain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Heros;

@Component
public class HeroDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }




    // Fonction création héros et requète SQL INSERT
    public int createHero (final int idCivil, Heros p) {
            PreparedStatementCreator psc = new PreparedStatementCreator() {

                @Override
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO `HEROS` (`ID_CIVIL`) VALUES (?);",
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, idCivil);
                    return ps;
                }
            };
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(psc, keyHolder);
            int heroId = keyHolder.getKey().intValue();

            String sql = "INSERT INTO SUPER (ID_HEROS, NOM_SUPER, POUVOIR_SUPER, " +
                "POINT_FAIBLE_SUPER, COMMENTAIRE_SUPER)" +
                " VALUES (?,?,?,?,?)";


            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            dateFormat.setTimeZone(TimeZone.getDefault());


            return jdbcTemplate.update(sql, heroId, p.getNom_Super(), p.getPouvoir_Super(),
                    p.getPoint_Faible(), p.getCommentaire_Super());
    }
    
    //Création de la requête SQL pour update le héros
    public int updateHero (Heros p) {
        String sql = "UPDATE SUPER " +
                     "SET " +
                     "NOM_SUPER=?," +
                     "POUVOIR_SUPER=?," +
                     "POINT_FAIBLE_SUPER=?," +
                     "COMMENTAIRE_SUPER=? " +
                     "WHERE ID_SUPER = ?";

        return jdbcTemplate.update(sql, p.getNom_Super(), p.getPouvoir_Super()
              , p.getPoint_Faible(), p.getCommentaire_Super(), p.getId_Super());
    }



    //Fonction qui récupère l'ID du héros
    public Heros getHeroById(int id) {
        String sql = "SELECT HEROS.ID_HEROS,HEROS.ID_CIVIL,SUPER.ID_SUPER,NOM_CIVIL,PRENOM_CIVIL,DATE_NAISSANCE_CIVIL,ADRESSE_CIVIL,MAIL_CIVIL,TELEPHONE_CIVIL,ACTIF_CIVIL,COMMENTAIRE_CIVIL,NOM_SUPER,POUVOIR_SUPER,POINT_FAIBLE_SUPER,COMMENTAIRE_SUPER FROM HEROS INNER JOIN CIVIL ON (HEROS.ID_CIVIL = CIVIL.ID_CIVIL) INNER JOIN SUPER ON (HEROS.ID_HEROS = SUPER.ID_HEROS)  where ID_HEROS=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Heros>(Heros.class));
    }

    //Fonciton qui récupère l'ID du SUPER
    public Heros getSuperById(int id) {
        String sql = "SELECT ID_SUPER,NOM_SUPER,POUVOIR_SUPER,POINT_FAIBLE_SUPER,COMMENTAIRE_SUPER FROM SUPER WHERE ID_SUPER=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Heros>(Heros.class));
    }

    //Fonction pour récupérer tous les héros de la BDD
    public List<Heros> getAllHeros(){
        return jdbcTemplate.query("SELECT HEROS.ID_HEROS,HEROS.ID_CIVIL,SUPER.ID_SUPER,NOM_CIVIL,PRENOM_CIVIL,DATE_NAISSANCE_CIVIL,ADRESSE_CIVIL,MAIL_CIVIL,TELEPHONE_CIVIL,ACTIF_CIVIL,COMMENTAIRE_CIVIL,NOM_SUPER,POUVOIR_SUPER,POINT_FAIBLE_SUPER,COMMENTAIRE_SUPER FROM HEROS INNER JOIN CIVIL ON (HEROS.ID_CIVIL = CIVIL.ID_CIVIL) INNER JOIN SUPER ON (HEROS.ID_HEROS = SUPER.ID_HEROS)", new RowMapper<Heros>() {
            public Heros mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                Heros hero = new Heros();
                hero.setId(rs.getInt("HEROS.ID_HEROS"));
                hero.setId_Super(rs.getInt("SUPER.ID_SUPER"));
                hero.setId_Civil(rs.getInt("HEROS.ID_CIVIL"));
                hero.setNom(rs.getString("NOM_CIVIL"));
                hero.setPrenom(rs.getString("PRENOM_CIVIL"));
                hero.setDateNaiss(rs.getDate("DATE_NAISSANCE_CIVIL"));
                hero.setAddresse(rs.getString("ADRESSE_CIVIL"));
                hero.setEmail(rs.getString("MAIL_CIVIL"));
                hero.setTelephoneNumber(rs.getString("TELEPHONE_CIVIL"));
                hero.setCommentaires(rs.getString("COMMENTAIRE_CIVIL"));
                hero.setActifs(rs.getBoolean("ACTIF_CIVIL"));
                hero.setNom_Super(rs.getString("NOM_SUPER"));
                hero.setPouvoir_Super(rs.getString("POUVOIR_SUPER"));
                hero.setPoint_Faible(rs.getString("POINT_FAIBLE_SUPER"));
                hero.setCommentaire_Super(rs.getString("COMMENTAIRE_SUPER"));

                return hero;
            }
        });



    }
}
