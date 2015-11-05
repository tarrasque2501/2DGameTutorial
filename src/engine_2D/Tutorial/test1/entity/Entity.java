package engine_2D.Tutorial.test1.entity;

import java.util.Random;

import engine_2D.Tutorial.test1.graphics.Screen;
import engine_2D.Tutorial.test1.level.Level;

public abstract class Entity {
    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();
    
    public void update () {
	
    }
    
    public void render (Screen screen) {
	
    }
    
    public void remove(){
	this.removed = true;
    }
    
    public boolean isRemoved () {
	return this.removed;
    }

}
