package com.gio.paint;

import java.awt.Color;
import java.awt.Point;

public class NullPixel implements Pixel {

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public Pixel GetNorth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixel GetSouth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixel GetWest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixel GetEast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor(Color _color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getPoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
