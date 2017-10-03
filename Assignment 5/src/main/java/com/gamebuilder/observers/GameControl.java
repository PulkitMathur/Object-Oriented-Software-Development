package com.gamebuilder.observers;

import java.util.ArrayList;

import com.gamebuidler.readouts.GameTime;
import com.gamebuilder.commands.SpriteCommand;
import com.gamebuilder.commands.TimerCommand;
import com.gamebuilder.sprite.GameSprite;

public class GameControl implements Observer {
	
	private Observable observable;
	private boolean play;
	private ArrayList<GameSprite> spriteArray;
	private ArrayList<GameTime> timeArray;
	
	public GameControl(ArrayList<GameSprite> spriteArray, Observable observable){
		this.spriteArray = spriteArray;
		this.observable = observable;
		this.observable.register(this);
		this.play = false;
	}

	@Override
	public void update() {
		if(play){
			for(GameSprite gameSprite : spriteArray){
				SpriteCommand spriteCommand = new SpriteCommand(gameSprite);
				spriteCommand.execute();
			}
			
			for(GameTime gameTime : timeArray) {
				TimerCommand timerCommand = new TimerCommand(gameTime);
				timerCommand.execute();
			}
		}
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public ArrayList<GameSprite> getSpriteArray() {
		return spriteArray;
	}

	public void setSpriteArray(ArrayList<GameSprite> spriteArray) {
		this.spriteArray = spriteArray;
	}

}
