package com.oosd.events;

import com.oosd.model.Sprite;
import com.oosd.view.GameStage;

public class Destroy {
	
	Sprite sprite;
	GameStage gameStage;

	public Destroy(Sprite sprite, GameStage gameStage) {		
		this.gameStage = gameStage;
		this.sprite = sprite;
	}
	
	public boolean execute(){		
		
		int spriteIndex  = Sprite.spriteList.indexOf(sprite);
		Sprite.spriteList.remove(spriteIndex);	
		GameStage.score = GameStage.score+1;
		gameStage.remove(sprite.getSpriteLabel());
		//GameStage.backgroundImage.update(gameStage.getGraphics());
		gameStage.revalidate();
		return true;

	}

	
}
