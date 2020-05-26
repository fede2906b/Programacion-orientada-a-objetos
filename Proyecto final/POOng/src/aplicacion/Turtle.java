package aplicacion;

public class Turtle extends Sorpresa{
	
	public Turtle() {
		super();
	}
	
	@Override
	public void aplicarSorpresa(Personaje personaje1,Personaje personaje2,Pelota pelota) {
		personaje2.ralentizar();
	}
	
	@Override 
	public void contarTiempo() {
		
	}
}
