package com.gamebuilder.helpers;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.ui.GamePanelView;

public class BackgroundButtonListener implements ActionListener{
	
	private GamePanelView gamePanelView;
	private SpritePanelModel spritePanelModel;
	private Image image;
	ImageIcon imageIcon;
	
	private static Logger backgroundRbLog = Logger.getLogger("backgroundRbLogger");
	
	public BackgroundButtonListener(SpritePanelModel spritePanelModel, GamePanelView gamePanelView) {
		this.spritePanelModel = spritePanelModel;
		this.gamePanelView = gamePanelView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String backgroundCommand = e.getActionCommand();
		
		switch(backgroundCommand) {
		
		case GameConstants.BG_FROGGER:
			ImageIcon imageIcon1 = new ImageIcon(GameConstants.FROGGER_IMAGE); 
        	image = imageIcon1.getImage();
        	spritePanelModel.setBackGroundImage(image);
        	gamePanelView.setBackGroundImage(spritePanelModel.getBackGroundImage());
        	gamePanelView.revalidate();
        	gamePanelView.repaint();
            break;
		
		case GameConstants.BG_SPACE:
			ImageIcon imageIcon2 = new ImageIcon(GameConstants.SPACEINVADERS_IMAGE); 
        	image = imageIcon2.getImage();
        	spritePanelModel.setBackGroundImage(image);
        	gamePanelView.setBackGroundImage(spritePanelModel.getBackGroundImage());
        	gamePanelView.revalidate();
        	gamePanelView.repaint();
            break;
					
		case GameConstants.BG_ASTEROIDS:	
			ImageIcon imageIcon3 = new ImageIcon(GameConstants.ASTEROIDS_IMAGE); 
        	image = imageIcon3.getImage();
        	spritePanelModel.setBackGroundImage(image);
        	gamePanelView.setBackGroundImage(spritePanelModel.getBackGroundImage());
        	gamePanelView.revalidate();
        	gamePanelView.repaint();
            break;
	        					
		}
	}
	
	
}
