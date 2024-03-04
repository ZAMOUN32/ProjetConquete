package engine.process;

import engine.map.Map;
import engine.mobile.Batiments;
import engine.mobile.Unites;


public class BatimentElementManager {
	private Map map;
	private Batiments batiment;
	
	public BatimentElementManager(Map map) {
		this.map = map;
	}

	public void set(Batiments batiment) {
		this.batiment= batiment;
	}
	
	public Batiments getBatiments() {
		return batiment;
	}


}
