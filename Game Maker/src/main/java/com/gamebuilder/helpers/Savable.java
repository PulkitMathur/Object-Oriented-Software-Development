package com.gamebuilder.helpers;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import com.gamebuilder.sprite.GameSprite;

public class Savable implements Serializable {
	
	private static final long serialVersionUID = 12L;
	
	public ArrayList<GameSprite> spriteArrayList;
	public Color backGroundColor;
	
	public Savable(ArrayList<GameSprite> spriteArrayList, Color backGroundColor){
		this.spriteArrayList = spriteArrayList;
		this.backGroundColor = backGroundColor;
	}

}
