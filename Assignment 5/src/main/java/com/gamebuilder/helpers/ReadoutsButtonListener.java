package com.gamebuilder.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import com.gamebuidler.readouts.GameTime;
import com.gamebuilder.commands.TimerCommand;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.ui.GamePanelView;
import com.gamebuilder.ui.SpritePanelView;

public class ReadoutsButtonListener implements ActionListener{
	
	//private static Logger actionLog = Logger.getLogger("timeLogger");

	private SpritePanelModel spritePanelModel;
	private GamePanelView gamePanelView;
	
	public ReadoutsButtonListener(SpritePanelModel spritePanelModel, GamePanelView gamePanelView) {
		this.spritePanelModel = spritePanelModel;
		this.gamePanelView = gamePanelView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		System.out.println(actionCommand);
		GameTime gameTime = new GameTime();
		
		if (actionCommand.equals("Clock")) {
			//spritePanelModel.addTimer();
			gamePanelView.getGameTimeArray().add(gameTime);
		}
		
	}

}
