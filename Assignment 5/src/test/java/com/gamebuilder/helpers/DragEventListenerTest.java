package com.gamebuilder.helpers;


import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import com.gamebuilder.sprite.GameSprite;

public class DragEventListenerTest {

	private GameSprite dragSprite;

	private DragEventListener dragEventListener;

	@Before
	public void setUp(){
		dragSprite = new GameSprite();
		dragEventListener = mock(DragEventListener.class);
		when(dragEventListener.getDragSprite()).thenReturn(dragSprite);
	}

	@Test
	public void testAction(){
		assertEquals(dragEventListener.getDragSprite(),dragSprite);
	}
}
