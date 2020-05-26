package aplicacion;

import java.awt.Color;

public class Celula implements Elemento{
    protected final static char VIVA='v', MUERTA='m';
    protected AutomataCelular automata;
    private int fila,columna;
    protected char estadoActual,estadoSiguiente;
    protected Color color;
    protected int edad;

    public Celula(AutomataCelular ac,int fila, int columna){
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        estadoActual=' ';
        estadoSiguiente=VIVA;
        edad=0;
        automata.setElemento(fila,columna,(Elemento)this);  
        color=Color.black;
    }

    public final int getFila(){
        return fila;
    }

    public final int getColumna(){
        return columna;
    }

    public final Color getColor(){
        return color;
    }

    public final boolean isVivo(){
        return (estadoActual == VIVA) ;
    }

    public final int edad(){
        return (edad) ;
    }

    public void decida(){
        if (edad>=2){
            estadoSiguiente=MUERTA;
        }   
    }

    public final void cambie(){
        edad++;
        estadoActual=estadoSiguiente;
    }
}
