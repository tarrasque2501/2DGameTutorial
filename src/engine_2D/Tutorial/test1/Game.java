package engine_2D.Tutorial.test1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import engine_2D.Tutorial.test1.entity.mob.Player;
import engine_2D.Tutorial.test1.graphics.Screen;
import engine_2D.Tutorial.test1.input.Keyboard;
import engine_2D.Tutorial.test1.level.Level;
import engine_2D.Tutorial.test1.level.SpawnLevel;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static int scale = 3;
    public static int width = 300;
    public static int height = (width / 16) * 9;
    public static String title = "testGame 00";
    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private Level level;
    private Player player;
    private boolean running = false;
    private Screen screen;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Game() {
	Dimension size = new Dimension(width * scale, height * scale);
	setPreferredSize(size);
	this.screen = new Screen(width, height);
	this.frame = new JFrame();
	this.key = new Keyboard();
	this.level = new SpawnLevel("/textures/level.png");
	this.player = new Player(8 * 16, 8 * 16, key);
	addKeyListener(this.key);
    }

    public synchronized void start() {
	this.running = true;
	this.thread = new Thread(this, "Display");
	this.thread.start();
    }

    public synchronized void stop() {
	this.running = false;
	try {
	    this.thread.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void run() {
	long timer = System.currentTimeMillis();
	long runTime = System.nanoTime();
	final double nanoSec = 1000000000.0 / 60.0;
	double delta = 0;
	int frames = 0;
	int updates = 0;
	int avg = 0;
	int avgCont = 0;
	requestFocus();
	while (this.running) {
	    long now = System.nanoTime();
	    delta += ((now - runTime) / nanoSec);
	    runTime = now;
	    while (delta >= 1) {
		this.update();
		updates++;
		delta--;
	    }
	    this.render();
	    frames++;
	    if ((System.currentTimeMillis() - timer) > 1000) {
		timer += 1000;
		avg += frames;
		avgCont++;
		this.frame.setTitle(title + " | " + updates + " ups, " + frames + " fps, " + (avg / avgCont) + " avgFPS");
		updates = 0;
		frames = 0;
	    }
	}
	stop();
    }


    private void update() {
	this.key.update();
	this.player.update();
    }

    public void render() {
	BufferStrategy bufferStr = getBufferStrategy();
	if (bufferStr == null) {
	    createBufferStrategy(3);
	    return;
	}
	this.screen.clear();
	int xScroll = this.player.x - this.screen.width / 2;
	int yScroll = this.player.y - this.screen.height / 2;
	
	
	this.level.render(xScroll, yScroll, this.screen);
	this.player.render(this.screen);
	for (int i = 0; i < this.pixels.length; i++) {
	    pixels[i] = screen.pixels[i];
	}
	Graphics graphics = bufferStr.getDrawGraphics();
	graphics.drawImage(this.image, 0, 0, getWidth(), getHeight(), null);
	graphics.setColor(Color.WHITE);
	graphics.setFont(new Font("Verdana", 0, 15));
	//graphics.drawString("X: " + this.player.x + ", Y: " + this.player.y, 15, 25);
	graphics.dispose();
	bufferStr.show();
    }

    public static void main(String[] args) {
	Game game = new Game();
	game.frame.setResizable(false);
	game.frame.setTitle(Game.title);
	game.frame.add(game);
	game.frame.pack();
	game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	game.frame.setLocationRelativeTo(null);
	game.frame.setVisible(true);
	game.start();
    }

}
