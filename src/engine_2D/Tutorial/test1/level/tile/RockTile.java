package engine_2D.Tutorial.test1.level.tile;

import engine_2D.Tutorial.test1.graphics.Screen;
import engine_2D.Tutorial.test1.graphics.Sprite;

public class RockTile extends Tile {

    public RockTile(Sprite sprite) {
	super(sprite);
    }
    
    public void render(int x, int y, Screen screen) {
	screen.renderTile(x << 4, y << 4, this);
    }
    
    public boolean solid() {
   	return true;
    }
    
    

}
