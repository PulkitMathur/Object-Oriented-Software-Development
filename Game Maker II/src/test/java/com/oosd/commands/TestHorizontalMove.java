package com.oosd.commands;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.oosd.model.Sprite;
import com.oosd.utils.Constants;
import com.oosd.view.GameStage;

@RunWith(MockitoJUnitRunner.class)
public class TestHorizontalMove {
	
	@Mock
	private Sprite sprite;
	private KeyMove keyMove;
	private JLabel testLabel;
	
	@Test
	public void KeyMoveTest() {
		GameStage gameStage = Mockito.mock(GameStage.class);
		Mockito.when(sprite.getxPosition()).thenReturn(200);
		Mockito.when(sprite.getyPosition()).thenReturn(200);
		Mockito.when(sprite.getSpriteWidth()).thenReturn(100);
		Mockito.when(sprite.getSpriteHeight()).thenReturn(100);
		Mockito.when(sprite.getxVel()).thenReturn(1);
		Mockito.when(sprite.getyVel()).thenReturn(1);
		testLabel = new JLabel("Test");
		testLabel.setBounds(200, 200, 100, 100);
		Mockito.when(sprite.getSpriteLabel()).thenReturn(testLabel);
		String direction = Constants.NONE;
		keyMove = new KeyMove(gameStage);
		//KeyEvent e = new KeyEvent(gameStage, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN);
		//keyMove.keyPressed(e);
		assertEquals(200, sprite.getxPosition());
		assertEquals(200, sprite.getyPosition());
	}



}
