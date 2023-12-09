package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.animal.Animal;
import model.animal.Eagle;
import model.character.Character;
import model.item.Item;
import model.place.Place;
import util.Javafxutils;

abstract public class World {

	public class Chunk { //smaller part of the world
		
		double x, y, width, height;

		public List<Item> items = new ArrayList<Item>();
		public List<Character> characters = new ArrayList<Character>();
		public List<Place> places = new ArrayList<Place>();
		public List<Animal> animals = new ArrayList<Animal>();
		

		public Chunk(double x, double y, double width, double height) {
			this.x = x; this.y = y; this.width = width; this.height = height;
		}	
		
		public void save(File file) {
			
		}

		public void getReadyFor(Game game) {
			for (Animal animal: animals) {
				animal.getReadyFor(game);
			}
			for (Place place: places) {
				//place.getReadyFor(game);
			}
			for (Item item: items) {
				item.getReadyFor(game);
			}
			for (Character character: characters) {
				character.getReadyFor(game);
			}
		}
	}
	
	public double viewX, viewY, viewWidth, viewHeight; //changes as player moves and zooms in/out
	Chunk[][] chunks;
	
	public World(double width, double height) {
		this.viewX = width/2; this.viewY = height/2;
		
		double screenWidth = Javafxutils.getScreenBounds().getWidth();
		double screenHeight = Javafxutils.getScreenBounds().getHeight();
		
		//chunk is screen dimensions rectangle (close to it, little bit bigger if neeeded for equal partition)
		int x_chunks = (int)(width/screenWidth);
		int y_chunks = (int)(height/screenHeight);
		
		chunks = new Chunk[x_chunks][y_chunks];
		
		double chunkWidth = width/x_chunks;
		double chunkHeight = height/y_chunks;
		
		this.viewWidth = chunkWidth; this.viewHeight = chunkHeight;
		
		for (int x_chunk = 0; x_chunk < x_chunks; x_chunk++) {
			for (int y_chunk = 0; y_chunk < y_chunks; y_chunk++) {
				chunks[x_chunk][y_chunk] = new Chunk(x_chunk*chunkWidth, y_chunk*chunkHeight,
						(x_chunk+1)*chunkWidth, (y_chunk+1)*chunkHeight);
			}
		}
		
	}
	
	public void addItem(Item item) {
		getChunkXY()
	}
	
	public int[] getChunkXY(double x, double y) {
		int xChunk = (int)(x/chunks[0].length);
		int yChunk = (int)(y/chunks.length);
		return new int[] {xChunk, yChunk};
	}
	
	Chunk nullChunk = new Chunk(0,0,0,0);
	public Chunk getChunk(int chunk_x, int chunk_y) {
		if (chunk_x < 0 || chunk_x >= chunks[0].length || chunk_y < 0 || chunk_y > chunks.length)
			return nullChunk;
		return chunks[chunk_x][chunk_y];
	}
	
	public Chunk[] getChunkArea(double x, double y) {
		int[] chunk_xy = this.getChunkXY(x,y);
		return null;
	}
	
	abstract public void iterateState();
	abstract public void getReadyFor(Game game);
}
