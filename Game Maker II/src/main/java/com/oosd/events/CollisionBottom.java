package com.oosd.events;

import org.apache.log4j.Logger;

import com.oosd.commands.Bounce;
import com.oosd.model.Sprite;
import com.oosd.utils.Constants;
import com.oosd.view.GameStage;

public class CollisionBottom implements Constants {
	public static final Logger logger = Logger.getLogger(CollisionBottom.class);
	private Sprite sprite;
	private GameStage gameStage;
	
	public CollisionBottom(Sprite sprite, GameStage gameStage) 
	{	
		this.sprite = sprite;
		this.gameStage = gameStage;
	}
	
	public boolean execute() 
	{
		logger.info("Bottom Collision.");
		if(sprite.getyPosition() >= GAME_STAGE_HEIGHT - sprite.getSpriteHeight()) 
		{
			return true;
		}
		return false;
	}	
}
