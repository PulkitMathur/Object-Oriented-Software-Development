package com.oosd.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSprite {

	@Test
	public void test() {
		Sprite sprite = new Sprite();
		
		assertEquals(200, sprite.getxPosition());
		
		assertEquals(200, sprite.getxPosition());
		
		assertEquals(-1, sprite.getyVel());
		
		assertEquals(1, sprite.getxVel());
		
		assertEquals(100, sprite.getSpriteWidth());
		
		assertEquals(100, sprite.getSpriteHeight());
		
		assertEquals("None", sprite.getAction());
		
		assertEquals(false , sprite.isDestroyed());
	}

}
