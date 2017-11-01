package com.oosd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.apache.log4j.Logger;

import com.oosd.commands.AutoMove;
import com.oosd.commands.Bounce;
import com.oosd.commands.KeyMove;
import com.oosd.events.CollisionBottom;
import com.oosd.events.CollisionLeft;
import com.oosd.events.CollisionRight;
import com.oosd.events.CollisionTop;
import com.oosd.events.Destroy;
import com.oosd.events.SpriteCollision;
import com.oosd.listeners.AddButtonListener;
import com.oosd.listeners.AddMusicButtonListener;
import com.oosd.listeners.ApplyButtonListener;
import com.oosd.listeners.LoadButtonListener;
import com.oosd.listeners.PlayButtonListener;
import com.oosd.listeners.ResetButtonListener;
import com.oosd.listeners.SaveButtonListener;
import com.oosd.model.Background;
import com.oosd.model.Sprite;
import com.oosd.utils.Constants;
import com.oosd.utils.Music;
import com.oosd.view.GameMaker;
import com.oosd.view.GameStage;
import com.oosd.view.LoadGameList;

public class GameController implements ActionListener, Constants {
	public static final Logger logger = Logger.getLogger(GameController.class);
	Timer timer;
	GameStage gameStage;
	GameMaker gameMaker;
	KeyMove keyMove;
	private Music music = new Music();
	private Background background;

	public GameController(GameStage gameStage, GameMaker gameMaker) {
		timer = new Timer(DEFAULT_TIMER_DELAY, this);
		this.gameStage = gameStage;
		this.background = gameStage.getBackgroundObject();

		keyMove = new KeyMove(gameStage);
		gameStage.addKeyListener(keyMove);

		this.gameMaker = gameMaker;
		gameMaker.addPlayButtonListener(new PlayButtonListener(this));
		gameMaker.addApplyButtonListener(new ApplyButtonListener(gameMaker));
		gameMaker.addSaveButtonListener(new SaveButtonListener(background));
		gameMaker.addLoadButtonListener(new LoadButtonListener(gameStage));
		gameMaker.addResetButtonListener(new ResetButtonListener(gameStage));
		gameMaker.addAddButtonListener(new AddButtonListener(gameMaker, gameStage));
		gameMaker.addAddMusicButtonListener(new AddMusicButtonListener(gameMaker));
	}

	public void startTimer() {
		timer.start();
	}

