    package aplicacion;
    import java.awt.Color;
    
    /**
     * Write a description of class Izquierdosa here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    public class Izquierdosa extends Celula{
    /**
     * Constructor for objects of class Izquierdosa
     */
    public Izquierdosa(AutomataCelular ac,int fila,int columna){
        super(ac,fila,columna);
        estadoActual=' ';
        estadoSiguiente=VIVA;
        edad=0;
        automata.setElemento(fila,columna,(Elemento)this);  
        color=Color.red;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
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
