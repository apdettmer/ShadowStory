import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame1 extends JFrame {

	public MyFrame1(String title){
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 900);
		add(new MyPanel1());
	}
	
	public static void main(String [] args){
		JFrame frame = new MyFrame1("Bobby");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}