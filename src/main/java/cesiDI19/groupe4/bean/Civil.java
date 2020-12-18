package cesiDI19.groupe4.bean;

import java.util.Date;

public class Civil {
	
    private Integer Id;
    private String Nom;
    private String Prenom;
    private Date DateNaiss;
    private String Adresse;
    private String Email;
    private String TelephoneNumber;
    private Boolean Actifs;
    private String Commentaires;
    private String Mdp;
    private Date DateDeces;

    public Civil() {
    	
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
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

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String Mdp) { this.Mdp = Mdp; }

    public Date getDateDeces() { return DateDeces; }

    public void setDateDeces(Date dateDeces) {
        DateDeces = dateDeces;
    }
}