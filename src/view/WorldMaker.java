package view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import model.World;

abstract public class WorldMaker extends Pane {

	WorldView worldView;
	
	Button add, delete, move;
	
	Button characters, places, items;
	
	World world;
	
	public WorldMaker(World world) {
		this.world = world;
		Button add = new Button("Add");
		Button delete = new Button("Delete");
		Button move = new Button("Move");
		
		add.setOnAction(a->{
			
		});
		
		this.setOnZoom(z->{
			if (z.getZoomFactor() > 0) { //zoom in, close down the viewing window
				world.viewWidth -= z.getZoomFactor()*10;
			}
			else {
				
			}
		});
		this.getChildren().addAll(add, delete, move);
	}
	
	
}
