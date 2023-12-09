package model;

import java.util.Arrays;
import java.util.List;

import model.animal.Eagle;
import model.character.Character;
import model.character.Character.Dwarf;
import model.character.Elf;
import model.character.Hobbit;
import model.character.Character.Maia;
import model.character.Man;
import model.character.Character.Orc;
import model.character.Wizard;
import model.character.Man.Nazgul;
import model.item.Item.Ring;
import model.place.Mountain;
import model.place.PlaceGroup;

public class MiddleEarth extends World {

	final int EAGLES_COUNT = 5, HORSES_COUNT = 10, WARGS_COUNT = 15,
			RAVENS_COUNT = 10, RABBITS_COUNT = 5;
	
	public MiddleEarth(double width, double height) {
		super(width, height);
		addCharacters();
		addAnimals();
		addPlaces();
	}

	private void addCharacters() {
		Maia sauron = new Maia("Sauron", 10000000) {
			
			@Override
			public void getReadyFor(Game game) {
				
			}		
		};
		
		Character gollum = new Character("Gollum", 2000) {
			@Override
			public void getReadyFor(Game game) {
				
			}
			
		};
		
		Ring ring = new Ring(0.1);
		sauron.possessions.add(ring);

		Nazgul witchking = new Nazgul("Witch King of Angmar", 100000);

		Wizard gandalf = new Wizard("Gandalf", 10000);
		Wizard saruman = new Wizard("Saruman", 10000);
		Wizard radagast = new Wizard("Radagast", 8000);

		Hobbit frodo = new Hobbit("Frodo Baggins", 1000);
		Hobbit sam = new Hobbit("Samwise Gamgee", 1000);
		Hobbit bilbo = new Hobbit("Bilbo Baggins", 1000);
		Hobbit merry = new Hobbit("Merry", 500);
		Hobbit pippin = new Hobbit("Pippin", 500);

		Dwarf gimli = new Dwarf("Gimli", 2500);
		Dwarf thorin = new Dwarf("Thorin", 2500);
		Dwarf balin = new Dwarf("Balin", 2500);

		Elf arwen = new Elf("Arwen", 4000);
		Elf elrond = new Elf("Elrond", 20000);
		Elf galadriel = new Elf("Galadriel", 50000);
		Elf legolas = new Elf("Legolas", 6000);
		Elf tauriel = new Elf("Tauriel", 6000);

		Orc azog = new Orc("Azog", 4000);
		Orc bolg = new Orc("Bolg", 3000);
		Orc gothmog = new Orc("Gothmog", 3000);

		//assign them a location, 
		//which will put them in chunks
		/*
		characters.addAll(Arrays.asList(
				sauron, witchking, 
				gandalf, saruman, radagast,
				frodo, sam, bilbo, merry, pippin,
				gollum,
				gimli, thorin, balin,
				arwen, elrond, galadriel, legolas, tauriel,
				azog, bolg, gothmog
				)); */
	}
	
	private void addAnimals() {
		for (int eagleNo = 0; eagleNo < EAGLES_COUNT; eagleNo++) {
			Eagle eagle = new Eagle(2000);
			//animals.add(eagle);
		}
		
		for (int eagleNo = 0; eagleNo < EAGLES_COUNT; eagleNo++) {
			Eagle eagle = new Eagle(2000);
			//animals.add(eagle);
		}
	}
	
	private void addPlaces() {
		
		Mountain erebor = new Mountain();
		
		PlaceGroup mistyMountains = new PlaceGroup("Misty Mountains");
		for (int mountainNo = 0; mountainNo < 100; mountainNo++) {
			mistyMountains.places.add(new Mountain());
		}
		
	}
	
	
	public void iterateState() {
		
	}
	

	@Override
	public void getReadyFor(Game game) {
		for (int i = 0; i < chunks.length; i++) {
			for (int j = 0; j < chunks[i].length; j++) {
				
			}
		}
		Chunk[] chunkArea = this.getChunkArea(game.mainCharacter.pos[0], game.mainCharacter.pos[1]);
		for (Chunk chunk: chunkArea)
			chunk.getReadyFor(game);
		
	}

}
