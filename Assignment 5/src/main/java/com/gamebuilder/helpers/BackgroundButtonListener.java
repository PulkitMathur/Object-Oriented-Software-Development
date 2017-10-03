package com.gamebuilder.helpers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.ui.GamePanelView;

public class BackgroundButtonListener implements ActionListener{
	
	private GamePanelView gamePanelView;
	private SpritePanelModel spritePanelModel;
	
	private static Logger backgroundRbLog = Logger.getLogger("backgroundRbLogger");
	
	public BackgroundButtonListener(SpritePanelModel spritePanelModel, GamePanelView gamePanelView) {
		this.spritePanelModel = spritePanelModel;
		this.gamePanelView = gamePanelView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String backgroundCommand = e.getActionCommand();
		
		switch(backgroundCommand) {
		case GameConstants.BLUE:
			backgroundRbLog.info("BLUE Background Selected: ");
			spritePanelModel.setBackgroundColor(Color.BLUE);
			gamePanelView.setBackground(spritePanelModel.getBackgroundColor());
			break;
		case GameConstants.GREEN:
			backgroundRbLog.info("GREEN Background Selected: ");
			spritePanelModel.setBackgroundColor(Color.GREEN);
			gamePanelView.setBackground(spritePanelModel.getBackgroundColor());
			break;
		case GameConstants.YELLOW:
			backgroundRbLog.info("YELLOW Background Selected: ");
			spritePanelModel.setBackgroundColor(Color.YELLOW);
			gamePanelView.setBackground(spritePanelModel.getBackgroundColor());
			break;
		}
	}
	
	
}
