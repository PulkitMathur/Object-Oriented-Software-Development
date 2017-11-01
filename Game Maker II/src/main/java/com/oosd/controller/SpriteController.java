package com.oosd.controller;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import com.oosd.model.Background;
import com.oosd.model.RotatingSprite;
import com.oosd.model.Sprite;
import com.oosd.utils.Constants;
import com.oosd.view.GameMaker;
import com.oosd.view.GameStage;

public class SpriteController implements ControllerInterface {

	Sprite sprite;
	String action;
	public static final Logger logger = Logger.getLogger(SpriteController.class);

	private Background background;
	private GameStage gameStage;

	public SpriteController(GameStage gameStage)
	{
		this.background = gameStage.getBackgroundObject();
		this.gameStage = gameStage;
	}

	public Sprite addSprite(int xPosition, int yPosition) {

		ImageIcon icon = new ImageIcon(GameMaker.spriteImages.get(GameMaker.spriteKey).getScaledInstance(Integer.parseInt(GameMaker.spriteWidth.getText()), Integer.parseInt(GameMaker.spriteHeight.getText()), Image.SCALE_SMOOTH));
		JLabel spriteLabel = new JLabel();
		spriteLabel.setIcon(icon);
		spriteLabel.setBounds(xPosition, yPosition, Integer.parseInt(GameMaker.spriteWidth.getText()), Integer.parseInt(GameMaker.spriteHeight.getText()));

		//Creating sprite with specified width and height
		action = GameMaker.comboBox.getSelectedItem().toString();
		if (action != Constants.KEY_PRESS_ROTATE) {
			sprite = new Sprite(spriteLabel, xPosition, yPosition, Integer.parseInt(GameMaker.spriteWidth.getText()), Integer.parseInt(GameMaker.spriteHeight.getText()), GameMaker.action);	
		}
		else {
			//System.out.println("In sprite controller" + Sprite.getRotatingSpriteImage());
			sprite = new RotatingSprite(Sprite.getRotatingSpriteImage(), xPosition, yPosition, Integer.parseInt(GameMaker.spriteWidth.getText()), Integer.parseInt(GameMaker.spriteHeight.getText()), GameMaker.action);

		}

		//Adding action to sprite
		sprite.action = GameMaker.comboBox.getSelectedItem().toString();

		//Adding collision event map to sprite
		sprite.setCollisionEventMap(GameMaker.collisionEventMap);

		Sprite.spriteList.add(sprite);

		if(GameMaker.winFlag)
			GameMaker.winFlagCount++;

		if(GameMaker.LoseFlag)
			GameMaker.loseFlagCount++;

		GameMaker.collisionEventMap.clear();

		return sprite;
	}

	public void updateView(GameStage gameStage)
	{

		if(action != Constants.KEY_PRESS_ROTATE) {

			if(background.isBackgroundSet())
			{
				JLabel spriteLabel = Sprite.spriteList.get(Sprite.spriteList.size() - 1).getSpriteLabel();

				System.out.println("in updateView" + spriteLabel);
				GameStage.addedSpriteLabels.add(spriteLabel);

				spriteLabel.setForeground(Color.WHITE);
				spriteLabel.setHorizontalAlignment(JLabel.LEFT);
				spriteLabel.setVerticalAlignment(JLabel.TOP);
				gameStage.add(spriteLabel);

				gameStage.revalidate();
				gameStage.repaint();
				gameStage.requestFocusInWindow();	
			}
			else
			{
				gameStage.add(Sprite.spriteList.get(Sprite.spriteList.size() - 1).getSpriteLabel());
				gameStage.repaint();

			}
		}
		gameStage.repaint();
	}


	public void updateView()
	{
		gameStage.repaint();
	}
}
