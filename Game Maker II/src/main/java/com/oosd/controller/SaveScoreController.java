package com.oosd.controller;

import com.oosd.DAOImpl.ScoreDAOImpl;
import com.oosd.model.Score;

public class SaveScoreController {
	
	int playerId;
	String playerName;
	int score;
	int gameId;
	String gameName;
	
	public  SaveScoreController(String playerName, int score, int gameId, String gameName) {
		this.playerName = playerName;
		this.score = score;	
		this.gameId = gameId;
		this.gameName = gameName;		
	}	
	
	public void execute() {
		
		Score newScore = new Score();
		
		newScore.setPlayerId(playerId);
		newScore.setPlayerName(playerName);
		newScore.setScore(score);
		newScore.setGameId(gameId);
		newScore.setGameName(gameName);
		
		ScoreDAOImpl scoreDAOImpl = new ScoreDAOImpl();
		scoreDAOImpl.add(newScore);		
	}

}
