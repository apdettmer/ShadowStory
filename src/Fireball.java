import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;
public class Fireball extends Projectile{
BufferedImage sprite;
	//constructor
	public Fireball(int xx, int yy){
		super("fireball", 9, 1, xx, yy);
		init();
	}
	
	//method override to paint sprite
	@Override
	public void paint(Graphics g){ 						
		g.drawImage(sprite, getXSpawn(),getYSpawn(), null);
		super.paint(g);
	}
	
	//method to load sprite
	private void init(){									
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage gobSprite = null;
		try{
			gobSprite = loader.loadImage("images/fire.png");
		}catch (IOException ex){
		}
		GobSprite gs = new GobSprite(gobSprite);
		
		sprite = gs.getSprite();
		repaint();
	
	}



}

	