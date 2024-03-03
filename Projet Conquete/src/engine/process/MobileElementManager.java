package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Aircraft;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class MobileElementManager {
	private Map map;

	private Aircraft aircraft;


	public MobileElementManager(Map map) {
		this.map = map;
	}

	public void set(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	
	public Aircraft getAircraft() {
		return aircraft;
	}

	public void moveLeftAirCraft() {
		Block position = aircraft.getPosition();

		if (position.getColumn() > 0) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			aircraft.setPosition(newPosition);
		}

	}

	public void moveRightAirCraft() {
		Block position = aircraft.getPosition();

		if (position.getColumn() < GameConfiguration.COLUMN_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			aircraft.setPosition(newPosition);
		}
	}


	/*private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}*/
}
