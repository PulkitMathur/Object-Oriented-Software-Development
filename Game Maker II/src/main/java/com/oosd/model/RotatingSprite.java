package com.oosd.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JLabel;

public class RotatingSprite extends Sprite {
	private int xPosition;
	private int yPosition;
	private int xVel = 0;
	private int yVel = 0;
	
	//private JLabel spriteLabel;
	private int spriteWidth;
	private int spriteHeight;
	public String action;
	public ArrayList<String> eventList;
	public Rectangle bounds;
	private boolean isDestroyed = false;
	
	private Image image;
	
	//Maps collision check with event to be executed
	private HashMap<String, ArrayList<String>> collisionEventMap;
	private int centerX;
	private int centerY;
	

	public RotatingSprite(){
		//this.spriteLabel = null;
		this.xPosition = 200;
		this.yPosition = 200;
		this.spriteWidth = 100;
		this.spriteHeight = 100;
		this.action = "None";
		this.isDestroyed = false;
	}
	
    public RotatingSprite(Image image, int xPosition, int yPosition, int spriteWidth, int spriteHeight, String action) {
    	//this.spriteLabel = sprite;
    	//this.image = image;
    	
    	//System.out.println("In rotating sprit" + this.image);
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
		this.action = action;
		collisionEventMap = new HashMap<String, ArrayList<String>>();
		
		this.centerX = xPosition + spriteWidth/2;
		this.centerY = yPosition + spriteHeight/2;
		if(image != null)
		    this.image = image.getScaledInstance(spriteWidth, spriteHeight, Image.SCALE_FAST);
	}
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getxPosition() {
		return xPosition;
	}
	
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	
	public int getyPosition() {
		return yPosition;
	}
	
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public int getSpriteWidth() {
		return spriteWidth;
	}

	public void setSpriteWidth(int spriteWidth) {
		this.spriteWidth = spriteWidth;
	}

	public int getSpriteHeight() {
		return spriteHeight;
	}

	public void setSpriteHeight(int spriteHeight) {
		this.spriteHeight = spriteHeight;
	}

	
	public Rectangle getBounds() {
		return new Rectangle(xPosition, yPosition, spriteWidth, spriteHeight);
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public ArrayList<String> getEventList() {
		return eventList;
	}

	public void setEventList(ArrayList<String> eventList) {
		this.eventList = eventList;
	}

	
	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	public HashMap<String, ArrayList<String>> getCollisionEventMap() {
		return collisionEventMap;
	}

	public void setCollisionEventMap(HashMap<String, ArrayList<String>> collisionEventMap) {
		this.collisionEventMap = collisionEventMap;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
}
