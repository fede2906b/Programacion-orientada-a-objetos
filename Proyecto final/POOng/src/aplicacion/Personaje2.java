package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Personaje2 extends Personaje{
	public Personaje2(String nombre) {
		this.nombre=nombre;
		this.y=533;
	}
	
	@Override
	public boolean getJugador() {
		return false;
	}
	
	@Override
	public Double cuadradoPersonaje() {
		return new Rectangle2D.Double(this.x, this.y+35, 70, 35);
	}
	
	@Override
	public void reiniciar() {
		this.x=247;
		this.y=533;
	}
}
