import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;


public class Framework extends JFrame {
	//constructor
	public Framework(String title){
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 900);
		add(new GamePanel());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		music();
	}
	//main
	public static void main(String [] args){
		JFrame startframe = new StartFrame();
	}
	//music -- takes music file from images folder
	public void music(){
		AudioPlayer myPlayer = AudioPlayer.player;
		AudioStream myStream;
		ContinuousAudioDataStream loop = null;
		try {
			InputStream test = new FileInputStream("src/images/music.wav");
			myStream = new AudioStream(test);
			AudioPlayer.player.start(myStream);
		} catch (IOException e) {
			System.out.print("file not found!\n");
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		myPlayer.start(loop);
	}
}