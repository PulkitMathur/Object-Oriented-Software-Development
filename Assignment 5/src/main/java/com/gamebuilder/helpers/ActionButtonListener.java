package com.gamebuilder.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.strategy.BlowUpAction;
import com.gamebuilder.strategy.AutoMoveAction;
import com.gamebuilder.strategy.MoveAction;
import com.gamebuilder.strategy.SpriteActionInterface;


public class ActionButtonListener implements ActionListener {
	
	private static Logger actionLog = Logger.getLogger("actionLogger");
	
	private SpritePanelModel spritePanelModel;
	
	public ActionButtonListener(SpritePanelModel spritePanelModel){
		this.spritePanelModel = spritePanelModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		switch(actionCommand){
		case GameConstants.MOVE:
			actionLog.info("Move Selected");
			moveInterface();
			break;
		case GameConstants.AUTOMOVE:
			actionLog.info("Bounce Selected");
			autoMoveInterface();			
			break;
		case GameConstants.BLOWUP:
			actionLog.info("Blow Up Selected");
			blowUpInterface();			
			break;
		}

	}
	
	
	
	public static Logger getActionLog() {
		return actionLog;
	}

	public static void setActionLog(Logger actionLog) {
		ActionButtonListener.actionLog = actionLog;
	}

	public SpritePanelModel getSpritePanelModel() {
		return spritePanelModel;
	}

	public void setSpritePanelModel(SpritePanelModel spritePanelModel) {
		this.spritePanelModel = spritePanelModel;
	}

	public void moveInterface(){
		SpriteActionInterface spriteAction = new MoveAction();
		spritePanelModel.setActionInterface(spriteAction);
	}
	
	public void autoMoveInterface(){
		SpriteActionInterface spriteAction = new AutoMoveAction(spritePanelModel);
		spritePanelModel.setActionInterface(spriteAction);
	}
	
	public void blowUpInterface(){
		SpriteActionInterface spriteAction = new BlowUpAction(spritePanelModel);
		spritePanelModel.setActionInterface(spriteAction);
	}

}
