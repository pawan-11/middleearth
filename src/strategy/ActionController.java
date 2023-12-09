package strategy;

import model.Action.Attack;

public interface ActionController { //algorithms for dynamic moving objects (characters, animals, attacks)

	public double[] getMove();
	public double getRotate();
	public Attack getAttack();
	
}

