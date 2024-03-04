package gui;

import java.awt.Graphics;


import javax.swing.JPanel;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Batiments;
import engine.mobile.Unites;
import engine.process.BatimentElementManager;
import engine.process.MobileElementManager;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private MobileElementManager manager;
	private BatimentElementManager building_manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Map map, MobileElementManager manager, BatimentElementManager building_manager) {
		this.map = map;
		this.manager = manager;
		this.building_manager = building_manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(map, g);

		Unites unite = manager.getUnites();
		paintStrategy.paint(unite, g);
		
		Batiments batiment= building_manager.getBatiments();
		paintStrategy.paint(batiment, g);

		List<Block> batimentrange = buldingmanager.getBatiment(); 
		paintStrategy.paint(batimentrange,g); 
	}

	public Block getBatiment(int x, int y) {
		int line = y / GameConfiguration.BLOCK_SIZE;
		int column = x / GameConfiguration.BLOCK_SIZE;
		return map.getBlock(line, column);
	}
	

	

}
