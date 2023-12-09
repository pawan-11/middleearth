package model.place;

import java.util.Arrays;
import java.util.List;

import model.animal.Animal;

public class Cave {
	
	List<Animal> animals; //animals bound inside the cave
	List<Place> places; //
	
	public Cave(List<Animal> animals) {
		this.animals = animals;
	}
	
	public Cave(Animal...animals) {
		this(Arrays.asList(animals));
	}
}