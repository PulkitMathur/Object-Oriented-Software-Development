package com.gamebuilder.sprite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gamebuilder.commands.SpriteCommand;
import com.gamebuilder.helpers.GameConstants;
public class SpriteCommandTest {
	
	private GameSprite gameSprite;
	private int initX, initY;
	private String action, event;
	private int eventKey;
	
	@Before
	public void setUp() {
	gameSprite = new GameSprite();
	initX = gameSprite.getPosX();
	initY = gameSprite.getPosY();
	}
	
	@Test
	public void checkTheGeterAndSeter(){		
		//Call the constructor 
		SpriteCommand spriteCommand = new SpriteCommand(gameSprite);
		//this.imageInterface = gameSprite.getImageInterface();
	
		//test the getPosX method
		assertEquals(spriteCommand.getInitX(), initX);
		
		//test the getPosY method
		assertEquals(spriteCommand.getInitY(), initY);
		
		//test the Sprite Image
		assertEquals(spriteCommand.getActionInterface(), action);
		
		//test the Sprite Image Interface
		assertEquals(spriteCommand.getEventInterface(), event);
		
		//test the Sprite Event Interface
		assertEquals(spriteCommand.getGameSprite(), gameSprite);
		
		
	}

}


