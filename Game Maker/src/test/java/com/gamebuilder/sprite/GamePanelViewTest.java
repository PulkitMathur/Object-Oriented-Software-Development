package com.gamebuilder.sprite;


import static org.junit.Assert.*;
import com.gamebuilder.ui.GamePanelView;

import java.util.ArrayList;

import org.junit.Test;


public class GamePanelViewTest {

	private ArrayList<GameSprite> gameSpriteArray = new ArrayList<GameSprite>();
	public boolean play = false;
	
	@Test
	public void check(){
	GamePanelView gamePanelView = new GamePanelView();
	
	assertEquals(gamePanelView.getGameSpriteArray(), gameSpriteArray);
	assertEquals(play,false);
}
}