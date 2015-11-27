package com.gio.paint;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

public class FillBucketTests {
	
	@Test
	public void fillBucketTest() {
		// arrange
		Point p = new Point(0, 0);
		Color c = Color.white; 
		Color fc = Color.red;
		Canvas canvas = Canvas.CreateWithSize(96, 96);		
		
		// act
		canvas.fillBucket(p, c, fc);	
		
		// assert
		System.out.println(canvas);
	}	
}
