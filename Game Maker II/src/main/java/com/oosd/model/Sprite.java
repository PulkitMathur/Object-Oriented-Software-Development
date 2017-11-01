package com.oosd.model;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JLabel;

public class Sprite implements Serializable {
	
	private int xPosition;
	private int yPosition;
	private int xVel = 1;
	private int yVel = -1;
	private JLabel spriteLabel;
	private int spriteWidth;
	private int spriteHeight;
	public static CopyOnWriteArrayList<Sprite> spriteList = new CopyOnWriteArrayList<Sprite>();	
	public static HashMap<String, JLabel> spriteLabels = new HashMap<String, JLabel>();
	public String action;
	public ArrayList<String> eventList;
	public Rectangle bounds;
	private boolean isDestroyed = false;
	public static Image rotatingSpriteImage;
	
	//Maps collision check with event to be executed
	private HashMap<String, ArrayList<String>> collisionEventMap;
	
	public Sprite(){
		this.spriteLabel = null;
		this.xPosition = 200;
		this.yPosition = 200;
		this.spriteWidth = 100;
		this.spriteHeight = 100;
		this.action = "None";
		this.isDestroyed = false;
	}
	
	public Sprite(JLabel sprite, int xPosition, int yPosition, int spriteWidth, int spriteHeight, String action) {
		this.spriteLabel = sprite;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
		this.action = action;
		collisionEventMap = new HashMap<String, ArrayList<String>>();
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

	public JLabel getSpriteLabel() {
		return spriteLabel;
	}

	public void setSpriteLabel(JLabel spriteLabel) {
		this.spriteLabel = spriteLabel;
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

	public static CopyOnWriteArrayList<Sprite> getSpriteList() {
		return spriteList;
	}

	public static void setSpriteList(CopyOnWriteArrayList<Sprite> spriteList) {
		Sprite.spriteList = spriteList;
	}

	public static HashMap<String, JLabel> getSpriteLabels() {
		return spriteLabels;
	}

	public static void setSpriteLabels(HashMap<String, JLabel> spriteLabels) {
		Sprite.spriteLabels = spriteLabels;
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

	public  HashMap<String, ArrayList<String>> getCollisionEventMap() {
		return collisionEventMap;
	}

	public void setCollisionEventMap(HashMap<String, ArrayList<String>> collisionEventMap) {
		this.collisionEventMap = new HashMap<String, ArrayList<String>>(collisionEventMap);
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	public static Image getRotatingSpriteImage() {
		return rotatingSpriteImage;
	}

	public static void setRotatingSpriteImage(Image rotatingSpriteImage) {
		Sprite.rotatingSpriteImage = rotatingSpriteImage;
	}

}
