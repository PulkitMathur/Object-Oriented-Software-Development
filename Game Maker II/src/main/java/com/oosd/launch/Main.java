package com.oosd.launch;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.oosd.view.GameMaker;
import com.oosd.view.GameStage;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	public Main() {
		
		GameStage gameStage = new GameStage();	//Game stage panel
		GameMaker gameMaker = new GameMaker(gameStage);	//Game editor panel
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(gameMaker, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(gameStage, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(gameStage, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
				.addComponent(gameMaker, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}
	public static void main(String[] ar)
	{
		Main frame = new Main();
		
		//frame.setSize(990, 780);
		frame.setSize(990, 840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("GameMaker 1.0");
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
