package com.oosd.gamemakerwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oosd.gamemakerwebapp.gamestore.GamesRepository;
import com.oosd.gamemakerwebapp.gamestore.PlayersRepository;
import com.oosd.gamemakerwebapp.model.ScoreBoard;

@Controller
public class SampleRestController {

    @Autowired
    GamesRepository gamesRepository;
    @Autowired
    PlayersRepository playersRepository;

    @GetMapping("/")
    public String hello(Model model) {
        //String greet = "Welcome to Game Maker";
        //model.addAttribute("greeting", greet);
        return "index";
    }	

    @GetMapping("/games")
    public String getAll(Model model) {
        List<ScoreBoard> scores = gamesRepository.findAll();
        model.addAttribute("scoreslist", scores);
        return "scoressheet";
    }
}
