package com.gamebuilder.strategy;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.gamebuilder.commands.SpriteCommand;
import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public class TestBlowUpAction {

	@Mock
	private GameSprite gameSprite;
	
	@Mock 
	private SpritePanelModel spritePanelModel;
	
	@Mock
	private GamePanelView gamePanelView;
	
	@Before
	public void init(){
		gameSprite = Mockito.mock(GameSprite.class);
		spritePanelModel = Mockito.mock(SpritePanelModel.class);
		gamePanelView = Mockito.mock(GamePanelView.class);
	}

	@Test
	public void BlowUpActionTest() {
		//Test BlowUp Action
		
		SpriteActionInterface spriteAction = new BlowUpAction(spritePanelModel, gamePanelView);
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.isCollisionEvent()).thenReturn(true);
		Mockito.when(gameSprite.isVisible()).thenReturn(true);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).createCollider();
		
	}

}
