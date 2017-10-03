package com.gamebuilder.helpers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public class SpriteKeyListener implements KeyListener {
	
	private ArrayList<GameSprite> spriteArray;
	
	private GamePanelView gamePanelView;
	public SpriteKeyListener(GamePanelView gamePanelView){
		this.gamePanelView = gamePanelView;
	}

	@Override
	public void keyTyped(KeyEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent e) {

			for (GameSprite gameSprite : gamePanelView.getGameSpriteArray()) {
				gameSprite.setEventKeyCode(e.getKeyCode());
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
