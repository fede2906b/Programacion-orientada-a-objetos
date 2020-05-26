package aplicacion;

public class AutomataException extends Exception{
	public static final String SALVAR = "Opcion salvar en construccion";
	public static final String ABRIR = "Opcion abrir en construccion";
	public static final String EXPORTAR = "Opcion exportar en construccion";
	public static final String IMPORTAR = "Opcion importar en construccion";
	
	public AutomataException(String message) {
		super(message);
	}
}
