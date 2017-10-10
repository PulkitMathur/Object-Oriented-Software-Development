package com.gamebuilder.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gamebuilder.controller.SpritePanelController;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.strategy.AutoMoveVerticalAction;
import com.gamebuilder.strategy.SpriteActionInterface;
import com.gamebuilder.ui.GamePanelView;

public class GameLogicButtonListener implements ActionListener {
	private SpritePanelModel spritePanelModel;
	private GamePanelView gamePanelView;
	private SpritePanelController spritePanelController;
	
	private static Logger buttonLog = Logger.getLogger("buttonLogger");
	
	public GameLogicButtonListener(SpritePanelController spritePanelController){
		this.spritePanelModel = spritePanelController.getSpritePanelModel();
		this.gamePanelView = spritePanelController.getGamePanelView();
		this.spritePanelController = spritePanelController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		switch(actionCommand){
		case GameConstants.GAME_WIN:
			buttonLog.info("GAME_WIN Clicked");
			gameWinInterface();
			
			break;
		case GameConstants.GAME_LOSE:
			buttonLog.info("GAME_LOSE Clicked");
			gameLoseInterface();
			break;
			
		}
		
		
		
	}
	public void gameWinInterface(){
		spritePanelModel.setWinGame(true);
		System.out.println("win listen --->"+spritePanelModel.getWinGame());

	}
	public void gameLoseInterface(){
		

		spritePanelModel.setLoseGame(true);
		System.out.println("Lose listen--->"+spritePanelModel.getLoseGame());
	}
}
