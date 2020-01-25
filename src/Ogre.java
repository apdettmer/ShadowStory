import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;
public class Ogre extends Enemy{
BufferedImage sprite;
															// constructor
	public Ogre(){
		super("Ogre",3,3,3,3,1100,800);
		init();
	}
	
	@Override
	public void paint(Graphics g){ 					//method override to paint sprite
		g.drawImage(sprite, getXPos(),getYPos(), null);
		super.paint(g);
	}
	
	private void init(){
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage gobSprite = null;										//method to load sprite
		try{
			gobSprite = loader.loadImage("images/ogre.png");
		}catch (IOException ex){
		}
		GobSprite gs = new GobSprite(gobSprite);
		
		sprite = gs.getSprite();
		repaint();
	
	}





}