package com.gamebuilder.helpers;


import java.awt.Dimension;

public class GameConstants {
	
	//Game Frame Dimensions
	protected static final int FRAME_HEIGHT = 760;
	public static final int FRAME_WIDTH = 750;
	public static final Dimension FRAME_DIMENSION = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
	public static final String FRAME_TITLE = new String("Game Builder");
	
	//Sprite Panel Dimensions
	protected static final int SPRITE_PANEL_HEIGHT = 760;
	protected static final int SPRITE_PANEL_WIDTH = 250;
	public static final Dimension SPRITE_PANEL_DIMENSION = new Dimension(SPRITE_PANEL_WIDTH, SPRITE_PANEL_HEIGHT);
	
	//Game Panel Dimensions
	public static final int GAME_PANEL_HEIGHT = 760;
	public static final int GAME_PANEL_WIDTH = 500;
	public static final Dimension GAME_PANEL_DIMENSION = new Dimension(GAME_PANEL_WIDTH, GAME_PANEL_HEIGHT);
	
	//Ball sprite image size
	public static final int BALL_RADIUS = 30;
	
	//Paddle sprite image size
	public static final int PADDLE_WIDTH = 60;
	public static final int PADDLE_HEIGHT = 20;
	
	//Brick sprite image size
	public static final int BRICK_WIDTH = 60;
	public static final int BRICK_HEIGHT = 40;
	
	//Strings for Actions
	public static final String MOVE = "Move";
	public static final String AUTOMOVE = "Automove";
	public static final String BLOWUP = "Blow Up";
	
	
	//Strings for Events
	public static final String SIDES = "Side";
	public static final String UPDOWN = "Up";
	public static final String COLLISION = "Collision";
	
	//Strings for Game Buttons
	public static final String DRAW = "Draw";
	public static final String PLAY = "Play";
	public static final String PAUSE = "Pause";
	public static final String SAVE = "Save";
	public static final String LOAD = "Load";
	
	//Default Draw position
	public static int DEFAULT_X = 500;
	public static int DEFAULT_Y = 500;
	
	//Default Move value
	public static int DEFAULT_MOVE = 20;
	
	//Non Move Value
	public static int NO_MOVE = 1000;
	
	//Strings for Images
	public static final String AQUA = "Aqua";
	public static final String FOOT = "Foot";
	public static final String PADDLE = "Paddle";
	public static final String BRICK = "Brick";
	
	
	//Move speed for the ball
	public static int BALL_SPEED_X = 5;
	public static int BALL_SPEED_Y = 5;
	
	public static final String BLUE = "Blue";
	public static final String GREEN = "Green";
	public static final String YELLOW = "Yellow";
	
	//Game Bound dimension
	public static final int BOUND_WIDTH = GAME_PANEL_WIDTH+100;
	public static final int BOUND_HEIGHT = GAME_PANEL_HEIGHT-40;
	
	//background sound music 
	public static final String MARIOMUSIC = "Mario";
	public static final String TICKTOCK = "Tick Tock";
	public static final String NOMUSIC = "No Music";
}
