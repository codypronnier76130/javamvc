package cesiDI19.groupe4.bean;

import java.util.Date;

public class Organisation {
	
    private Integer Id;
    private String Nom;
    private Date AjoutOrg;
    private Date DerniereModif;
    private String Adresse;
    private String Commentaires;
    
   public Organisation() {
    	
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
   
   public Date getAjoutOrg() {
       return AjoutOrg;
   }

   public void setAjoutOrg(Date ajoutOrg) {
       AjoutOrg = ajoutOrg;
   }
   
   public Date getDerniereModif() {
       return DerniereModif;
   }

   public void setDerniereModif(Date derniereModif) {
       DerniereModif = derniereModif;
   }
   
   public String getAdresse() {
       return Adresse;
   }

   public void setAdresse(String addresse) {
       Adresse = addresse;
   }
   
   public String getCommentaires() {
       return Commentaires;
   }

   public void setCommentaires(String commentaires) {
       Commentaires = commentaires;
   }
    
    
    
}
    