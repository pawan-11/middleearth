package model;

import model.character.Character;
import model.item.Weapon;

abstract public class Action { //character actions/command

	abstract public void execute(World world, Living being); //executes action for being in game
	
	public static class Move extends Action {
		
		double[] currPos, nextPos;
		public Move(double[] currPos, double[] nextPos) {
			this.currPos = currPos; this.nextPos = nextPos;
		}
		
		@Override
		public void execute(World world, Living being) {
			being.move(nextPos);
		}
		
	}
	
	public static class Rotate extends Action {
		
		double currAngle, nextAngle;
		public Rotate(double currAngle, double nextAngle) {
			this.currAngle = currAngle; this.nextAngle = nextAngle;
		}
		
		@Override
		public void execute(World world, Living being) {
			being.setAngle(nextAngle);
		}
		
	}
	
	public abstract static class Attack extends Action {
		
		int iteration = 0, delay;
		public Attack(int delay) { //delay in game iterations
			this.delay = delay;
		}
		
		public class PointAttack extends Attack {

			public PointAttack(int delay) {
				super(delay);
			}

			@Override
			public void execute(World world, Living being) {				
			}
			
		}
		
		public static class RangeAttack extends Attack { //an attack that travels over time

			double angle;
			Weapon weapon;
			
			public RangeAttack(Weapon weapon, int delay, double angle, double duration) { 
				super(delay);
				this.weapon = weapon;
			}
			
			@Override
			public void execute(World world, Living being) {	//fires a weapon	
				world.addItem(weapon);
			}
			
		}
		
		
		
	}
	
	
}
