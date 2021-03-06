package com.gio.paint;

import java.awt.Color;
import java.awt.Point;

public class GioPixel implements NullObject, Pixel {
	public static final Pixel NULL_PIXEL = new NullPixel();
	
	private Canvas _canvas;
	private Color _color;
	private Point _point;
	
	
	public GioPixel() {
		// TODO Auto-generated constructor stub
	}
	
	public GioPixel(Canvas _canvas, Color _color, Point _point) {
		super();
		this._canvas = _canvas;
		this._color = _color;
		this._point = _point;
	}

	/* (non-Javadoc)
	 * @see com.gio.paint.Pixcel#GetUp()
	 */
	@Override
	public Pixel GetNorth()
	{
		return _canvas.GetPixel(_point.x, _point.y - 1);
	}
	
	/* (non-Javadoc)
	 * @see com.gio.paint.Pixcel#GetDown()
	 */
	@Override
	public Pixel GetSouth()
	{
		return _canvas.GetPixel(_point.x, _point.y + 1);
	}
	
	/* (non-Javadoc)
	 * @see com.gio.paint.Pixcel#GetLeft()
	 */
	@Override
	public Pixel GetWest()
	{
		return _canvas.GetPixel(_point.x - 1, _point.y);
	}
	
	/* (non-Javadoc)
	 * @see com.gio.paint.Pixcel#GetRight()
	 */
	@Override
	public Pixel GetEast()
	{
		return _canvas.GetPixel(_point.x + 1, _point.y);
	}
	
	/* (non-Javadoc)
	 * @see com.gio.paint.Pixcel#getColor()
	 */
	@Override
	public Color getColor() {
		return _color;
	}
	/* (non-Javadoc)
	 * @see com.gio.paint.Pixcel#setColor(java.awt.Color)
	 */
	@Override
	public void setColor(Color _color) {
		this._color = _color;
	}
	/* (non-Javadoc)
	 * @see com.gio.paint.Pixcel#get_point()
	 */
	@Override
	public Point getPoint() {
		return _point;
	}

	public boolean isNull() {
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(!(obj instanceof GioPixel)){
			return false;
		}
		if(obj == this){
			return true;
		}
		
		GioPixel gioP = (GioPixel)obj;
		return gioP.getColor() == this.getColor() &&
				gioP.getPoint().equals(this.getPoint());
	}
	
	@Override
	public int hashCode() {
		return this.getPoint().hashCode() + this.getColor().hashCode();
	}
}
