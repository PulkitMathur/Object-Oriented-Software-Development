package com.oosd.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.oosd.DAOImpl.GameDAOImpl;
import com.oosd.model.Game;

public class SaveController {
	File saveFile;
	String gameName;
	HashMap<String, Object> savableObject;
	Logger logger = Logger.getLogger(SaveController.class);

	public SaveController(String gameName, HashMap<String, Object> savableObject) {
		this.gameName = gameName;
		this.savableObject = savableObject;
	}

	// Function to save sprite list
	public void execute() {
		try {

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(savableObject);
			objectOutputStream.close();
			byteArrayOutputStream.close();

			byte[] gameObject = byteArrayOutputStream.toByteArray();
			Game game = new Game();
			game.setGameId(1);
			game.setGameName(gameName);
			game.setGameObject(gameObject);
			// GameDaoImpl gameDaoImpl = new GameDaoImpl();
			GameDAOImpl gameDAOImpl = new GameDAOImpl();

			gameDAOImpl.add(game);

		} catch (Exception e) {
			logger.fatal("Failed to save file.");
			e.printStackTrace();
		}

	}

}
