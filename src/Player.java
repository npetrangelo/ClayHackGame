import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private double pX = 0;
	private double pY = 0;
	private double vX = 0;
	private double vY = 0;
	private double aY = 0.3;
	
	private final int WIDTH = 100;
	private final int HEIGHT = 100;
	private BufferedImage sprite;
	
	public Player(String spritepath) {
		this.sprite = generateSprite(spritepath);
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}
	
	public void update() {
		if (pY < 300) {
			vY += aY;
		}

		pX += vX;
		pY += vY;
	}
	
	public void jump() {
		if (pY >= 300) {
			setYVelocity(-10);
		}
	}
	
	public void setXVelocity(double vX) {
		this.vX = vX;
	}

	public void setYVelocity(double vY) {
		this.vY = vY;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(sprite, (int) pX, (int) pY, WIDTH, HEIGHT, null);
	}
	
	public static BufferedImage generateSprite(String filepath) {
		BufferedImage result = null;
		try {
			result =  ImageIO.read(new File(filepath));
		} catch (IOException e) {
			System.err.println("Bad image file");
			e.printStackTrace();
		} return result;
	}
}
