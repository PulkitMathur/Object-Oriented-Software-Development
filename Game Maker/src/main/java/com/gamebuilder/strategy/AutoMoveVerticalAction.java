package com.gamebuilder.strategy;

import java.awt.Rectangle;
import java.io.Serializable;

import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public class AutoMoveVerticalAction implements SpriteActionInterface, Serializable {
	
	private static final long serialVersionUID = 4L;
	
	private SpritePanelModel spritePanelModel;
	private boolean isSelected;
	
	public AutoMoveVerticalAction(SpritePanelModel spritePanelModel){
		this.spritePanelModel = spritePanelModel;
		this.isSelected = isSelected;
	}

	@Override
	public void performAction(GameSprite gameSprite, GamePanelView gamePanelView) {
		Rectangle currentSpriteRectangle = gameSprite.createCollider();
		for(GameSprite sprite: spritePanelModel.getSpriteArray()){
			if(sprite.isCollisionEvent() && sprite.isVisible()){
				Rectangle arrayListSpriteRectangle = sprite.createCollider();
				if(arrayListSpriteRectangle.intersects(currentSpriteRectangle) && !sprite.equals(gameSprite)){
					gameSprite.setVelY(-gameSprite.getVelY());
				}
			}
		}
	
		{
			gameSprite.setPosY(gameSprite.getPosY()+gameSprite.getVelY());
			if(gameSprite.getPosY() >= GameConstants.BOUND_HEIGHT)
			{
				gameSprite.setPosY(0);
			}
		}
	}

}
