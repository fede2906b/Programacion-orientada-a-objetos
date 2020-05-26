package aplicacion;
import java.io.File;
import java.util.*;

public class AutomataCelular{
    static private int LONGITUD=20;
    private Elemento[][] automata;
    
    public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
    }

    public int  getLongitud(){
        return LONGITUD;
    }

    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }

    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }

    public void algunosElementos(){
        //Ciclo 1
        Celula indiana=new Celula(this,1,1);
        Celula c007=new Celula(this,2,2);
        //Ciclo 2
        Celula marx=new Izquierdosa(this,3,6);
        Celula hegel=new Izquierdosa(this,3,5);
        //Ciclo 3
        Barrera suroeste=new Barrera(this,19,0);
        Barrera noreste=new Barrera(this,0,19);
        //Ciclo 4: Casos significativos para sandwich
        Sandwich cristian=new Sandwich(this,7,5);
        Sandwich federico=new Sandwich(this,10,5);
        Barrera c1=new Barrera(this,7,4);
        Barrera c2=new Barrera(this,7,6);
        Celula c3=new Celula(this,10,4);
        Celula c4=new Celula(this,10,6);
        //Ciclo 5: Casos significativos para Virus
        Virus virus1=new Virus(this,18,0);
        Virus virus2=new Virus(this,1,2);
        //Juego de la vida
        Celula john=new Conway(this,5,10);
        Celula horton=new Conway(this,5,11);
        //Bloque
        Celula a=new Conway(this,19,0);
        Celula b=new Conway(this,19,1);
        Celula c=new Conway(this,18,0);
        Celula d=new Conway(this,18,1);
        //Parpadeador
        Celula izquierda=new Conway(this,15,8);
        Celula centro=new Conway(this,15,9);
        Celula derecha=new Conway(this,15,10);
    }
    
    public void ticTac(){
        for(int i=0; i<LONGITUD;i++){
            for(int j=0;j<LONGITUD;j++){
                if(automata[i][j]!=null){
                    automata[i][j].decida();
                }
            }
        }
        ArrayList<int[]> paraAgregar=cambios();
        //paraAgregar=
        for(int i=0; i<LONGITUD;i++){
            for(int j=0;j<LONGITUD;j++){
                if(automata[i][j]!=null){
                    automata[i][j].cambie();
                }
            }
        }
        
        for(int[] i:paraAgregar){
            this.setElemento(i[0],i[1],new Conway(this,i[0],i[1]));
        }
    }
    
    public ArrayList<int[]> cambios(){
        ArrayList<int[]> paraAgregar=new ArrayList<int[]>();
        for(int i=0; i<LONGITUD;i++){
            for(int j=0;j<LONGITUD;j++){
                int cont=alRededor(i,j);
                if(cont==3){
                    int[] p={i,j};
                    //if(this.getElemento(i,j) instanceof Conway){
                        paraAgregar.add(p);
                    //}
                }
            }
        }
        return paraAgregar;
    }
    
    public int alRededor(int f,int c){
        int[][] posiciones={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int cont=0;
        for(int[] i:posiciones){
            if(f+i[0]>=0 && f+i[0]<this.getLongitud() && c+i[1]>=0 && c+i[1]<this.getLongitud()){
                Elemento e=this.getElemento(f+i[0],c+i[1]);
                if(e!=null && e.isVivo()){
                    cont++;
                }
            }
        }
        return cont;
    }
    
    public void setCelula(int f,int c,Celula nueva){
        automata[f][c]=nueva;
    }
    
    public void salve(/*File archivo*/) throws AutomataException {
    	throw new AutomataException(AutomataException.SALVAR);
    }
    
    public void abra(/*File archivo*/) throws AutomataException {
    	throw new AutomataException(AutomataException.ABRIR);
    }
    
    public void exporte() throws AutomataException {
    	throw new AutomataException(AutomataException.EXPORTAR);
    }
    
    public void importe() throws AutomataException {
    	throw new AutomataException(AutomataException.IMPORTAR);
    }
}