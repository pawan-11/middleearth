package view.animal;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import model.animal.Animal;

public abstract class AnimalView implements PropertyChangeListener {

	Animal animal;
	public AnimalView(Animal animal) {
		this.animal = animal;
	}
	
	abstract void updatePosition(double[] position);
	abstract void updateAngle(double angle);
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("position")) {
			updatePosition((double[])evt.getNewValue());
		}
		else if (evt.getPropertyName().equals("angle")) {
			updateAngle((double)evt.getNewValue());
		}
	}
	
}

