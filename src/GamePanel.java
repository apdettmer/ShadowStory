   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.util.ArrayList;

   public class GamePanel extends JPanel implements ActionListener, KeyListener{
      private Player p;
      private ArrayList<Enemy> enemies;
      private ArrayList<Projectile> spells;
      private Timer t;
      private Timer gobSpawn;
      private Timer orcSpawn;
      private Timer ogreSpawn;
      private Timer playCD;
		//constructor
      public GamePanel(){
         super();
         enemies = new ArrayList<Enemy>();
         spells = new ArrayList<Projectile>();
         p = new Player();
         t = new Timer(50, this);
         t.start();
         gobSpawn = new Timer(3000, this);
         gobSpawn.start();
         orcSpawn = new Timer(5000, this);
         orcSpawn.start();
         ogreSpawn = new Timer(10000, this);
         ogreSpawn.start();
         playCD = new Timer(850, this);
         setFocusable(true);
         requestFocus();
         addKeyListener(this);
      
      }
   	//paints player, enemies, and launched spells
      public void paint(Graphics g){ 
         super.paint(g);
         p.paint(g);
         for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).paint(g);
         }
         for(int i = 0; i < spells.size(); i++){
            spells.get(i).paint(g);
         }
      }
   
   
      public void actionPerformed(ActionEvent e){
			//moves player -- stops player at boundaries
         if(e.getSource() == t){
				p.move(p.getDirection());
				if(p.getXPos() < 0 || p.getXPos() > getWidth() - 50)
               p.setXSpeed(0);
            if(p.getYPos() < 0 || p.getYPos() > getHeight()-50)
               p.setYSpeed(0);
				//checks enemy health -- moves enemies toward player	
            for(int i = 0; i < enemies.size(); i++){
     				if(enemies.get(i).getHP() <= 0){
						enemies.remove(i);
						break;
					}          
					enemies.get(i).trackX(p);
               enemies.get(i).trackY(p);
            }
				//stops game if an enemy comes in contact with the player
				for(int i = 0; i < enemies.size(); i++){
					Enemy a = enemies.get(i);
					if(p.getXPos() <= a.getXPos() + 30 && 
							p.getXPos() >= a.getXPos() - 30 && 
							p.getYPos() <= a.getYPos() + 30 && 
							p.getYPos() >= a.getYPos() - 30){
						t.stop();
						gobSpawn.stop();
						orcSpawn.stop();
						ogreSpawn.stop();
						p.setCooldown(true);
						System.out.println(
								"The orc hordes have overwhelmed you. "
								+ "Blaze Shadowflame succumbs to the "
								+ "hellish onslaught.");
					}
				}
				//moves launched spells -- removes spells if they hit a boundary
            for(int i = 0; i < spells.size(); i++){
               Projectile sp = spells.get(i);
               sp.move(sp.getDirection());
               if(sp.getXSpawn() < -20 || sp.getXSpawn() > getWidth() || 
            		   sp.getYSpawn() < -10 || sp.getYSpawn() > 900){
                  spells.remove(i);
               }
            }
				//checks position of spells and enemies -- controls damaging enemies and subsequently removing the spell
            for(int i = 0; i < spells.size(); i ++){
               Projectile sp = spells.get(i);
               for(int k = 0; k < enemies.size(); k++){
                  Enemy a = enemies.get(k);
                  if(sp.getXSpawn() <= a.getXPos() + 30 && 
                		  sp.getXSpawn() >= a.getXPos() - 30 && 
                		  sp.getYSpawn() <= a.getYPos() + 30 && 
                		  sp.getYSpawn() >= a.getYPos() - 30){
                     a.hurt(sp.getDamage());
                     spells.remove(i);
							break;
                  }
               }
            }
         
            repaint();
         }
			//spawns goblins
         if(e.getSource() == gobSpawn){
            Goblin g = new Goblin();
            enemies.add(g);
         }
			//spawns orcs
         if(e.getSource() == orcSpawn){
            Orc o = new Orc();
            enemies.add(o);
         }
			//spawns ogres
         if(e.getSource() == ogreSpawn){
            Ogre sog = new Ogre();
            enemies.add(sog);
         }
			//ends cooldown after elapsed time -- allows player to fire another projectile
         if(e.getSource() == playCD){
            p.setCooldown(false);
            playCD.stop();
         }
      
      	
      }	
   
      public void keyPressed(KeyEvent e){
         p.keyPressed(e);
			//fires projectile in given arrow key direction and starts cooldown
         if(e.getKeyCode() == KeyEvent.VK_UP && !p.getCooldown()){
            Projectile proj = p.getSpellType();
            spells.add(proj);
            proj.setDirection("up");
            p.setCooldown(true);
            playCD.start();
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN && !p.getCooldown()){
            Projectile proj = p.getSpellType();
            spells.add(proj);
            proj.setDirection("down");
            p.setCooldown(true);
            playCD.start();
         }
         if(e.getKeyCode() == KeyEvent.VK_LEFT && !p.getCooldown()){
            Projectile proj = p.getSpellType();
            spells.add(proj);
            proj.setDirection("left");
            p.setCooldown(true);
            playCD.start();
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT && !p.getCooldown()){
            Projectile proj = p.getSpellType();
            spells.add(proj);
            proj.setDirection("right");
            p.setCooldown(true);
            playCD.start();
         }
         repaint();
      }
   
      public void keyReleased(KeyEvent e){
      
      }
   
      public void keyTyped(KeyEvent e){
      
      
      }
   
   
   
   }