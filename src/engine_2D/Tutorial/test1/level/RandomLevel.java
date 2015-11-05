package engine_2D.Tutorial.test1.level;

import java.util.Random;

public class RandomLevel extends Level{
    
    private static final Random random = new Random();

    public RandomLevel(int auxWidth, int auxHeight) {
	super(auxWidth, auxHeight);
    }
    
    protected void generateLevel(){
	for (int y = 0; y < height; y++) {
	    for (int x = 0; x < width; x++) {
		tilesInt[x+y*width] = random.nextInt(4);
	    }
	}
    }
}
