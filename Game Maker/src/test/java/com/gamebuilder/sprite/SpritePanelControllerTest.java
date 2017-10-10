package com.gamebuilder.sprite;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gamebuilder.controller.SpritePanelController;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.ui.GamePanelView;
import com.gamebuilder.ui.SpritePanelView;

public class SpritePanelControllerTest {
	
	private SpritePanelModel spritePanelModel;
	private SpritePanelView spritePanelView;
	private GamePanelView gamePanelView;
	
	@Before
	public void setUp(){
		spritePanelModel = new SpritePanelModel();
		spritePanelView = new SpritePanelView();
		gamePanelView = new GamePanelView();
	}
	
	@Test
	public void testAction(){
		SpritePanelController spritePanelController = new SpritePanelController(spritePanelModel, spritePanelView, gamePanelView);
		
		assertEquals(spritePanelController.getSpritePanelModel(),this.spritePanelModel);
	}
}
