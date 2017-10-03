package com.gamebuilder.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import com.gamebuidler.readouts.GameTime;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.strategy.SpriteActionInterface;
import com.gamebuilder.strategy.SpriteEventInterface;
import com.gamebuilder.strategy.SpriteImageInterface;

public class SpritePanelModel implements Serializable{
	
	private static final long serialVersionUID = 13L;
	
	private GameSprite gameSprite;
	private ArrayList<GameSprite> spriteArray;
	private GameTime gameTime;
	private ArrayList<GameTime> timeArray;
	private Color backgroundColor;
	
	public GameTime getGameTime() {
		return gameTime;
	}

	public void setGameTime(GameTime gameTime) {
		this.gameTime = gameTime;
	}

	public ArrayList<GameTime> getTimeArray() {
		return timeArray;
	}

	public void setTimeArray(ArrayList<GameTime> timeArray) {
		this.timeArray = timeArray;
	}

	public SpritePanelModel(){
		this.gameSprite = new GameSprite();
		this.spriteArray = new ArrayList<GameSprite>();
		this.backgroundColor = Color.GRAY;
	}
	
	public void setActionInterface(SpriteActionInterface actionInterface){
		gameSprite.setActionInterface(actionInterface);
	}
	
	public void setImageInterface(SpriteImageInterface imageInterface){
		gameSprite.setImageInterface(imageInterface);
	}
	
	public void setEventInterface(SpriteEventInterface eventInterface){
		gameSprite.setEventInterface(eventInterface);
		gameSprite.getEventInterface().addEvent(gameSprite);
	}
	
	public void addSprite(){
		spriteArray.add(new GameSprite(gameSprite));
	}
	
	public void removeSprite(GameSprite gameSprite){
		spriteArray.remove(gameSprite);
	}

	public void addTimer() {
		timeArray.add(new GameTime());
	}
	
	public ArrayList<GameSprite> getSpriteArray() {
		return spriteArray;
	}

	public GameSprite getGameSprite() {
		return gameSprite;
	}

	public void setGameSprite(GameSprite gameSprite) {
		this.gameSprite = gameSprite;
	}

	public void setSpriteArray(ArrayList<GameSprite> spriteArray) {
		this.spriteArray = spriteArray;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
}
