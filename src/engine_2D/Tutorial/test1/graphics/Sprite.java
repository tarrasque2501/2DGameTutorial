package engine_2D.Tutorial.test1.graphics;

public class Sprite {

    public final int SIZE;
    private int x, y;
    private SpriteSheet sheet;
    public int[] pixels;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite grass2 = new Sprite(16, 3, 0, SpriteSheet.tiles);
    public static Sprite dirt = new Sprite(16, 1, 0, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0x1B87E0);
    
     
    public static Sprite player_up = new Sprite(32, 0, 7, SpriteSheet.tiles);
    public static Sprite player_side = new Sprite(32, 1, 7, SpriteSheet.tiles);
    public static Sprite player_down = new Sprite(32, 2, 7, SpriteSheet.tiles);
    
    public static Sprite player_up_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
    public static Sprite player_up_2 = new Sprite(32, 0, 5, SpriteSheet.tiles);
    public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
    public static Sprite player_side_2 = new Sprite(32, 1, 5, SpriteSheet.tiles);
    public static Sprite player_down_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
    public static Sprite player_down_2 = new Sprite(32, 2, 5, SpriteSheet.tiles);
    
    
    
    
    
    
    
    

    public Sprite(int auxSize, int auxX, int auxY, SpriteSheet auxSheet) {
	this.SIZE = auxSize;
	this.pixels = new int[this.SIZE * this.SIZE];
	this.x = auxX * auxSize;
	this.y = auxY * auxSize;
	this.sheet = auxSheet;
	this.load();
    }
    
    public Sprite(int size,int colour){
	this.SIZE = size;
	this.pixels = new int[this.SIZE * this.SIZE];
	setColour(colour);
    }

    private void setColour(int colour) {
	for (int i = 0; i < this.SIZE * this.SIZE; i++) {
	    this.pixels[i] = colour;
	}
    }

    private void load() {
	for (int y = 0; y < this.SIZE; y++) {
	    for (int x = 0; x < this.SIZE; x++) {
		this.pixels[x + y * this.SIZE] = this.sheet.pixels[(x + this.x)	+ (y + this.y) * this.sheet.SIZE];
	    }
	}
    }
}
