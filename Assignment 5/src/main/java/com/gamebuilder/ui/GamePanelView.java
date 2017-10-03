package com.gamebuilder.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.gamebuidler.readouts.GameTime;
import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.sprite.GameSprite;

public class GamePanelView extends JPanel {
	
	private ArrayList<GameSprite> gameSpriteArray;
	private ArrayList<GameTime> gameTimeArray;
	
	private static Logger gamePanelLog = Logger.getLogger("gamePanelLogger");
	
	public boolean play = false;
	public GamePanelView(){
		this.setSize(GameConstants.GAME_PANEL_DIMENSION);
		this.setBackground(Color.GRAY);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setFocusTraversalKeysEnabled(false);
		gameSpriteArray = new ArrayList<GameSprite>();
		gameTimeArray = new ArrayList<GameTime>();
	}
	
	public ArrayList<GameTime> getGameTimeArray() {
		return gameTimeArray;
	}

	public void setGameTimeArray(ArrayList<GameTime> gameTimeArray) {
		this.gameTimeArray = gameTimeArray;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		try{
			for (GameSprite gameSprite : gameSpriteArray){
				gameSprite.getImageInterface().setImage(gameSprite);
				if(gameSprite.isVisible()){
					gameSprite.draw(g);
				}
			}
			for (GameTime gameTimer : gameTimeArray) {
				g.drawString(gameTimer.getText(), 300, 40);
			}
		}catch(NullPointerException e){
			gamePanelLog.error("Sprite ArrayList not created " + e.fillInStackTrace());
		}
		
	}

	public ArrayList<GameSprite> getGameSpriteArray() {
		return gameSpriteArray;
	}

	public void setGameSpriteArray(ArrayList<GameSprite> gameSpriteArray) {
		this.gameSpriteArray = gameSpriteArray;
	}

	public void setGameTimerArray(ArrayList<GameTime> timeArray) {
		// TODO Auto-generated method stub
		
	}

}
