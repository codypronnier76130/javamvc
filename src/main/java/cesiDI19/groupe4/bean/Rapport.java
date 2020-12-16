package cesiDI19.groupe4.bean;

public class Rapport {

	private Integer Id;
    private String Status_Rapport;
	
	public Rapport() {
		
	}
	
    public Integer getId() {
        return Id;
    }
    
    public void setId(Integer id) {
        Id = id;
    }
    
    public String getStatus_Rapport() {
        return Status_Rapport;
    }

    public void setStatus_Rapport(String status_rapport) {
    	Status_Rapport = status_rapport;

    }
    
}
 