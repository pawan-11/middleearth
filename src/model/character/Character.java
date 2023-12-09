package model.character;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import model.World;
import model.Action;
import model.Game;
import model.Living;
import model.Action.Move;
import model.Action.Rotate;
import model.item.Item;
import strategy.ActionController;

public abstract class Character extends Living {

	public String name;
	public List<Item> possessions = new ArrayList<Item>();
	double speed = 1;
	
	PropertyChangeSupport ps = new PropertyChangeSupport(this);
	
	public Character(String name, double health) {
		super(health);
		this.name = name;
	}
	
	abstract public void getReadyFor(Game game);
	
	//abstract public List<Action> getActions(World world);
	
	abstract public static class Maia extends Character {
		
		public Maia(String name, double health) {
			super(name, health);
		}	
		
		
	}
	
	public static class Dwarf extends Character {

		public Dwarf(String name, double health) {
			super(name, health);
			// TODO Auto-generated constructor stub
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
	
	public static class Orc extends Character {

		public Orc(String name, double health) {
			super(name, health);
			// TODO Auto-generated constructor stub
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
	
	public static class Dragon extends Character {
		
		public Dragon(String name, double health) {
			super(name, health);
			// TODO Auto-generated constructor stub
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
	
	public static class Troll extends Character {

		public Troll(String name, double health) {
			super(name, health);
			// TODO Auto-generated constructor stub
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
	
	public static class Goblin extends Character {

		public Goblin(String name, double health) {
			super(name, health);
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
}
