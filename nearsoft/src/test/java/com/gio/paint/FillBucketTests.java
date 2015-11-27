package com.gio.paint;

import org.junit.Assert;
import org.junit.Test;

import java.awt.Color;
import java.awt.Point;


public class FillBucketTests {
	
	@Test
	public void fillBucketPaint_x0_y0_color_redTest() {
		// arrange
		Point p = new Point(0, 0);
		Color c = Color.white; 
		Color fc = Color.red;
		Canvas canvas = Canvas.CreateWithSize(10, 10);
		canvas.GetPixel(4, 4).setColor(Color.BLACK);
		canvas.GetPixel(5, 4).setColor(Color.BLACK);
		canvas.GetPixel(6, 4).setColor(Color.BLACK);
		canvas.GetPixel(7, 4).setColor(Color.BLACK);
		canvas.GetPixel(4, 5).setColor(Color.BLACK);
		canvas.GetPixel(5, 5).setColor(Color.GREEN);
		canvas.GetPixel(6, 5).setColor(Color.GREEN);
		canvas.GetPixel(7, 5).setColor(Color.BLACK);
		canvas.GetPixel(4, 6).setColor(Color.BLACK);
		canvas.GetPixel(5, 6).setColor(Color.GREEN);
		canvas.GetPixel(6, 6).setColor(Color.GREEN);
		canvas.GetPixel(7, 6).setColor(Color.BLACK);
		canvas.GetPixel(4, 7).setColor(Color.BLACK);
		canvas.GetPixel(5, 7).setColor(Color.BLACK);
		canvas.GetPixel(6, 7).setColor(Color.BLACK);
		canvas.GetPixel(7, 7).setColor(Color.BLACK);
		
		System.out.println("-- fillBucketPaint_x0_y0_color_redTest -- Original Canvas \n");
		System.out.println(canvas);
		
		// act				
		canvas.fillBucket(p, c, fc);
		System.out.println("-- fillBucketPaint_x0_y0_color_redTest -- Final Canvas \n");
		System.out.println(canvas);
		
		// assert
		Assert.assertEquals(Color.red, canvas.GetPixel(0, 5).getColor());
	}
	
	@Test
	public void fillBucketPaint_x5_y5_color_redTest() {
		// arrange
		Point p = new Point(6, 5);
		Color c = Color.green; 
		Color fc = Color.red;
		Canvas canvas = Canvas.CreateWithSize(10, 10);
		canvas.GetPixel(4, 4).setColor(Color.BLACK);
		canvas.GetPixel(5, 4).setColor(Color.BLACK);
		canvas.GetPixel(6, 4).setColor(Color.BLACK);
		canvas.GetPixel(7, 4).setColor(Color.BLACK);
		canvas.GetPixel(4, 5).setColor(Color.BLACK);
		canvas.GetPixel(5, 5).setColor(Color.GREEN);
		canvas.GetPixel(6, 5).setColor(Color.GREEN);
		canvas.GetPixel(7, 5).setColor(Color.BLACK);
		canvas.GetPixel(4, 6).setColor(Color.BLACK);
		canvas.GetPixel(5, 6).setColor(Color.GREEN);
		canvas.GetPixel(6, 6).setColor(Color.GREEN);
		canvas.GetPixel(7, 6).setColor(Color.BLACK);
		canvas.GetPixel(4, 7).setColor(Color.BLACK);
		canvas.GetPixel(5, 7).setColor(Color.BLACK);
		canvas.GetPixel(6, 7).setColor(Color.BLACK);
		canvas.GetPixel(7, 7).setColor(Color.BLACK);
		
		System.out.println("-- fillBucketPaint_x5_y5_color_redTest -- Original Canvas \n");
		System.out.println(canvas);
		
		// act				
		canvas.fillBucket(p, c, fc);
		System.out.println("-- fillBucketPaint_x5_y5_color_redTest -- Final Canvas \n");
		System.out.println(canvas);
		
		// assert
		Assert.assertEquals(Color.red, canvas.GetPixel(6, 5).getColor());
	}
}
