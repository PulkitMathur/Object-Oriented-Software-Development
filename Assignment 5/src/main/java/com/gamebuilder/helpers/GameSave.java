package com.gamebuilder.helpers;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.apache.log4j.Logger;

import com.gamebuilder.controller.SpritePanelController;
import com.gamebuilder.sprite.GameSprite;

public class GameSave {
	
	private ArrayList<GameSprite> spriteArrayList;
	private Color backgroundColor;
	private Savable savable;
	
	private static Logger gameSaveLog = Logger.getLogger("gameSaveLogger");
	
	public GameSave(SpritePanelController spritePanelController){
		this.spriteArrayList = spritePanelController.getSpritePanelModel().getSpriteArray();
		this.backgroundColor = spritePanelController.getSpritePanelModel().getBackgroundColor();
		
		savable = new Savable(this.spriteArrayList, this.backgroundColor);
	}
	
	public boolean serialize(){
		try{
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			jfc.setApproveButtonText("Save");
			jfc.setApproveButtonMnemonic('s');
			jfc.setApproveButtonToolTipText("Save Game");
			int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				FileOutputStream fileOut = new FileOutputStream(selectedFile.getPath()+".save");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(savable);
				out.close();
				fileOut.close();
				gameSaveLog.info("Filed saved");
				return true;
			}else{
				gameSaveLog.info("Failed to save, Approve option not selected");
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			gameSaveLog.error("Failed to save" + e.getLocalizedMessage());
		}
		return false;
	}

}
