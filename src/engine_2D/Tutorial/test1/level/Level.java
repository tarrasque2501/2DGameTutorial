package engine_2D.Tutorial.test1.level;

import engine_2D.Tutorial.test1.graphics.Screen;
import engine_2D.Tutorial.test1.level.tile.Tile;

public class Level {
    
    protected int width, height;
    protected int[] tilesInt;
    protected int[] tiles;

    public Level(int auxWidth, int auxHeight) {
	this.width = auxWidth;
	this.height = auxHeight;
	this.tilesInt = new int[this.width * this.height];
	generateLevel();
    }

    public Level(String path) {
	loadLevel(path);
	generateLevel();
    }

    protected void loadLevel(String path) {

    }

    protected void generateLevel() {

    }

    public void update() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {
	screen.setOffset(xScroll, yScroll);
	int x0 = xScroll >> 4;
	int x1 = (xScroll + screen.width +16) >> 4;
	int y0 = yScroll >> 4;
	int y1 = (yScroll + screen.height +16) >> 4;
	
	for (int y = y0; y < y1; y++) {
	    for (int x = x0; x < x1; x++) {
		this.getTile(x, y).render(x, y, screen);
	    }
	}
    }
 // grass = 0X4fa343, dirt = 0X957159, rock = 0Xa2a2a2, grass2 = 0X7dc374
    public Tile getTile(int x, int y) {
	if (x < 0 || y < 0 || x >= this.width || y >= this.height) return Tile.voidTile;
	if (this.tiles[x + y * this.width] == 0Xff4fa343) return Tile.grass;
	if (this.tiles[x + y * this.width] == 0Xff957159) return Tile.dirt;
	if (this.tiles[x + y * this.width] == 0Xffa2a2a2) return Tile.rock;
	return Tile.grass2;
    }
    
    
}
