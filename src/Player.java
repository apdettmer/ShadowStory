import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Player extends JPanel implements ActionListener, KeyListener {
	private int xPos = 600;
	private int yPos = 450;
	private int xSpeed = 7;
	private int ySpeed = 7;
	private String spellType;
	private boolean cooldown;
	private String direction = "down";
	BufferedImage sprite;
	
	//constructor
	public Player(){
		super();
		spellType = "fireball";
		cooldown = false;
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		init();
	}
	//sets direction of player--up, down, left, or right
	public void setDirection(String str){
		direction = str;
	}
	//returns which direction the player is travelling
	public String getDirection(){
		return direction;
	}
	//moves the player in given direction
	public void move(String str){
		if(str.equals("up"))
			yPos -= ySpeed;
		if(str.equals("down"))
			yPos += ySpeed;
		if(str.equals("left"))
			xPos -= xSpeed;
		if(str.equals("right"))
			xPos += xSpeed;
	}
	//cooldown used to control how often player can fire projectiles
	public void setCooldown(boolean b){
		cooldown = b;
	}
	//returns whether cooldown is currently occurring
	public boolean getCooldown(){
		return cooldown;
	}
	//sets horizontal speed
	public void setXSpeed(int x){
		xSpeed = x;
	} 
	//sets vertical speed
	public void setYSpeed(int y){
		ySpeed = y;
	}
	//sets which projectile player uses
	public void setSpellType(String s){
		spellType = s;
	}
	
	@Override								//method override to paint sprite
	public void paint(Graphics g){ 
		g.drawImage(sprite, getXPos(),getYPos(), null);
		super.paint(g);
	}

	//stops player at boundaries
	public void actionPerformed(ActionEvent e){
		if(xPos > 0)
			xSpeed = 0;
		if(yPos < 0 || yPos > 850)
			ySpeed = 0;
	}	
	//moves player based on WASD controls -- gets player moving again if stopped at boundary
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_W)
			direction = "up";
		if(e.getKeyCode() == KeyEvent.VK_S)
			direction = "down";
		if(e.getKeyCode() == KeyEvent.VK_A)
			direction = "left";
		if(e.getKeyCode() == KeyEvent.VK_D)
			direction = "right";
		if(xSpeed == 0 && e.getKeyCode() == KeyEvent.VK_A && xPos  >= 0){
			direction = "left";
			setXSpeed(8);
		}
		if(xSpeed == 0 && e.getKeyCode() == KeyEvent.VK_D && xPos <= 0){
			direction = "right";
			setXSpeed(8);
		}
		if(ySpeed == 0 && e.getKeyCode() == KeyEvent.VK_W && yPos >= 0){
			direction = "up";
			setYSpeed(8);
		}
		if(ySpeed == 0 && e.getKeyCode() == KeyEvent.VK_S && yPos <= 0){
			direction = "down";
			setYSpeed(8);
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent e){
	
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	//returns horizontal position
	public int getXPos(){
		return xPos;
	}
	//returns vertical position
	public int getYPos(){
		return yPos;
	}
	//returns a projectile based on which spell (String) the player currently has
	public Projectile getSpellType(){
		Projectile pr;
		if(spellType.equals("fireball"))
			pr = new Fireball(xPos, yPos);
		else if(spellType.equals("iceball"))
			pr = new Iceball(xPos, yPos);
		else
			pr = null;
		return pr;
	}
	
	private void init(){												//method to load sprite
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage gobSprite = null;
		try{
			gobSprite = loader.loadImage("images/wizard.png");
		}catch (IOException ex){
		}
		GobSprite gs = new GobSprite(gobSprite);
		
		sprite = gs.getSprite();
		repaint();
	
	}

	



}