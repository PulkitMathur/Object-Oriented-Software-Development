package com.gamebuilder.strategy;

import java.awt.event.KeyEvent;
import java.io.Serializable;

import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.sprite.GameSprite;

public class MoveAction implements SpriteActionInterface, Serializable {
	
	private static final long serialVersionUID = 2L;
	
	@Override
	public void performAction(GameSprite gameSprite) {
		if(gameSprite.isKeySideEvent()){
			int keyCode = gameSprite.getEventKeyCode();
			if(keyCode == KeyEvent.VK_LEFT){
				gameSprite.setPosX(gameSprite.getPosX()-GameConstants.DEFAULT_MOVE);
				gameSprite.setEventKeyCode(0);
			}
			if(keyCode == KeyEvent.VK_RIGHT){
				gameSprite.setPosX(gameSprite.getPosX()+GameConstants.DEFAULT_MOVE);
				gameSprite.setEventKeyCode(0);
			}
		}
		if(gameSprite.isKeyUpEvent()){
			int keyCode = gameSprite.getEventKeyCode();
			if(keyCode == KeyEvent.VK_DOWN){		
				gameSprite.setPosY(gameSprite.getPosY()+GameConstants.DEFAULT_MOVE);
				gameSprite.setEventKeyCode(0);
			}
			if(keyCode == KeyEvent.VK_UP){
				gameSprite.setPosY(gameSprite.getPosY()-GameConstants.DEFAULT_MOVE);
				gameSprite.setEventKeyCode(0);
			}
		}
	}

}
