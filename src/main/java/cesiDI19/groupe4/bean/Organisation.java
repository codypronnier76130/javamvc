package cesiDI19.groupe4.bean;

import java.util.Date;

public class Organisation {
	
    private Integer id;
    private Integer id_civil;
    private String nom_Organisation;
    private Date date_Ajout_Organisation;
    private Date date_Derniere_Modification_Organisation;
    private String adresse_Organisation;
    private String commentaires_Organisation;
    
   public Organisation() {
    	
    }

   public Integer getId() {
       return id;
   }

   public void setId(Integer id) { this.id = id; }
   
   public String getNom_Organisation() {
       return nom_Organisation;
   }

   public void setNom_Organisation(String nom_organisation) { nom_Organisation = nom_organisation; }
   
   public Date getDate_Ajout_Organisation() {
       return date_Ajout_Organisation;
   }

   public void setDate_Ajout_Organisation(Date date_ajout_organisation) { date_Ajout_Organisation = date_ajout_organisation; }
   
   public Date getDate_Derniere_Modification_Organisation() {
       return date_Derniere_Modification_Organisation;
   }

   public void setDate_Derniere_Modification_Organisation(Date date_derniere_modification_organisation) { date_Derniere_Modification_Organisation = date_derniere_modification_organisation; }

   public String getAdresse_Organisation() { return adresse_Organisation; }

   public void setAdresse_Organisation(String adresse_organisation) { adresse_Organisation = adresse_organisation; }

   public String getCommentaires_Organisation() { return commentaires_Organisation; }

   public void setCommentaires_Organisation(String commentaires) { commentaires_Organisation = commentaires; }

    public Integer getId_civil() {
        return id_civil;
    }

    public void setId_civil(Integer id_civil) {
        this.id_civil = id_civil;
    }


}
    