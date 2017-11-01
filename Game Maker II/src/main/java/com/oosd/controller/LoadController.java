package com.oosd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;

import com.oosd.model.Background;
import com.oosd.model.Sprite;
import com.oosd.view.GameMaker;
import com.oosd.view.GameStage;

public class LoadController {

	File savedFile;
	Logger logger = Logger.getLogger(SaveController.class);
	GameStage gameStage;
	Background background;
	BackgroundController backgroundController;

	public LoadController(File savedFile, GameStage gameStage)
	{
		this.savedFile = savedFile;
		this.gameStage = gameStage;
		this.background = gameStage.getBackgroundObject();
		this.backgroundController = gameStage.getBackgroundController();
	}

	public void execute()
	{
		try {
			FileInputStream fileInputStream = new FileInputStream(savedFile);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			HashMap<String, Object> savedObjects = new HashMap<String, Object>();
			savedObjects = (HashMap<String, Object>) objectInputStream.readObject();

			Sprite.spriteList = (CopyOnWriteArrayList<Sprite>) savedObjects.get("spriteList");
			GameMaker.winFlagCount = (int) savedObjects.get("win");
			GameMaker.loseFlagCount = (int) savedObjects.get("lose");

			for(int i = 0; i < Sprite.spriteList.size(); i++)
			{
				Sprite sprite = Sprite.spriteList.get(i);
				GameStage.addedSpriteLabels.add(Sprite.spriteList.get(i).getSpriteLabel());
				gameStage.add(Sprite.spriteList.get(i).getSpriteLabel());

			}

			background.setCurrentBackgroundKey((String)savedObjects.get("backgroundImage"));
			backgroundController.setBackgroundImage(background.getCurrentBackgroundKey());
			backgroundController.update();


			objectInputStream.close();
			fileInputStream.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.fatal("Failed to load file.");
		}		
	}
}
