package cesiDI19.groupe4.bean;

public class Satisfaction {

	
	private Integer Id;
	private String Note_Satisfaction;
	private String Commentaire_Satisfaction;
	
	public Satisfaction() {
	}
	
	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	
	public String getNote_Satisfaction() {
		return Note_Satisfaction;
	}
	
	public void setNote_Satisfaction(String note_satisfaction) {
		Note_Satisfaction = note_satisfaction;
	}
	
	public String getCommentaire_Satisfaction() {
		return Commentaire_Satisfaction;
	}
	
	public void setCommentaire_Satisfaction(String commentaire_satisfaction) {
		Commentaire_Satisfaction = commentaire_satisfaction;
	}
}
