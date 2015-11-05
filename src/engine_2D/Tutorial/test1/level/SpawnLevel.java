package engine_2D.Tutorial.test1.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;



public class SpawnLevel extends Level {
    
    public SpawnLevel(String path) {
	super(path);
    }
    // grass = 0X4fa343, dirt = 0X957159, rock = 0Xa2a2a2, grass2 = 0X7dc374
    protected void generateLevel () {
	
	
    }
    
    protected void loadLevel(String path) {
	try {
	    BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
	    int w = this.width = image.getWidth();
	    int h = this.height = image.getHeight();
	    this.tiles = new int[w * h];
	    image.getRGB(0, 0, w, h, tiles, 0, w);
	} catch (IOException e) {
	    e.printStackTrace();
	    System.out.println("exception, fail at loading level file");
	}
    }

    

}
