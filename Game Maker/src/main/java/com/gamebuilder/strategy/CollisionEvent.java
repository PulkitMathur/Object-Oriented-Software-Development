package com.gamebuilder.strategy;

import java.io.Serializable;

import com.gamebuilder.sprite.GameSprite;

public class CollisionEvent implements SpriteEventInterface, Serializable {
	
	private static final long serialVersionUID = 8L;

	
	private boolean collisionEvent;

	public CollisionEvent(boolean collisionEvent) {
		
		this.collisionEvent = collisionEvent;

	}

	@Override
	public void addEvent(GameSprite gameSprite) {
		
		gameSprite.setCollisionEvent(collisionEvent);
		
	}

}
