package com.oosd.commands;

import org.apache.log4j.Logger;

import com.oosd.model.Sprite;
import com.oosd.utils.Constants;

public class Bounce implements Constants, CommandInterface
{
	Sprite sprite;
	String collision;
	public static final Logger logger = Logger.getLogger(Bounce.class);
	public Bounce(Sprite sprite, String collision){
		this.sprite = sprite;
		this.collision = collision; 
	}
	
	public void execute()
	{
		if(collision.equals(TOP_BOUNDARY) || collision.equals(BOTTOM_BOUNDARY)) {
			sprite.setyVel(-(sprite.getyVel()));
			logger.debug("Sprite Top Collision Invoked.");
		}
		
		else if(collision.equals(RIGHT_BOUNDARY) || collision.equals(LEFT_BOUNDARY)) {
			sprite.setxVel(-(sprite.getxVel()));
			logger.debug("Sprite side collision INvoked.");
		}
		
		else if(collision.equals(ANOTHER_SPRITE)) {

			sprite.setyVel(-(sprite.getyVel()));			
			logger.debug("2 Sprites collision invoked.");
		}		
	}
}
