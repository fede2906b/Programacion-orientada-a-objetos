import java.lang.Integer;
import java.util.HashMap;
/**
 * Write a description of class Tablero here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tablero{
    private int posicion;
    private Casilla[][] tablero;
    private Ficha[][] fichas;
    private HashMap<Integer,int[]> referencias;
    /**
     * Constructor for objects of class Tablero
     */
    public Tablero(int posicion){
        this.posicion=posicion;
        tablero=new Casilla[8][8];
        fichas=new Ficha[8][8];
        referencias=new HashMap<Integer,int[]>(); 
        int contador=1;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                fichas[i][j]=null;
                if(i!=j && ((i%2==0 && j%2!=0)||(i%2!=0 && j%2==0))){
                    tablero[i][j]=new Casilla(contador,i,j,this.posicion);
                    referencias.put(contador,new int[] {i,j});
                    contador++;
                }else{
                    tablero[i][j]=new Casilla(0,i,j,this.posicion);
                }
            }
        }
    }
    
    public void makeVisible(){
        for(Casilla[] fila:tablero){
            for(Casilla casilla:fila){
                casilla.makeVisible();
            }
        }
    }
    
    public void makeInvisible(){
        for(Casilla[] fila:tablero){
            for(Casilla casilla:fila){
                casilla.makeInvisible();
            }
        }
    }
    
    public void add(String equipo,boolean rey,int fila,int columna){
        if(rey){
            this.fichas[fila-1][columna-1]=new Rey(fila-1,columna-1,equipo);
        }else{
            this.fichas[fila-1][columna-1]=new Hombre(fila-1,columna-1,equipo);
        }
    }
    
    public boolean hayUnaFicha(int fila,int columna){
        return fichas[fila-1][columna-1]!=null;
    }
    
    public void remove(int fila,int columna){
        this.fichas[fila-1][columna-1].remove();
        this.fichas[fila-1][columna-1]=null;
    }
    
    public Ficha[][] getFichas(){
        return this.fichas;
    }
    
    public void borrarFichas(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(hayUnaFicha(i+1,j+1)){
                    this.remove(i+1,j+1);
                }   
            }
        }
    }
    
    public void swap(Ficha[][] fichas,int distancia){
        this.borrarFichas();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                this.fichas[i][j]=fichas[i][j];
                if(hayUnaFicha(i+1,j+1)){
                    this.fichas[i][j].moverHorizontal(distancia);
                } 
            }
        }
    }
    
    public void movimientoSimple(int[] movimientos){
        int[] posicionInicial=referencias.get(movimientos[0]);
        int fila=posicionInicial[0];int columna=posicionInicial[1];
        int[] posicionFinal=referencias.get(movimientos[1]);
        int filaNueva=posicionFinal[0];int columnaNueva=posicionFinal[1];
        if(!hayUnaFicha(filaNueva+1,columnaNueva+1)){
            if(hayUnaFicha(fila+1,columna+1)){
                this.fichas[filaNueva][columnaNueva]=this.fichas[fila][columna];
                this.fichas[fila][columna]=null;
                this.fichas[filaNueva][columnaNueva].move(posicionFinal);
            }else{
                System.out.println("No hay una ficha para mover :(");
            }
        }else{
            System.out.println("Hay una ficha ahí :(");
        }
    }
}
