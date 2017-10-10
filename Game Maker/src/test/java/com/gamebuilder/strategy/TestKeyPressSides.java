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

public class TestKeyPressSides {

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
		Mockito.when(gameSprite.isKeySideEvent()).thenReturn(true);
	}
	
	@Test
	public void testKeyPressLeft() {
		//Test Key Press Sides
		
		SpriteActionInterface spriteAction = new FireAction(spritePanelModel, gamePanelView);
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.getEventKeyCode()).thenReturn(KeyEvent.VK_LEFT);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).setPosX(Mockito.anyInt());
		verify(gameSprite, atLeast(1)).setEventKeyCode(0);
	}
	@Test
	public void testKeyPressRight() {
		//Test Key Press Sides
		
		SpriteActionInterface spriteAction = new FireAction(spritePanelModel, gamePanelView);
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.getEventKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).setPosX(Mockito.anyInt());
		verify(gameSprite, atLeast(1)).setEventKeyCode(0);
	}

}
