package com.gio.paint;

import java.awt.Color;
import java.awt.Point;

public class NullPixel implements Pixel {

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public Pixel GetUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixel GetDown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixel GetLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pixel GetRight() {
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
	public Point get_point() {
		// TODO Auto-generated method stub
		return null;
	}

}
