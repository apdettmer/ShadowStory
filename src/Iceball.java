import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Iceball extends Projectile{

	
	public Iceball(int xx, int yy){
		super("iceball", 11, 2, xx, yy);
	}
	
	public void paint(Graphics g){ 
		super.paint(g);
		g.setColor(Color.blue);
		g.fillOval(getXSpawn(),getYSpawn(),25,25);
	}


}
