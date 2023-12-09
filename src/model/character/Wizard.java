package model.character;

import java.util.ArrayList;
import java.util.List;

import model.Action;
import model.Game;
import model.Action.Move;
import model.Action.Rotate;

import model.World;
import model.character.Character.Maia;

public class Wizard extends Maia {
	
	public Wizard(String name, double health) {
		super(name, health);
	}

	@Override
	public void getReadyFor(Game game) {
		
	}

	
}