package com.oosd.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.oosd.model.Background;
import com.oosd.view.GameStage;

public class TestBackgroundController {

	private static String backGroundImagePath = "ball.png";
	//backGroundImagePath = GameStage.setBackGroundImagePath(backGroundImagePath);
	@Test
	public void test() {
		BackgroundController backgroundController = Mockito.mock(BackgroundController.class);
		
		
		//Mockito.when(backgroundController.getBackGroundImagePath()).thenReturn(backGroundImagePath);
		//assertEquals(backgroundController.getBackGroundImagePath(),backGroundImagePath);
	}
	
	
}
