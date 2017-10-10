package com.gamebuilder.commands;

import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.strategy.SpriteActionInterface;
import com.gamebuilder.strategy.SpriteEventInterface;
import com.gamebuilder.ui.GamePanelView;

public class SpriteCommand implements Command {
	
	private GameSprite gameSprite;
	private GamePanelView gamePanelView;
	private int initX, initY;
	private SpriteActionInterface actionInterface;
	private SpriteEventInterface eventInterface;

	
	public SpriteCommand(GameSprite gameSprite,GamePanelView gamePanelView ,SpriteActionInterface actionInterface ){
		this.gameSprite = gameSprite;
		this.gamePanelView = gamePanelView;
		this.initX = gameSprite.getPosX();
		this.initY = gameSprite.getPosY();
		this.actionInterface = actionInterface;
		eventInterface = gameSprite.getEventInterface();
	}

	@Override
	public void execute() {
		//if (actionInterface is instance of )
		
		
		actionInterface.performAction(gameSprite, gamePanelView);
		
	
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
