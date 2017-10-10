package com.gamebuilder.strategy;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import com.gamebuilder.commands.SpriteCommand;
import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.Bullet;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public class FireAction implements SpriteActionInterface, Serializable {

	private SpritePanelModel spritePanelModel;
	private GamePanelView gamePanelView;
	Music music = new Music();
	public FireAction(SpritePanelModel spritePanelModel, GamePanelView gamePanelView){
		this.spritePanelModel = spritePanelModel;
		this.gamePanelView = gamePanelView;
	}
	@Override
	public void performAction(GameSprite gameSprite, GamePanelView gamePanelView) {

		int keyCode = gameSprite.getEventKeyCode();

		if(keyCode == KeyEvent.VK_SPACE){	
				
			GamePanelView.bulletArray.add(new Bullet(gameSprite.getPosX(), gameSprite.getPosY(),gameSprite,false));
			gameSprite.setEventKeyCode(0);

		}
	}

	
}
