package aplicacion;
import java.awt.Color;

/**
 * Write a description of class Barrera here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Barrera implements Elemento{
    protected final static char VIVA='v', MUERTA='m';
    protected AutomataCelular automata;
    private int fila,columna;
    protected static char estadoActual=MUERTA,estadoSiguiente=MUERTA;
    private static Color color=Color.black;
    /**
     * Constructor for objects of class Barrera
     */
    public Barrera(AutomataCelular ac,int fila, int columna){
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        automata.setElemento(fila,columna,(Elemento)this);
        
    }
    
    public int getForma(){
      return CUADRADA;
    }
    
    /**Retorna el color de  la célula
    @return 
     */
    public final Color getColor(){
        return color;
    }
    
    public boolean isVivo(){
      return false;
    }
}
