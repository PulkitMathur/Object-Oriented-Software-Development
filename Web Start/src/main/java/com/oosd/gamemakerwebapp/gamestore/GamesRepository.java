package com.oosd.gamemakerwebapp.gamestore;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oosd.gamemakerwebapp.model.ScoreBoard;

public interface GamesRepository extends JpaRepository<ScoreBoard,Integer>{
}
