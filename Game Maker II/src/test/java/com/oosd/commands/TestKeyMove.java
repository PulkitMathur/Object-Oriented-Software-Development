package com.oosd.commands;

import static org.junit.Assert.*;

import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Before;
import org.junit.Test;

import com.oosd.model.Bullet;
import com.oosd.model.Sprite;
import com.oosd.view.GameStage;

public class TestKeyMove {

	int spriteDir ;
	private Sprite sprite;
	private GameStage game;
	private String direction;
	private int keyPress;
	private int centerX;
	private int centerY;
	private CopyOnWriteArrayList<Bullet> bulletList;
	
	
	@Before
	public void setUp() {
		sprite = new Sprite();
		game = new GameStage();
		centerX = 0;
		centerY = 0;
		direction = "KEY_PRESS_VERTICAL";
	}
	
	
	@Test
	public void checkTheGeterAndSeter() {
		KeyMove keyMove = new KeyMove(game);
		keyMove.setSprite(sprite, direction);
		
		assertEquals(keyMove.getSprite(),sprite);
		assertEquals(keyMove.getDirection(),direction);
		assertEquals(keyMove.getSprite(),sprite);
		assertEquals(keyMove.getDirection(),direction);
		assertEquals(centerX,0);
		assertEquals(centerY,0);
		assertEquals(direction,"KEY_PRESS_VERTICAL");
		assertEquals(keyMove.getDirection(),direction);
	}
}
