package model.animal;

import java.util.List;

import javafx.scene.input.KeyCode;
import model.Action;
import model.Action.Attack;
import model.Action.Attack.RangeAttack;
import model.Game;
import model.Game.KeyBoard;
import model.World;
import model.item.Weapon.Arrow;

public class Eagle extends Animal {

	
	
	
	{
		moveSpeed = 4;
		rotateSpeed =3;
	}
	
	public Eagle(double health) {
		super(health);
		this.actualSize = 10;
		this.apparentSize = this.actualSize;
	}
	
	public double[] flyForward() {
		double x_delta = Math.cos(Math.toRadians(angle));
		double y_delta = -Math.sin(Math.toRadians(angle));
		
		return this.translate(x_delta, y_delta, 0);
	}
	

	@Override
	public void getReadyFor(Game game) {
		actionController = new strategy.ActionController() {
			
			KeyBoard board;
			{
				board = game.keyboard;
			}
			@Override
			public double[] getMove() {				
				double[] nextPos = pos.clone();
				if (board.keyPressed.getOrDefault(KeyCode.UP, false)) {
					nextPos = flyForward();
				}
				if (board.keyPressed.getOrDefault(KeyCode.DOWN, false)) {
					
				}
				return nextPos;
			}

			@Override
			public double getRotate() {
				double nextAngle = angle;
				if (board.keyPressed.getOrDefault(KeyCode.LEFT, false)) {
					nextAngle = rotate(1);
				}
				if (board.keyPressed.getOrDefault(KeyCode.RIGHT, false)) {
					nextAngle = rotate(-1);
				}
				
				return nextAngle;
			}
			
			@Override
			public Attack getAttack() {
				return new RangeAttack(new Arrow(), 0, angle, 100);
			}	
			
		};
	}


}
