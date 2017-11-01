package com.oosd.controller;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Test;
import org.mockito.Mockito;

import com.oosd.model.Sprite;
import com.oosd.utils.Constants;
import com.oosd.view.GameMaker;
import com.oosd.view.GameStage;

public class TestGameController {
	
	@Test
	public void test() {
		GameStage gameStage = Mockito.mock(GameStage.class);
		GameMaker gameMaker = Mockito.mock(GameMaker.class);
		
		GameController gameController = new GameController(gameStage, gameMaker);
		
		Sprite sprite = new Sprite(new JLabel("Test"), Constants.GAME_STAGE_WIDTH+1, 100, 100, 100, "None");
		
		//assertEquals(true, gameController.outOfBounds(sprite));
	}
	
	@Test
	public void test2() {
		GameStage gameStage = Mockito.mock(GameStage.class);
		GameMaker gameMaker = Mockito.mock(GameMaker.class);
		
		GameController gameController = new GameController(gameStage, gameMaker);
		
		Sprite sprite = new Sprite(new JLabel("Test"), Constants.GAME_STAGE_WIDTH, 100, 100, 100, "None");
		
		//assertEquals(false, gameController.outOfBounds(sprite));
	
		Sprite.spriteList.add(sprite);
	}
	
	
	@Test
	public void test3() {
		//GameStage gameStage = Mockito.mock(GameStage.class);
		//GameMaker gameMaker = Mockito.mock(GameMaker.class);
		GameStage gameStage = new GameStage();
		GameMaker gameMaker = new GameMaker(gameStage);
		
		GameController gameController = new GameController(gameStage, gameMaker);
		
		Sprite sprite = new Sprite(new JLabel("Test"), Constants.GAME_STAGE_WIDTH+1, 100, 100, 100, "None");
		System.out.println(Constants.GAME_STAGE_WIDTH+1);
		Sprite.spriteList.add(sprite);
		
		//assertEquals(2, Sprite.spriteList.size());
		
		//gameController.removeSpritesOnCrossingBounds();
		
		//assertEquals(1, Sprite.spriteList.size());
	}
}
