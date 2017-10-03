package com.gamebuilder.strategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/*
 * This file contains methods for playing and stopping music
 * It checks for the filename provided
 */

public class Music implements Serializable {
	private Player player;
	String fileName;
	
	public void play(String fileName) {
		try{
		FileInputStream fileInputStream = new FileInputStream(fileName);
		player = new Player(fileInputStream);
		}catch(FileNotFoundException e){
			
		}catch(JavaLayerException e1){
			
		}
		new Thread(){
			public void run(){
				try{
					{
					player.play();
					}
				}catch(Exception e){	
				}
			}
		}.start();
	}
	
	public void stop(){
		if(player != null){
			try{
				player.close();
			}catch(Exception e){
				
			}
		}
	}
}
