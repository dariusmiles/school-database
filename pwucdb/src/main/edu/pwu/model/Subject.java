package main.edu.pwu.model;

public class Subject {
	
	public Subject() {
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SUBJECT_TYPE getType() {
		return type;
	}
	public void setType(SUBJECT_TYPE type) {
		this.type = type;
	}
	public Integer getUnits() {
		return units;
	}
	public void setUnits(Integer units) {
		this.units = units;
	}

	public static enum SUBJECT_TYPE{ACADEMIC,NON_ACADEMIC}
	
	private String code;
	private String title;
	private String description;
	private SUBJECT_TYPE type;
	private Integer units;
}
