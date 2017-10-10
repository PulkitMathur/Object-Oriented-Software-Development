package com.gamebuilder.commands;

import org.apache.log4j.Logger;

import com.gamebuidler.readouts.GameTime;

public class TimerCommand implements Command{

	private static Logger log = Logger.getLogger("timeLogger");
	private GameTime timeDisplay;
	private String initTime, text;
	private int runningTime;
	
	public TimerCommand(GameTime timeDisplay) {
		this.timeDisplay = timeDisplay;
	}

	@Override
	public void execute() {
		initTime = timeDisplay.getText();
		runningTime = timeDisplay.getTime();
		timeDisplay.setTime(runningTime + 25);
		
		if (runningTime % 1000 == 0 ) {
			int currTime = runningTime/1000;
			int gameMin = currTime / 60;
			int gameSec = currTime % 60;
			String minText = "", secText = "";
			
			if(gameMin < 10){
				minText = "0" + gameMin;
			} else {
				minText = "" +gameMin;
			}
			
			if(gameSec < 10){
				secText = "0" + gameSec;
			} else {
				secText = "" +gameSec;
			}
			
			text = minText + ":" + secText;
			log.debug(text);
			timeDisplay.setText(text);
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
	
	public String getText() {
		return text;
	}
}
