package engine_2D.Tutorial.test1.level.tile;

import engine_2D.Tutorial.test1.graphics.Screen;
import engine_2D.Tutorial.test1.graphics.Sprite;

public class Tile {
    
    public int x, y;
    public Sprite sprite;
    
    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile grass2 = new Grass2Tile(Sprite.grass2);
    public static Tile dirt = new DirtTile(Sprite.dirt);
    public static Tile rock = new RockTile(Sprite.rock);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);
    
    public Tile(Sprite sprite) {
	this.sprite = sprite;	
    }
    
    public void render(int x, int y, Screen screen) {
	
    }
    
    public boolean solid() {
	return false;
    }
    

}
