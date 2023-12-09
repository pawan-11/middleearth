package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.item.Item;

public class Storage {

	public static class Box<I extends Item> {
		
		double capacity;
		double weight, value;
		List<I> items;
		
		public Box(double capacity, List<I> items) {
			this.capacity = capacity;
			items.forEach(item->add(item));
		}
		
		@SafeVarargs
		public Box(double capacity, I...items) {
			this(capacity, Arrays.asList(items));
		}
		
		public Box(double capacity) {
			this(capacity,new ArrayList<>());
		}
		
		public boolean add(I item) {
			if (weight + item.weight <= capacity && items.add(item)) {
				weight += item.weight;
				value += item.value;
				return true;
			}
			return false;	
		}
		
		public boolean remove(I item) {
			if (items.remove(item)) {
				weight = Math.max(0, weight-item.weight);
				value = Math.max(0, value-item.value);
				return true;
			}
			return false;	
		}
	}
	
}
