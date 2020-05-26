package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public abstract class Pelota {
	protected int velocidad;
	protected int x;
	protected int y;
	protected int dx;
	protected int dy;
	protected boolean saleArriba;
	protected boolean saleAbajo;
	protected boolean objetivoSuperior;
	protected boolean objetivoInferior;
	protected boolean sorpresa;
	protected boolean ultimoJugador;
	
	public Pelota() {
		this.x=247;
		this.y=500;
		this.saleArriba=false;
		this.saleAbajo=false;
		this.objetivoInferior=false;
		this.objetivoSuperior=false;
		this.sorpresa=false;
	}
	
	public abstract void mover(boolean colision1,boolean colision2,boolean colisionSuperior,boolean colisionInferior, boolean colisionSorpresa);
		
	public boolean getSalioAbajo() {
		return this.saleAbajo;
	}
	
	public boolean getSalioArriba() {
		return this.saleArriba;
	}
	
	public boolean getTomoObjetivo1() {
		return this.objetivoSuperior;
	}
	
	public boolean getTomoObjetivo2() {
		return this.objetivoInferior;
	}
	
	public boolean getTomoSorpresa() {
		return this.sorpresa;
	}
	
	public boolean getUltimoJugador() {
		return this.ultimoJugador;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Double cuadradoPelota() {
		return new Rectangle2D.Double(this.x, this.y, 20, 20);
	}
	
	public void nuevaPelota() {
		this.x=247;
		this.y=533;
		this.saleArriba=false;
		this.saleAbajo=false;
		this.objetivoSuperior=false;
		this.objetivoInferior=false;
		this.sorpresa=false;
	}
}
