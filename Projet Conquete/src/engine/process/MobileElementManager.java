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

	public void moveLeftUnites() {
		Block position = unites.getPosition();

		if (position.getColumn() > 0) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			unites.setPosition(newPosition);
		}

	}

	public void moveRightUnites() {
		Block position = unites.getPosition();

		if (position.getColumn() < GameConfiguration.COLUMN_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			unites.setPosition(newPosition);
		}
	}
	
	public void moveUpUnites() {
	    Block position = unites.getPosition();

	    if (position.getLine() > 0) {
	        Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
	        unites.setPosition(newPosition);
	    }
	}
	
	public void moveDownUnites() {
	    Block position = unites.getPosition();

	    if (position.getLine() < GameConfiguration.LINE_COUNT - 1) {
	        Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
	        unites.setPosition(newPosition);
	    }
	}


	/*private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}*/
}
