package engine.process;

import java.util.ArrayList; 
import java.util.List;


import engine.map.Block;
import engine.map.Map;
import engine.mobile.Batiments;
import engine.mobile.Unites;


public class BatimentElementManager {
	private Map map;
	private List<Batiments> batiments = new ArrayList<Batiments>();
	private List<Block> batimentrange = new ArrayList<Block>();
	private List<Block> unitesrange = new ArrayList<Block>();
	private List<Unites> unites = new ArrayList<Unites>();
	
	public BatimentElementManager(Map map) {
		this.map = map;
	}
	
	public void addBatiment(Batiments batiment) {
		batiments.add(batiment);
	}
	public void addBatimentrange(Block batiment) {
		batimentrange.add(batiment);
	}
	
	public List<Batiments> PosBatiment(){
		return batiments; 
	}
	public List<Block> BatimentRange(){
		return batimentrange; 
	}
	public List<Unites> Unites(){
		return unites; 
	}
	public void putGrass(Block position) {
		int line = position.getLine();
		int column = position.getColumn();
		this.batimentrange.add(map.getBlock(line, column));
		this.batimentrange.add(map.getBlock(line, column));
		this.batimentrange.add(map.getBlock(line, column));
		this.batimentrange.add(map.getBlock(line, column));
		this.batimentrange.add(map.getBlock(line, column));
	}
	public List<Block> putBatiment(Block position) {
		
		// Can not release a bomb on the border of the map.
		List<Block> batimentrange =new ArrayList<Block>();
		int line = position.getLine();
		int column = position.getColumn();

		// The four blocks around
		batimentrange.add(map.getBlock(line, column + 1));
		batimentrange.add(map.getBlock(line, column - 1));
		batimentrange.add(map.getBlock(line - 1, column));
		batimentrange.add(map.getBlock(line + 1, column));
		this.batimentrange.add(map.getBlock(line, column + 1));
		this.batimentrange.add(map.getBlock(line, column - 1));
		this.batimentrange.add(map.getBlock(line - 1, column));
		this.batimentrange.add(map.getBlock(line + 1, column));
		return batimentrange;
		}
	
	public void putUnites(Block position, int distance) {
		
	}
	
	public void nextRound() {
		DeleteBrillance();
	}
	private void DeleteBrillance() {
		if(batimentrange.size()>8) {
			batimentrange.clear();
		}
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return batimentrange.size();
	}

	public void clear() {
		// TODO Auto-generated method stub
		batimentrange.clear();
	}
	
	public boolean IsBatiment(Block block) {
		for (Batiments batiment : batiments) {
			if(batiment.getPosition()==block) {
				return true;
			}
		}
		return false;
	}
	
	public boolean IsUnites(Block block) {
		for (Unites unites1 : unites) {
			if(unites1.getPosition()==block) {
				return true;
			}
		}
		return false;
	}
	
	public void addUnites (Block block) {
		if(!IsUnites(block)) {
			Unites unite= new Unites(block);
			unites.add(unite);
			this.batimentrange.clear();
		}
	}
}