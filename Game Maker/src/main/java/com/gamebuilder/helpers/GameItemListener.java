package com.gamebuilder.helpers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.apache.log4j.Logger;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.ui.SpritePanelView;

public class GameItemListener implements ItemListener{
	
	private static Logger actionLog = Logger.getLogger("actionLogger");
	private SpritePanelModel spritePanelModel;
	private SpritePanelView spritePanelView;
	
	public GameItemListener(SpritePanelModel spritePanelModel, SpritePanelView spritePanelView){
		this.spritePanelModel = spritePanelModel;
		this.spritePanelView = spritePanelView;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {

		int gameIndex = spritePanelView.getGameComboBox().getSelectedIndex();
		actionLog.debug("Index: " + spritePanelView.getGameComboBox().getSelectedIndex());
		switch(gameIndex){
			case 1: 
				actionLog.debug("Frogger Selected");
				break;
				
			case 2: 
				actionLog.debug("Asteroids Selected");
				break;
				
			case 3: 
				actionLog.debug("Space Invader Selected");
				break;
				
			default:
				actionLog.debug("No Game Selected");
				break;
		}
	}
}
