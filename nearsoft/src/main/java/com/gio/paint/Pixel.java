package com.gio.paint;

import java.awt.Color;
import java.awt.Point;

public interface Pixel extends NullObject {

	Pixel GetUp();

	Pixel GetDown();

	Pixel GetLeft();

	Pixel GetRight();

	Color getColor();

	void setColor(Color _color);

	Point getPoint();

}