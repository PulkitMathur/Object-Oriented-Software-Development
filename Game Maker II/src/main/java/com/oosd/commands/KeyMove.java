package com.oosd.commands;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;

import com.oosd.model.Bullet;
import com.oosd.model.Sprite;
import com.oosd.model.Vector;
import com.oosd.utils.Music;
import com.oosd.utils.Constants;
import com.oosd.view.GameStage;

public class KeyMove implements KeyListener, Constants {
	int spriteDir ;
	private Sprite sprite;
	private GameStage game;
	private String direction;
	private int keyPress;
	private int centerX = 0;
	private int centerY = 0;
	private CopyOnWriteArrayList<Bullet> bulletList;
	private Music music = new Music();
	
	
	public static final Logger logger = Logger.getLogger(KeyMove.class);
	
	public  KeyMove(GameStage game)
	{
		this.game = game;
		this.bulletList = game.getBulletList();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		logger.info("Key Pressed.");
		switch (direction) {
		case KEY_PRESS_ACROSS: {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (sprite.getSpriteWidth()==50) {
					music.play(JUMP);
				}
				sprite.setxPosition(sprite.getxPosition()-20);	
				} 
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (sprite.getSpriteWidth()==50) {
						music.play(JUMP);
					}
					sprite.setxPosition(sprite.getxPosition()+20);	
				}
				if (e.getKeyCode() == KeyEvent.VK_UP){
					if (sprite.getSpriteWidth()==50) {
						music.play(JUMP);
					}
					sprite.setyPosition(sprite.getyPosition()-20);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN){
					if (sprite.getSpriteWidth()==50) {
						music.play(JUMP);
					}
					sprite.setyPosition(sprite.getyPosition()+20);
				}
			break;
		}

		case KEY_PRESS_HORIZONTAL: {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				sprite.setxPosition(sprite.getxPosition()-20);	
				} 
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					sprite.setxPosition(sprite.getxPosition()+20);	
				}
			break;
		}

		case KEY_PRESS_VERTICAL: {
			if (e.getKeyCode() == KeyEvent.VK_UP){
				sprite.setyPosition(sprite.getyPosition()-20);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN){
				sprite.setyPosition(sprite.getyPosition()+20);
			}
			break;
		}
		
		case KEY_PRESS_ROTATE: {
			
			 keyPress = e.getKeyCode();
			 keyPressRotate(keyPress);
			 
			
			break;
		}
		
		
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			int spriteXpos = sprite.getxPosition();
			int spriteYpos = sprite.getyPosition();
			
			int bulletXpos = spriteXpos + sprite.getSpriteWidth()/2 - Constants.BULLET_WIDTH/2;
			int bulletYpos = spriteYpos + sprite.getSpriteHeight();
			
			try {
				music.play(LASER);
				bulletList.add(new Bullet(bulletXpos, bulletYpos, new Vector(game.getRotationDegree())));
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
		
		
		// bottom
		if(sprite.getyPosition()>=game.getHeight()-sprite.getSpriteHeight()){
			sprite.setyPosition(game.getHeight()-sprite.getSpriteHeight());
		}
		// top
		if(sprite.getyPosition()<=ZERO){
			sprite.setyPosition(ZERO);
		}
		// left
		if(sprite.getxPosition()<=ZERO) {
			sprite.setxPosition(ZERO);
		}
		//right
		if(sprite.getxPosition()>=game.getWidth()-sprite.getSpriteWidth()){
			sprite.setxPosition(game.getWidth()-sprite.getSpriteWidth());
		}
		if(direction != KEY_PRESS_ROTATE)
		sprite.getSpriteLabel().setBounds(sprite.getxPosition(), sprite.getyPosition(), sprite.getSpriteWidth(), sprite.getSpriteHeight());
		//GameStage.backgroundImage.update(game.getGraphics());

	}
	
	public void keyPressRotate(int keyPressed) {
		if (keyPressed == KeyEvent.VK_LEFT) {				
				game.setRotationDegree(-Math.PI/6);
			} 
			if (keyPressed == KeyEvent.VK_RIGHT) {
				game.setRotationDegree(Math.PI/6);
			}
	}
		/*public void keyPressRotate(int keyPressed) {
				
			int xPos = sprite.getxPosition();
			int yPos = sprite.getyPosition();
			
			if(centerX == 0 && centerY ==0){
				this.centerX = sprite.getxPosition() + sprite.getSpriteWidth()/2;
				this.centerY = sprite.getyPosition() + sprite.getSpriteHeight()/2;
			}
			
				if (keyPressed == KeyEvent.VK_LEFT) {				
				xPos = xPos - 20;
				sprite.setxPosition(xPos);
				} 
				if (keyPressed == KeyEvent.VK_RIGHT) {
					xPos = xPos + 20;
					sprite.setxPosition(xPos);
				}
				if (keyPressed == KeyEvent.VK_UP) {
					yPos = yPos - 20;
					sprite.setyPosition(yPos);
					} 
					if (keyPressed == KeyEvent.VK_DOWN) {
						yPos = yPos + 20;
						sprite.setyPosition(yPos);
					}
		}*/
	

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite sprite, String direction) {
		this.sprite = sprite;
		this.direction = direction;
	}
	public String getDirection() {
		return direction;
	}
	
	
}
