import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Actual game.
 * 
 * @author www.gametutorial.net
 */

public class App {
	// private SunGraphics2D graphics;
	private static int width = 400;
	private static int height = 400;
	private double centerX = Framework.frameWidth / 2;
	private double centerY = Framework.frameHeight / 2;

	Window window;
	private static App instance;
	private Player player;

	private int increment = 0;
	
	public boolean keyPressed;

	public App() {
		Thread threadForInitGame = new Thread() {
			@Override
			public void run() {
				// Sets variables and objects for the game.
				Initialize();
				// Load game files (images, sounds, ...)
				LoadContent();
			}
		};
		threadForInitGame.start();
		window = Window.getInstance();
		System.out.println("Just got instance: " + window);
		instance = this;
	}

	public static App getInstance() {
		return instance;
	}

	/**
	 * Set variables and objects for the game.
	 */
	private void Initialize() {
		player = new Player(Player.generateSprite("8bitColonial.png"));
	}

	/**
	 * Load game files - images, sounds, ...
	 */
	private void LoadContent() {
		// TODO
	}

	/**
	 * Restart game - reset some variables.
	 */
	public void RestartGame() {
		// TODO
	}

	/**
	 * Update game logic.
	 * 
	 * @param gameTime
	 *            gameTime of the game.
	 */
	public void UpdateGame(long gameTime, Point deltaMousePosition) {
		if (keyPressed) {
			System.out.println("A is held down");
		}
		// TODO
	}

	/**
	 * Draw the game to the screen.
	 * 
	 * @param g2d
	 *            Graphics2D
	 */
	public void Draw(Graphics2D g2d) {
		g2d.drawImage(player.getSprite(), 0, 0, 100, 100, null);
	}
}
