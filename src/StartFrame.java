import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartFrame extends JFrame {
	
	public StartFrame() {
		super("Main Menu");
		setSize(450, 150);
		setVisible(true);
		setResizable(false);
		add(new StartPanel());
	}
	
	public void hideStart() {
		setVisible(false);
	}

	
	class StartPanel extends JPanel implements ActionListener{
		public StartPanel() {
			super(new BorderLayout());
			JLabel welcome = new JLabel("Welcome to ShadowStory!", JLabel.CENTER);
			welcome.setForeground(Color.MAGENTA);
			add(welcome, BorderLayout.PAGE_START);
			JLabel controls = new JLabel("Controls: WASD to control player direction, arrow keys to fire spells ", JLabel.CENTER);
			controls.setForeground(Color.RED);
			add(controls, BorderLayout.CENTER);
			JButton bstart = new JButton("Start Game");
			bstart.setPreferredSize(new Dimension(100, 50));
			bstart.addActionListener(this);
			bstart.setActionCommand("start");
			add(bstart, BorderLayout.PAGE_END);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("start")) {
				setVisible(false);
				JFrame frame = new Framework("Shadowstory");
				hideStart();
			}
			
		}
		
	}
	

}
