package util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.image.Image;


public class OsUtils {

	public static File getProjectDirectory() {
		ClassLoader loader = OsUtils.class.getClassLoader();
		URL url = loader.getResource("util/OsUtils.class");
		File classFile;
		try {
			classFile = new File(url.toURI());
			File projectDir = classFile.getParentFile().getParentFile().getParentFile();
			//System.out.println(projectDir.toString()+","+ projectDir.exists());
			return projectDir;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	public static void main(String [] args) {
		Path p = Paths.get(OsUtils.getProjectDirectory().toPath().toFile().toString(),
				"resources", "images");
		System.out.println(p);
		File f = new File(p.toString());
		System.out.print(f.exists());
	}

}
