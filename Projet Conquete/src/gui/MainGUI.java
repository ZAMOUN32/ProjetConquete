package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.process.BatimentElementManager;
import engine.process.GameBuilder;
import engine.process.MobileElementManager;


/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class MainGUI extends JFrame implements Runnable {
	
	private int posx=0;
	
	private int posy=0;
	
	List<Block> savedbatimentrange = new ArrayList<Block>();
	
	private static final long serialVersionUID = 1L;

	private Map map;
	
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private MobileElementManager manager;
	
	private BatimentElementManager building_manager;

	private GameDisplay dashboard;

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());		

		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		building_manager = GameBuilder.buildInitBatiment(map);
		dashboard = new GameDisplay(map, manager, building_manager);

		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			dashboard.repaint();
			//building_manager.nextRound();
		}
	}

	private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			int x = e.getX();
			int y = e.getY();
			
			
			if(posx==0&posy==0) {
				Block batimentpos = dashboard.getBlock(x,y);
				List<Block> batimentrange = new ArrayList<Block>();
				if(building_manager.IsBatiment(batimentpos)) {
					batimentrange = building_manager.putBatiment(batimentpos);
					savedbatimentrange.addAll(batimentrange);
					posx=x;
					posy=y;
				}if(building_manager.IsUnites(batimentpos)) {
					building_manager.putUnites(batimentpos,3);
				}if(building_manager.size()<4) {
					building_manager.putGrass(batimentpos);
				}
			}else{
				Block unitespos = dashboard.getBlock(x,y);
				Block batimentpos = dashboard.getBlock(x,y);
				for(Block bloc: savedbatimentrange){
					if(unitespos == bloc) {
						building_manager.addUnites(unitespos);
					}
				}
				
				if(building_manager.IsBatiment(batimentpos)||building_manager.IsUnites(batimentpos)) {
					building_manager.clear();
				}else {
					building_manager.putGrass(batimentpos);
				}
				//savedbatimentrange.clear();
				posx=0;
				posy=0;
				
			}
			building_manager.BatimentRange();
			Block batimentpos = dashboard.getBlock(x,y);
			if(building_manager.size()>8 & !savedbatimentrange.contains(batimentpos)) {
				building_manager.clear();
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

}