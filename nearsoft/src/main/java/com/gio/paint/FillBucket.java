package com.gio.paint;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

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

	/**
	 * Flood fill algorithm 
	 * https://en.wikipedia.org/wiki/Flood_fill
	 */
	public void draw() {
		Queue<Pixel> pixels = new LinkedList<Pixel>();
		if (p.isNull() || p.getColor() == finalColor) {
			return;
		}

		pixels.add(p);
		Pixel w;
		Pixel e;
		while (!pixels.isEmpty()) {
			w = pixels.peek();
			e = pixels.peek();
			pixels.poll();			
			while (!e.GetEast().isNull() && e.GetEast().getColor() == originalColor) {
				e = e.GetEast();
			}
			while (!w.GetWest().isNull() && w.GetWest().getColor() == originalColor) {
				w = w.GetWest();
			}			
			while (!w.equals(e)) {
				w.setColor(finalColor);
				if (!w.GetNorth().isNull() && w.GetNorth().getColor() == originalColor) {
					pixels.add(w.GetNorth());
				}
				if (!w.GetSouth().isNull() && w.GetSouth().getColor() == originalColor) {
					pixels.add(w.GetSouth());
				}
				w = w.GetEast();
			}
			if (w.equals(e)) {
				w.setColor(finalColor);
			}
		}
	}

}
