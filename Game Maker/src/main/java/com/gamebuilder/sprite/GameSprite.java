package com.gamebuilder.sprite;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.strategy.SpriteActionInterface;
import com.gamebuilder.strategy.SpriteEventInterface;
import com.gamebuilder.strategy.SpriteImageInterface;

public class GameSprite implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int posX, posY;
	private ImageIcon spriteImageIcon;
	//private SpriteActionInterface actionInterface;
	
	private ArrayList<SpriteActionInterface> actionInterfaces;
	private SpriteImageInterface imageInterface;
	private SpriteEventInterface eventInterface;
	private int velX,velY;
	private int keyCode;
	private boolean collisionEvent;
	private boolean keySideEvent;
	private boolean keyUpEvent;
	private boolean visible;
	private boolean winGame;
	private boolean loseGame;

	private boolean autoFire;
	
	public GameSprite(){
		this.posX = GameConstants.DEFAULT_X;
		this.posY = GameConstants.DEFAULT_Y;
		spriteImageIcon = new ImageIcon("drawable/Questionmark.png");
		this.velX = GameConstants.BALL_SPEED_X;
		this.velY = GameConstants.BALL_SPEED_Y;
		this.actionInterfaces = new ArrayList<SpriteActionInterface>();
		this.collisionEvent = false;
		this.keySideEvent = false;
		this.keyUpEvent = false;
		this.visible = true;
		this.autoFire = true;
		this.winGame = false;
		this.loseGame = false;
	}
	
	public GameSprite(GameSprite gameSprite){
		this.posX = gameSprite.posX;
		this.posY = gameSprite.posY;
		this.spriteImageIcon = gameSprite.spriteImageIcon;
		this.actionInterfaces = gameSprite.actionInterfaces;
		this.imageInterface = gameSprite.imageInterface;
		this.eventInterface = gameSprite.eventInterface;
		this.velX = gameSprite.velX;
		this.velY = gameSprite.velY;
		this.keyCode = gameSprite.keyCode;
		this.keySideEvent = gameSprite.keySideEvent;
		this.keyUpEvent = gameSprite.keyUpEvent;
		this.collisionEvent = gameSprite.collisionEvent;
		this.visible = gameSprite.visible;
		this.winGame = gameSprite.winGame;
		this.loseGame = gameSprite.loseGame;
	}
	
	
	public void draw(Graphics g){
		Image tempImage = spriteImageIcon.getImage();
		g.drawImage(tempImage, posX, posY, null);
	}
	
	// Function to check for boundary of the game panel window
	public void checkBounds(){
		if(posY <= 0){
			velY = -velY;
		}
		if(posY >= GameConstants.BOUND_HEIGHT){
			velY = -velY;
		}
		if(posX >= GameConstants.BOUND_WIDTH  || posX <= 0){
			velX = -velX;
		}
	}
	public boolean isAutoFire() {
		return autoFire;
	}
	public void setAutoFire(boolean autoFire) {
		this.autoFire = autoFire;
	}
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}
	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public ImageIcon getSpriteImageIcon() {
		return spriteImageIcon;
	}

	public void setSpriteImageIcon(ImageIcon spriteImageIcon) {
		this.spriteImageIcon = spriteImageIcon;
	}

//	public SpriteActionInterface getActionInterface() {
//		return actionInterface;
//	}
//
//	public void setActionInterface(SpriteActionInterface actionInterface) {
//		this.actionInterface = actionInterface;
//	}

	public SpriteImageInterface getImageInterface() {
		return imageInterface;
	}

	public ArrayList<SpriteActionInterface> getActionInterfaces() {
		return actionInterfaces;
	}

	public void setActionInterfaces(ArrayList<SpriteActionInterface> actionInterfaces) {
		this.actionInterfaces = actionInterfaces;
	}

	public void setImageInterface(SpriteImageInterface imageInterface) {
		this.imageInterface = imageInterface;
	}

	public SpriteEventInterface getEventInterface() {
		return eventInterface;
	}

	public void setEventInterface(SpriteEventInterface eventInterface) {
		this.eventInterface = eventInterface;
	}
	
	public Rectangle createCollider(){
		int width = spriteImageIcon.getIconWidth();
		int height = spriteImageIcon.getIconHeight();
		return new Rectangle(posX, posY, width, height);
	}
	
	public int getEventKeyCode() {
		return keyCode;
	}

	public void setEventKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

	public boolean isCollisionEvent() {
		return collisionEvent;
	}

	public void setCollisionEvent(boolean collisionEvent) {
		this.collisionEvent = collisionEvent;
	}

	public boolean isKeySideEvent() {
		return keySideEvent;
	}

	public void setKeySideEvent(boolean keySideEvent) {
		this.keySideEvent = keySideEvent;
	}

	public boolean isKeyUpEvent() {
		return keyUpEvent;
	}

	public void setKeyUpEvent(boolean keyUpEvent) {
		this.keyUpEvent = keyUpEvent;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean isWinGame() {
		return winGame;
	}

	public void setWinGame(boolean winGame) {
		this.winGame = winGame;
	}

	public boolean isLoseGame() {
		return loseGame;
	}

	public void setLoseGame(boolean loseGame) {
		this.loseGame = loseGame;
	}

}
