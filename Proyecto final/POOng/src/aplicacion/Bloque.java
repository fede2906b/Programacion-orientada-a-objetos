package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Bloque {
	private int x;
	private int y;
	public Bloque(int y) {
		this.y=y;
		this.x=(int) Math.floor(Math.random()*(441-122+1)+122);
	}
	
	public Double cuadradoBloque() {
		return new Rectangle2D.Double(this.x, this.y+35, 70, 35);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
