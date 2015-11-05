package engine_2D.Tutorial.test1.entity.mob;

import engine_2D.Tutorial.test1.graphics.Screen;
import engine_2D.Tutorial.test1.graphics.Sprite;
import engine_2D.Tutorial.test1.input.Keyboard;

public class Player extends Mob {
    
    private Keyboard input;
    private Sprite sprite;
    private int anim = 0;
    private boolean walking = false;

    public Player(Keyboard input) {
	this.input = input;
	this.sprite = Sprite.player_up;
    }

    public Player(int x, int y, Keyboard input) {
	this.x = x;
	this.y = y;
	this.input = input;
    }
    
    public void update() {
	int xa = 0, ya = 0;
	if (anim < 7500) this.anim++;
	else anim = 0;
	if (this.input.up) ya--;
	if (this.input.down) ya++;
	if (this.input.left) xa--;
	if (this.input.right) xa++;
	if (xa != 0 || ya != 0) {
	    move(xa,ya);
	    this.walking = true;
	} else {
	    this.walking = false;
	}
    }
    
    public void render(Screen screen) {
	int flip = 0;
	switch (this.dir) {
	case 0: 
	    this.sprite = Sprite.player_up;
	    if (this.walking) {
		if (this.anim % 20 > 10) {
		    this.sprite = Sprite.player_up_1;
		} else {
		    this.sprite = Sprite.player_up_2;
		}
	    }
	    break;
	case 1:
	    this.sprite = Sprite.player_side;
	    if (this.walking) {
		if (this.anim % 20 > 10) {
		    this.sprite = Sprite.player_side_1;
		} else {
		    this.sprite = Sprite.player_side_2;
		}
	    }
	    break;
	case 2: 
	    this.sprite = Sprite.player_down;
	    if (this.walking) {
		if (this.anim % 20 > 10) {
		    this.sprite = Sprite.player_down_1;
		} else {
		    this.sprite = Sprite.player_down_2;
		}
	    }
	    break;
	case 3:
	    this.sprite = Sprite.player_side;
	    if (this.walking) {
		if (this.anim % 20 > 10) {
		    this.sprite = Sprite.player_side_1;
		} else {
		    this.sprite = Sprite.player_side_2;
		}
	    }
	    flip = 1;
	    break;
	}
	screen.renderPlayer(this.x - 16 , this.y - 16 , this.sprite, flip);
    }

}
