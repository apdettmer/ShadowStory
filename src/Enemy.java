import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Enemy extends JPanel implements ActionListener, KeyListener {

	private String caste;
	private int id;
	private int xSpeed;
	private int ySpeed;
	private int hp;
	private int xPos;
	private int yPos;
	
	//constructor
	public Enemy(String c, int i, int x, int y, int h, int xp, int yp){
		caste = c;
		id = i;
		xSpeed = x;
		ySpeed = y;
		hp = h;
		xPos = xp;
		yPos = yp;
	}
	//sets horizontal speed
	public void setXSpeed(int x){
		xSpeed = x;
	}
	//sets vertical speed
	public void setYSpeed(int y){
		ySpeed = y;
	}
	//returns horizontal speed
	public int getXSpeed(){
		return xSpeed;
	}
	//returns vertical speed
	public int getYSpeed(){
		return ySpeed;
	}
	//returns enemy "type" (ie. goblin, orc, etc.)
	public String getCaste(){
		return caste;
	}
	//returns enemy health
	public int getHP(){
		return hp;
	}
	//damages the enemy (lowers health)
	public void hurt(int dam){
		hp -= dam;
	}
	
	public void actionPerformed(ActionEvent e){
		repaint();
	}	
	
	
	public void keyPressed(KeyEvent e){
		
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
	//moves enemy in the direction of a player -- horizontal plane
	public void trackX(Player p){	
			if(getXPos() < p.getXPos())
				xPos+=xSpeed;
			else if(getXPos() > p.getXPos())
				xPos-=xSpeed;
			repaint();
			
	}
	//moves enemy in the direction of a player -- vertical plane
	public void trackY(Player p){
		if(getYPos() > p.getYPos())
			yPos-=ySpeed;
		else if(getYPos() < p.getYPos())
			yPos+=ySpeed;
		repaint();
	}
	




}