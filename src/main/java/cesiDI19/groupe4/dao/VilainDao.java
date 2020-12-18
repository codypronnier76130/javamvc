package cesiDI19.groupe4.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import cesiDI19.groupe4.bean.Heros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import cesiDI19.groupe4.bean.Vilain;

@Component
public class VilainDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createVilains (final Vilain p) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO `VILAIN` (`ID_CIVIL`,`MALVEILLANCE_VILAIN`) VALUES ("+p.getId_Civil()+","+p.getMalveillance()+");",
                        Statement.RETURN_GENERATED_KEYS);
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);
        int heroId = keyHolder.getKey().intValue();

        String sql = "INSERT INTO SUPER (ID_VIILAIN, NOM_SUPER, POUVOIR_SUPER, " +
                "POINT_FAIBLE_SUPER, COMMENTAIRE_SUPER)" +
                " VALUES (?,?,?,?,?)";

        return jdbcTemplate.update(sql, heroId, p.getNom_Super(), p.getPouvoir_Super(),
                p.getPoint_Faible(), p.getCommentaire());
    }



    public Vilain getHeroById(int id) {
        String sql = "SELECT VILAIN.ID_VIILAIN,VILAIN.ID_CIVIL,SUPER.ID_SUPER,NOM_CIVIL,PRENOM_CIVIL,DATE_NAISSANCE_CIVIL,ADRESSE_CIVIL,MAIL_CIVIL,TELEPHONE_CIVIL,ACTIF_CIVIL,COMMENTAIRE_CIVIL,NOM_SUPER,POUVOIR_SUPER,POINT_FAIBLE_SUPER,COMMENTAIRE_SUPER,MALVEILLANCE_VILAIN FROM VILAIN" +
                "INNER JOIN CIVIL ON (VILAIN.ID_VIILAIN = CIVIL.ID_VIILAIN)" +
                "INNER JOIN SUPER ON (VILAIN.ID_VIILAIN = SUPER.ID_VIILAIN) WHERE ID_VIILAIN = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Vilain>(Vilain.class));
    }


    public Vilain getSuperVilainById(int id) {
        String sql = "SELECT ID_SUPER,NOM_SUPER,POUVOIR_SUPER,POINT_FAIBLE_SUPER,COMMENTAIRE_SUPER FROM SUPER WHERE ID_SUPER=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Vilain>(Vilain.class));
    }

    public List<Vilain> getAllVilains(){
        return jdbcTemplate.query("SELECT VILAIN.ID_VIILAIN,VILAIN.ID_CIVIL,SUPER.ID_SUPER,NOM_CIVIL,PRENOM_CIVIL,DATE_NAISSANCE_CIVIL,ADRESSE_CIVIL,MAIL_CIVIL,TELEPHONE_CIVIL,ACTIF_CIVIL,COMMENTAIRE_CIVIL,NOM_SUPER,POUVOIR_SUPER,POINT_FAIBLE_SUPER,COMMENTAIRE_SUPER,MALVEILLANCE_VILAIN FROM VILAIN " +
                "LEFT JOIN CIVIL ON (VILAIN.ID_CIVIL = CIVIL.ID_CIVIL) " +
                "INNER JOIN SUPER ON (VILAIN.ID_VIILAIN = SUPER.ID_VIILAIN)", new RowMapper<Vilain>() {

            public Vilain mapRow(ResultSet rs, int rowNum) throws SQLException {

                Vilain vilain = new Vilain();
                vilain.setId(rs.getInt("VILAIN.ID_VIILAIN"));
                vilain.setId_Super(rs.getInt("SUPER.ID_SUPER"));
                vilain.setId_Civil(rs.getInt("VILAIN.ID_CIVIL"));
                vilain.setNom(rs.getString("NOM_CIVIL"));
                vilain.setPrenom(rs.getString("PRENOM_CIVIL"));
                vilain.setDateNaiss(rs.getDate("DATE_NAISSANCE_CIVIL"));
                vilain.setAddresse(rs.getString("ADRESSE_CIVIL"));
                vilain.setEmail(rs.getString("MAIL_CIVIL"));
                vilain.setTelephoneNumber(rs.getString("TELEPHONE_CIVIL"));
                vilain.setCommentaires(rs.getString("COMMENTAIRE_CIVIL"));
                vilain.setActifs(rs.getBoolean("ACTIF_CIVIL"));
                vilain.setNom_Super(rs.getString("NOM_SUPER"));
                vilain.setPouvoir_Super(rs.getString("POUVOIR_SUPER"));
                vilain.setPoint_Faible(rs.getString("POINT_FAIBLE_SUPER"));
                vilain.setCommentaire(rs.getString("COMMENTAIRE_SUPER"));
                vilain.setMalveillance(rs.getInt("MALVEILLANCE_VILAIN"));

                return vilain;
            }
        });



    }
}
