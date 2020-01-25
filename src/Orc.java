import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Orc extends Enemy{
BufferedImage sprite; 						//constructor
	public Orc(){
		super("Orc",2,4,4,2,1100,50);
		init();
	}
	
	@Override
	public void paint(Graphics g){ 
		g.drawImage(sprite, getXPos(),getYPos(), null); //method to paint sprite
		super.paint(g);
	}
	
	
		private void init(){			//method to load sprite from images
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage gobSprite = null;
		try{
			gobSprite = loader.loadImage("images/orc.png");
		}catch (IOException ex){
		}
		GobSprite gs = new GobSprite(gobSprite);
		
		sprite = gs.getSprite();
		repaint();
	
	}




}