	/*	public void removeSpritesOnCrossingBounds(){
		for (int i = 0; i < Sprite.spriteList.size(); i++) {
			if(Sprite.spriteList.get(i).getxPosition()>Constants.GAME_STAGE_WIDTH -50)
				Sprite.spriteList.get(i).setxPosition(0);
			if(Sprite.spriteList.get(i).getyPosition()<0)
				Sprite.spriteList.get(i).setyPosition(Constants.GAME_STAGE_HEIGHT);
			Sprite sprite = Sprite.spriteList.get(i);
			if(outOfBounds(sprite)){
				int spriteIndex  = Sprite.spriteList.indexOf(sprite);
				Sprite.spriteList.remove(spriteIndex);	

				gameStage.remove(sprite.getSpriteLabel());
			}
		}
	}

	public boolean outOfBounds(Sprite sprite){
		if(sprite.getxPosition() > Constants.GAME_STAGE_WIDTH || sprite.getxPosition() < 0 ){
			return true;
		}
		else if(sprite.getyPosition() > Constants.GAME_STAGE_HEIGHT || sprite.getyPosition() < 0){
			return true;
		}
		return false;
	}
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		gameStage.revalidate();
		gameStage.repaint();



		for (int i = 0; i < Sprite.spriteList.size(); i++) {
			Sprite sprite = Sprite.spriteList.get(i);
			String action = sprite.action;
			HashMap<String, ArrayList<String>> collisionEventMap = sprite.getCollisionEventMap();

			switch (action) {

			case AUTO_MOVE_ACROSS: {
				AutoMove autoMove = new AutoMove(sprite, gameStage, action);
				autoMove.execute();
				logger.info("Automove Across");
				break;
			}

			case AUTO_MOVE_HORIZONTAL: {
				AutoMove autoMove = new AutoMove(sprite, gameStage, action);
				autoMove.execute();
				break;
			}

			case AUTO_MOVE_VERTICAL: {
				AutoMove autoMove = new AutoMove(sprite, gameStage, action);
				autoMove.execute();
				break;
			}

			case KEY_PRESS_ACROSS: {
				gameStage.requestFocus();
				keyMove.setSprite(sprite, action);
				break;
			}

			case KEY_PRESS_HORIZONTAL: {
				gameStage.requestFocus();
				keyMove.setSprite(sprite, action);
				break;
			}

			case KEY_PRESS_VERTICAL: {
				gameStage.requestFocus();
				keyMove.setSprite(sprite, action);
				break;
			}

			case KEY_PRESS_ROTATE: {
				gameStage.requestFocus();
				gameStage.setUserSprite(sprite);
				keyMove.setSprite(sprite, action);
				break;

			}
			}

			for (String key : collisionEventMap.keySet()) {


				if(key.equals(TOP_BOUNDARY)) {
					CollisionTop collisionTop = new CollisionTop(sprite, gameStage);
					if (collisionTop.execute()) {
						executeEvents(collisionEventMap.get(key), sprite, TOP_BOUNDARY);
						music.play(JAB);
						//break;
					}
				}
				if(key.equals(BOTTOM_BOUNDARY)) {
					CollisionBottom collisionBottom = new CollisionBottom(sprite, gameStage);
					if (collisionBottom.execute()) {
						executeEvents(collisionEventMap.get(key), sprite, BOTTOM_BOUNDARY);
						music.play(JAB);

					}
					//break;
				}

				if(key.equals(LEFT_BOUNDARY)) {
					CollisionLeft collisionLeft = new CollisionLeft(sprite, gameStage);
					if (collisionLeft.execute()) {
						executeEvents(collisionEventMap.get(key), sprite, LEFT_BOUNDARY);
						music.play(JAB);

					}
					//break;
				}

				if(key.equals(RIGHT_BOUNDARY)) {
					CollisionRight collisionRight = new CollisionRight(sprite, gameStage);
					if (collisionRight.execute()) {
						executeEvents(collisionEventMap.get(key), sprite, RIGHT_BOUNDARY);
						music.play(JAB);
					}
					//	break;
				}

				if(key.equals(ANOTHER_SPRITE)) {
					SpriteCollision spriteCollision = new SpriteCollision(sprite, gameStage);
					if (spriteCollision.execute()) {			
						executeEvents(collisionEventMap.get(key), sprite, ANOTHER_SPRITE);
						music.play(GAMEOVER);
					}
					//	break;
				}
			}
		}
	}
	//	removeSpritesOnCrossingBounds();


	private void executeEvents(ArrayList<String> eventList, Sprite sprite, String collisionFlag) {
		for (String event : eventList) {
			System.out.println(event);
			switch (event) {
			case DESTROY:

				if (Sprite.spriteList.contains(sprite)) {
					Destroy destroy = new Destroy(sprite, gameStage);
					destroy.execute();
				}
				break;

			case BOUNCE:
				Bounce bounce = new Bounce(sprite, collisionFlag);
				bounce.execute();
				System.out.println("bounce" + collisionFlag);
				break;

			case GAME_WIN:
				GameMaker.winFlagCount--;
				if (!(GameMaker.winFlagCount > 0)) {
					timer.stop();
					JOptionPane.showMessageDialog(null, "Game Won");

					SaveScoreController saveScoreController = new SaveScoreController(PlayButtonListener.playerName, GameStage.score, LoadGameList.currentGameId, LoadGameList.currentGameName);
					saveScoreController.execute();
				}
				break;

			case GAME_LOSE:

				GameMaker.loseFlagCount--;
				if (!(GameMaker.loseFlagCount > 0)) {
					timer.stop();
					JOptionPane.showMessageDialog(null, "Game Lose");
					
					SaveScoreController saveScoreController = new SaveScoreController(PlayButtonListener.playerName, GameStage.score, LoadGameList.currentGameId, LoadGameList.currentGameName);
					saveScoreController.execute();
				}
				break;

			}
		}
	}
}



