package com.gamebuilder.strategy;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.gamebuilder.commands.SpriteCommand;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public class TestKeyPressUpDown {

	@Mock
	private GameSprite gameSprite;
	
	@Mock 
	private SpritePanelModel spritePanelModel;
	
	@Mock
	private GamePanelView gamePanelView;
	
	@Before
	public void init(){
		gameSprite = Mockito.mock(GameSprite.class);
		spritePanelModel = Mockito.mock(SpritePanelModel.class);
		gamePanelView = Mockito.mock(GamePanelView.class);
		Mockito.when(gameSprite.isKeyUpEvent()).thenReturn(true);
	}
	
	@Test
	public void testKeyPressUp() {
		//Test Key Press Sides
		
		SpriteActionInterface spriteAction = new FireAction(spritePanelModel, gamePanelView);
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.getEventKeyCode()).thenReturn(KeyEvent.VK_UP);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).setPosY(Mockito.anyInt());
		verify(gameSprite, atLeast(1)).setEventKeyCode(0);
	}
	
	@Test
	public void testKeyPressDown() {
		//Test Key Press Sides
		
		SpriteActionInterface spriteAction = new FireAction(spritePanelModel, gamePanelView);
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.getEventKeyCode()).thenReturn(KeyEvent.VK_DOWN);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).setPosY(Mockito.anyInt());
		verify(gameSprite, atLeast(1)).setEventKeyCode(0);
	}

}
