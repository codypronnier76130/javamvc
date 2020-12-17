package cesiDI19.groupe4.bean;

import java.util.Date;

public class Mission {

	private Integer Id;
    private String Titre_Mission;
    private String Type_Mission;
    private Date Date_Debut_Mission;
    private Date Date_Fin_Mission;
    private String Niveau_Mission;
    private String Itineraire_Mission;
    private String Detail_Mission;
	
	public Mission() {
    	
    }

    public Integer getId() {
        return Id;
    }
    
    public void setId(Integer id) {
        Id = id;
    }

    public String getTitre_Mission() {
        return Titre_Mission;
    }

    public void setTitre_Mission(String titre_mission) {
    	Titre_Mission = titre_mission;

    }
    
    public String getType_Mission() {
        return Type_Mission;
    }

    public void setType_Mission(String type_mission) {
    	Type_Mission = type_mission;

    }
    
    public Date getDate_Debut_Mission() {
        return Date_Debut_Mission;
    }

    public void setDate_Debut_Mission(Date date_debut_mission) {
    	Date_Debut_Mission = date_debut_mission;
    }
    
    public Date getDate_Fin_Mission() {
        return Date_Fin_Mission;
    }

    public void setDate_Fin_Mission(Date date_fin_mission) {
    	Date_Fin_Mission = date_fin_mission;
    }
    
    public String getNiveau_Mission() {
        return Niveau_Mission;
    }

    public void setNiveau_Mission(String niveau_mission) {
    	Niveau_Mission = niveau_mission;
    }
    
    public String getItineraire_Mission() {
        return Itineraire_Mission;
    }

    public void setItineraire_Mission(String itineraire_mission) {
    	Itineraire_Mission = itineraire_mission;
    }
    
    public String getDetail_Mission() {
        return Detail_Mission;
    }

    public void setDetail_Mission(String detail_mission) {
    	Detail_Mission = detail_mission;
    }

}
