package engine_2D.Tutorial.test1.graphics;

import java.util.Random;

import engine_2D.Tutorial.test1.level.tile.Tile;

public class Screen {
    public int width, height;
    public int[] pixels;
    private final int MAP_SIZE = 64;
    //private final int MAP_SIZE_MASK = this.MAP_SIZE - 1;
    
    public int xOffset, yOffset;
    public int tiles[] = new int[MAP_SIZE * MAP_SIZE];
    private Random random = new Random();

    int time = 0;
    int counter = 0;

    public Screen(int width, int height) {
	this.width = width;
	this.height = height;
	pixels = new int[width * height];
	for (int i = 0; i < (MAP_SIZE * MAP_SIZE); i++) {
	    this.tiles[i] = this.random.nextInt(0xffffff);
	}
    }

    public void clear() {
	for (int i = 0; i < this.pixels.length; i++) {
	    pixels[i] = 0;
	}
    }

    public void render() {
	for (int y = 0; y < height; y++) {
	    int yy = y;
	    // if (yy < 0 || yy >= this.height) break;
	    for (int x = 0; x < width; x++) {
		int xx = x;
		// if (xx < 0 || xx >= this.width) break;
		int tileIndex = ((xx >> 4) & 63) + ((yy >> 4) & 63) * 64;
		// int tileIndex = (xx >> 4) + (yy >> 4) * MAP_SIZE;
		this.pixels[x + y * this.width] = this.tiles[tileIndex];
	    }
	}
    }

    public void renderTile(int xp, int yp, Tile tile) {  
	xp -= this.xOffset;
	yp -= this.yOffset;
	for (int y = 0; y < tile.sprite.SIZE; y++) {
	    int ya = y + yp;
	    for (int x = 0; x < tile.sprite.SIZE; x++) {
		int xa = x + xp;
		if (xa < -tile.sprite.SIZE || xa >= this.width || ya < 0 || ya >= this.height) break;
		if(xa < 0) xa = 0;
		pixels[xa + ya * this.width] = tile.sprite.pixels[x + y	* tile.sprite.SIZE];
	    }
	}
    }
    
    public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
	xp -= this.xOffset;
	yp -= this.yOffset;
	for (int y = 0; y < 32; y++) {
	    int ya = y + yp;
	    int ys = y;
	    if (flip == 2 || flip == 3) ys = 31 - y;
	    for (int x = 0; x < 32; x++) {
		int xa = x + xp;
		int xs = x;
		if (flip == 1 || flip == 3) xs = 31 - x;
		if (xa < -32 || xa >= this.width || ya < 0 || ya >= this.height) break;
		if(xa < 0) xa = 0;
		int col = sprite.pixels[xs + ys * 32];
		if (col != 0xffff00ff) pixels[xa + ya * this.width] = col;
	    }
	}
    }
    
    public void setOffset (int xOffset, int yOffset) {
	this.xOffset = xOffset;
	this.yOffset = yOffset;
    }
}
