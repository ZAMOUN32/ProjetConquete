package gui;

import java.awt.Graphics;


import javax.swing.JPanel;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Aircraft;

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
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(map, g);

		Aircraft aircraft = manager.getAircraft();
		paintStrategy.paint(aircraft, g);
	}

	

}
