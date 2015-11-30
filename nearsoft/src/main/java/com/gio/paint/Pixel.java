package com.gio.paint;

import java.awt.Color;
import java.awt.Point;

public interface Pixel extends NullObject {

	Pixel GetNorth();

	Pixel GetSouth();

	Pixel GetWest();

	Pixel GetEast();

	Color getColor();

	void setColor(Color _color);

	Point getPoint();

}