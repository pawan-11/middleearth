package view;


import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Game;
import model.SpriteAnimation;
import model.World;
import model.animal.Eagle;
import util.Javafxutils;
import view.animal.EagleView;

public class GameView extends Pane {
		 
	MiddleEarthView worldView;
	public GameView(Game game) {
		worldView = new MiddleEarthView(game.middleEarth);
		
		//MiddleEarthMaker me_maker = new MiddleEarthMaker();
		
		EagleView eagleView = new EagleView((Eagle)game.mainCharacter);
		this.getChildren().addAll(eagleView);
		
		//eagle.getReadyFor(game);
		
		//eagle.addkeyboard
		//eagle.setcontroller
		
		this.setOnKeyPressed(k->{
			game.keyboard.pressKey(k.getCode());
		});
		this.setOnKeyReleased(k->{
			game.keyboard.releaseKey(k.getCode());
		});
	}
	
	
}
