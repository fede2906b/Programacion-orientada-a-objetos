package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Personaje1 extends Personaje{
	public Personaje1(String nombre) {
		this.nombre=nombre;
		this.y=60;
	}
	
	@Override
	public boolean getJugador() {
		return true;
	}
	
	@Override
	public Double cuadradoPersonaje() {
		return new Rectangle2D.Double(this.x, this.y, 70, 50);
	}
	
	@Override
	public void reiniciar() {
		this.x=247;
		this.y=60;
	}
}
