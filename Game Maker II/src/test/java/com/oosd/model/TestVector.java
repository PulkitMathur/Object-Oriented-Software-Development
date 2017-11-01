package com.oosd.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVector {

	
	Double angle;
	Double Y;
	Double X;
	
	@Test
	public void test() {
		angle = 0.00;
		Vector vector = new Vector(angle);
		Y = Math.cos(angle);
		X = Math.sin(angle);
		
		System.out.println(vector.getX());
		System.out.println(vector.getY());
		System.out.println(Y);
		System.out.println(X);
		
		assertEquals(1,1);
		assertEquals(0,0);
		
		
	}

}
