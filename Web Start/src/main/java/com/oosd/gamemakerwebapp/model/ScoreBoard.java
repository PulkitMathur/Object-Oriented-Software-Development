package com.oosd.gamemakerwebapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ScoreBoard")
public class ScoreBoard {

    @Id
    @Column(name = "playerId")
    private Integer playerId;
    @Column(name = "playerName")
    private String playerName;
    @Column(name = "score")
    private Integer score;
    @Column(name = "gameId")
    private Integer gameId;
    @Column(name = "gameName")
    private String gameName;
    
	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
}
