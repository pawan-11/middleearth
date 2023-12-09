package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import model.animal.Eagle;
import model.character.Character;

public class Game {

	public MiddleEarth middleEarth;
	Timeline gameTimer;
	public KeyBoard keyboard = new KeyBoard();
	
	public Living mainCharacter;
	
	//public Mouse mouse = new Mouse();
	
	public class KeyBoard {
		
		public Map<KeyCode, Boolean> keyPressed = new HashMap<KeyCode, Boolean>(20);
		
		public void pressKey(KeyCode key) {
			keyPressed.put(key, true);
		}
		
		public void releaseKey(KeyCode key) {
			keyPressed.put(key, false);
		}
		
		public boolean isPressed(KeyCode key) {
			return keyPressed.get(key);
		}
	}
	
	public Game(MiddleEarth middleEarth) {
		this.middleEarth = middleEarth;
		
		gameTimer = new Timeline();
		gameTimer.setCycleCount(Animation.INDEFINITE);
		gameTimer.getKeyFrames().add(new KeyFrame(Duration.millis(16), k->{
			middleEarth.iterateState();
			mainCharacter.executeActions(middleEarth);	//assumes characters play fair, according to game rules		
			
		}));
		
		setMainCharacter(new Eagle(1000));
	}
	
	public void setMainCharacter(Living living) {
		mainCharacter = living;
		mainCharacter.getReadyFor(this);
	}
	
	
	public void start() {
		gameTimer.play();
	}
	
}
