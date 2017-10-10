
package com.gamebuilder.strategy;

import java.awt.Rectangle;
import java.io.Serializable;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public class AutoMoveAction implements SpriteActionInterface, Serializable {
	
	private static final long serialVersionUID = 4L;
	
	private SpritePanelModel spritePanelModel;
	private GamePanelView gamePanelView;
	
	public AutoMoveAction(SpritePanelModel spritePanelModel){
		this.spritePanelModel = spritePanelModel;
		this.gamePanelView = gamePanelView;
	}

	@Override
	public void performAction(GameSprite gameSprite, GamePanelView gamePanelView) {
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
		int newX = gameSprite.getPosX()+gameSprite.getVelX();

		
		int newY = gameSprite.getPosY()+gameSprite.getVelY();
		gameSprite.setPosX(newX);
		gameSprite.setPosY(newY);
	}

}

