package com.oosd.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.oosd.utils.Music;
import com.oosd.view.GameMaker;

public class AddMusicButtonListener implements ActionListener {

	private GameMaker gameMaker;
	private Music music = new Music();
	private String fileName;
	
	public AddMusicButtonListener(GameMaker gameMaker) {
		this.gameMaker = gameMaker;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(gameMaker.getMusicComboBox().getSelectedItem().equals("Space Invaders")) {
			fileName = "sound/05-earth.mp3";
			stopMusic();
			playMusic(fileName);
		}
		
		if(gameMaker.getMusicComboBox().getSelectedItem().equals("Frogger")) {
			fileName = "sound/08-honey-bee-hollow.mp3";
			stopMusic();
			playMusic(fileName);
		}
		if(gameMaker.getMusicComboBox().getSelectedItem().equals("Atari")) {
			fileName = "sound/atari.mp3";
			stopMusic();
			playMusic(fileName);
		}
			
	}
	
	private void playMusic(String fileName) {
		music.play(fileName);
	}

	private void stopMusic() {
		music.stop();
	}

}
