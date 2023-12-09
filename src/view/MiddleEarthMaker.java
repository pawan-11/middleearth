package view;

import model.MiddleEarth;
import model.World;

public class MiddleEarthMaker extends WorldMaker {

	public MiddleEarthMaker(World world) {
		super(world);
	}

	
	public MiddleEarthMaker() {
		this(new MiddleEarth(100,80));
	}
}
