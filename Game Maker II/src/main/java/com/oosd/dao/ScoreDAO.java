package com.oosd.dao;

import com.oosd.model.Score;

public interface ScoreDAO {

	public void add(Score score);
	public void edit(Score score);
	public void delete(int playerId);
	public Score getScore(int playerId);
}


