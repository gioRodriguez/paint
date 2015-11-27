package com.gio.paint;

import java.awt.Color;
import java.awt.Point;

public class FillBucket {
	private Pixel p;
	private Color originalColor;
	private Color finalColor;

	public FillBucket(Pixel p2, Color originalColor2, Color finalColor2) {
		p = p2;
		this.originalColor = originalColor2;
		this.finalColor = finalColor2;
	}

	public static FillBucket Create(Pixel p, Color originalColor, Color finalColor) {
		return new FillBucket(p, originalColor, finalColor);
	}

	public void draw() {
		this.draw(p);
	}

	private void draw(Pixel initialPixel) {
		if(initialPixel.isNull())
		{
			return;
		}
		
		if (initialPixel.getColor().equals(originalColor)) 
		{
			initialPixel.setColor(finalColor);
			
			draw(initialPixel.GetUp());
			draw(initialPixel.GetLeft());
			draw(initialPixel.GetRight());
			draw(initialPixel.GetDown());
		}
	}

}
