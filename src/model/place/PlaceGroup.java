package model.place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceGroup extends Place {

	public List<Place> places;
	public PlaceGroup(String name, Place...places) {
		this.places = new ArrayList<Place>(Arrays.asList(places));
		System.out.println(this.places.size());
	}
	@Override
	public void getReadyForPlayer(Character character) {
		// TODO Auto-generated method stub
		
	}
	
}
