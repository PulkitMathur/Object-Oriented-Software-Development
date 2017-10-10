package com.gamebuilder.strategy;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import com.gamebuilder.commands.SpriteCommand;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.Bullet;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public class AutoFireAction implements SpriteActionInterface, Serializable {

	// int i;
	private SpritePanelModel spritePanelModel;
	private GamePanelView gamePanelView;
	Music music = new Music();

	public AutoFireAction(SpritePanelModel spritePanelModel, GamePanelView gamePanelView) {
		this.spritePanelModel = spritePanelModel;
		this.gamePanelView = gamePanelView;
	}

	@Override
	public void performAction(GameSprite gameSprite, GamePanelView gamePanelView) {


		if(gameSprite.isAutoFire()){

			Bullet bullet = new Bullet(gameSprite.getPosX(), gameSprite.getPosY(),gameSprite,true);
			GamePanelView.bulletArray.add(bullet);	
		}

	}
}