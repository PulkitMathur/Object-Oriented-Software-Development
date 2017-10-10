package com.gamebuilder.strategy;

import static org.junit.Assert.*;
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

public class TestFireAction {
	
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
	}
	@Test
	public void testFireAction() {
		//Test Fire Action
		
		SpriteActionInterface spriteAction = new FireAction(spritePanelModel, gamePanelView);
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.getEventKeyCode()).thenReturn(KeyEvent.VK_SPACE);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		GamePanelView.bulletArray.clear();
		testCommand.execute();
		assertEquals(1, GamePanelView.bulletArray.size());
		verify(gameSprite, atLeast(1)).setEventKeyCode(0);
		
	}

}
