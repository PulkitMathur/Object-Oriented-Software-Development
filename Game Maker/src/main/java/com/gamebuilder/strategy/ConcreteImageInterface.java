package com.gamebuilder.strategy;

import java.io.Serializable;

import javax.swing.ImageIcon;

import com.gamebuilder.sprite.GameSprite;

public class ConcreteImageInterface implements SpriteImageInterface, Serializable {
	
	private static final long serialVersionUID = 7L;
	
	private ImageIcon imageIcon;
	
	public ConcreteImageInterface(ImageIcon imageIcon){
		this.imageIcon = imageIcon;
	}

	@Override
	public void setImage(GameSprite gameSprite) {
		gameSprite.setSpriteImageIcon(imageIcon);
	}

}
