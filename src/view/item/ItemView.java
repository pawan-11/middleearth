package view.item;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.scene.image.ImageView;
import model.item.Item;

abstract public class ItemView extends ImageView implements PropertyChangeListener {

	
	Item item;
	public ItemView(Item item) {
		this.item = item;
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
