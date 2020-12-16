package cesiDI19.groupe4.bean;

import java.util.Date;

public class Incident {
	
	private Integer Id;
    private String DeclarantIncident;
    private String LieuIncident;
    private Date AjoutIncident;
    private String DescriptionIncident;
	
	public Incident() {
    	
    }

    public Integer getId() {
        return Id;
    }
    
    public void setId(Integer id) {
        Id = id;
    }

    public String getDeclarantIncident() {
        return DeclarantIncident;
    }

    public void setDeclarantIncident(String declarantincident) {
        DeclarantIncident = declarantincident;

    }
    
    public String getLieuIncident() {
        return LieuIncident;
    }

    public void setLieuIncident(String lieuincident) {
        LieuIncident = lieuincident;

    }
    
    public Date getAjoutIncident() {
        return AjoutIncident;
    }

    public void setAjoutIncident(Date ajoutincident) {
        AjoutIncident = ajoutincident;
    }
    
    public String getDescriptionIncident() {
        return DescriptionIncident;
    }

    public void setDescriptionIncident(String descriptionincident) {
        DescriptionIncident = descriptionincident;
    }
}
