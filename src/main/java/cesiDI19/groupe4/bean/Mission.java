package cesiDI19.groupe4.bean;

import java.util.Date;

public class Mission {

    private Integer id;
    private Integer id_incident;
    private String titre_Mission;
    private String type_Mission;
    private Date date_Debut_Mission;
    private Date date_Fin_Mission;
    private String niveau_Mission;
    private String itineraire_Mission;
    private String detail_Mission;
	
	public Mission() {
    	
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre_Mission() {
        return titre_Mission;
    }

    public void setTitre_Mission(String titre_mission) {
    	titre_Mission = titre_mission;

    }
    
    public String getType_Mission() {
        return type_Mission;
    }

    public void setType_Mission(String type_mission) {
    	type_Mission = type_mission;

    }
    
    public Date getDate_Debut_Mission() {
        return date_Debut_Mission;
    }

    public void setDate_Debut_Mission(Date date_debut_mission) {
    	date_Debut_Mission = date_debut_mission;
    }
    
    public Date getDate_Fin_Mission() {
        return date_Fin_Mission;
    }

    public void setDate_Fin_Mission(Date date_fin_mission) {
    	date_Fin_Mission = date_fin_mission;
    }
    
    public String getNiveau_Mission() {
        return niveau_Mission;
    }

    public void setNiveau_Mission(String niveau_mission) {
    	niveau_Mission = niveau_mission;
    }
    
    public String getItineraire_Mission() {
        return itineraire_Mission;
    }

    public void setItineraire_Mission(String itineraire_mission) {
    	itineraire_Mission = itineraire_mission;
    }
    
    public String getDetail_Mission() {
        return detail_Mission;
    }

    public void setDetail_Mission(String detail_mission) {
    	detail_Mission = detail_mission;
    }

    public Integer getId_incident() {
        return id_incident;
    }

    public void setId_incident(Integer id_incident) {
        this.id_incident = id_incident;
    }

}
