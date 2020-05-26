package aplicacion;

import java.awt.geom.Rectangle2D.Double;

public abstract class Personaje {
	protected String nombre;
	protected int x,y;
	protected Fortaleza fortaleza;
	protected int velocidad;
	
	public Personaje() {
		this.x=247;
		this.fortaleza=new Fortaleza();
		this.velocidad=15;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getFortaleza() {
		return this.fortaleza.getFortaleza();
	}
	
	public void moverDerecha() {
		if(this.x+velocidad<400) {
			this.x+=velocidad;
			this.fortaleza.reducir();;
		}
	}
	
	public void moverIzquirda() {
		if(this.x-velocidad>122) {
			this.x-=velocidad;
			this.fortaleza.reducir();
		}
	}
	
	public void recuperarFortaleza() {
		this.fortaleza.recuperar();
	}
	
	public void ralentizar() {
		this.velocidad=2;
	}
	
	public void desralentizar() {
		this.velocidad=15;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void perderFortaleza() {
		this.fortaleza.perder();
	}
	
	public void noPerderFortaleza() {
		
	}
	
	public abstract Double cuadradoPersonaje();
	
	public abstract boolean getJugador();
	
	public abstract void reiniciar();
}