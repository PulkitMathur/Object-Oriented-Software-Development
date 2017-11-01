package com.oosd.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.oosd.DAOImpl.GameDAOImpl;
import com.oosd.controller.BackgroundController;
import com.oosd.model.Background;
import com.oosd.model.Game;
import com.oosd.model.Sprite;
import com.oosd.utils.Constants;

public class LoadGameList extends JFrame implements ActionListener, Constants {

	JComboBox savedGames;
	JButton btnLoad;
	HashMap<String, Integer> idNameMap = new HashMap<String, Integer>();
	GameStage gameStage;
	Background background;
	BackgroundController backgroundController;
	
	public static int currentGameId;
	public static String currentGameName;
	

	public LoadGameList(GameStage gameStage) {

		this.setTitle("Load Game");
		this.setSize(300, 121);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.YELLOW);
		this.setLocation(MAIN_FRAME_WIDTH/3, MAIN_FRAME_HEIGHT/3);
		this.gameStage = gameStage;
		this.background = gameStage.getBackgroundObject();
		this.backgroundController = gameStage.getBackgroundController();

		savedGames = new JComboBox();

		btnLoad = new JButton("Load");
		btnLoad.addActionListener(this);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(savedGames,
										0, 264, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addGap(108).addComponent(btnLoad)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(savedGames, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnLoad)
						.addContainerGap(196, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

		// Display list of saved games
		savedGameList();
	}

	public void savedGameList() {

		GameDAOImpl gameDAOImpl = new GameDAOImpl();
		ArrayList<String> gameList = gameDAOImpl.getAllGameNames();

		savedGames.addItem("Select a Game");

		for (int i = 0; i < gameList.size(); i++) {

			savedGames.addItem(gameList.get(i));
			idNameMap.put(gameList.get(i), i + 1);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		HashMap<String, Object> savedObjects = new HashMap<String, Object>();
		GameDAOImpl gameDAOImpl = new GameDAOImpl();

		if (savedGames.getSelectedItem() != "Select a Game") {

			Game game = gameDAOImpl.getGame(idNameMap.get(savedGames.getSelectedItem()));
			byte[] gameObject = game.getGameObject();
			
			currentGameId = game.getGameId();
			currentGameName = game.getGameName();

			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(gameObject);
			ObjectInputStream objectInputStream;
			try {
				objectInputStream = new ObjectInputStream(byteArrayInputStream);
				savedObjects = (HashMap<String, Object>) objectInputStream.readObject();

				objectInputStream.close();
				byteArrayInputStream.close();

				Sprite.spriteList = (CopyOnWriteArrayList<Sprite>) savedObjects.get("spriteList");
				GameMaker.winFlagCount = (int) savedObjects.get("win");
				GameMaker.loseFlagCount = (int) savedObjects.get("lose");

				for (int i = 0; i < Sprite.spriteList.size(); i++) {
					Sprite sprite = Sprite.spriteList.get(i);
					GameStage.addedSpriteLabels.add(Sprite.spriteList.get(i).getSpriteLabel());
					gameStage.add(Sprite.spriteList.get(i).getSpriteLabel());

				}

				background.setCurrentBackgroundKey((String) savedObjects.get("backgroundImage"));
				backgroundController.setBackgroundImage(background.getCurrentBackgroundKey());
				backgroundController.update();

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		
		//Close on load click
		this.dispose();

	}

}
