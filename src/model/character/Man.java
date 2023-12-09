package model.character;

import java.util.List;

import model.Action;
import model.Game;
import model.World;

public class Man extends Character {

	public Man(String name, double health) {
		super(name, health);
	}	
	
	public static class Nazgul extends Man {

		public Nazgul(String name, double health) {
			super(name, health);
		}	
	}

	@Override
	public List<Action> getActions(World world) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getReadyFor(Game game) {
		// TODO Auto-generated method stub
		
	}
}