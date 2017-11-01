package com.oosd.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import com.oosd.controller.BackgroundController;
import com.oosd.controller.SpriteController;
import com.oosd.listeners.GameStageMouseListener;
import com.oosd.model.Background;
import com.oosd.model.Bullet;
import com.oosd.model.RotatingSprite;
import com.oosd.model.Sprite;
import com.oosd.utils.Constants;

public class GameStage extends JPanel{

	//public static JLabel backgroundImage = new JLabel();

	//private Image backGroundImage;
	private static String backGroundImagePath;

	SpriteController spriteController;
	public static LinkedList<Sprite> spriteList = new LinkedList<Sprite>();
	public static ArrayList<JLabel> addedSpriteLabels = new ArrayList<JLabel>();
	public static JLabel timerLabel = new JLabel("00:00");
	private GameStageMouseListener gameStageMouseListener;
	public static int score=0;
	private CopyOnWriteArrayList<Bullet> bulletList;

	private Sprite userSprite;

	private double rotationDegree;
	
	private Background background;
	private BackgroundController backgroundController;

	public GameStage() {
		setBackground(Color.white);
		this.setSize(490, 780);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK));

		this.background = new Background();
		backgroundController = new BackgroundController(background, this);
		spriteController = new SpriteController(this);
		
		this.setLayout(null);

		gameStageMouseListener = new GameStageMouseListener(spriteController,this);

		//System.out.println("gameStageMouseListener" + gameStageMouseListener);

		this.addMouseListener(gameStageMouseListener);	

		bulletList = new CopyOnWriteArrayList<Bullet>();
		this.setFocusable(true);
		this.requestFocus();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		
		if(background.isBackgroundSet()){
			
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.drawImage(background.getBackgroundImage(), 0, 0, this.getWidth(), this.getHeight(), this);	
		
		}
		collisionHandler();
		draw(g);
	}



	public void collisionHandler(){

		bullet_collision: for (Bullet bullet : bulletList){
			bullet.update();
			if(bullet.getImageYpos() >= Constants.GAME_STAGE_HEIGHT){
				//System.out.println(bullet);
				bulletList.remove(bullet);
			}
			for(Sprite sprite: Sprite.spriteList){

				if( sprite.getBounds().intersects(bullet.getBounds()) ){


					if(sprite != this.userSprite  )
					{
						//score++;
						System.out.println("Hit the Sprite");
						System.out.println();
						int spriteIndex  = Sprite.spriteList.indexOf(sprite);
						Sprite.spriteList.remove(spriteIndex);	

						this.remove(sprite.getSpriteLabel());
						bulletList.remove(bullet);
						this.revalidate();
						break bullet_collision;

					}

				}
			}
		}
	}


	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setFont(new Font("TimesRoman", Font.BOLD, Constants.SCORE_BOARD_SIZE));
		g2d.setColor(Color.WHITE);
		g2d.drawString("SCORE: "+score, Constants.SCORE_BOARD_X, Constants.SCORE_BOARD_Y);
		for (Bullet bullet : bulletList){
			g2d.drawImage(bullet.getImage(), bullet.getImageXpos(), bullet.getImageYpos(), Constants.BULLET_WIDTH, Constants.BULLET_HEIGHT, this);
		}

		if(userSprite !=null ) {


			int userCenterX = ((RotatingSprite)userSprite).getxPosition();
			int userCenterY = ((RotatingSprite)userSprite).getyPosition();

			int imageWidth = ((RotatingSprite)userSprite).getSpriteWidth();
			int imageHeight = ((RotatingSprite)userSprite).getSpriteHeight();

			Image image = ((RotatingSprite)userSprite).getImage();

			if(rotationDegree != 0) {

				AffineTransform at = AffineTransform.getTranslateInstance(userCenterX, userCenterY);
				at.rotate(rotationDegree, imageWidth/2, imageHeight/2);				
				g2d.drawImage(image, at, null);
				repaint();

			}
			else
				g2d.drawImage(image, userSprite.getxPosition(), userSprite.getyPosition(), userSprite.getSpriteWidth(), userSprite.getSpriteHeight(), this);
		}
	}

	public CopyOnWriteArrayList<Bullet> getBulletList() {
		return this.bulletList;
	}

	public void setBulletList(CopyOnWriteArrayList<Bullet> bulletList) {
		this.bulletList = bulletList;
	}

	public String getBackGroundImagePath() {
		return backGroundImagePath;
	}

	public static void setBackGroundImagePath(String backGroundImagePath) {
		GameStage.backGroundImagePath = backGroundImagePath;
	}

	public double getRotationDegree() {
		return rotationDegree;
	}

	public void setRotationDegree(double rotationDegree) {
		this.rotationDegree += rotationDegree;
	}

	public Background getBackgroundObject() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public BackgroundController getBackgroundController() {
		return backgroundController;
	}

	public void setBackgroundController(BackgroundController backgroundController) {
		this.backgroundController = backgroundController;
	}
	
	public Sprite getUserSprite() {
		return userSprite;
	}

	public void setUserSprite(Sprite userSprite) {
		this.userSprite = userSprite;
	}
}
