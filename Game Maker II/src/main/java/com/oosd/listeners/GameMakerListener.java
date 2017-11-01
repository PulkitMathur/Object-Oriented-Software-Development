package com.oosd.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import com.oosd.controller.BackgroundController;
import com.oosd.model.Background;
import com.oosd.model.Sprite;
import com.oosd.view.GameMaker;

public class GameMakerListener implements MouseListener {

	GameMaker gameMaker;
	/*private HashMap<String, JLabel> backgroundLabels;
	private HashMap<String, String> backGroundImagePaths; 
	*/

	public GameMakerListener(GameMaker gameMaker) {
		this.gameMaker = gameMaker;
		//this.backgroundLabels = GameMaker.getBackgroundLabels();
		//this.backGroundImagePaths = gameMaker.getBackGroundImagePaths();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}