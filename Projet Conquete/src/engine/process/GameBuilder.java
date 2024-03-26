package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Unites;
import engine.mobile.Batiments;

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
	
	public static BatimentElementManager buildInitBatiment(Map map) {
		BatimentElementManager manager = new BatimentElementManager(map);
		
		intializeBatiments(map, manager);
		
		return manager;
	}

	private static void intializeUnites(Map map, MobileElementManager manager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 10, (GameConfiguration.COLUMN_COUNT - 10) / 2);
		Unites unite = new Unites(block);
		manager.set(unite);
	}
	
	private static void intializeBatiments(Map map, BatimentElementManager manager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 2, (GameConfiguration.COLUMN_COUNT - 2) / 2);
		Batiments batiment = new Batiments(block);
		manager.addBatiment(batiment);
	}
}