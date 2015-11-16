package ru.opa.pack.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Sprite {
	protected Image image;
	protected BufferedImage sourceImage;

	public Sprite(String path) {
		sourceImage = null;
		
		try {
			URL url = this.getClass().getClassLoader().getResource(path);
			sourceImage = ImageIO.read(url);
		} catch (IOException e) {
			System.out.println("Couldn't creat sprite from \"" + path + "\"");
		}
		image = Toolkit.getDefaultToolkit()
				.createImage(sourceImage.getSource());
	}

	public int getWidth() {
		return image.getWidth(null);
	}

	public int getHeight() {
		return image.getHeight(null);
	}

	public void draw(Graphics g, int x, int y) {
		g.drawImage(image, x, y, null);

	}
	
	public Image getImage(){
		return image;
	}
	
	public int getRaduis(){
		return Math.min(getWidth(), getHeight())/2;
	}
}
