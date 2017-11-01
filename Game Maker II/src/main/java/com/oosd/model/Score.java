package com.oosd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ScoreBoard")
public class Score {
	
	@Id
	@Column(name = "playerId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int playerId;
	
	@Column(name = "playerName")
	private String playerName;
	
	@Column(name = "score")
	private int score;
	
	@Column(name = "gameId")
	private int gameId;
	
	@Column(name = "gameName")
	private String gameName;

	public Score() {};
	
	public Score(int playerId, String playerName, int score) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.score = score;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
	
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

}
