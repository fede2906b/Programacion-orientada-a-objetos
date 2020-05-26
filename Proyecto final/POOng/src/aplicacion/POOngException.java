package aplicacion;

public class POOngException extends Exception{
	public static final String SIN_JUEGO="Empieza a jugar antes de guardar.";
	public static final String ERROR_ABRIR="No se puede abrir el juego, el archivo no es válido.";
	
	public POOngException(String message) {
		super(message);
	}
}
