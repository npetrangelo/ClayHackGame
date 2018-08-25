import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private double pX;
	private double pY;
	private double vX;
	private double vY;
	private BufferedImage sprite;
	
	public Player(BufferedImage sprite) {
		this.sprite = sprite;
	}
	
	public BufferedImage getSprite() {
		return sprite;
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
