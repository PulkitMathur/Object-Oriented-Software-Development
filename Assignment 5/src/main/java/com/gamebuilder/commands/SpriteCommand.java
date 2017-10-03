package com.gamebuilder.commands;

import java.awt.event.KeyEvent;

import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.strategy.SpriteActionInterface;
import com.gamebuilder.strategy.SpriteEventInterface;

public class SpriteCommand implements Command {
	
	private GameSprite gameSprite;
	private int initX, initY;
	private SpriteActionInterface actionInterface;
	private SpriteEventInterface eventInterface;
	
	public SpriteCommand(GameSprite gameSprite){
		this.gameSprite = gameSprite;
		this.initX = gameSprite.getPosX();
		this.initY = gameSprite.getPosY();
		actionInterface = gameSprite.getActionInterface();
		eventInterface = gameSprite.getEventInterface();
	}

	@Override
	public void execute() {
		actionInterface.performAction(gameSprite);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	public GameSprite getGameSprite() {
		return gameSprite;
	}

	public void setGameSprite(GameSprite gameSprite) {
		this.gameSprite = gameSprite;
	}

	public int getInitX() {
		return initX;
	}

	public void setInitX(int initX) {
		this.initX = initX;
	}

	public int getInitY() {
		return initY;
	}

	public void setInitY(int initY) {
		this.initY = initY;
	}

	public SpriteActionInterface getActionInterface() {
		return actionInterface;
	}

	public void setActionInterface(SpriteActionInterface actionInterface) {
		this.actionInterface = actionInterface;
	}

	public SpriteEventInterface getEventInterface() {
		return eventInterface;
	}

	public void setEventInterface(SpriteEventInterface eventInterface) {
		this.eventInterface = eventInterface;
	}

}
