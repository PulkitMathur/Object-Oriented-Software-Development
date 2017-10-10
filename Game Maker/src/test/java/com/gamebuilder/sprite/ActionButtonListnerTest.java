
package com.gamebuilder.sprite;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.gamebuilder.helpers.ActionButtonListener;
import com.gamebuilder.model.SpritePanelModel;

public class ActionButtonListnerTest {


	private ActionButtonListener actionButtonListner;
	private SpritePanelModel spritePanelModel;

	@Before
	public void setUp(){
		spritePanelModel = new SpritePanelModel();
		actionButtonListner = mock(ActionButtonListener.class);
		when(actionButtonListner.getSpritePanelModel()).thenReturn(spritePanelModel);
	}

	@Test
	public void testAction(){
		assertEquals(actionButtonListner.getSpritePanelModel(),spritePanelModel);
	}
}