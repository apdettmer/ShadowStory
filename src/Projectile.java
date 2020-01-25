import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public abstract class Projectile extends JPanel implements ActionListener, KeyListener {

	private String type;
	private int speed;
	private int damage;
	private int xSpawn;
	private int ySpawn;
	private String direction = "up";
	
	//constructor
	public Projectile(String t, int s, int d, int x, int y){
		type = t;
		speed = s;
		damage = d;
		xSpawn = x;
		ySpawn = y;
	}
	
	//sets initial horizontal position
	public void setXSpawn(int xs){
		xSpawn = xs;
	}
	//returns speed of projectile
	public int getSpeed(){
		return speed;
	}
	//returns damage (amount subtracted from enemy health)
	public int getDamage(){
		return damage;
	}
	//returns direction that projectile will travel -- up, down, left, right
	public String getDirection(){
		return direction;
	}
	//sets direction that projectile will travel in
	public void setDirection(String str){
		direction = str;
	}
	//sets initial vertical position
	public void setYSpawn(int ys){
		ySpawn = ys;
	}
	//returns horizontal position
	public int getXSpawn(){
		return xSpawn;
	}
	//returns vertical position
	public int getYSpawn(){
		return ySpawn;
	}
	
	//moves projectile in given direction
	public void move(String str){
		if(str.equals("up"))
			ySpawn -= speed;
		if(str.equals("down"))
			ySpawn += speed;
		if(str.equals("left"))
			xSpawn -= speed;
		if(str.equals("right"))
			xSpawn += speed;
	}

	
	public void actionPerformed(ActionEvent e){	
	}	
	
	public void keyPressed(KeyEvent e){
			repaint();
	}
	
	public void keyReleased(KeyEvent e){
	
	}
	
	public void keyTyped(KeyEvent e){
		
	}


}