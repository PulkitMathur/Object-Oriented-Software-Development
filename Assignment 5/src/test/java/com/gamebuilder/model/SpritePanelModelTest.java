package com.gamebuilder.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import com.gamebuilder.sprite.GameSprite;

public class SpritePanelModelTest {

	private SpritePanelModel spritePanelModel;
	private ArrayList<GameSprite> gsList;
	
	@Before
	public void setUp(){
		 GameSprite gs1 = new GameSprite();
		 GameSprite gs2 = new GameSprite();
		 GameSprite gs3 = new GameSprite();
		 gsList = new ArrayList<GameSprite>();
		 gsList.add(gs1);
		 gsList.add(gs2);
		 gsList.add(gs3);
		 spritePanelModel = mock(SpritePanelModel.class);
		 when(spritePanelModel.getSpriteArray()).thenReturn(gsList);
	}
	
	@Test
	public void testAction(){
		assertEquals(spritePanelModel.getSpriteArray().size(),this.gsList.size());
	}
}
