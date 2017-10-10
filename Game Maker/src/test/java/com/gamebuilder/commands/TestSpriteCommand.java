package com.gamebuilder.commands;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.sprite.Bullet;
import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.strategy.AutoFireAction;
import com.gamebuilder.strategy.AutoMoveAction;
import com.gamebuilder.strategy.AutoMoveHorizontalAction;
import com.gamebuilder.strategy.AutoMoveVerticalAction;
import com.gamebuilder.strategy.SpriteActionInterface;
import com.gamebuilder.ui.GamePanelView;

@RunWith(MockitoJUnitRunner.class)
public class TestSpriteCommand {
	
	@Mock
	private GameSprite gameSprite;
	
	@Mock
	private Bullet bullet;
	
	@Mock 
	private SpritePanelModel spritePanelModel;
	
	@Mock
	private GamePanelView gamePanelView;
	
	@Mock
	private SpriteActionInterface spriteActionInterface;
	
	@Mock
	private AutoMoveAction autoMoveAction;
	
    @Mock
	private AutoFireAction autoFireAction;
	
    @Mock
    private SpriteActionInterface testSpriteAction;
    
    @Before
    public void init(){
    	gameSprite = Mockito.mock(GameSprite.class);
		spritePanelModel = Mockito.mock(SpritePanelModel.class);
		gamePanelView = Mockito.mock(GamePanelView.class);
		Mockito.when(spritePanelModel.getSpriteArray()).thenReturn(new ArrayList<GameSprite>());
    }
    
	@Test
	public void SpriteCommandTest() {
		//Test AutoFire Action
		
		SpriteActionInterface spriteAction = new AutoFireAction(spritePanelModel, gamePanelView);
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		Mockito.when(gameSprite.isAutoFire()).thenReturn(true);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).getPosX();
		verify(gameSprite, atLeast(1)).getPosY();
		assertEquals(GamePanelView.bulletArray.size(), 1);

	}
	
	@Test
	public void TestAutoMoveVertical(){
		//Test AutoMoveVertical Action
		
		SpriteActionInterface spriteAction = new AutoMoveVerticalAction(spritePanelModel, true);
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).setPosY(Mockito.anyInt());
	}
	
	@Test
	public void TestAutoMoveHorizontal(){
		//Test AutoMoveHorizontal Action
		
		SpriteActionInterface spriteAction = new AutoMoveHorizontalAction(spritePanelModel, true);
	    Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
	 	SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).setPosX(Mockito.anyInt());
	}
	
	@Test
	public void TestAutoMove(){
		//Test AutoMove Action
		
		SpriteActionInterface spriteAction = new AutoMoveAction(spritePanelModel);
		Mockito.when(gameSprite.getActionInterface()).thenReturn(spriteAction);
		SpriteCommand testCommand = new SpriteCommand(gameSprite, gamePanelView);
		testCommand.execute();
		verify(gameSprite, atLeast(1)).checkBounds();
		verify(gameSprite, atLeast(1)).createCollider();			
	}

}
