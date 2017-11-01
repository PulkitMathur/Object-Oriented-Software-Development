package com.oosd.controller;

import java.awt.Image;
import org.apache.log4j.Logger;
import com.oosd.model.Background;
import com.oosd.view.GameStage;

public class BackgroundController implements ControllerInterface
{
	public static final Logger logger = Logger.getLogger(BackgroundController.class);
	private Background background;
	private GameStage gameStage;
	
	public BackgroundController(Background background, GameStage gameStage) {
		this.background = background;
		this.gameStage = gameStage;
	}
	
	public void setBackgroundImage(Image backgroundImage, String currentBackgroundKey) {
		background.setBackgroundImage(backgroundImage);
		background.setCurrentBackgroundKey(currentBackgroundKey);
	}

	public void setBackgroundImage(String currentBackgroundKey)
	{
		background.setBackgroundImage(background.getBackgroundImages().get(currentBackgroundKey));
	}
	
	public void update()
	{
		gameStage.repaint();
		background.setBackgroundSet(true);
		logger.debug("Update View from Background Controller called.");
	}
	
	public void updateView()
	{
		update();
	}

}
