package com.oosd.events;

import org.apache.log4j.Logger;

import com.oosd.commands.Bounce;
import com.oosd.model.Sprite;
import com.oosd.utils.Constants;
import com.oosd.view.GameStage;

public class CollisionLeft {
	
	private Sprite sprite;
	private GameStage gameStage;
	public static final Logger logger = Logger.getLogger(CollisionLeft.class);
	public CollisionLeft(Sprite sprite, GameStage gameStage) {
		
		this.sprite = sprite;
		this.gameStage = gameStage;
	}
	
	public boolean execute() {

		logger.info("COllision Left.");
		if(sprite.getxPosition() <= Constants.ZERO) {
			return true;
		}
		return false;
	}

}

