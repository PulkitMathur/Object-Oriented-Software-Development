package com.gamebuilder.helpers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.gamebuilder.model.SpritePanelModel;

public class GameButtonListenerTest {

	private SpritePanelModel spritePanelModel;

	private GameButtonListener gameButtonListener;

	@Before
	public void setUp(){
		spritePanelModel = new SpritePanelModel();
		gameButtonListener = mock(GameButtonListener.class);
		when(gameButtonListener.getSpritePanelModel()).thenReturn(spritePanelModel);
	}

	@Test
	public void testAction(){
		assertEquals(gameButtonListener.getSpritePanelModel(),spritePanelModel);
	}
}
