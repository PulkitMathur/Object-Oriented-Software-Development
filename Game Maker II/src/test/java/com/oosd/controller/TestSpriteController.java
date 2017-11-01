package com.oosd.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.oosd.events.CollisionBottom;
import com.oosd.events.CollisionLeft;
import com.oosd.events.CollisionRight;
import com.oosd.events.CollisionTop;
import com.oosd.events.Destroy;
import com.oosd.model.Sprite;
import com.oosd.view.GameStage;

@RunWith(MockitoJUnitRunner.class)
public class TestSpriteController {
	
	@Mock
	private Sprite sprite;
	private CollisionBottom collisionBottom;
	private CollisionTop collisionTop;
	private CollisionLeft collisionLeft;
	private CollisionRight collisionRight;
	private Destroy destroy;
	private GameStage gameStage = new GameStage();
	
	SpriteController spriteController = Mockito.mock(SpriteController.class);

	@Test
	public void testAddSprite() {
		sprite = new Sprite();
		Mockito.when(spriteController.addSprite(100,100)).thenReturn(sprite);
		assertEquals("They are not equal",spriteController.addSprite(100, 100),sprite);
		
	}

}
