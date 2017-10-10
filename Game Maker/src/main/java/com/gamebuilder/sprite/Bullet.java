package com.gamebuilder.sprite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.ui.GamePanelView;

public class Bullet {
	private GameSprite gameSprite;
	private int x, y, speedX, speedY;
	private boolean visible;
	private boolean bullerDir;
	
	public Bullet(int startX, int startY, GameSprite gameSprite, boolean bullerDir){
		x = startX;
		y = startY;
		speedX = GameConstants.BULLET_SPEED_X;
		speedY = GameConstants.BULLET_SPEED_Y;
		visible = true;
		this.gameSprite = gameSprite;
		this.bullerDir = bullerDir;
	}
	
	
	public boolean isBullerDir() {
		return bullerDir;
	}
	public void setBullerDir(boolean bullerDir) {
		this.bullerDir = bullerDir;
	}
	public GameSprite getGameSprite() {
		return gameSprite;
	}

	public void setGameSprite(GameSprite gameSprite) {
		this.gameSprite = gameSprite;
	}

	public void update(){
		if (bullerDir){
			y+=speedY;
		}else
			y-=speedY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,20,20);
	}
	public void draw(Graphics g, GamePanelView gamePanelView) {
		
		// System.out.println("draw bulet");
		 g.setColor(Color.GRAY);
		 g.fillOval(x-speedX,y,20,20);
		 
		// System.out.println("flk--->" + String.valueOf(x-speedX)+"     " + x);
		 g.setColor(Color.BLACK);
		 g.fillOval(x,y,20,20);	 
		 gamePanelView.repaint();
	}
	
}