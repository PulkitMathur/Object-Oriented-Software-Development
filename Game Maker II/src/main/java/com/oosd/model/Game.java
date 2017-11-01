package com.oosd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pcpeters
 *
 */
@Entity  
@Table(name = "Game")
public class Game {

	@Id  
	@Column(name = "gameId")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int gameId;
	
	@Column(name = "gameName")
	private String gameName;
	
	@Column(name="gameObject", columnDefinition="Blob")
    private byte[] gameObject;
	
	public Game() {}; 

	public Game(int gameId, String gameName) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
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
	
	public byte[] getGameObject() {
		return gameObject;
	}

	public void setGameObject(byte[] gameObject) {
		this.gameObject = gameObject;
	}

}
