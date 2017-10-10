package com.gamebuilder.strategy;

import java.awt.event.KeyEvent;
import java.io.Serializable;

import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public class MoveAction implements SpriteActionInterface, Serializable {
	
	private static final long serialVersionUID = 2L;
	
	@Override
	public void performAction(GameSprite gameSprite, GamePanelView gamePanelView) {
		if(gameSprite.isKeySideEvent()){
			int keyCode = gameSprite.getEventKeyCode();
			if(keyCode == KeyEvent.VK_LEFT){
				int newPosX = gameSprite.getPosX() - GameConstants.DEFAULT_MOVE;
				if(newPosX <= 0) 
				{
					newPosX = 0;
				}
				gameSprite.setPosX(newPosX);
				gameSprite.setEventKeyCode(0);
			}
			if(keyCode == KeyEvent.VK_RIGHT){
				int newPosX = gameSprite.getPosX() + GameConstants.DEFAULT_MOVE;
				if(newPosX >= 450) 
				{
					newPosX = 450;
				}
				gameSprite.setPosX(newPosX);
				gameSprite.setEventKeyCode(0);
			}
		}
		if(gameSprite.isKeyUpEvent()){
			int keyCode = gameSprite.getEventKeyCode();
			if(keyCode == KeyEvent.VK_DOWN){	
				int newPosY = gameSprite.getPosY()+GameConstants.DEFAULT_MOVE;
				if(newPosY >= 690) 
				{
					newPosY = 690;
				}
				gameSprite.setPosY(newPosY);
				gameSprite.setEventKeyCode(0);
			}
			if(keyCode == KeyEvent.VK_UP){
				int newPosY = gameSprite.getPosY()-GameConstants.DEFAULT_MOVE;
				if(newPosY <= 0) 
				{
					newPosY = 0;
				}
				gameSprite.setPosY(newPosY);
				gameSprite.setEventKeyCode(0);
			}
			
		}
	}
}
