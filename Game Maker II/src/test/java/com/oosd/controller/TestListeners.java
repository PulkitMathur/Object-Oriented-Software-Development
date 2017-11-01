package com.oosd.controller;

import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;

import com.oosd.listeners.GameStageMouseListener;
import com.oosd.view.GameStage;

public class TestListeners {

	//private SpriteController spriteController = new SpriteController();
	private GameStage gameStage = new GameStage();
	
	@Test
	public void checkTheGeterAndSeter() {
		
		//GameStageMouseListener gameStageMouseListener = new GameStageMouseListener(spriteController, gameStage);
		
		GameStageMouseListener gameStageMouseListener = Mockito.mock(GameStageMouseListener.class);
		//Mockito.when(gameStageMouseListener.getSpriteController()).thenReturn(spriteController);
		//assert
		//assertEquals(spriteController, gameStageMouseListener.getSpriteController());
	}
	
}