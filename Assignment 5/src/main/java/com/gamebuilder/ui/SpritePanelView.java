package com.gamebuilder.ui;

import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.gamebuilder.helpers.GameConstants;

public class SpritePanelView extends JPanel{
	
	private ImageIcon previewIcon;
	private JLabel previewLabel;
	private ButtonGroup bgActions;
	private ButtonGroup bgSprites;
	private ButtonGroup bgGame;
	private ArrayList<JCheckBox> bgEvents;
	private ButtonGroup bgBackgrounds;
	private ButtonGroup bgReadouts;
	private ButtonGroup bgBackgroundMusic;
	
	
	public SpritePanelView(){
		this.setSize(GameConstants.SPRITE_PANEL_DIMENSION);
		//this.setBackground(Color.WHITE);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		previewIcon = new ImageIcon("drawable/Questionmark.png");
		Image tempImg = previewIcon.getImage();
		tempImg = tempImg.getScaledInstance(GameConstants.BALL_RADIUS, GameConstants.BALL_RADIUS, java.awt.Image.SCALE_SMOOTH);
		previewIcon = new ImageIcon(tempImg);
		previewLabel = new JLabel();
		//previewLabel.setIcon(previewIcon);
		previewLabel = new JLabel("Selected", previewIcon, JLabel.CENTER);
		initSpriteButtons();
		this.add(previewLabel);
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		initActionButtons();
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		initEventButtons();
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
		
		bgSprites = new ButtonGroup();
		bgSprites.add(spriteRadioButton);
		bgSprites.add(spriteRbFootball);
		bgSprites.add(spriteRadioButtonPaddle);
		bgSprites.add(spriteRadioButtonBrick);
		
		
	}
	
	public void initActionButtons(){
		JLabel actionTitle = new JLabel("Attach Action");
this.add(actionTitle);
		JRadioButton actionRbMove = new JRadioButton("Move", false);
		JRadioButton actionRbBounce = new JRadioButton("Auto-Move", false);
		JRadioButton actionRbBlowUp = new JRadioButton("Blow Up", false);
		actionRbMove.setFocusable(false);
		actionRbBounce.setFocusable(false);
		actionRbBlowUp.setFocusable(false);
		
		actionRbMove.setActionCommand(GameConstants.MOVE);
		actionRbBounce.setActionCommand(GameConstants.AUTOMOVE);
		actionRbBlowUp.setActionCommand(GameConstants.BLOWUP);
		
		bgActions = new ButtonGroup();
		bgActions.add(actionRbMove);
		bgActions.add(actionRbBounce);
		bgActions.add(actionRbBlowUp);
		
		this.add(actionRbMove);
		this.add(actionRbBounce);
		this.add(actionRbBlowUp);
		
	}
	
	public void initEventButtons(){
		JLabel eventTitle = new JLabel("Attach Events");
		this.add(eventTitle);
		JCheckBox eventRbsides = new JCheckBox("Left-Right", false);
		JCheckBox eventRbup = new JCheckBox("Up-down", false);
		JCheckBox eventCollision = new JCheckBox("Collision", false);
		
		eventRbsides.setFocusable(false);
		eventRbup.setFocusable(false);
		eventCollision.setFocusable(false);
		
		eventRbsides.setActionCommand(GameConstants.SIDES);
		eventRbup.setActionCommand(GameConstants.UPDOWN);
		eventCollision.setActionCommand(GameConstants.COLLISION);
		
		
		
		bgEvents = new ArrayList<JCheckBox>();
		bgEvents.add(eventRbsides);
		bgEvents.add(eventRbup);
		bgEvents.add(eventCollision);
		
		this.add(eventRbsides);
		this.add(eventRbup);
		this.add(eventCollision);
		
	}
	
	public void initBackgroundButtons() {
		JLabel backGroundTitle = new JLabel("Backgrounds");
		JRadioButton backGroundBlue = new JRadioButton("Blue", false);
		JRadioButton backGroundGreen = new JRadioButton("Green", false);
		JRadioButton backGroundYellow = new JRadioButton("Yellow", false);
		
		backGroundBlue.setFocusable(false);
		backGroundGreen.setFocusable(false);
		backGroundYellow.setFocusable(false);
		
		bgBackgrounds = new ButtonGroup();
		bgBackgrounds.add(backGroundBlue);
		bgBackgrounds.add(backGroundGreen);
		bgBackgrounds.add(backGroundYellow);
		
		this.add(backGroundTitle);
		this.add(backGroundBlue);
		this.add(backGroundGreen);
		this.add(backGroundYellow);
		
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
		//JRadioButton readoutScore = new JRadioButton("Score", false);
		//JRadioButton readoutLives = new JRadioButton("Lives", false);
		
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
		Enumeration<AbstractButton> buttons = bgActions.getElements();
		while(buttons.hasMoreElements()){
			AbstractButton button = buttons.nextElement();
			button.addActionListener(actionButtonListener);
		}
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
	
	public void addEventButtonListener(ActionListener eventButtonListener){
		for(JCheckBox checkBox: bgEvents){
			checkBox.addActionListener(eventButtonListener);
		}
//		Enumeration<AbstractButton> buttons = bgEvents.getElements();
//		while(buttons.hasMoreElements()){
//			AbstractButton button = buttons.nextElement();
//			button.addActionListener(eventButtonListener);
//		}
	}
	
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
	
	//listener for background music
	public void addBackGroundMusicButtonListener(ActionListener backgroundMusicButtonListener) {
		Enumeration<AbstractButton> buttons = bgBackgroundMusic.getElements();
		while (buttons.hasMoreElements()) {
			AbstractButton button = buttons.nextElement();
			button.addActionListener(backgroundMusicButtonListener);
		}
	}
}
