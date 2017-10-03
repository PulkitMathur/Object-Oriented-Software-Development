package com.gamebuilder.strategy;

import java.awt.Rectangle;
import java.io.Serializable;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.GameSprite;

public class AutoMoveAction implements SpriteActionInterface, Serializable {
	
	private static final long serialVersionUID = 4L;
	
	private SpritePanelModel spritePanelModel;
	
	public AutoMoveAction(SpritePanelModel spritePanelModel){
		this.spritePanelModel = spritePanelModel;
	}

	@Override
	public void performAction(GameSprite gameSprite) {
		gameSprite.checkBounds();
		Rectangle currentSpriteRectangle = gameSprite.createCollider();
		for(GameSprite sprite: spritePanelModel.getSpriteArray()){
			if(sprite.isCollisionEvent() && sprite.isVisible()){
				Rectangle arrayListSpriteRectangle = sprite.createCollider();
				if(arrayListSpriteRectangle.intersects(currentSpriteRectangle) && !sprite.equals(gameSprite)){
					gameSprite.setVelY(-gameSprite.getVelY());
				}
			}
		}
		gameSprite.setPosX(gameSprite.getPosX()+gameSprite.getVelX());
		gameSprite.setPosY(gameSprite.getPosY()+gameSprite.getVelY());
	}

}
