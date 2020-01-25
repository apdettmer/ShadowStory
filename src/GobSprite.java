import java.awt.image.BufferedImage;
public class GobSprite {
	//creates a buffered image
	public BufferedImage gobSprite;
	//constructor
	public GobSprite(BufferedImage gs){
		this.gobSprite = gs;
	}
	//method that returns the sprite
	public BufferedImage getSprite(){
		return gobSprite;
	}
	
}