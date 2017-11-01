package com.oosd.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.oosd.model.Sprite;
import com.oosd.view.GameStage;

public class ResetButtonListener implements ActionListener {

	private GameStage gameStage;
	
	public ResetButtonListener(GameStage gameStage) {
		this.gameStage = gameStage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("restart button");
		for(int i = 0; i < GameStage.addedSpriteLabels.size(); i++)
		{
			gameStage.remove(GameStage.addedSpriteLabels.get(i));
		}
		GameStage.addedSpriteLabels.clear();
		Sprite.spriteList.clear();
		gameStage.repaint();
		
	}

}