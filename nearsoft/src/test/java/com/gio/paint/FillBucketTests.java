package com.gio.paint;

import org.junit.Assert;
import org.junit.Test;

import java.awt.Color;
import java.awt.Point;


public class FillBucketTests {
	
	@Test
	public void fillBucketTest() {
		// arrange
		Point p = new Point(0, 0);
		Color c = Color.white; 
		Color fc = Color.red;
		Canvas canvas = Canvas.CreateWithSize(50, 50);		
		
		// act
		canvas.fillBucket(p, c, fc);	
		
		// assert
		Assert.assertEquals(Color.red, canvas.GetPixel(0, 5).getColor());
	}	
}
