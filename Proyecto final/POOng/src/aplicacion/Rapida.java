package aplicacion;

public class Rapida extends Pelota{
	public Rapida() {
		super();
		this.velocidad=20;
		this.dx=velocidad;
		this.dy=velocidad;
	}
	
	@Override
	public void mover(boolean colision1,boolean colision2,boolean colisionSuperior,boolean colisionInferior, boolean colisionSorpresa) {
		if(colision1) {
			dy = velocidad;
			this.ultimoJugador=true;
		}
		if(colision2) {
			dy = -velocidad;
			this.ultimoJugador=false;
		}
		if (x + dx < 122)
			dx = velocidad;
		if (x + dx > 450)
			dx = -velocidad;
		if (y + dy < 74)
			saleArriba=true;
		if (y + dy > 583)
			saleAbajo=true;
		if(colisionSuperior)
			objetivoSuperior=true;
		if(colisionInferior)
			objetivoInferior=true;
		if(colisionSorpresa)
			sorpresa=true;
		x = x + dx;
		y = y + dy;
	}
}
