package com.oosd.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.oosd.utils.Constants;

public class Bullet {
	
	private Image image;
	private int imageXpos;
	private int imageYpos;
	private Vector vector;
	private int velocity = Constants.BULLET_VELOCITY;
	private double vectorMagnitude;
	
	
	public Bullet(int imageXpos, int  imageYpos,Vector vector) throws IOException{
		
		BufferedImage bufferedImage;
		File bulletFile = new File("src/main/java/res/sprites/bomb.png");
		bufferedImage = ImageIO.read(bulletFile);
		ImageIcon icon = new ImageIcon(bufferedImage);
		image = icon.getImage();
		image.getScaledInstance(20, 25, Image.SCALE_SMOOTH);
		this.vector = vector;
		this.vector = this.vector.normalize();
		this.vectorMagnitude = Math.sqrt(Math.pow(imageXpos*this.vector.getX(),2) + Math.pow(imageYpos*this.vector.getY(),2)); 
		
	
		this.imageXpos = (this.vector.getX() == 0) ? imageXpos :(int)(imageXpos + imageXpos*this.vector.getX()/vectorMagnitude) ;
		this.imageYpos = (this.vector.getY() == 0) ? imageYpos :(int)(imageYpos + imageYpos*this.vector.getY()/vectorMagnitude) ;
		
	}
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getImageXpos() {
		return imageXpos;
	}
	public void setImageXpos(int imageXpos) {
		this.imageXpos = imageXpos;
	}
	public int getImageYpos() {
		return imageYpos;
	}
	public void setImageYpos(int imageYpos) {
		this.imageYpos = imageYpos;
	}
	public void update() {
		int angle = (int) (vector.getAngle()*6);
		int angleCount = (int) (angle/360);
		angle = angle - angle*angleCount;
		
		
		
		if(0 < angle && angle < 90 ){
			this.imageXpos +=  velocity*vector.getX();
			this.imageYpos +=  velocity*vector.getY();
		}
		if(90 < angle && angle < 180 ){
			this.imageXpos -=  velocity*vector.getX();
			this.imageYpos +=  velocity*vector.getY();
		}
		if(180 < angle && angle < 270 ){
			this.imageXpos -=  velocity*vector.getX();
			this.imageYpos -=  velocity*vector.getY();
		}
		if(270 < angle && angle < 360 ){
			this.imageXpos +=  velocity*vector.getX();
			this.imageYpos -=  velocity*vector.getY();
		}

		
		if(angle == 0 ){
			this.imageYpos +=  velocity*vector.getY();
					
		}
		if(angle == 360 ){
			this.imageYpos -=  velocity*vector.getY();		
		}
		if(angle == 90 ){
			this.imageXpos +=  velocity*vector.getX();
					
		}
		if(angle == 270 ){
			this.imageXpos -=  velocity*vector.getX();
					
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(imageXpos, imageYpos, Constants.BULLET_WIDTH, Constants.BULLET_HEIGHT);
	}

}