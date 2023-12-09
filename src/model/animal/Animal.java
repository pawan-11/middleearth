package model.animal;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import model.Action;
import model.Game;
import model.Living;
import model.World;

abstract public class Animal extends Living {

	
	public Animal(double health) {
		super(health);
	}
}

