package aplicacion;
import java.awt.Color;

public class Conway extends Celula{

    public Conway(AutomataCelular ac,int fila,int columna){
        super(ac,fila,columna);
        estadoActual=VIVA;
        estadoSiguiente=VIVA;
        edad=0;
        automata.setElemento(fila,columna,(Elemento)this);  
        color=Color.blue;
    }
    
    public void decida(){
        int f=this.getFila();
        int c=this.getColumna();
        int cont=alRededor(f,c);
        if(this.isVivo()){
            if(cont==2 || cont==3){
                estadoSiguiente=VIVA;
            }else{
                estadoSiguiente=MUERTA;
            }
        }else{
            if(cont==3){
                estadoSiguiente=VIVA;
            }else if(cont==1 || cont>3){
                estadoSiguiente=MUERTA;
            }
        }
    }
    
    public int alRededor(int f,int c){
        int[][] posiciones={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int cont=0;
        for(int[] i:posiciones){
            if(f+i[0]>=0 && f+i[0]<automata.getLongitud() && c+i[1]>=0 && c+i[1]<automata.getLongitud()){
                Elemento e=automata.getElemento(f+i[0],c+i[1]);
                if(e!=null && e.isVivo()){
                    cont++;
                }
            }
        }
        return cont;
    }
}
