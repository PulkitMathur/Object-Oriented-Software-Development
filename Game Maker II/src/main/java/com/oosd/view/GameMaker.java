package com.oosd.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import com.oosd.controller.BackgroundController;
import com.oosd.controller.GameController;
import com.oosd.hibernate.RetrieveImages;
import com.oosd.listeners.GameMakerListener;
import com.oosd.model.Background;
import com.oosd.model.Sprite;
import com.oosd.utils.Constants;

public class GameMaker extends JPanel implements Constants, MouseListener {//ActionListener, MouseListener, Constants {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	JPanel backgroundPanel, spritePanel;
	public static HashMap<String, JLabel> backgroundLabels = new HashMap<String, JLabel>();
	
	public static HashMap<String, Image> spriteImages = new HashMap<String, Image>();
	public static String spriteKey;
	public static String getSpriteKey() {
		return spriteKey;
	}

	public static void setSpriteKey(String spriteKey) {
		GameMaker.spriteKey = spriteKey;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	private short selectedSprite;
	private short selectedBackground;
	private static File[] backgroundFiles;
	private static File[] spriteFiles;
	public static JTextField spriteWidth;
	public static JTextField spriteHeight;
	public static String action;
	GameController gameController;
	public static boolean winFlag = false;
	public static boolean LoseFlag = false;

	public static int winFlagCount = 0;
	public static int loseFlagCount = 0;

	
	public static HashMap<String, ArrayList<String>> collisionEventMap = new HashMap<String, ArrayList<String>>();

	
	public static JComboBox comboBox;	
	
	//Gameplay buttons
	JButton btnSave = new JButton(BTN_SAVE);		
	public JComboBox getMusicComboBox() {
		return musicComboBox;
	}

	JButton btnLoad = new JButton(BTN_LOAD);		
	JButton btnPlay = new JButton(BTN_PLAY);		
	JButton btnReset = new JButton(BTN_RESET);
	JButton btnApplyCollisionCheck = new JButton("Apply");
	JButton btnMusicAdd = new JButton("Add");
	
	//Collision Check Combo Box
	private JComboBox collisionCheck = new JComboBox();
	
	//Collision Event Checkboxes
	private JCheckBox checkboxDestroy = new JCheckBox(DESTROY);		
	private JCheckBox checkboxBounce = new JCheckBox(BOUNCE);
	private JCheckBox checkboxWin = new JCheckBox(GAME_WIN);
	private JCheckBox checkboxLose = new JCheckBox(GAME_LOSE);
	
	GameStage gameStage;
	
	private final JLabel lblStepSound = new JLabel("Select a sound for collision.");
	private final JLabel lblStepDrop = new JLabel("STEP 5: Drop the sprite on the game stage");
	private final JLabel lblStepChoose = new JLabel("STEP 6: Choose a readout:");
	private final JLabel lblStepMusic = new JLabel("STEP 7: Choose music:");
	private final JComboBox readoutComboBox = new JComboBox();
	private final JComboBox musicComboBox = new JComboBox();
	private final JComboBox soundComboBox = new JComboBox();
	private final JButton btnAdd = new JButton("Add");
	
	private GameMakerListener gameMakerListner;
	//private HashMap<String, String> backGroundImagePaths = new HashMap<String, String>();
	
	private Background background;
	private BackgroundController backgroundController;
	private String currentBackgroundKey;
	private HashMap<String, Image> backgroundImages;

	public GameMaker(GameStage gameStage)
	{
		lblStepMusic.setForeground(Color.WHITE);
		lblStepChoose.setForeground(Color.WHITE);
		lblStepDrop.setForeground(Color.WHITE);
		lblStepSound.setForeground(Color.WHITE);
		initComponents();
		setBackground(Color.DARK_GRAY);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		this.setSize(490, 780);
		
		backgroundImages = new HashMap<String, Image>();
		
		this.gameStage = gameStage;
		this.background = gameStage.getBackgroundObject();
		this.backgroundController = gameStage.getBackgroundController();
		
		//File backgroundFolder = new File("src/main/java/res/backgrounds");
		//File spriteFolder = new File("src/main/java/res/sprites");
		
		//setBackgroundFiles(listFiles(backgroundFolder));
		//initBackgroundImages(getBackgroundFiles());
		//setSpriteFiles(listFiles(spriteFolder));
		//initSpriteImages(getSpriteFiles());
		
		//Get images from database
		RetrieveImages retrieveImages = new RetrieveImages();
		
		initBackgroundImages(retrieveImages.getImages("background"));
		
		background.setBackgroundImages(backgroundImages);
		
		//setSpriteFiles(listFiles(spriteFolder));
		initSpriteImages(retrieveImages.getImages("sprite"));
		
		gameController = new GameController(gameStage, this);
		gameMakerListner = new GameMakerListener(this);
		
	}
	
	public void mouseClicked(MouseEvent e) {

			for(int i = 0; i < backgroundImages.size(); i++)
			{
				backgroundLabels.get("backgroundLabel" + i).setBorder(null);
				if(e.getSource().equals(backgroundLabels.get("backgroundLabel" + i)))
				{
					backgroundLabels.get("backgroundLabel" + i).setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 3));
					
					background.setBackgroundSet(true);
					currentBackgroundKey = "backgroundImage" + i;
					backgroundController.setBackgroundImage(backgroundImages.get(currentBackgroundKey), currentBackgroundKey);
					backgroundController.update();
					gameStage.repaint();
				}
			}
			
