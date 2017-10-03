package com.gamebuilder.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import org.apache.log4j.Logger;

import com.gamebuilder.model.SpritePanelModel;
import com.gamebuilder.strategy.CollisionEvent;
import com.gamebuilder.strategy.KeyPressSides;
import com.gamebuilder.strategy.KeyPressUpDown;
import com.gamebuilder.strategy.SpriteEventInterface;
import com.gamebuilder.ui.GamePanelView;

public class EventButtonListener implements ActionListener {

	private static Logger eventLog = Logger.getLogger("eventLogger");
	private SpritePanelModel spritePanelModel;
	private GamePanelView gamePanelView;

	public EventButtonListener(SpritePanelModel spritePanelModel, GamePanelView gamePanelView) {
		this.spritePanelModel = spritePanelModel;
		this.gamePanelView = gamePanelView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String actionCommand = e.getActionCommand();

		switch (actionCommand) {
		case GameConstants.UPDOWN:
			eventLog.info("Up-down event selected");
			updownInterface(((JCheckBox) (e.getSource())).isSelected());

			break;
		case GameConstants.SIDES:
			eventLog.info("Sides event selected");
			sidesInterface( ((JCheckBox) (e.getSource())).isSelected());

			break;
		case GameConstants.COLLISION:
			eventLog.info("Collision event selected");
			collisionInterface(((JCheckBox) (e.getSource())).isSelected());
		}

	}

	private void updownInterface(boolean keyPressUp) {
		SpriteEventInterface spriteEvent = new KeyPressUpDown(keyPressUp);
		spritePanelModel.setEventInterface(spriteEvent);
	}
	private void sidesInterface(boolean keyPressSide) {
		SpriteEventInterface spriteEvent = new KeyPressSides(keyPressSide);
		spritePanelModel.setEventInterface(spriteEvent);
	}
	private void collisionInterface(boolean collisionEvent) {
		SpriteEventInterface spriteEvent = new CollisionEvent(collisionEvent);
		spritePanelModel.setEventInterface(spriteEvent);
	}

}
