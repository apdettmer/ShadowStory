import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;
//constructor
public class Goblin extends Enemy {
	BufferedImage sprite;
	public Goblin(){
		super("Goblin",1,6,6,1,50,50);
		init();
	}
	@Override
	public void paint(Graphics g){ //method to override paint and add sprite
		g.drawImage(sprite, getXPos(),getYPos(), null);
		super.paint(g);
	}
	
	private void init(){ //method to load sprite from images
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage gobSprite = null;
		try{
			gobSprite = loader.loadImage("images/goblin.png");
		}catch (IOException ex){
		}
		GobSprite gs = new GobSprite(gobSprite);
		
		sprite = gs.getSprite();
		repaint();
	
	}


	




}