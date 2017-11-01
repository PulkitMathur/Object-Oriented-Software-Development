package com.oosd.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.oosd.controller.SpriteController;
import com.oosd.model.Sprite;
import com.oosd.view.GameStage;

public class GameStageMouseListener  implements MouseListener{
	
	private SpriteController spriteController;
	private GameStage gameStage;

	
	public GameStageMouseListener(SpriteController spriteController, GameStage gameStage) {
		this.spriteController = spriteController;
		this.gameStage = gameStage;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int xPosition = e.getX();
		int yPosition = e.getY();
		
		spriteController.addSprite(xPosition, yPosition);
		spriteController.updateView(gameStage);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}

	@Override
	public void mousePressed(MouseEvent e) {	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	public SpriteController getSpriteController() {
		return spriteController;
	}

	public void setSpriteController(SpriteController spriteController) {
		this.spriteController = spriteController;
	}


}
