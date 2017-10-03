package com.gamebuilder.helpers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import org.apache.log4j.Logger;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.strategy.ConcreteImageInterface;
import com.gamebuilder.strategy.SpriteImageInterface;
import com.gamebuilder.ui.SpritePanelView;

public class ImageButtonListener implements ActionListener {
	
	private SpritePanelModel spritePanelModel;
	private SpritePanelView spritePanelView;
	
	private static Logger imageRbLog = Logger.getLogger("imageRbLogger");
	
	public ImageButtonListener(SpritePanelModel spritePanelModel, SpritePanelView spritePanelView){
		this.spritePanelModel = spritePanelModel;
		this.spritePanelView = spritePanelView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		switch(actionCommand){
		case GameConstants.AQUA:
			imageRbLog.info("Aquaball Image Selected: ");
			addImageInteface(((ImageIcon) ((JRadioButton)e.getSource()).getIcon()));
			setSelectedSprite(e);
			break;
		case GameConstants.FOOT:
			imageRbLog.info("Football Image Selected: ");
			addImageInteface(((ImageIcon) ((JRadioButton)e.getSource()).getIcon()));
			setSelectedSprite(e);
			break;
		case GameConstants.PADDLE:
			imageRbLog.info("Paddle Image Selected: ");
			addImageInteface(((ImageIcon) ((JRadioButton)e.getSource()).getIcon()));
			setSelectedSprite(e);
			break;
		case GameConstants.BRICK:
			imageRbLog.info("Brick Image Selected: ");
			addImageInteface(((ImageIcon) ((JRadioButton)e.getSource()).getIcon()));
			setSelectedSprite(e);
			break;
		}
		
	}
	
	public void addImageInteface(ImageIcon imageIcon){
		SpriteImageInterface imageInterface = new ConcreteImageInterface(imageIcon);
		spritePanelModel.setImageInterface(imageInterface);
	}
	
	private void setSelectedSprite(ActionEvent e) {
		spritePanelView.getPreviewLabel().setIcon((ImageIcon) ((JRadioButton) e.getSource()).getIcon());
		spritePanelView.setButtonEnabled();
	}

}
