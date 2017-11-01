package com.oosd.commands;
import com.oosd.model.Sprite;
import com.oosd.utils.Constants;
import com.oosd.view.GameStage;

public class AutoMove implements Constants, CommandInterface {
	
	Sprite sprite;
	String direction;
	GameStage gameStage;
	
	
	public AutoMove(Sprite sprite, GameStage gameStage, String direction) {
		this.sprite = sprite;
		this.gameStage = gameStage;
		this.direction = direction;
	}
	
	public void execute() {
		
		int xPosition = sprite.getxPosition();
		int yPosition = sprite.getyPosition();
		
		int width = sprite.getSpriteWidth();
		int height = sprite.getSpriteHeight();
		
		int xVel = sprite.getxVel();
		int yVel = sprite.getyVel();
		//Update sprite position values
		switch(direction){
			case AUTO_MOVE_ACROSS: {
				sprite.setxPosition(xPosition + xVel);
				sprite.setyPosition(yPosition + yVel);
				break;
			}
	
			case AUTO_MOVE_HORIZONTAL: {
				sprite.setxPosition(xPosition + xVel);
				break;
			}
	
			case AUTO_MOVE_VERTICAL: {
				sprite.setyPosition(yPosition + yVel);
				break;
			} 
		}
		
		
		

		sprite.getSpriteLabel().setBounds(xPosition+xVel, yPosition + yVel, width, height);
		//GameStage.backgroundImage.update(gameStage.getGraphics());
	}
}
