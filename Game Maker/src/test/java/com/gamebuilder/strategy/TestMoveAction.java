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

public class TestMoveAction {
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
	public void testMoveUp() {
		SpriteActionInterface spriteAction = new MoveAction();
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.getEventKeyCode()).thenReturn(KeyEvent.VK_UP);
		Mockito.when(gameSprite.isKeyUpEvent()).thenReturn(true);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).setPosY(Mockito.anyInt());
		verify(gameSprite, atLeast(1)).setEventKeyCode(0);
	}
	
	@Test
	public void testMoveDown() {
		SpriteActionInterface spriteAction = new MoveAction();
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.getEventKeyCode()).thenReturn(KeyEvent.VK_DOWN);
		Mockito.when(gameSprite.isKeyUpEvent()).thenReturn(true);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).setPosY(Mockito.anyInt());
		verify(gameSprite, atLeast(1)).setEventKeyCode(0);
	}
	
	@Test
	public void testMoveLeft() {
		SpriteActionInterface spriteAction = new MoveAction();
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.getEventKeyCode()).thenReturn(KeyEvent.VK_LEFT);
		Mockito.when(gameSprite.isKeySideEvent()).thenReturn(true);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).setPosX(Mockito.anyInt());
		verify(gameSprite, atLeast(1)).setEventKeyCode(0);
	}
	
	@Test
	public void testMoveRight() {
		SpriteActionInterface spriteAction = new MoveAction();
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.getEventKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
		Mockito.when(gameSprite.isKeySideEvent()).thenReturn(true);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).setPosX(Mockito.anyInt());
		verify(gameSprite, atLeast(1)).setEventKeyCode(0);
	}

}
