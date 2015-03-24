package rnr.com.springtutorial.sptutorial.beans;

import java.util.List;

public class Jungle {
	
	List<Animal> animals;
	
	public Jungle() {
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
	
	@Override
	public String toString() {
		return animals.toString();
	}
}
