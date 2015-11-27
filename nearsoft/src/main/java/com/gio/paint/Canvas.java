package com.gio.paint;

import java.awt.Color;
import java.awt.Point;

public class Canvas {

	private Pixel[][] _canvas;	
	private int height;
	private int width;
	
	private Canvas(int width, int height) {
		this.width = width;
		this.height = height;
		
		_canvas = new GioPixel[width][height];
		
		for(int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++) {
				_canvas[x][y] = new GioPixel(this, Color.white, new Point(x, y));
			}
		}
	}
	
	public static Canvas CreateWithSize(int high, int width) {		
		return new Canvas(width, high);
	}

	public void fillBucket(Point p, Color originalColor, Color finalColor) {
		FillBucket fillBucket = FillBucket.Create(GetPixel(p.x, p.y), originalColor, finalColor);	
		fillBucket.draw();
	}

	public Pixel GetPixel(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
		{
			return GioPixel.NULL_PIXEL;
		}
		
		return _canvas[x][y];
	}

	@Override
	public String toString() {
		StringBuilder outout = new StringBuilder();
		for (int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++)
			{
				outout.append(GetPixel(x, y).getColor()).append(" - ");
			}			
			outout.append("\n");
		}
		return outout.toString();
	}
}
