package com.gamebuilder.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.gamebuilder.controller.SpritePanelController;
import com.gamebuilder.helpers.GameConstants;
import com.gamebuilder.model.SpritePanelModel;

public class GameFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private SpritePanelView spritePanelView;
	private GamePanelView gamePanelView;
	private SpritePanelModel spritePanelModel;
	private SpritePanelController spritePanelController;
	
	public GameFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(GameConstants.FRAME_DIMENSION);
		this.setTitle(GameConstants.FRAME_TITLE);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		
		spritePanelView = new SpritePanelView();
		JScrollPane spriteScrollPane = new JScrollPane(spritePanelView, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spritePanelModel = new SpritePanelModel();
		gamePanelView = new GamePanelView();
		
		spritePanelController = new SpritePanelController(spritePanelModel, spritePanelView, gamePanelView);
		
		this.add(spriteScrollPane, BorderLayout.WEST);
		this.add(gamePanelView, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
