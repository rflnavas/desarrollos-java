package rnr.com.springtutorial.sptutorial.beans;

public class Animal {
	
	private String name;
	
	private String type;
	
	public Animal() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return String.format("name: %s  type: %s", this.name, this.type);
	}
	
}
