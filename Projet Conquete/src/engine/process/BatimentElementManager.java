package engine.process;

import java.util.ArrayList; 
import java.util.List; 

import engine.map.Map;
import engine.mobile.Batiments;
import engine.mobile.Unites;


public class BatimentElementManager {
	private Map map;
	private Batiments batiment;
	private List<Block> batimentrange = new ArrayList<Block>(); 
	
	public BatimentElementManager(Map map) {
		this.map = map;
	}

	public void set(Batiments batiment) {
		this.batiment= batiment;
	}
	
	public Batiments getBatiments() {
		return batiment;
	}

	public void putBatiment(Block position) {
		
			// Can not release a bomb on the border of the map.
	
				int line = position.getLine();
				int column = position.getColumn();

				// The four blocks around
				batimentrange.add(map.getBlock(line, column + 1));
				batimentrange.add(map.getBlock(line, column - 1));
				batimentrange.add(map.getBlock(line - 1, column));
				batimentrange.add(map.getBlock(line + 1, column));
			}
	}


