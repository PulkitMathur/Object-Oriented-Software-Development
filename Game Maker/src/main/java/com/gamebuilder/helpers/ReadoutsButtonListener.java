package com.gamebuilder.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gamebuidler.readouts.GameTime;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.ui.GamePanelView;

public class ReadoutsButtonListener implements ActionListener{

	private SpritePanelModel spritePanelModel;
	private GamePanelView gamePanelView;
	
	public ReadoutsButtonListener(SpritePanelModel spritePanelModel, GamePanelView gamePanelView) {
		this.spritePanelModel = spritePanelModel;
		this.gamePanelView = gamePanelView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		GameTime gameTime = new GameTime();
		
		if (actionCommand.equals("Clock")) {
			//spritePanelModel.addTimer();
			gamePanelView.getGameTimeArray().add(gameTime);
		}
		
	}

}
