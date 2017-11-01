package com.oosd.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBackground {


	private static boolean isBackgroundSet = false;
	private static String backgroundImagePath;
	
	@Test
	public void test() {
		Background background = new Background();
		
		assertEquals(isBackgroundSet, false);
		//assertEquals(background.getBackgroundImagePath(),backgroundImagePath);
	}
}
