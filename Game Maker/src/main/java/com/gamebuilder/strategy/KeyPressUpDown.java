package com.gamebuilder.strategy;

import java.io.Serializable;

import com.gamebuilder.sprite.GameSprite;

public class KeyPressUpDown implements SpriteEventInterface, Serializable {
	
	private static final long serialVersionUID = 5L;
	
	private boolean keyUpEvent;
	
	public KeyPressUpDown(boolean keyUpEvent){
		this.keyUpEvent = keyUpEvent;
	}

	@Override
	public void addEvent(GameSprite gameSprite) {
		gameSprite.setKeyUpEvent(keyUpEvent);
	}

}
