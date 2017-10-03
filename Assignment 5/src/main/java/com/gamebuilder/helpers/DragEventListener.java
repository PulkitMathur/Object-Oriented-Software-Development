package com.gamebuilder.helpers;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public class DragEventListener implements MouseListener, MouseMotionListener {
	
	private GameSprite dragSprite;
	private GamePanelView gamePanelView;
	private boolean drag = false;
	
	public DragEventListener(GamePanelView gamePanelView){
		this.gamePanelView = gamePanelView;
	}
	

	private void checkBounds(MouseEvent e) {
		if (e.getX()>gamePanelView.getWidth()-dragSprite.getSpriteImageIcon().getIconWidth()) {
			dragSprite.setPosX(gamePanelView.getWidth()-dragSprite.getSpriteImageIcon().getIconWidth());
		}
		
		if (e.getX()<0) {
			dragSprite.setPosX(0);
		}
		
		if (e.getY()>gamePanelView.getHeight()-dragSprite.getSpriteImageIcon().getIconHeight()) {
			dragSprite.setPosY(gamePanelView.getHeight()-dragSprite.getSpriteImageIcon().getIconHeight());
		}
		
		if (e.getY()<0) {
			dragSprite.setPosY(0);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(drag){
			dragSprite.setPosX(e.getX());
			dragSprite.setPosY(e.getY());
			checkBounds(e);
			gamePanelView.repaint();
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for(GameSprite gameSprite : gamePanelView.getGameSpriteArray()){
			Rectangle rectangle = gameSprite.createCollider();
			if(rectangle.contains(e.getX(), e.getY())){
				//Add logger
				dragSprite = gameSprite;
				drag = true;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		dragSprite = null;
		drag = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}


	public GameSprite getDragSprite() {
		return dragSprite;
	}


	public void setDragSprite(GameSprite dragSprite) {
		this.dragSprite = dragSprite;
	}

}
