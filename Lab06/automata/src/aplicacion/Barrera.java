package aplicacion;
import java.awt.Color;

public class Barrera implements Elemento{
    protected final static char VIVA='v', MUERTA='m';
    protected AutomataCelular automata;
    private int fila,columna;
    protected static char estadoActual=MUERTA,estadoSiguiente=MUERTA;
    private static Color color=Color.black;
    
    public Barrera(AutomataCelular ac,int fila, int columna){
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        automata.setElemento(fila,columna,(Elemento)this); 
    }
    
    public int getForma(){
      return CUADRADA;
    }
    
    public final Color getColor(){
        return color;
    }
    
    public boolean isVivo(){
      return false;
    }
    
    public final int getFila(){
        return fila;
    }

    public final int getColumna(){
        return columna;
    }
}
