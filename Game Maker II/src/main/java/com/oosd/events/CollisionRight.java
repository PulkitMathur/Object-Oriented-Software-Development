package com.oosd.events;

import com.oosd.model.Sprite;
import com.oosd.view.GameStage;

public class CollisionRight {
	
	private Sprite sprite;
	private GameStage gameStage;
	
	public CollisionRight(Sprite sprite, GameStage gameStage) {
		
		this.sprite = sprite;
		this.gameStage = gameStage;
	}
	
	public boolean execute() {

		if(sprite.getxPosition() >= gameStage.getWidth()) {
			return true;
		}
		return false;
	}

}

