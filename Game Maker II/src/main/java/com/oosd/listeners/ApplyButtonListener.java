package com.oosd.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.oosd.view.GameMaker;

public class ApplyButtonListener implements ActionListener {
	
	private GameMaker gameMaker;

	public ApplyButtonListener(GameMaker gameMaker) {
		this.gameMaker = gameMaker;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Apply Button");
		if (!GameMaker.collisionEventMap.containsKey(gameMaker.getCollisionCheck().getSelectedItem().toString())) {
			System.out.println("collisionEventMap");
			GameMaker.collisionEventMap.put(gameMaker.getCollisionCheck().getSelectedItem().toString(), new ArrayList<String>());
			
		}
		
		if (gameMaker.getCheckboxDestroy().isSelected()) {
			GameMaker.collisionEventMap.get(gameMaker.getCollisionCheck().getSelectedItem().toString()).add(gameMaker.getCheckboxDestroy().getText());
			
		}

		if (gameMaker.getCheckboxBounce().isSelected()) {
			GameMaker.collisionEventMap.get(gameMaker.getCollisionCheck().getSelectedItem().toString()).add(gameMaker.getCheckboxBounce().getText());

		}

		if (gameMaker.getCheckboxWin().isSelected()) {
			GameMaker.collisionEventMap.get(gameMaker.getCollisionCheck().getSelectedItem().toString()).add(gameMaker.getCheckboxWin().getText());
			GameMaker.winFlag = true;
		}

		if (gameMaker.getCheckboxLose().isSelected()) {
			GameMaker.collisionEventMap.get(gameMaker.getCollisionCheck().getSelectedItem().toString()).add(gameMaker.getCheckboxLose().getText());
			GameMaker.LoseFlag  = true;
		}
	}
}
