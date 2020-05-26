package aplicacion;

public class Energy extends Sorpresa{
	
	public Energy() {
		super();
	}
	
	@Override
	public void aplicarSorpresa(Personaje personaje1,Personaje personaje2,Pelota pelota) {
		personaje1.recuperarFortaleza();
	}
	
	@Override 
	public void contarTiempo() {
		
	}
}
