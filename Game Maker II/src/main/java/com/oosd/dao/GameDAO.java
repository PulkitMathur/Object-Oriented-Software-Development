package com.oosd.dao;

import com.oosd.model.Game;

public interface GameDAO {
	
	public void add(Game game);
	public void edit(Game game);
	public void delete(int gameId);
	public Game getGame(int gameId);
	//public List getGames();

}
