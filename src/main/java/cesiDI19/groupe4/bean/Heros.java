package cesiDI19.groupe4.bean;

import java.util.Date;

public class Heros {
    // Atribues de super héro
    private Integer Id;
    private Integer Id_Super;
    private Integer Id_Civil;
    private String Nom_Super;
    private String Is_Super;
    private Date Pouvoir_Super;
    private String Point_Faible;
    private String Commentaire;

    // Atribues de civil
    private String Nom;
    private String Prenom;
    private Date DateNaiss;
    private String Addresse;
    private String Email;
    private String TelephoneNumber;
    private Boolean Actifs;
    private String Commentaires;

    public Heros() {

    }


    // Getter And Setter
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getId_Super() {
        return Id_Super;
    }

    public void setId_Super(Integer id_Super) {
        Id_Super = id_Super;
    }

    public Integer getId_Civil() {
        return Id_Civil;
    }

    public void setId_Civil(Integer id_Civil) {
        Id_Civil = id_Civil;
    }

    public String getNom_Super() {
        return Nom_Super;
    }

    public void setNom_Super(String nom_Super) {
        Nom_Super = nom_Super;
    }

    public String getIs_Super() {
        return Is_Super;
    }

    public void setIs_Super(String is_Super) {
        Is_Super = is_Super;
    }

    public Date getPouvoir_Super() {
        return Pouvoir_Super;
    }

    public void setPouvoir_Super(Date pouvoir_Super) {
        Pouvoir_Super = pouvoir_Super;
    }

    public String getPoint_Faible() {
        return Point_Faible;
    }

    public void setPoint_Faible(String point_Faible) {
        Point_Faible = point_Faible;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String commentaire) {
        Commentaire = commentaire;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public Date getDateNaiss() {
        return DateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        DateNaiss = dateNaiss;
    }

    public String getAddresse() {
        return Addresse;
    }

    public void setAddresse(String addresse) {
        Addresse = addresse;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        TelephoneNumber = telephoneNumber;
    }

    public Boolean getActifs() {
        return Actifs;
    }

    public void setActifs(Boolean actifs) {
        Actifs = actifs;
    }

    public String getCommentaires() {
        return Commentaires;
    }

    public void setCommentaires(String commentaires) {
        Commentaires = commentaires;
    }
}