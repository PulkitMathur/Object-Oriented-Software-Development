package com.gamebuilder.sprite;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import com.gamebuilder.commands.SpriteCommand;
import com.gamebuilder.ui.GamePanelView;
public class SpriteCommandTest {
	
	private GameSprite gameSprite;
	private GamePanelView gamePanelView;
	private int initX, initY;
	private String action, event;
	private int eventKey;
	
	@Before
	public void setUp() {
	gameSprite = new GameSprite();
	initX = gameSprite.getPosX();
	initY = gameSprite.getPosY();
	}
	
	
	public void checkTheGeterAndSeter(){		
		//Call the constructor 
		SpriteCommand spriteCommand = new SpriteCommand(gameSprite, gamePanelView);
		//this.imageInterface = gameSprite.getImageInterface();
	
		//test the getPosX method
		assertEquals(spriteCommand.getInitX(), initX);
		
		//test the getPosY method
		assertEquals(spriteCommand.getInitY(), initY);
		
//		//test the Sprite Image
//		assertEquals(spriteCommand.getActionInterface(), action);
//		System.out.println("Testing: " + spriteCommand.getActionInterface());
//		//test the Sprite Image Interface
//		assertEquals(spriteCommand.getEventInterface(), event);
//		System.out.println("Testing: " + spriteCommand.getEventInterface());
		
		//test the Sprite Event Interface
		assertEquals(spriteCommand.getGameSprite(), gameSprite);
	}

}


