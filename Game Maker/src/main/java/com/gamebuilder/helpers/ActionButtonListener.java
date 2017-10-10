package com.gamebuilder.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;

import org.apache.log4j.Logger;

import com.gamebuilder.controller.SpritePanelController;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.strategy.AutoFireAction;
import com.gamebuilder.strategy.AutoMoveAction;
import com.gamebuilder.strategy.AutoMoveHorizontalAction;
import com.gamebuilder.strategy.AutoMoveVerticalAction;
import com.gamebuilder.strategy.BlowUpAction;
import com.gamebuilder.strategy.FireAction;
import com.gamebuilder.strategy.MoveAction;
import com.gamebuilder.strategy.SpriteActionInterface;
import com.gamebuilder.ui.GamePanelView;
import com.gamebuilder.ui.SpritePanelView;


public class ActionButtonListener implements ActionListener {
	
	private static Logger actionLog = Logger.getLogger("actionLogger");
	
	private SpritePanelModel spritePanelModel;
	private GamePanelView gamePanelView;
	private SpritePanelView spritePanelView;

	
	public ActionButtonListener(SpritePanelModel spritePanelModel, GamePanelView gamePanelView,  SpritePanelView spritePanelView){
		this.spritePanelModel = spritePanelModel;
		this.gamePanelView = gamePanelView;
		this.spritePanelView= spritePanelView;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	String actionCommand = e.getActionCommand();

  
		if(actionCommand==GameConstants.APPLY){
			clearInterface();
			ArrayList<AbstractButton> actionslist = spritePanelView.getBgActions();
			for(int i =0;i<actionslist.size()-1;i++){
					AbstractButton	button= actionslist.get(i);
					if(button.isSelected()){
					switch(button.getText()){
				//	switch(actionCommand){
					
						case GameConstants.USER_CTRL_MOVE:
							actionLog.info("Move Selected");
							moveInterface();
							break;
							
						case GameConstants.AUTOMOVE:
							actionLog.info("Automove Random Selected");
							autoMoveInterface();			
							break;
							
						case GameConstants.AUTOMOVE_HORIZONTAL:
							actionLog.info("Automove Horizontal Selected");
							autoMoveHorizontalInterface();
							break;
							
						case GameConstants.AUTOMOVE_VERTICAL:
							actionLog.info("Automove Vertical Selected");
							autoMoveVerticalInterface();
							break;
							
						case GameConstants.BLOWUP:
							actionLog.info("Blow Up Selected");
							blowUpInterface();			
							break;
							
						case GameConstants.SHOOT:
							actionLog.info("Shoot is Selected");
							fireInterface();
							break;
						case GameConstants.AUTOSHOOT:
							actionLog.info("Auto Shoot is Selected");
							autoFireInterface();
							break;
							
					}
				}
			}
			

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
	public void clearInterface(){
		
		spritePanelModel.setActionInterfaces(new ArrayList<SpriteActionInterface>());;
	}
	public void moveInterface(){
		SpriteActionInterface spriteAction = new MoveAction();
		spritePanelModel.getActionInterfaces().add(spriteAction);
	}
	public void fireInterface(){
		SpriteActionInterface spriteAction = new FireAction(spritePanelModel,gamePanelView);
		spritePanelModel.getActionInterfaces().add(spriteAction);
	}
	
	public void autoFireInterface(){
		SpriteActionInterface spriteAction = new AutoFireAction(spritePanelModel,gamePanelView);
		spritePanelModel.getActionInterfaces().add(spriteAction);
	}
	public void autoMoveInterface(){
		SpriteActionInterface spriteAction = new AutoMoveAction(spritePanelModel);
		spritePanelModel.getActionInterfaces().add(spriteAction);
	}
	
	public void autoMoveHorizontalInterface(){
		SpriteActionInterface spriteAction = new AutoMoveHorizontalAction(spritePanelModel);
		spritePanelModel.getActionInterfaces().add(spriteAction);
	}
	
	public void autoMoveVerticalInterface(){
		SpriteActionInterface spriteAction = new AutoMoveVerticalAction(spritePanelModel);
		spritePanelModel.getActionInterfaces().add(spriteAction);
	}
	
	public void blowUpInterface(){
		SpriteActionInterface spriteAction = new BlowUpAction(spritePanelModel,gamePanelView);
		spritePanelModel.getActionInterfaces().add(spriteAction);
	}

}
