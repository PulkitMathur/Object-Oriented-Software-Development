package com.oosd.events;

import static org.junit.Assert.assertTrue;

import java.awt.Label;

import javax.swing.JLabel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.oosd.model.Sprite;
import com.oosd.view.GameStage; 

@RunWith(MockitoJUnitRunner.class)
public class CollisionTest {

	@Mock
	private Sprite sprite;
	private CollisionBottom collisionBottom;
	private CollisionTop collisionTop;
	private CollisionLeft collisionLeft;
	private CollisionRight collisionRight;
	private Destroy destroy;
	private GameStage gameStage = new GameStage();
	
	
	@Test
	public void testTopCollision() {
		Mockito.when(sprite.getxPosition()).thenReturn(100);
		Mockito.when(sprite.getyPosition()).thenReturn(0);
		collisionTop = new CollisionTop(sprite, gameStage);
		assertTrue(collisionTop.execute());
	}
	
	@Test
	public void testBottomCollision() {
		Mockito.when(sprite.getxPosition()).thenReturn(100);
		Mockito.when(sprite.getyPosition()).thenReturn(780);
		collisionBottom = new CollisionBottom(sprite, gameStage);
		assertTrue(collisionBottom.execute()); 
	}
	
	@Test
	public void testLeftCollision() {
		Mockito.when(sprite.getxPosition()).thenReturn(0);
		Mockito.when(sprite.getyPosition()).thenReturn(100);
		collisionLeft = new CollisionLeft(sprite, gameStage);
		assertTrue(collisionLeft.execute());
	}
	
	@Test
	public void testRightCollision() {
		Mockito.when(sprite.getxPosition()).thenReturn(490);
		//Mockito.when(sprite.getyPosition()).thenReturn(100);
		collisionRight = new CollisionRight(sprite, gameStage);
		assertTrue(collisionRight.execute());
	}
	
	@Test
	public void destroy(){
		
		sprite = new Sprite();
		sprite.spriteList.add(sprite);
		JLabel temp = new JLabel("");
		sprite.setSpriteLabel(temp);
		gameStage.add(temp);
		destroy = new Destroy(sprite, gameStage);
		assertTrue(destroy.execute());
	}
}
