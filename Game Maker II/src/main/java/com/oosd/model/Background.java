package com.oosd.model;

import java.awt.Image;
import java.util.HashMap;

public class Background 
{
	
	private boolean isBackgroundSet = false;
	private Image backgroundImage;
	private String currentBackgroundKey;
	private HashMap<String, Image> backgroundImages;
	
	public boolean isBackgroundSet() {
		return isBackgroundSet;
	}
	
	public void setBackgroundSet(boolean isBackgroundSet) {
		this.isBackgroundSet = isBackgroundSet;
	}

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public String getCurrentBackgroundKey() {
		return currentBackgroundKey;
	}

	public void setCurrentBackgroundKey(String currentBackgroundKey) {
		this.currentBackgroundKey = currentBackgroundKey;
	}

	public HashMap<String, Image> getBackgroundImages() {
		return backgroundImages;
	}

	public void setBackgroundImages(HashMap<String, Image> backgroundImages) {
		this.backgroundImages = backgroundImages;
	}	
}

