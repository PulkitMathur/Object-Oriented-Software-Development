package com.gamebuilder.strategy;

import com.gamebuilder.sprite.GameSprite;
import com.gamebuilder.ui.GamePanelView;

public interface SpriteActionInterface {
	public void performAction(GameSprite gameSprite, GamePanelView gamePanelView);
}
