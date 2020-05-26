package aplicacion;

public class Parcial extends Sorpresa{
	public Parcial() {
		super();
	}
	
	@Override
	public void aplicarSorpresa(Personaje personaje1,Personaje personaje2,Pelota pelota) {
		personaje1.noPerderFortaleza();
	}
	
	@Override 
	public void contarTiempo() {
		
	}
}
