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
public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);
		
		intializeUnites(map, manager);
		
		return manager;
	}

	private static void intializeUnites(Map map, MobileElementManager manager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 1, (GameConfiguration.COLUMN_COUNT - 1) / 2);
		Unites unite = new Unites(block);
		manager.set(unite);
	}

}
