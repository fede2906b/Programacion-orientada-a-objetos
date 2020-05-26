package aplicacion;
import java.awt.Color;

public class Virus implements Elemento{
  private static Color color=Color.black;
  protected final static char VIVA='v',MUERTA='m';
  protected char estadoActual,estadoSiguiente;
  private int fila,columna;
  protected int edad;
  protected AutomataCelular automata;
  
  public Virus(AutomataCelular ac,int fila, int columna){
      automata=ac;
      this.fila=fila;
      this.columna=columna;
      estadoActual=' ';
      estadoSiguiente=VIVA;
      edad=0;
      automata.setElemento(fila,columna,(Elemento)this);  
      color=Color.green;
  }
    
  public void decida(){
      int elementosEnLaFila=0;
      for(int i=0;i<automata.getLongitud();i++){
          Elemento e=automata.getElemento(fila,i);
          if(e!=null && e.isVivo() && i!=columna){
              elementosEnLaFila++;
          }
      }
      int elementosEnLaColumna=0;
      for(int i=0;i<automata.getLongitud();i++){
          Elemento e=automata.getElemento(i,columna);
          if(e!=null && e.isVivo() && i!=fila){
              elementosEnLaColumna++;
          }
      }
      if(elementosEnLaFila==0 && elementosEnLaColumna==0){
          estadoSiguiente=MUERTA;
      }else{
          estadoSiguiente=VIVA;
      }
  }
   
  public void cambie(){
      edad++;
      estadoActual=estadoSiguiente;
  }
  
  public int getForma(){
      return REDONDA;
  }
  
  public Color getColor(){
      return color;
  }
  
  public final boolean isVivo(){
      return (estadoActual == VIVA);
  }
}