			for(int i = 0; i <spriteImages.size(); i++)
			{
	
				Sprite.spriteLabels.get("spriteLabel" + i).setBorder(null);
				if(e.getSource().equals(Sprite.spriteLabels.get("spriteLabel" + i)))
				{
					GameMaker.spriteKey = "spriteImage" + i;
					Sprite.spriteLabels.get("spriteLabel" + i).setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 3));
					setSelectedSprite((short)i);
					Sprite.setRotatingSpriteImage(spriteImages.get("spriteImage" + i));
					
					gameStage.repaint();
				}
			}
		}
	
		@Override
		public void mouseEntered(MouseEvent e) {
			//System.out.println("MOuse ENteres");
	
			for(int i = 0; i < backgroundImages.size(); i++)
			{
				if(e.getSource().equals(backgroundLabels.get("backgroundLabel" + i)) && getSelectedBackground() != i)
				{
					backgroundLabels.get("backgroundLabel" + i).setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
				}
			}
			
			for(int i = 0; i < spriteImages.size(); i++)
			{
				if(e.getSource().equals(Sprite.spriteLabels.get("spriteLabel" + i)) && getSelectedSprite() != i)
				{
					Sprite.spriteLabels.get("spriteLabel" + i).setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
				}
			}
		}
	
		@Override
		public void mouseExited(MouseEvent e) {

			for(int i = 0; i < backgroundImages.size(); i++)
			{
				if(e.getSource().equals(backgroundLabels.get("backgroundLabel" + i)) && getSelectedBackground() != i)
				{
					backgroundLabels.get("backgroundLabel" + i).setBorder(null);
				}
			}
			
			for(int i = 0; i <spriteImages.size(); i++)
			{
				if(e.getSource().equals(Sprite.spriteLabels.get("spriteLabel" + i)) && getSelectedSprite() != i)
				{
					Sprite.spriteLabels.get("spriteLabel" + i).setBorder(null);
				}
			}
		}
	
		@Override
		public void mousePressed(MouseEvent arg0) {
		}
	
		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	
	
	public void initBackgroundImages(ArrayList<Image> images) {
		for(int i = 0; i < images.size(); i++)
		{
			try {
				
				backgroundImages.put("backgroundImage" + i, images.get(i));

				ImageIcon icon = new ImageIcon(images.get(i));
				icon.setImage(images.get(i).getScaledInstance(100, 100, Image.SCALE_FAST));
				JLabel jLabel = new JLabel();
				jLabel.setIcon(icon);
				backgroundPanel.add(jLabel); 
				jLabel.addMouseListener(this);
								
				backgroundLabels.put("backgroundLabel" + i, jLabel);
				//backgroundLabels.get("backgroundLabel" + i).setIcon(icon);
				
			} catch (Exception e) {

				e.printStackTrace();
			}	
		}
	}
	
	public void initSpriteImages(ArrayList<Image> images)
	{
		for(int i = 0; i < images.size(); i++)
		{
			try {
				/*
				BufferedImage bufferedImage = ImageIO.read(files[i]);
				ImageIcon icon = new ImageIcon(bufferedImage);
				Image image = icon.getImage();	
				*/		
				spriteImages.put("spriteImage" + i, images.get(i));	
				ImageIcon icon = new ImageIcon(images.get(i));
				icon.setImage(images.get(i).getScaledInstance(100, 100, Image.SCALE_FAST));
				JLabel jLabel = new JLabel();
				Sprite.spriteLabels.put("spriteLabel" + i, jLabel);
				Sprite.spriteLabels.get("spriteLabel" + i).setIcon(icon);
				spritePanel.add(Sprite.spriteLabels.get("spriteLabel" + i)); 
				Sprite.spriteLabels.get("spriteLabel" + i).addMouseListener(this);	
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	public void initComponents() {

		JLabel lblChooseABackground = new JLabel("STEP 1: Choose a background");
		lblChooseABackground.setForeground(Color.ORANGE);

		backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.white);

		JScrollPane scrollPane = new JScrollPane(backgroundPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JLabel lblSelectSpritesFor = new JLabel("STEP 2: Select objects for your game:");
		lblSelectSpritesFor.setForeground(Color.ORANGE);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.BLACK);

		JLabel lblChoosePropertiesFor = new JLabel("STEP 3: Choose properties for your sprite:");
		lblChoosePropertiesFor.setForeground(Color.ORANGE);

		// Add Game Play buttons to layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
						.addComponent(lblChoosePropertiesFor)
						.addComponent(lblSelectSpritesFor)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChooseABackground)
						.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
						.addComponent(lblStepDrop)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblStepChoose)
							.addGap(18)
							.addComponent(getReadoutComboBox(), 0, 228, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblStepMusic)
							.addGap(18)
							.addComponent(musicComboBox, 0, 228, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnMusicAdd, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSave)
							.addGap(18)
							.addComponent(btnLoad)
							.addGap(18)
							.addComponent(btnReset)
							.addGap(18)
							.addComponent(btnPlay)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblChooseABackground)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSelectSpritesFor)
					.addGap(12)
					.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblChoosePropertiesFor)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblStepDrop)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStepChoose)
						.addComponent(getReadoutComboBox(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd))
						.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStepMusic)
						.addComponent(musicComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMusicAdd))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnLoad)
						.addComponent(btnReset)
						.addComponent(btnPlay))
					.addContainerGap(69, Short.MAX_VALUE))
		);

		spritePanel = new JPanel();
		scrollPane2.setViewportView(spritePanel);
		spritePanel.setBackground(Color.WHITE);

		// Select height and width
		JLabel lblSelectWidthAnd = new JLabel("Select width and height of your sprite:");
		lblSelectWidthAnd.setForeground(Color.ORANGE);

		spriteWidth = new JTextField();
		spriteWidth.setText(FORTY);
		spriteWidth.setColumns(10);
		
		spriteHeight = new JTextField();
		spriteHeight.setText(FORTY);
		spriteHeight.setColumns(10);
		
		// Select sprite actions
		JLabel lblChooseActionsFor = new JLabel("Choose actions for your sprite:");
		lblChooseActionsFor.setForeground(Color.ORANGE);

		comboBox = new JComboBox();
		comboBox.addItem(NONE);
		comboBox.addItem(AUTO_MOVE_VERTICAL);
		comboBox.addItem(AUTO_MOVE_HORIZONTAL);
		comboBox.addItem(AUTO_MOVE_ACROSS);
		comboBox.addItem(KEY_PRESS_VERTICAL);
		comboBox.addItem(KEY_PRESS_HORIZONTAL);
		comboBox.addItem(KEY_PRESS_ACROSS);
		comboBox.addItem(KEY_PRESS_ROTATE);

		// Select collision checks
		JLabel lblSelectCollisionChecks = new JLabel("Select collision checks for your sprite:");
		lblSelectCollisionChecks.setForeground(Color.ORANGE);

		getCollisionCheck().addItem(NONE);
		getCollisionCheck().addItem(TOP_BOUNDARY);
		getCollisionCheck().addItem(BOTTOM_BOUNDARY);
		getCollisionCheck().addItem(RIGHT_BOUNDARY);
		getCollisionCheck().addItem(LEFT_BOUNDARY);
		getCollisionCheck().addItem(ANOTHER_SPRITE);

		JLabel lblSelectOnCollision = new JLabel("Select on collision events:");
		lblSelectOnCollision.setForeground(Color.ORANGE);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectWidthAnd)
								.addComponent(lblChooseActionsFor))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(spriteWidth, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(spriteHeight, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
								.addComponent(comboBox, 0, 258, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSelectCollisionChecks)
							.addGap(9)
							.addComponent(getCollisionCheck(), 0, 258, Short.MAX_VALUE))
						.addComponent(lblSelectOnCollision)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(getCheckboxDestroy())
							.addGap(18)
							.addComponent(getCheckboxBounce())
							.addGap(18)
							.addComponent(getCheckboxWin())
							.addGap(18)
							.addComponent(getCheckboxLose()))
						.addComponent(btnApplyCollisionCheck))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(spriteWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spriteHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSelectWidthAnd))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChooseActionsFor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelectCollisionChecks)
						.addComponent(getCollisionCheck(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblSelectOnCollision)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(getCheckboxDestroy())
						.addComponent(getCheckboxBounce())
						.addComponent(getCheckboxWin())
						.addComponent(getCheckboxLose()))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnApplyCollisionCheck)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		getCheckboxBounce().setBackground(Color.ORANGE);
		getCheckboxBounce().setForeground(Color.BLACK);
		getCheckboxWin().setBackground(Color.ORANGE);
		getCheckboxWin().setForeground(Color.BLACK);
		getCheckboxLose().setBackground(Color.ORANGE);
		getCheckboxLose().setForeground(Color.BLACK);
		getCheckboxDestroy().setBackground(Color.ORANGE);
		getCheckboxDestroy().setForeground(Color.BLACK);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		btnReset.setFocusable(false);
		btnPlay.setFocusable(false);
		btnLoad.setFocusable(false);
		btnApplyCollisionCheck.setFocusable(false);
		btnSave.setFocusable(false);

		comboBox.setFocusable(false);
		getCollisionCheck().setFocusable(false);
		
		getCheckboxBounce().setFocusable(false);
		getCheckboxDestroy().setFocusable(false);
		getCheckboxLose().setFocusable(false);
		getCheckboxWin().setFocusable(false);
		
		getReadoutComboBox().addItem("None");
		getReadoutComboBox().addItem("Timer");
		
	
		musicComboBox.addItem("None");
		musicComboBox.addItem("Atari");
		musicComboBox.addItem("Frogger");
		musicComboBox.addItem("Space Invaders");
		
		//soundComboBox.addItem("None");
		//soundComboBox.addItem("Jab");

		
	}
		// Action Listeners for GamePlay Buttons

		public void addPlayButtonListener(ActionListener playButtonListener) {
			btnPlay.addActionListener(playButtonListener);
		}
		
		public void addApplyButtonListener(ActionListener applyButtonListener) {
			btnApplyCollisionCheck.addActionListener(applyButtonListener);
		}
		
		public void addSaveButtonListener(ActionListener saveButtonListener) {
			btnSave.addActionListener(saveButtonListener);
		}

		public void addLoadButtonListener(ActionListener loadButtonListener) {
			btnLoad.addActionListener(loadButtonListener);
		}
		
		public void addResetButtonListener(ActionListener resetButtonListener) {
			btnReset.addActionListener(resetButtonListener);
		}
		
		public void addGameMakerListener(MouseListener gameMakerListener) {
			this.addGameMakerListener(gameMakerListener);
		}
		
		public void addAddButtonListener(ActionListener addButtonListener) {
			btnAdd.addActionListener(addButtonListener);
		}
		

		public void addAddMusicButtonListener(ActionListener addMusicButtonListener) {
			btnMusicAdd.addActionListener(addMusicButtonListener);
		}

		public JComboBox getCollisionCheck() {
			return collisionCheck;
		}

		public void setCollisionCheck(JComboBox collisionCheck) {
			this.collisionCheck = collisionCheck;
		}

		public JCheckBox getCheckboxDestroy() {
			return checkboxDestroy;
		}

		public void setCheckboxDestroy(JCheckBox checkboxDestroy) {
			this.checkboxDestroy = checkboxDestroy;
		}

		public JCheckBox getCheckboxWin() {
			return checkboxWin;
		}

		public void setCheckboxWin(JCheckBox checkboxWin) {
			this.checkboxWin = checkboxWin;
		}

		public JCheckBox getCheckboxBounce() {
			return checkboxBounce;
		}

		public void setCheckboxBounce(JCheckBox checkboxBounce) {
			this.checkboxBounce = checkboxBounce;
		}

		public JCheckBox getCheckboxLose() {
			return checkboxLose;
		}

		public void setCheckboxLose(JCheckBox checkboxLose) {
			this.checkboxLose = checkboxLose;
		}

		public File[] getBackgroundFiles() {
			return backgroundFiles;
		}

		public static void setBackgroundFiles(File[] backgroundFiles) {
			GameMaker.backgroundFiles = backgroundFiles;
		}

		public short getSelectedBackground() {
			return selectedBackground;
		}

		public void setSelectedBackground(short selectedBackground) {
			this.selectedBackground = selectedBackground;
		}

		public File[] getSpriteFiles() {
			return spriteFiles;
		}

		public static void setSpriteFiles(File[] spriteFiles) {
			GameMaker.spriteFiles = spriteFiles;
		}

		public short getSelectedSprite() {
			return selectedSprite;
		}

		public void setSelectedSprite(short selectedSprite) {
			this.selectedSprite = selectedSprite;
		}

		public JComboBox getReadoutComboBox() {
			return readoutComboBox;
		}
		
		public static HashMap<String, JLabel> getBackgroundLabels() {
			return backgroundLabels;
		}

		public static void setBackgroundLabels(HashMap<String, JLabel> backgroundLabels) {
			GameMaker.backgroundLabels = backgroundLabels;
		}

		
		
}