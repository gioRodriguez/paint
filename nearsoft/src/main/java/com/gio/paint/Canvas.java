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
		
		for(int x = 0; x < width; x++){
			for (int y = 0; y < height; y++) {
				_canvas[x][y] = new GioPixel(this, Color.white, new Point(x, y));
			}
		}
	}
	
	public static Canvas CreateWithSize(int high, int width) {		
		return new Canvas(width, high);
	}

	public void fillBucket(Point p, Color finalColor) {
		Color originalColor = GetPixel(p.x, p.y).getColor();
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
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Canvas)){
			return false;
		}
		if(obj == this){
			return true;
		}
		
		Canvas canvas = (Canvas)obj;
		return canvas._canvas.hashCode() == this._canvas.hashCode();
	}
	
	@Override
	public String toString() {
		StringBuilder outout = new StringBuilder();
		addXaxis(outout);
		
		for (int y = 0; y < height; y++) {
			outout.append(y).append(" ");
			for(int x = 0; x < width; x++)
			{
				outout.append(mapColorToLetter(GetPixel(x, y).getColor())).append(" - ");				
			}			
			outout.append("\n");
		}
		return outout.toString();
	}

	private void addXaxis(StringBuilder outout) {
		outout.append("  ");
		for (int x = 0; x < width; x++) {
			outout.append(x).append(" - ");
		}
		outout.append("\n");
	}
	
	private char mapColorToLetter(Color c){
		if(c == Color.RED){
			return 'r';
		}
		
		if(c == Color.BLACK){
			return 'b';
		}		
		
		if(c == Color.GREEN){
			return 'g';
		}
		
		return 'w';
	}
	
	int countPixelsByColor(Color color){
		int count = 0;
		for(int x = 0; x < width; x++){
			for (int y = 0; y < height; y++) {
				if(_canvas[x][y].getColor() == color){
					count++;
				}
			}
		}
		return count;
	}
	
	int totalPixels(){
		return width * height;
	}
}
