package com.gamebuilder.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.gamebuilder.controller.SpritePanelController;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.ui.GamePanelView;

public class GameButtonListener implements ActionListener {
	
	private SpritePanelModel spritePanelModel;
	private GamePanelView gamePanelView;
	private SpritePanelController spritePanelController;
	
	private static Logger buttonLog = Logger.getLogger("buttonLogger");
	
	public GameButtonListener(SpritePanelController spritePanelController){
		this.spritePanelModel = spritePanelController.getSpritePanelModel();
		this.gamePanelView = spritePanelController.getGamePanelView();
		this.spritePanelController = spritePanelController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		switch(actionCommand){
		case GameConstants.DRAW:
			buttonLog.info("Draw Clicked");
			spritePanelModel.addSprite();
			gamePanelRefresh();
			break;
		case GameConstants.PLAY:
			buttonLog.info("Play Clicked");
			gamePanelRefresh();
			spritePanelController.setGamePlay(true);
			break;
		case GameConstants.PAUSE:
			buttonLog.info("Pause Clicked");
			spritePanelController.setGamePlay(false);
			break;
		case GameConstants.SAVE:
			buttonLog.info("Save Clicked");
			saveFunctionality();
			break;
		case GameConstants.LOAD:
			buttonLog.info("Load Clicked");
			loadFunctionality();
			break;
		}
	}
	
	public void gamePanelRefresh(){
		gamePanelView.setGameSpriteArray(spritePanelModel.getSpriteArray());
		gamePanelView.setGameTimerArray(spritePanelModel.getTimeArray());
		gamePanelView.repaint();
	}
	
	public void saveFunctionality(){
		GameSave gameSave = new GameSave(spritePanelController);
		if(gameSave.serialize()){
			JOptionPane.showMessageDialog(null,
					"Save Successful",
					"Save",
					JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null,
					"Error Saving File",
					"Save",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void loadFunctionality(){
		GameLoad gameLoad = new GameLoad();
		try{
			Savable loadSaveable = gameLoad.deserialize();
			spritePanelController.getSpritePanelModel().setSpriteArray(loadSaveable.spriteArrayList);
			spritePanelController.getSpritePanelModel().setBackgroundColor(loadSaveable.backGroundColor);
			spritePanelController.getGamePanelView().setBackground(spritePanelController.getSpritePanelModel().getBackgroundColor());
			gamePanelRefresh();
		}catch(Exception e){
			buttonLog.error("Loading Failed" + e.getLocalizedMessage());
		}
		
	}

	public SpritePanelModel getSpritePanelModel() {
		return spritePanelModel;
	}

	public void setSpritePanelModel(SpritePanelModel spritePanelModel) {
		this.spritePanelModel = spritePanelModel;
	}

	public GamePanelView getGamePanelView() {
		return gamePanelView;
	}

	public void setGamePanelView(GamePanelView gamePanelView) {
		this.gamePanelView = gamePanelView;
	}

	public SpritePanelController getSpritePanelController() {
		return spritePanelController;
	}

	public void setSpritePanelController(SpritePanelController spritePanelController) {
		this.spritePanelController = spritePanelController;
	}

}
