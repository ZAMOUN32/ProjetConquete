
package test;

import gui.MainGUI;

/**
 * Copyright SEDAMOP - Software Engineering
 * oui
 * @author tianxiao.liu@cyu.fr
 *
 */
public class TestGame {
	public static void main(String[] args) {

		MainGUI gameMainGUI = new MainGUI("Conquête");

		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	}
}
