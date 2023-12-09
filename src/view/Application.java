package view;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Game;
import model.MiddleEarth;

public class Application extends javafx.application.Application {

	@Override
	public void start(Stage stage) throws Exception {
		Game game = new Game(new MiddleEarth(100,80));
		
		GameView gameView = new GameView(game);
		
		Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		
		Scene scene = new Scene(gameView, screenBounds.getWidth()*0.8, screenBounds.getHeight()*0.8);
		stage.setScene(scene);
		stage.show();
		gameView.requestFocus();
		
		game.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
