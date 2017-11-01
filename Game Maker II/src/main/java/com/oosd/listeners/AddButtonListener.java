package com.oosd.listeners;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import com.oosd.view.GameMaker;
import com.oosd.view.GameStage;

public class AddButtonListener implements ActionListener {
	
	private GameMaker gameMaker;
	private GameStage gameStage;

	public AddButtonListener(GameMaker gameMaker, GameStage gameStage) {
		this.gameMaker = gameMaker;
		this.gameStage = gameStage;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(gameMaker.getReadoutComboBox().getSelectedItem().equals("Timer"))
		{
		//	if(Background.isBackgroundSet())
			//{
				GameStage.timerLabel.setForeground(Color.RED);
				GameStage.timerLabel.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));
				GameStage.timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
				GameStage.timerLabel.setText("  00:00");
				GameStage.timerLabel.setBounds(400, 5, 70, 30);
				GameStage.timerLabel.repaint();
			//}
			/*else
			{
				GameStage.timerLabel.setForeground(Color.RED);
				GameStage.timerLabel.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));
				GameStage.timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
				GameStage.timerLabel.setText("  00:00");
				GameStage.timerLabel.setBounds(400, 5, 70, 30);
				gameStage.add(GameStage.timerLabel);
				gameStage.repaint();
			}*/
		}
	}
		
}
