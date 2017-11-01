package com.oosd.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.oosd.controller.GameController;
import com.oosd.controller.SpriteController;
import com.oosd.model.TimerReadout;

public class PlayButtonListener implements ActionListener{
	
	private SpriteController spriteController;
	private GameController gameController;
	
	public static String playerName = "";

	public PlayButtonListener(GameController gameController) {
		this.spriteController = spriteController;
		this.gameController = gameController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Play Button");
		
		playerName = JOptionPane.showInputDialog("Enter your Name");
		
		gameController.startTimer();
		
		TimerReadout timerReadout = new TimerReadout();
		timerReadout.startTimer();
		
	}

}
