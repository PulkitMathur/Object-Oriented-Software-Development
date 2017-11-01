package com.oosd.events;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import com.oosd.model.Sprite;
import com.oosd.view.GameStage;

public class SpriteCollision {
	
	Sprite sprite;
	int spriteIndex;
	private static CopyOnWriteArrayList<Sprite> spriteList;
	
	GameStage gameStage;
	
	
	public SpriteCollision(Sprite sprite, GameStage gameStage) {
		this.sprite = sprite;
		this.gameStage = gameStage;
		spriteList = Sprite.spriteList;
		this.sprite = sprite;
		this.spriteIndex = Sprite.spriteList.indexOf(sprite);		
	}
	
	public boolean execute()
	{
		
		Rectangle r1 = this.sprite.getBounds();
		for (int i = 0; i < spriteList.size(); i++) 
		{

			if(i!=spriteIndex)
			{
				Sprite spriteApproaching=spriteList.get(i);
				Rectangle r2 = spriteApproaching.getBounds();
				
				if(r1.intersects(r2))
				{
					return true;
				}
			}
		}
		return false;
	}	
}