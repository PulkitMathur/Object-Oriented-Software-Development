package com.gamebuilder.strategy;

import java.io.Serializable;

import com.gamebuilder.sprite.GameSprite;

public class KeyPressSides implements SpriteEventInterface, Serializable {
	
	private static final long serialVersionUID = 3L;
	
	private boolean keySideEvent;
	
	public KeyPressSides(boolean keySideEvent){
		this.keySideEvent = keySideEvent;
	}
	
	@Override
	public void addEvent(GameSprite gameSprite) {
		gameSprite.setKeySideEvent(keySideEvent);
	}

}
