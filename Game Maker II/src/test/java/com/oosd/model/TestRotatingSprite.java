package com.oosd.model;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class TestRotatingSprite {

	private int xPosition = 200;;
	private int yPosition = 200;
	private int xVel = 0;
	private int yVel = 0;
	
	//private JLabel spriteLabel;
	private int spriteWidth = 100;
	private int spriteHeight = 100;
	public String action = "None";
	public ArrayList<String> eventList;
	public Rectangle bounds;
	private boolean isDestroyed = false;
	
	private Image image;
	
	//Maps collision check with event to be executed
	private HashMap<String, ArrayList<String>> collisionEventMap;
	private int centerX = xPosition + spriteWidth/2;
	private int centerY = yPosition + spriteHeight/2;
	
	@Test
	public void test() {
		RotatingSprite rotatingSprite = new RotatingSprite();
		RotatingSprite rotataingSprite1 = new RotatingSprite(null, xPosition, yPosition, spriteWidth, spriteHeight, action);
		
		assertEquals(rotatingSprite.getxPosition(),xPosition);
		assertEquals(rotatingSprite.getyPosition(),yPosition);
		assertEquals(rotatingSprite.getSpriteWidth(),spriteWidth);
		assertEquals(rotatingSprite.getSpriteHeight(),spriteHeight);
		assertEquals(rotatingSprite.getAction(),action);
		assertEquals(isDestroyed, false);
		assertEquals(rotataingSprite1.getCenterX(),centerX);
		assertEquals(rotataingSprite1.getCenterY(),centerY);
		assertEquals(rotataingSprite1.getxPosition(),xPosition);
		assertEquals(rotataingSprite1.getyPosition(),yPosition);
		assertEquals(rotataingSprite1.getxVel(),xVel);
		assertEquals(rotataingSprite1.getyVel(),yVel);
	}
}
