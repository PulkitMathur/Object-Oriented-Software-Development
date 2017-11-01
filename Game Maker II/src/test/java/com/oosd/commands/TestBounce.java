package com.oosd.commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.oosd.model.Sprite;
import com.oosd.view.GameStage;

@RunWith(MockitoJUnitRunner.class)
public class TestBounce {

	
	private Bounce bounce;
	@Mock
	private Sprite sprite ;
	//private GameStage gam
	

	public void init(){
		GameStage gameStage = Mockito.mock(GameStage.class);
		sprite = Mockito.mock(Sprite.class);
		Mockito.when(sprite.getxPosition()).thenReturn(200);
		Mockito.when(sprite.getyPosition()).thenReturn(200);
		Mockito.when(sprite.getSpriteWidth()).thenReturn(100);
		Mockito.when(sprite.getSpriteHeight()).thenReturn(100);
		Mockito.when(sprite.getxVel()).thenReturn(1);
		Mockito.when(sprite.getyVel()).thenReturn(1);
	}
	
	@Test
	public void BounceTest() {
		init();
		String collision = "TOP_BOUNDARY";
		bounce = new Bounce(sprite, collision);
		bounce.execute();
		assertEquals(1, sprite.getyVel());
		
		init();
		collision = "LEFT_BOUNDARY";
		bounce = new Bounce(sprite, collision);
		bounce.execute();
		assertEquals(1, sprite.getxVel());
	}

}
