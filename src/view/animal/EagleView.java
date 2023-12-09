package view.animal;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.SpriteAnimation;
import model.animal.Eagle;
import util.Javafxutils;

public class EagleView extends ImageView implements PropertyChangeListener {

	SpriteAnimation flying;
	Eagle eagle;
	
	public EagleView(Eagle eagle) {
		this.eagle = eagle;
		
		eagle.addPropertyListener(this);
		Image eagleImg = Javafxutils.getImage(Paths.get("animals","eagle-flying.png"));
		setPreserveRatio(true);
		setFitWidth(100);
		setImage(eagleImg);
		flying = new SpriteAnimation(this, Duration.millis(1500), 4, 3);
		flying.play();
	}

	private void updatePosition(double[] position) {
		this.setTranslateX(position[0]);
		this.setTranslateY(position[1]);
		this.setTranslateZ(position[2]);
	}
	
	private void updateAngle(double angle) {
		this.setRotate(90-angle);
	}
	
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
