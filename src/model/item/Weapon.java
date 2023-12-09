package model.item;

import model.Game;

public class Weapon extends Item {

	double damage; 
	public Weapon(double weight, double damage, double value) {
		super(weight, value);
		this.damage = damage;
	}



	public static class Arrow extends Weapon {

		public Arrow(double damage) {
			super(0.1, damage, 0.1);
		}

		public Arrow() {
			super(0.1, 10, 0.1);
		}
		
		public void use() {

		}
	}

	public static class Sword extends Weapon {

		public Sword(double damage) {
			super(5, damage, 200);
		}

	}

	public static class Spear extends Weapon {

		public Spear(double damage) {
			super(6, damage, 100);
		}

	}

	public static class Staff extends Weapon {

		public Staff(double damage) {
			super(8, damage, 2000);
			// TODO Auto-generated constructor stub
		}
	}

	public static class Rock extends Weapon {
		
		public Rock(double weight, double damage) {
			super(weight, damage, 0);
		}
		
	}

	@Override
	public void getReadyFor(Game game) {
		// TODO Auto-generated method stub
		
	}
	
}