package model.item;

import model.Game;

public class Cloth extends Item {

	public Cloth(double weight, double value) {
		super(weight, value);
	}
	

	@Override
	public void getReadyFor(Game game) {
		// TODO Auto-generated method stub
		
	}

	public static class Shoes extends Cloth {


		public Shoes() {
			super(0.8, 2);
		}

	}

	public static class Pants extends Cloth {

		public Pants() {
			super(0.8, 1);
		}
	}

	public static class Shirt extends Cloth {

		public Shirt() {
			super(0.5, 1);
		}
	}

	public static class Hat extends Cloth  {

		public Hat() {
			super(0.5, 1);
		}
	}
}


