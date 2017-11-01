package com.oosd.commands;

import static org.junit.Assert.assertEquals;

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
public class TestAutoMove {

	@Mock
	private Sprite sprite;
	private AutoMove autoMove;
	private JLabel testLabel;
	
	@Test
	public void AutoMoveTest() {
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
		autoMove = new AutoMove(sprite, gameStage, direction);
		autoMove.execute();
		assertEquals(200, sprite.getxPosition());
		assertEquals(200, sprite.getyPosition());
	}
	
	@Test
	public void AutoMoveTest2() {
		GameStage gameStage = Mockito.mock(GameStage.class);
		Mockito.when(sprite.getxPosition()).thenReturn(200);
		Mockito.when(sprite.getyPosition()).thenReturn(200);
		testLabel = new JLabel("Test");
		testLabel.setBounds(200, 200, 100, 100);
		Mockito.when(sprite.getSpriteLabel()).thenReturn(testLabel);
		String direction = Constants.AUTO_MOVE_ACROSS;
		autoMove = new AutoMove(sprite, gameStage, direction);
		autoMove.execute();
		assertEquals(200, sprite.getxPosition());
		assertEquals(200, sprite.getyPosition());
	}
	
	@Test
	public void AutoMoveTest3() {
		GameStage gameStage = Mockito.mock(GameStage.class);
		Mockito.when(sprite.getxPosition()).thenReturn(200);
		Mockito.when(sprite.getyPosition()).thenReturn(200);
		testLabel = new JLabel("Test");
		testLabel.setBounds(200, 200, 100, 100);
		Mockito.when(sprite.getSpriteLabel()).thenReturn(testLabel);
		String direction = Constants.AUTO_MOVE_HORIZONTAL;
		autoMove = new AutoMove(sprite, gameStage, direction);
		autoMove.execute();
		assertEquals(200, sprite.getxPosition());
		assertEquals(200, sprite.getyPosition());
	}
	
	@Test
	public void AutoMoveTest4() {
		GameStage gameStage = Mockito.mock(GameStage.class);
		Mockito.when(sprite.getxPosition()).thenReturn(200);
		Mockito.when(sprite.getyPosition()).thenReturn(200);
		testLabel = new JLabel("Test");
		testLabel.setBounds(200, 200, 100, 100);
		Mockito.when(sprite.getSpriteLabel()).thenReturn(testLabel);
		String direction = Constants.AUTO_MOVE_VERTICAL;
		autoMove = new AutoMove(sprite, gameStage, direction);
		autoMove.execute();
		assertEquals(200, sprite.getxPosition());
		assertEquals(200, sprite.getyPosition());
	}
	
	@Test
	public void AutoMoveTest5() {
		GameStage gameStage = Mockito.mock(GameStage.class);
		sprite = new Sprite(new JLabel("Test"), 100, 100, 100, 100, "None");
		autoMove = new AutoMove(sprite, gameStage, Constants.AUTO_MOVE_HORIZONTAL);
		autoMove.execute();
		assertEquals(101, sprite.getxPosition());
		assertEquals(100, sprite.getyPosition());
	}

}
