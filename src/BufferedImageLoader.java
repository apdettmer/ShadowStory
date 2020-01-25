import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class BufferedImageLoader{
	//creates a load image method which is able to find a buffered image based on a file path and then return it. 
	//returns an exception if no image found.
	public BufferedImage loadImage(String pathRelativeToThis) throws IOException {
			URL url = this.getClass().getResource(pathRelativeToThis);
			BufferedImage img = ImageIO.read(url);
			return img;
	}
	
}