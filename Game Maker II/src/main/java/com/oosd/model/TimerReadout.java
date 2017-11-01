package com.oosd.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.oosd.view.GameStage;

public class TimerReadout implements ActionListener
{
	Timer timer;
	
	int timerSeconds = 0;
	public int getTimerSeconds() {
		return timerSeconds;
	}
	public void setTimerSeconds(int timerSeconds) {
		this.timerSeconds = timerSeconds;
	}

	int timerMinutes = 0;
	
	public TimerReadout()
	{
		timer = new Timer(1000, this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		timerSeconds++;
		
		if(timerSeconds == 59)
		{
			timerMinutes++;
			timerSeconds = 0;
			
		}
		
		GameStage.timerLabel.setText("  " + timerMinutes + " : " + timerSeconds);
		GameStage.timerLabel.repaint();
	}
	
	public void startTimer()
	{
		this.timer.start();
	}
	
	
}
