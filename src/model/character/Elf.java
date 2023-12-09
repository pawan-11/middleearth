package model.character;

import java.util.List;

import model.Action;
import model.Game;
import model.World;

public class Elf extends Character {

	public Elf(String name, double health) {
		super(name, health);
	}

	@Override
	public List<Action> getActions(World world) {
		return null;
	}

	@Override
	public void getReadyFor(Game game) {
		// TODO Auto-generated method stub
		
	}
	
}
