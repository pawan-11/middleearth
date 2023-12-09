package model.item;

import model.Game;
import model.item.Weapon.Arrow;

abstract public class Item {

	public double x, y, width, height, depth, weight, value; //weight in kg, value in silver coins
	
	public Item(double weight, double value) {
		this.weight = weight; this.value = value;
	}
	
	public static class Ring extends Item {

		public Ring(double weight) {
			super(weight, 1000);
		}
		
		@Override
		public void getReadyFor(Game game) {
			
		}
	}

	public static class Bow extends Item {

		public Bow(double weight) {
			super(weight, 10);
		}

		@Override
		public void getReadyFor(Game game) {
			
		}
		
	}
	
	abstract public void getReadyFor(Game game);

	public void move(double x, double y, double z) {
		this.x = x; this.y = y; this.z = z;
	}
	
	public void resize(double width, double height, double depth) {
		this.width = width; this.height = height; this.depth = depth;
	}


	
}


