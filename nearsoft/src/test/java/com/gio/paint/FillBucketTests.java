package com.gio.paint;

import java.awt.Color;
import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;


public class FillBucketTests {
	
	private static final int SQUARE_LENGTH = 5;
	private static final int CANVAS_SIZE = 10;

	@Test
	public void fillBucketPaintWithAroundSquareTest() {
		// arrange
		Point p = new Point(0, 0);
		Color fc = Color.red;
		Canvas canvas = Canvas.CreateWithSize(CANVAS_SIZE, CANVAS_SIZE);
		drawSquare(canvas.GetPixel(3, 3), SQUARE_LENGTH, Color.BLACK);		
		int pixelsInFinalColor = canvas.countPixelsByColor(fc);
		int pixelsInsideSquare = (int) Math.pow(SQUARE_LENGTH - 2, 2);
		
		// act				
		canvas.fillBucket(p, fc);
		int pixelsPaitedByFillBucket = canvas.countPixelsByColor(fc);
		
		// assert
		Assert.assertEquals(0, pixelsInFinalColor);
		Assert.assertEquals(canvas.totalPixels() - canvas.countPixelsByColor(Color.BLACK) - pixelsInsideSquare, pixelsPaitedByFillBucket);
	}

	private void drawSquare(Pixel initialPixel, int squareSize, Color desiredColor) {
		Pixel upperLine = initialPixel;
		for(int upperLineCount = 0; upperLineCount < squareSize - 1; upperLineCount++){
			upperLine.setColor(desiredColor);
			upperLine = upperLine.GetRight();
		}
		
		Pixel rigthLine = upperLine;
		for(int rigthLineCount = 0; rigthLineCount < squareSize - 1; rigthLineCount++){
			rigthLine.setColor(desiredColor);
			rigthLine = rigthLine.GetDown();
		}
		
		Pixel bottonLine = rigthLine;
		for(int bottomLineCount = 0; bottomLineCount < squareSize - 1; bottomLineCount++){
			bottonLine.setColor(desiredColor);
			bottonLine = bottonLine.GetLeft();
		}
		
		Pixel leftLine = bottonLine;
		for(int leftLineCount = 0; leftLineCount < squareSize - 1; leftLineCount++){
			leftLine.setColor(desiredColor);
			leftLine = leftLine.GetUp();
		}
	}
	
	@Test
	public void fillBucketPaintWithInsideSquareTest() {
		// arrange
		Color fc = Color.red;
		Canvas canvas = Canvas.CreateWithSize(CANVAS_SIZE, CANVAS_SIZE);
		Pixel initialPixel = canvas.GetPixel(3, 3);
		drawSquare(initialPixel, 4, Color.BLACK);
		int pixelsInFinalColor = canvas.countPixelsByColor(fc);
		int pixelsInsideSquare = (int) Math.pow(4 - 2, 2);
		
		// act				
		canvas.fillBucket(initialPixel.GetRight().GetDown().getPoint(), fc);
		int pixelsPaitedByFillBucket = canvas.countPixelsByColor(fc);
		
		// assert
		Assert.assertEquals(0, pixelsInFinalColor);
		Assert.assertEquals(pixelsInsideSquare, pixelsPaitedByFillBucket);
	}
}
