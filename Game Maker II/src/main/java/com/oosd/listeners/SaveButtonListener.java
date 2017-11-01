package com.oosd.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.oosd.controller.SaveController;
import com.oosd.model.Background;
import com.oosd.model.Sprite;
import com.oosd.view.GameMaker;

public class SaveButtonListener implements ActionListener {

	Background background;
	
	public SaveButtonListener(Background background)
	{
		this.background = background;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//JFileChooser fileChooser = new JFileChooser();
		//int result = fileChooser.showSaveDialog(null);
		
		String gameName = JOptionPane.showInputDialog("Name of the Game");
		
		HashMap<String, Object> savableObject = new HashMap<String, Object>();
		savableObject.put("backgroundImage", background.getCurrentBackgroundKey());
		savableObject.put("spriteList", Sprite.spriteList);
		savableObject.put("win", GameMaker.winFlagCount);
		savableObject.put("lose", GameMaker.loseFlagCount);
		
		//if(result == JFileChooser.APPROVE_OPTION)
		//{
			//SaveController saveController = new SaveController(fileChooser.getSelectedFile());
			SaveController saveController = new SaveController(gameName, savableObject);
			saveController.execute();	
		//}
		
	}

}