package model.place;

import java.util.Arrays;
import java.util.List;

public class Mountain extends Place {
	
	List<Cave> caves;
	
	public Mountain(Cave...caves) {
		this.caves = Arrays.asList(caves);
	}

	@Override
	public void getReadyForPlayer(Character character) {
		// TODO Auto-generated method stub
		
	}
}
