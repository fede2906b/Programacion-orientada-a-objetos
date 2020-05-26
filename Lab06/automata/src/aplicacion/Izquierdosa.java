package aplicacion;
import java.awt.Color;
    
public class Izquierdosa extends Celula{

    public Izquierdosa(AutomataCelular ac,int fila,int columna){
        super(ac,fila,columna);
        estadoActual=' ';
        estadoSiguiente=VIVA;
        edad=0;
        automata.setElemento(fila,columna,(Elemento)this);  
        color=Color.red;
    }

    @Override
    public void decida(){
        int f=this.getFila();
        int c=this.getColumna();
        if(c>=1){
            Elemento e=automata.getElemento(f,c-1);
            if(e!=null && e.isVivo()){
                estadoSiguiente=MUERTA;
            }
        }
    }
}
