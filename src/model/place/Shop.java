package model.place;

import java.util.Arrays;
import java.util.List;

import model.Storage;

public class Shop {
	
	List<Storage> storages;
	double gold = 0;
	
	public Shop(List<Storage> storages) {
		this.storages = storages;
	}
	
	public Shop(Storage... storages) {
		this(Arrays.asList(storages));
	}
}