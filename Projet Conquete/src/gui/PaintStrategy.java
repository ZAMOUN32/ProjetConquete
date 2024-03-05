package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Batiments;
import engine.mobile.Unites;



/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class PaintStrategy {
	public void paint(Map map, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];
				graphics.drawImage(readImage("src/images/grass.png"),block.getColumn() * blockSize,block.getLine() * blockSize,blockSize, blockSize, null);
			}
		}
	}
	
	public void paintB(List<Batiments> batiments, Graphics g) {
		// TODO Auto-generated method stub
		int blockSize = GameConfiguration.BLOCK_SIZE;
		
		int imageWidth = 20; // Largeur de l'image
		int imageHeight = 20; // Hauteur de l'image
		
		for (Batiments batiment : batiments) {
			Block block = batiment.getPosition();
			g.drawImage(readImage("src/images/casernejaune.png"),block.getColumn() * blockSize + (blockSize - imageWidth) / 2,block.getLine() * blockSize +(blockSize - imageHeight) / 2,blockSize, blockSize, null);
		}
	}

	public void paint(Unites unites, Graphics graphics) {
		Block position = unites.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int imageWidth = 20; // Largeur de l'image
		int imageHeight = 20; // Hauteur de l'image
		
		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.BLUE);
		graphics.drawImage(readImage("src/images/armurejaune.png"), x * blockSize + (blockSize - imageWidth) / 2, y * blockSize + (blockSize - imageHeight) / 2, null);
		
		

	}

	public void paint(Batiments batiment, Graphics graphics) {
		Block position = batiment.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		int imageWidth = 20; // Largeur de l'image
		int imageHeight = 20; // Hauteur de l'image
		
		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.BLUE);
		graphics.drawImage(readImage("src/images/casernejaune.png"), x * blockSize + (blockSize - imageWidth) / 2, y * blockSize + (blockSize - imageHeight) / 2, null);
		
	}

	public void paint(List<Block> batimentrange, Graphics graphics) {
		for (Block block : batimentrange) {

			int blockSize = GameConfiguration.BLOCK_SIZE;

			int y = block.getLine();
			int x = block.getColumn();

			graphics.setColor(Color.ORANGE);
			graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
		}
	}
	
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}

	

	
	

}
