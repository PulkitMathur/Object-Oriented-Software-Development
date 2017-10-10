package com.gamebuilder.sprite;

import static org.junit.Assert.assertEquals;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import org.junit.Before;

import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.strategy.SpriteEventInterface;
import com.gamebuilder.strategy.SpriteImageInterface;

public class GameSpriteTest {

	ImageIcon imageIcon;
	String action;
	String event;
	int posX;
	int posY;
	ImageIcon tempSpriteIcon;
	Image tempImg;
	private SpriteImageInterface imageInterface;
	private SpriteEventInterface eventInterface;
	private Rectangle rect;
	//private ImageIcon spriteImageIcon;
	int width;
	int height;
	//adding more 
		private int velX;
		private int velY;
	
	@Before
	public void setUp() {
		imageIcon = new ImageIcon("drawable/soccer_ball.png");
		action = GameConstants.USER_CTRL_MOVE;
		event = GameConstants.UPDOWN;
		posX = 10;
		posY = 20;
		tempSpriteIcon = new ImageIcon("drawable/Questionmark.png");
		tempImg = tempSpriteIcon.getImage();
		rect = new Rectangle(GameConstants.DEFAULT_X, GameConstants.DEFAULT_Y, tempImg.getWidth(null), tempImg.getHeight(null));
		velX = GameConstants.BALL_SPEED_X;
		velY = GameConstants.BALL_SPEED_Y;				
	}
			
	
	public void checkTheGetAndSet(){		
		//Call the constructor 
		GameSprite gameSprite = new GameSprite();
		this.imageInterface = gameSprite.getImageInterface();
		tempSpriteIcon = gameSprite.getSpriteImageIcon();
	
		//test the getPosX method
		assertEquals(gameSprite.getPosX(), GameConstants.DEFAULT_X);
		
		//test the getPosY method
		assertEquals(gameSprite.getPosY(), GameConstants.DEFAULT_Y);
	
		//test the Sprite Image
				assertEquals(gameSprite.getSpriteImageIcon(), tempSpriteIcon);
				
				//test the Sprite Image Interface
				assertEquals(gameSprite.getImageInterface(), imageInterface);
				
				//test the Sprite Event Interface
				assertEquals(gameSprite.getEventInterface(), eventInterface);
				
				//test the Rectangle Collider
				assertEquals(gameSprite.createCollider(), rect);
				
				
				//test the getVelX method
				assertEquals(gameSprite.getVelX(), velX);
				
				//test the getVelY method
				assertEquals(gameSprite.getVelY(), velY);
		
	}
}





