package util;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.stage.Screen;

public class Javafxutils {

	public final static double screenWidth = Screen.getPrimary().getBounds().getWidth();
	public final static double screenHeight = Screen.getPrimary().getBounds().getHeight();
	
	public static Rectangle2D getScreenBounds() {
		return Screen.getPrimary().getBounds();
	}

	public static Image getImage(Path relativePath) {
		Path absolutePath;

		absolutePath = Paths.get(OsUtils.getProjectDirectory().toPath().toFile().toString(),
				"resources", "images", relativePath.toString());
		System.out.println(absolutePath.toFile().exists());
		Image img = new Image("file:///"+absolutePath.toFile().toString());
		return img;


	}

}


