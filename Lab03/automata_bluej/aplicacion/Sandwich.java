package aplicacion;
import java.awt.Color;


/**
 * Write a description of class AntiSocial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sandwich extends Celula{
    /**
     * Constructor for objects of class AntiSocial
     */
    public Sandwich(AutomataCelular ac,int fila,int columna){
        super(ac,fila,columna);
        estadoActual=' ';
        estadoSiguiente=VIVA;
        edad=0;
        automata.setElemento(fila,columna,(Elemento)this);  
        color=Color.orange;
    }

    @Override
    public void decida(){
        int f=this.getFila();
        int c=this.getColumna();
        if (c>= 1 && c<automata.getLongitud()){
            Elemento a=automata.getElemento(f,c-1);
            Elemento b=automata.getElemento(f,c+1);
            if (a!=null && b!= null && a.isVivo() && b.isVivo()){
                estadoSiguiente=MUERTA;
            }
        }
    }
}
