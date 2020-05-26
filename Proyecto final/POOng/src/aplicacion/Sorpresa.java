package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public abstract class Sorpresa {
	private int x,y;
	public Sorpresa() {
		this.x=(int) Math.floor(Math.random()*(441-122+1)+122);
		this.y=308;
	}
	
	public Double cuadradoSorpresa() {
		return new Rectangle2D.Double(this.x, this.y, 30, 30);
	}
	
	public int getX() {
		return this.x; 
	}
	
	public int getY() {
		return this.y;
	}
	
	public abstract void aplicarSorpresa(Personaje personaje1,Personaje personaje2,Pelota pelota);
	
	public abstract void contarTiempo();
}
