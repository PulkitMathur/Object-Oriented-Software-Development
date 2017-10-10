package com.gamebuidler.readouts;

import java.io.Serializable;

import javax.swing.JLabel;

public class GameTime extends JLabel implements Serializable {
	
	private static final long serialVersionUID = 10L;
	
	private String text;
	private int time;
	
	public GameTime() {
		text = "00:00";
		this.setText(text);
		this.setVisible(true);
	}

	public GameTime(GameTime gameTime) {
		gameTime.setText("00:00");
		gameTime.setVisible(true);
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void reset() {
		this.setText("00:00");
		this.setTime(0);
	}
	
}
