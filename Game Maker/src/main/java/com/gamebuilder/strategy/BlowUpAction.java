package com.gamebuilder.strategy;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.Bullet;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public class BlowUpAction implements SpriteActionInterface, Serializable{
	
	private static final long serialVersionUID = 9L;
	
	private SpritePanelModel spritePanelModel;
	private GamePanelView gamePanelView;
	Music music = new Music();
	private int blowIndex;
	public BlowUpAction(SpritePanelModel spritePanelModel, GamePanelView gamePanelView){
		this.spritePanelModel = spritePanelModel;
		this.gamePanelView = gamePanelView;
		blowIndex=-1;
	}
	
	@Override
	public void performAction(GameSprite gameSprite, GamePanelView gamePanelView) {
		if(gameSprite.isCollisionEvent() && gameSprite.isVisible()){
			
			Rectangle currentSpriteRectangle = gameSprite.createCollider();
			ArrayList<GameSprite> gameSpriteArray = spritePanelModel.getSpriteArray();
			ArrayList<GameSprite> copylist = new ArrayList<GameSprite>( gamePanelView.getGameSpriteArray());
			for(GameSprite gameSpriteElement : copylist){
				Rectangle arrayListSpriteRectangle = gameSpriteElement.createCollider();
				if(arrayListSpriteRectangle.intersects(currentSpriteRectangle) && !gameSprite.equals(gameSpriteElement)){
//					gameSpriteElement.setVelX(-gameSpriteElement.getVelX());
//					gameSpriteElement.setVelY(-gameSpriteElement.getVelY());
					gameSprite.setVisible(false);
					blowIndex = 1;
					music.play("sound/Bomb.mp3");
					
					System.out.println("blowup sprite---->"+gameSprite.isLoseGame()+"then"+gameSprite.isWinGame());
					
					isGameWin( gameSprite);
					isGameLose( gameSprite);
				}
				if(blowIndex != -1){
				gamePanelView.getGameSpriteArray().remove(gameSprite);
				blowIndex = -1;
				}
			for(Bullet bullet : gamePanelView.getBulletArray()){
				Rectangle bulletRect = bullet.getBounds();
				if(bulletRect.intersects(currentSpriteRectangle) && !gameSprite.equals(bullet.getGameSprite())){
					
					gameSprite.setVisible(false);
					bullet.setVisible(false);
					blowIndex = 1;
					System.out.println("blowup bullet---->"+gameSprite.isLoseGame()+"then"+gameSprite.isWinGame());

					isGameWin( gameSprite);
					isGameLose( gameSprite);
					music.play("sound/Bomb.mp3");
				}
				if(blowIndex != -1){
					gamePanelView.getGameSpriteArray().remove(gameSprite);
					blowIndex = -1;
					}
			}
			
			}
		}
	}
	
	void isGameWin(GameSprite gameSprite){
		if(gameSprite.isWinGame()){
			JOptionPane.showMessageDialog(null, "Game win");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	void isGameLose(GameSprite gameSprite){
		if(gameSprite.isLoseGame()){
			JOptionPane.showMessageDialog(null, "Game Lose");
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
