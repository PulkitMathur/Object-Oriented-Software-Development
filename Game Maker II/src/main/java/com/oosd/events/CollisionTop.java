package com.oosd.events;

import com.oosd.model.Sprite;
import com.oosd.utils.Constants;
import com.oosd.view.GameStage;

public class CollisionTop {
	
	private Sprite sprite;
	private GameStage gameStage;
	
	public CollisionTop(Sprite sprite, GameStage gameStage) {
		
		this.sprite = sprite;
		this.gameStage = gameStage;
	}
	
	public boolean execute() {
		
		if(sprite.getyPosition() <= Constants.ZERO) {
			return true;
		}
		return false;
	}
}

