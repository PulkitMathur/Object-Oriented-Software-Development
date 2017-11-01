package com.oosd.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.oosd.controller.LoadController;
import com.oosd.view.GameStage;
import com.oosd.view.LoadGameList;

public class LoadButtonListener implements ActionListener {

	GameStage gameStage;
	
	public LoadButtonListener(GameStage gameStage)
	{
		this.gameStage = gameStage;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//JFileChooser fileChooser = new JFileChooser();
		//int result = fileChooser.showOpenDialog(null);
		//if(result == JFileChooser.APPROVE_OPTION)
		//{
		
			//LoadController loadController = new LoadController(fileChooser.getSelectedFile(), gameStage);
			//loadController.execute();
		//}
		LoadGameList loadGameList = new LoadGameList(gameStage);
		loadGameList.setVisible(true);
	}

}
