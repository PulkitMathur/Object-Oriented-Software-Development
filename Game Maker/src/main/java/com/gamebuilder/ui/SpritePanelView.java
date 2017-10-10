package com.gamebuilder.ui;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.helpers.GameLogicButtonListener;
import com.gamebuilder.sprite.Bullet;

public class SpritePanelView extends JPanel{
	
	/**
	 * 
	 */

	private static final long serialVersionUID = -2731195143473852027L;
	private ImageIcon previewIcon;
	private JLabel previewLabel;
	private ArrayList<AbstractButton> bgActions;
	private ButtonGroup bgSprites;
	private ButtonGroup bgGame;
	private ArrayList<JCheckBox> bgEvents;
	private ButtonGroup bgBackgrounds;
	private ButtonGroup bgReadouts;
	private ButtonGroup bgBackgroundMusic;
	private JComboBox<String> gameComboBox;
	

	private ArrayList<Bullet> bulletArray = new ArrayList<Bullet>();

	//private ActionListener gameLogicListener;
	private ButtonGroup bgGamelogic;
	//private GameLogicButtonListener gameLogicButtonListener;
	
	public SpritePanelView(){
		this.setSize(GameConstants.SPRITE_PANEL_DIMENSION);
	    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		previewIcon = new ImageIcon("drawable/Questionmark.png");
		Image tempImg = previewIcon.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BALL_RADIUS, GameConstants.BALL_RADIUS, java.awt.Image.SCALE_SMOOTH);
		previewIcon = new ImageIcon(tempImg);
		previewLabel = new JLabel();
		previewLabel = new JLabel("Selected", previewIcon, JLabel.CENTER);
		initSpriteButtons();
		this.add(previewLabel);
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		initActionButtons();
		JLabel imageTitle = new JLabel("PRESS APPLY");
		this.add(imageTitle);
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		initEventButtons();
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		initGameLogicButtons();
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		initBackgroundButtons();
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		initBackgroundMusicButtons();
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		initControlReadouts();
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		initGameButtons();		
	}
	
	
	public void initSpriteButtons(){
		
		JLabel lblSelectAGame = new JLabel("Select a Game");
		add(lblSelectAGame);
		
		gameComboBox = new JComboBox<String>(GameConstants.GAMES_AVAILABLE);
		gameComboBox.setFocusable(false);
		add(gameComboBox);
		
		JSeparator separator = new JSeparator();
		add(separator);
		JLabel imageTitle = new JLabel("Select an Image");
		this.add(imageTitle);
		ImageIcon spriteImage = new ImageIcon("drawable/aqua_ball.png");
		Image tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BALL_RADIUS, GameConstants.BALL_RADIUS, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRadioButton = new JRadioButton("Aqua Ball",spriteImage, true);
		spriteRadioButton.setFocusable(false);
		spriteRadioButton.setActionCommand(GameConstants.AQUA);
		this.add(spriteRadioButton);
		
		spriteImage = new ImageIcon("drawable/soccer_ball.png");
		tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BALL_RADIUS, GameConstants.BALL_RADIUS, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRbFootball = new JRadioButton("Football", spriteImage, false);
		spriteRbFootball.setFocusable(false);
		spriteRbFootball.setActionCommand(GameConstants.FOOT);
		this.add(spriteRbFootball);
		
		spriteImage = new ImageIcon("drawable/paddle1.png");
		tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.PADDLE_WIDTH, GameConstants.PADDLE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRadioButtonPaddle = new JRadioButton("Paddle",spriteImage, true);
		spriteRadioButtonPaddle.setFocusable(false);
		spriteRadioButtonPaddle.setActionCommand(GameConstants.PADDLE);
		this.add(spriteRadioButtonPaddle);
		
		spriteImage = new ImageIcon("drawable/Bricks1.png");
		tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRadioButtonBrick = new JRadioButton("Brick",spriteImage, true);
		spriteRadioButtonBrick.setFocusable(false);
		spriteRadioButtonBrick.setActionCommand(GameConstants.BRICK);
		this.add(spriteRadioButtonBrick);
		
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		JLabel froggerImages = new JLabel("Frogger Sprites");
		this.add(froggerImages);
		
		spriteImage = new ImageIcon("drawable/frog.png");
		tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRadioButtonFrog = new JRadioButton("Frog",spriteImage, true);
		spriteRadioButtonFrog.setFocusable(false);
		spriteRadioButtonFrog.setActionCommand(GameConstants.BRICK);
		this.add(spriteRadioButtonFrog);
		
		spriteImage = new ImageIcon("drawable/log.png");
		tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRadioButtonLog = new JRadioButton("Log",spriteImage, true);
		spriteRadioButtonLog.setFocusable(false);
		spriteRadioButtonLog.setActionCommand(GameConstants.BRICK);
		this.add(spriteRadioButtonLog);
		
		spriteImage = new ImageIcon("drawable/snake.png");
		tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BRICK_WIDTH, GameConstants.BRICK_HEIGHT, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRadioButtonSnake = new JRadioButton("Snake",spriteImage, true);
		spriteRadioButtonSnake.setFocusable(false);
		spriteRadioButtonSnake.setActionCommand(GameConstants.BRICK);
		this.add(spriteRadioButtonSnake);
		
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		JLabel spaceAvengersImages = new JLabel("Space Avengers Sprites");
		this.add(spaceAvengersImages);
		
		spriteImage = new ImageIcon("drawable/spaceship.png");
		tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BALL_RADIUS, GameConstants.BALL_RADIUS, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRadioButtonSpaceShip = new JRadioButton("SpaceShip",spriteImage, true);
		spriteRadioButtonSpaceShip.setFocusable(false);
		spriteRadioButtonSpaceShip.setActionCommand(GameConstants.BRICK);
		this.add(spriteRadioButtonSpaceShip);
		
		spriteImage = new ImageIcon("drawable/enemy.png");
		tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BALL_RADIUS, GameConstants.BALL_RADIUS, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRadioButtonEnemy = new JRadioButton("Enemy Ship",spriteImage, true);
		spriteRadioButtonEnemy.setFocusable(false);
		spriteRadioButtonEnemy.setActionCommand(GameConstants.BRICK);
		this.add(spriteRadioButtonEnemy);	
		
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		JLabel asteroidImages = new JLabel("Asteroid Game Sprites");
		this.add(asteroidImages);
		
		spriteImage = new ImageIcon("drawable/spacecraft.png");
		tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BALL_RADIUS, GameConstants.BALL_RADIUS, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRadioButtonSpaceCraft = new JRadioButton("SpaceCraft",spriteImage, true);
		spriteRadioButtonSpaceCraft.setFocusable(false);
		spriteRadioButtonSpaceCraft.setActionCommand(GameConstants.BRICK);
		this.add(spriteRadioButtonSpaceCraft);
		
		spriteImage = new ImageIcon("drawable/asteroid.png");
		tempImg = spriteImage.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BALL_RADIUS, GameConstants.BALL_RADIUS, java.awt.Image.SCALE_SMOOTH);
		spriteImage = new ImageIcon(tempImg);
		
		JRadioButton spriteRadioButtonAsteroid = new JRadioButton("Asteroid",spriteImage, true);
		spriteRadioButtonAsteroid.setFocusable(false);
		spriteRadioButtonAsteroid.setActionCommand(GameConstants.BRICK);
		this.add(spriteRadioButtonAsteroid);
		
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		bgSprites = new ButtonGroup();
		bgSprites.add(spriteRadioButton);
		bgSprites.add(spriteRbFootball);
		bgSprites.add(spriteRadioButtonPaddle);
		bgSprites.add(spriteRadioButtonBrick);
		bgSprites.add(spriteRadioButtonFrog);
		bgSprites.add(spriteRadioButtonLog);
		bgSprites.add(spriteRadioButtonSnake);
		bgSprites.add(spriteRadioButtonSpaceShip);
		bgSprites.add(spriteRadioButtonEnemy);
		bgSprites.add(spriteRadioButtonSpaceCraft);
		bgSprites.add(spriteRadioButtonAsteroid);
		
	}
	
	public void initActionButtons(){
		JLabel actionTitle = new JLabel("Attach Action");
        this.add(actionTitle);
        JCheckBox actionUserCtrlMove = new JCheckBox(GameConstants.USER_CTRL_MOVE);
        JCheckBox actionAutoRandom = new JCheckBox(GameConstants.AUTOMOVE);
        JCheckBox actionAutoHorizontal = new JCheckBox(GameConstants.AUTOMOVE_HORIZONTAL);
        JCheckBox actionAutoVertical = new JCheckBox(GameConstants.AUTOMOVE_VERTICAL);
        JCheckBox actionRbBlowUp = new JCheckBox(GameConstants.BLOWUP);
        JCheckBox actionShoot  = new JCheckBox(GameConstants.SHOOT);
        JCheckBox actionAutoShoot  = new JCheckBox(GameConstants.AUTOSHOOT);
        JButton apply = new JButton(GameConstants.APPLY);
        
		actionUserCtrlMove.setFocusable(false);
		actionAutoRandom.setFocusable(false);
		actionAutoHorizontal.setFocusable(false);
		actionAutoVertical.setFocusable(false);
		actionRbBlowUp.setFocusable(false);
		actionShoot.setFocusable(false);
		actionAutoShoot.setFocusable(false);
		apply.setFocusable(false);

		
		actionUserCtrlMove.setActionCommand(GameConstants.USER_CTRL_MOVE);
		actionAutoRandom.setActionCommand(GameConstants.AUTOMOVE);
		actionAutoHorizontal.setActionCommand(GameConstants.AUTOMOVE_HORIZONTAL);
		actionAutoVertical.setActionCommand(GameConstants.AUTOMOVE_VERTICAL);
		actionRbBlowUp.setActionCommand(GameConstants.BLOWUP);
		actionShoot.setActionCommand(GameConstants.SHOOT);
		actionAutoShoot.setActionCommand(GameConstants.AUTOSHOOT);
		apply.setActionCommand(GameConstants.APPLY);

		
		bgActions = new ArrayList<AbstractButton>();
		bgActions.add(actionUserCtrlMove);
		bgActions.add(actionAutoRandom);
		bgActions.add(actionAutoHorizontal);
		bgActions.add(actionAutoVertical);
		bgActions.add(actionRbBlowUp);
		bgActions.add(actionShoot);
		bgActions.add(actionAutoShoot);
		bgActions.add(apply);

		
		this.add(actionUserCtrlMove);
		this.add(actionAutoRandom);
		this.add(actionAutoHorizontal);
		this.add(actionAutoVertical);
		this.add(actionRbBlowUp);
		this.add(actionShoot);
		this.add(actionAutoShoot);
		this.add(apply);

		
	}
	
	public void initEventButtons(){
		JLabel eventTitle = new JLabel("Attach Events");
		this.add(eventTitle);
		JCheckBox eventRbsides = new JCheckBox("Left-Right", false);
		JCheckBox eventRbup = new JCheckBox("Up-down", false);
		JCheckBox eventCollision = new JCheckBox("Collision", false);
		JCheckBox eventFire = new JCheckBox("Fire", false);
		
		eventRbsides.setFocusable(false);
		eventRbup.setFocusable(false);
		eventCollision.setFocusable(false);
		eventFire.setFocusable(false);
		
		eventRbsides.setActionCommand(GameConstants.SIDES);
		eventRbup.setActionCommand(GameConstants.UPDOWN);
		eventCollision.setActionCommand(GameConstants.COLLISION);
		eventFire.setActionCommand(GameConstants.FIRE);
		
		
		bgEvents = new ArrayList<JCheckBox>();
		bgEvents.add(eventRbsides);
		bgEvents.add(eventRbup);
		bgEvents.add(eventCollision);
		bgEvents.add(eventFire);
		
		this.add(eventRbsides);
		this.add(eventRbup);
		this.add(eventCollision);
		this.add(eventFire);
		
	}
	
	public void initBackgroundButtons() {
		JLabel backGroundTitle = new JLabel("Backgrounds");
		JRadioButton backGroundFrogger = new JRadioButton("Frogger", false);
		JRadioButton backGroundSpace = new JRadioButton("Space Invaders", false);
		JRadioButton backGroundAsteroid = new JRadioButton("Asteroids", false);
		
		backGroundFrogger.setFocusable(false);
		backGroundSpace.setFocusable(false);
		backGroundAsteroid.setFocusable(false);
		
		bgBackgrounds = new ButtonGroup();
		bgBackgrounds.add(backGroundFrogger);
		bgBackgrounds.add(backGroundSpace);
		bgBackgrounds.add(backGroundAsteroid);
		
		this.add(backGroundTitle);
		this.add(backGroundFrogger);
		this.add(backGroundSpace);
		this.add(backGroundAsteroid);
		
	}
	
	public void initGameLogicButtons() {
		JButton gameWin = new JButton(GameConstants.GAME_WIN);
		JButton gameLose = new JButton(GameConstants.GAME_LOSE);

		gameWin.setFocusable(false);
		gameLose.setFocusable(false);
		
		gameWin.setActionCommand(GameConstants.GAME_WIN);
		gameLose.setActionCommand(GameConstants.GAME_LOSE);
		
		bgGamelogic = new ButtonGroup();
		bgGamelogic.add(gameWin);
		bgGamelogic.add(gameLose);
		
		this.add(gameWin);
		this.add(gameLose);
		
		
	}
	
	public void initBackgroundMusicButtons() {
		JLabel backGroundMusicTitle = new JLabel("Background Music");
		JRadioButton backGroundMusicMario = new JRadioButton("Mario", false);
		JRadioButton backGroundMusicGreen = new JRadioButton("Tick Tock", false);
		JRadioButton backGroundMusicYellow = new JRadioButton("No Music", false);
		
		backGroundMusicMario.setFocusable(false);
		backGroundMusicGreen.setFocusable(false);
		backGroundMusicYellow.setFocusable(false);
		
		
		bgBackgroundMusic = new ButtonGroup();
		bgBackgroundMusic.add(backGroundMusicMario);
		bgBackgroundMusic.add(backGroundMusicGreen);
		bgBackgroundMusic.add(backGroundMusicYellow);
	
		this.add(backGroundMusicTitle);
		this.add(backGroundMusicMario);
		this.add(backGroundMusicGreen);
		this.add(backGroundMusicYellow);
	}
	
	public void initControlReadouts() {
		JLabel readoutTitle = new JLabel("Control Readouts");
		JRadioButton readoutClock = new JRadioButton("Clock", false);
		
		
		readoutClock.setFocusable(false);
		//readoutScore.setFocusable(false);
		//readoutLives.setFocusable(false);
		
		bgReadouts = new ButtonGroup();
		bgReadouts.add(readoutClock);
		//bgReadouts.add(readoutScore);
		//bgReadouts.add(readoutLives);
		
		this.add(readoutTitle);
		this.add(readoutClock);
		//this.add(readoutScore);
		//this.add(readoutLives);
	}
	
	public void initGameButtons(){
		JButton buttonDraw = new JButton("Draw");
		JButton buttonPlay = new JButton("Play");
		JButton buttonPause = new JButton("Pause");
		JButton buttonSave = new JButton("Save");
		JButton buttonLoad = new JButton("Load");
		
		buttonDraw.setFocusable(false);
		buttonPlay.setFocusable(false);
		buttonPause.setFocusable(false);
		buttonSave.setFocusable(false);
		buttonLoad.setFocusable(false);
	
		//disable the buttons
		buttonDraw.setEnabled(false);
		buttonPlay.setEnabled(false);
		buttonPause.setEnabled(false);
		buttonSave.setEnabled(false);
		
		buttonDraw.setActionCommand(GameConstants.DRAW);
		buttonPlay.setActionCommand(GameConstants.PLAY);
		buttonPause.setActionCommand(GameConstants.PAUSE);
		buttonSave.setActionCommand(GameConstants.SAVE);
		buttonLoad.setActionCommand(GameConstants.LOAD);
		
		bgGame = new ButtonGroup();
		bgGame.add(buttonPlay);
		bgGame.add(buttonDraw);
		bgGame.add(buttonPause);
		bgGame.add(buttonSave);
		bgGame.add(buttonLoad);
		
		this.add(buttonDraw);
		this.add(buttonPlay);
		this.add(buttonPause);
		this.add(buttonSave);
		this.add(buttonLoad);
	}

	public JLabel getPreviewLabel() {
		return previewLabel;
	}
	
	public void addActionButtonListener(ActionListener actionButtonListener){
		//for(AbstractButton button : ){
			( bgActions.get(bgActions.size()-1)).addActionListener(actionButtonListener);
		//}
	}
	
	
	public ArrayList<AbstractButton> getBgActions() {
		return bgActions;
	}


	public void setBgActions(ArrayList<AbstractButton> bgActions) {
		this.bgActions = bgActions;
	}


	public ArrayList<JCheckBox> getBgEvents() {
		return bgEvents;
	}


	public void setBgEvents(ArrayList<JCheckBox> bgEvents) {
		this.bgEvents = bgEvents;
	}


	public void addImageButtonListener(ActionListener imageButtonListener){
		Enumeration<AbstractButton> buttons = bgSprites.getElements();
		while(buttons.hasMoreElements()){
			AbstractButton button = buttons.nextElement();
			button.addActionListener(imageButtonListener);
		}
	}
	
	public void addGameButtonListener(ActionListener gameButtonListener){
		Enumeration<AbstractButton> buttons = bgGame.getElements();
		while(buttons.hasMoreElements()){
			AbstractButton button = buttons.nextElement();
			button.addActionListener(gameButtonListener);
		}
	}
	public void addGameLogicButtonListener(ActionListener gameLogicButtonListener){
		Enumeration<AbstractButton> buttons = bgGamelogic.getElements();
		while(buttons.hasMoreElements()){
			AbstractButton button = buttons.nextElement();
			button.addActionListener(gameLogicButtonListener);
		}
	}
	public void addEventButtonListener(ActionListener eventButtonListener){
		for(JCheckBox checkBox: bgEvents){
			checkBox.addActionListener(eventButtonListener);
		}}
	
	public void addBackGroundButtonListener(ActionListener backgroundButtonListener) {
		Enumeration<AbstractButton> buttons = bgBackgrounds.getElements();
		while (buttons.hasMoreElements()) {
			AbstractButton button = buttons.nextElement();
			button.addActionListener(backgroundButtonListener);
		}
	}
	
	public void addReadoutButtonListener(ActionListener readoutButtonListener) {
		Enumeration<AbstractButton> buttons = bgReadouts.getElements();
		while (buttons.hasMoreElements()) {
			AbstractButton button = buttons.nextElement();
			button.addActionListener(readoutButtonListener);
		}
	}
	
	//enable the buttons
	public void setButtonEnabled() {
		Enumeration<AbstractButton> buttons = bgGame.getElements();
		while(buttons.hasMoreElements()){
			AbstractButton button = buttons.nextElement();
			button.setEnabled(true);
		}
	}
	
//	public void setButtonEnabled() {
//		Enumeration<AbstractButton> buttons = bgGamelogic.getElements();
//		while(buttons.hasMoreElements()){
//			AbstractButton button = buttons.nextElement();
//			button.setEnabled(true);
//		}
//	}
	
	
	//listener for background music
	public void addBackGroundMusicButtonListener(ActionListener backgroundMusicButtonListener) {
		Enumeration<AbstractButton> buttons = bgBackgroundMusic.getElements();
		while (buttons.hasMoreElements()) {
			AbstractButton button = buttons.nextElement();
			button.addActionListener(backgroundMusicButtonListener);
		}
	}


	
	public JComboBox<String> getGameComboBox() {
		return gameComboBox;
	}


	public void setGameComboBox(JComboBox<String> gameComboBox) {
		this.gameComboBox = gameComboBox;
	}


	
	
	
}
