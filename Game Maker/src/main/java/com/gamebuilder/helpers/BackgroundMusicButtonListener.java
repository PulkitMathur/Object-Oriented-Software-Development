package com.gamebuilder.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import org.apache.log4j.Logger;

import com.gamebuilder.strategy.Music;

public class BackgroundMusicButtonListener implements ActionListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	String fileName;

	private static Logger backgroundMusicRbLog = Logger.getLogger("backgroundMusicRbLogger");

	Music music = new Music();

	@Override
	public void actionPerformed(ActionEvent e) {
		String backgroundCommand = e.getActionCommand();
		switch (backgroundCommand) {
		case GameConstants.MARIOMUSIC:
			backgroundMusicRbLog.info("Mario Music");
			fileName = "sound/mario.mp3";
			stopMusic();
			playMusic(fileName);
			break;
		case GameConstants.TICKTOCK:
			backgroundMusicRbLog.info("Tick-Tock Music");
			fileName = "sound/Tick.mp3";
			stopMusic();
			playMusic(fileName);
			break;
		case GameConstants.NOMUSIC:
			backgroundMusicRbLog.info("No Music");
			stopMusic();
			break;
		}
	}

	private void playMusic(String fileName) {
		music.play(fileName);
	}

	private void stopMusic() {
		music.stop();
	}

}
