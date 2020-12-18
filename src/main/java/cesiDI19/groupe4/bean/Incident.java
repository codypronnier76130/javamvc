package cesiDI19.groupe4.bean;

import java.util.Date;

public class Incident {
	
	private Integer id;
    private Integer id_mission;
    private String declarant_Incident;
    private String lieu_Incident;
    private Date ajout_Incident;
    private String description_Incident;
	
	public Incident() {

    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeclarant_Incident() {
        return declarant_Incident;
    }

    public void setDeclarant_Incident(String declarant_incident) {
        declarant_Incident = declarant_incident;

    }
    
    public String getLieu_Incident() {
        return lieu_Incident;
    }

    public void setLieu_Incident(String lieu_incident) {
        lieu_Incident = lieu_incident;

    }
    
    public Date getDate_Incident() {

	    return ajout_Incident;
    }

    public void setDate_Incident(Date ajout_incident) {
        ajout_Incident = ajout_incident;
    }
    
    public String getDescription_Incident() {
        return description_Incident;
    }

    public void setDescription_Incident(String description_incident) {
        description_Incident = description_incident;
    }

    public Integer getId_mission() {
        return id_mission;
    }

    public void setId_mission(Integer id_mission) {
        this.id_mission = id_mission;
    }
}
