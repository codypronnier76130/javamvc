package cesiDI19.groupe4.bean;

import java.util.Date;

public class Incident {
	
	private Integer Id;
    private String Declarant_Incident;
    private String Lieu_Incident;
    private Date Date_Incident;
    private String Description_Incident;
	
	public Incident() {
    	
    }
	
	

    public Integer getId() {
        return Id;
    }
    
    public void setId(Integer id) {
        Id = id;
    }

    public String getDeclarant_Incident() {
        return Declarant_Incident;
    }

    public void setDeclarant_Incident(String declarant_incident) {
        Declarant_Incident = declarant_incident;

    }
    
    public String getLieu_Incident() {
        return Lieu_Incident;
    }

    public void setLieu_Incident(String lieu_incident) {
        Lieu_Incident = lieu_incident;

    }
    
    public Date getDate_Incident() {
        return Date_Incident;
    }

    public void setDate_Incident(Date date_incident) {
        Date_Incident = date_incident;
    }
    
    public String getDescription_Incident() {
        return Description_Incident;
    }

    public void setDescritpion(String description_incident) {
        Description_Incident = description_incident;
    }
}
