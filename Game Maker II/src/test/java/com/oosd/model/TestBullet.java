package com.oosd.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestBullet {
	Bullet bullet;
	@Test
	public void test() {
		//Bullet bullet;
		try {
			bullet = new Bullet(100, 100, new Vector(0));
			assertEquals(100, bullet.getImageXpos());
			assertEquals(101, bullet.getImageYpos());
			bullet.update();
			assertEquals(111, bullet.getImageYpos());
			assertEquals(100, bullet.getImageXpos());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void test2(){
		//Bullet bullet;
		try {
			bullet = new Bullet(100, 100, new Vector(90));
			assertEquals(100, bullet.getImageXpos());
			assertEquals(99, bullet.getImageYpos());
			bullet.update();
			assertEquals(94, bullet.getImageYpos());
			assertEquals(100, bullet.getImageXpos());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
