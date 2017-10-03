package com.gamebuilder.strategy;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.GameSprite;

public class BlowUpAction implements SpriteActionInterface, Serializable{
	
	private static final long serialVersionUID = 9L;
	
	private SpritePanelModel spritePanelModel;
	Music music = new Music();
	public BlowUpAction(SpritePanelModel spritePanelModel){
		this.spritePanelModel = spritePanelModel;
	}
	
	@Override
	public void performAction(GameSprite gameSprite) {
		if(gameSprite.isCollisionEvent() && gameSprite.isVisible()){
			
			Rectangle currentSpriteRectangle = gameSprite.createCollider();
			ArrayList<GameSprite> gameSpriteArray = spritePanelModel.getSpriteArray();
			
			for(GameSprite gameSpriteElement : gameSpriteArray){
				Rectangle arrayListSpriteRectangle = gameSpriteElement.createCollider();
				if(arrayListSpriteRectangle.intersects(currentSpriteRectangle) && !gameSprite.equals(gameSpriteElement)){
					gameSpriteElement.setVelX(-gameSpriteElement.getVelX());
					gameSpriteElement.setVelY(-gameSpriteElement.getVelY());
					gameSprite.setVisible(false);
					music.play("sound/Bomb.mp3");
				}
			}
		}
	}

}
