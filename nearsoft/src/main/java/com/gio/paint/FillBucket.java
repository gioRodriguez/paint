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
			while (!w.GetRight().isNull() && w.GetRight().getColor() == originalColor) {
				w = w.GetRight();
			}
			while (!e.GetLeft().isNull() && e.GetLeft().getColor() == originalColor) {
				e = e.GetLeft();
			}
			while (!e.equals(w)) {
				e.setColor(finalColor);
				if (!e.GetUp().isNull() && e.GetUp().getColor() == originalColor) {
					pixels.add(e.GetUp());
				}
				if (!e.GetDown().isNull() && e.GetDown().getColor() == originalColor) {
					pixels.add(e.GetDown());
				}
				e = e.GetRight();
			}
			if (e.equals(w)) {
				e.setColor(finalColor);
			}
		}
	}

}
