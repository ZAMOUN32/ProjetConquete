package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Unites;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class MobileElementManager {
	private Map map;

	private Unites unites;


	public MobileElementManager(Map map) {
		this.map = map;
	}

	public void set(Unites unites) {
		this.unites = unites;
	}
	
	public Unites getUnites() {
		return unites;
	}

	/*private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}*/
}