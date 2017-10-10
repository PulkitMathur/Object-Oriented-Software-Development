package com.gamebuilder.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.apache.log4j.Logger;

public class GameLoad {
	
	private static Logger gameLoadLog = Logger.getLogger("gameLoadLogger");
	
	public Savable deserialize(){
		try{
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setApproveButtonText("Open");
			jfc.setApproveButtonMnemonic('o');
			jfc.setApproveButtonToolTipText("Open Game");
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				FileInputStream fileInput = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);
				Savable savable = (Savable) objectInputStream.readObject();
				gameLoadLog.info("Size of sprite array" + savable.spriteArrayList.size());
				gameLoadLog.info("Color: " + savable.backGroundColor);
				if(savable != null){
					return savable;
				}
				objectInputStream.close();
				fileInput.close();
			}
		}catch(IOException e){
			gameLoadLog.error("IO exception occured" + e.getLocalizedMessage());
			return null;
		}catch(ClassNotFoundException e){
			gameLoadLog.error("Class not found exception occured" + e.getLocalizedMessage());
			return null;
		}
		return null;
	}

}
