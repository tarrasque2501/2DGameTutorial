package engine_2D.Tutorial.test1.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

    private String path;
    public final int SIZE;
    public int[] pixels;

    public static SpriteSheet tiles = new SpriteSheet("/textures/spriteSheet.png", 256);

    public SpriteSheet(String auxPath, int auxSize) {
	this.path = auxPath;
	this.SIZE = auxSize;
	this.pixels = new int[SIZE * SIZE];
	this.load();
    }

    private void load() {
	try {
	    BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
	    int width = image.getWidth();
	    int height = image.getHeight();
	    image.getRGB(0, 0, width, height, this.pixels, 0, width);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
