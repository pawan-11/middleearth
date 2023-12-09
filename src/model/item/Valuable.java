package model.item;

import model.Game;

abstract public class Valuable extends Item {

	public Valuable(double value) { //value per ounce
		super(0.01, value);
	}
	
	@Override
	public void getReadyFor(Game game) {
		// TODO Auto-generated method stub
		
	}
	
	public class Gold extends Valuable {

		public Gold() {
			super(80); 
		}
	}

	public class Silver extends Valuable {

		public Silver() {
			super(1); 
		}
	}

	public class Sapphire extends Valuable {

		public Sapphire() {
			super(500); 
		}
	}
}
