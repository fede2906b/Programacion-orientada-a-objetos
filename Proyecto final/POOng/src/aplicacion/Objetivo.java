package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Objetivo {
	//random between 122 and 440
	protected int x;
	protected int y;
	
	public Objetivo(int y) {
		this.x=(int) Math.floor(Math.random()*(441-122+1)+122);
		this.y=y;
	}
	
	public Double cuadradoObjetivo() {
		return new Rectangle2D.Double(this.x, this.y, 30, 30);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}