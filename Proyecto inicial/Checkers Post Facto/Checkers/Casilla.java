/**
 * Write a description of class Casilla here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Casilla{
    private int numero;
    private int fila;
    private int columna;
    private int posicion;
    private Rectangle casilla;
    /**
     * Constructor for objects of class Casilla
     */
    public Casilla(int numero,int fila,int columna,int posicion){
        this.numero=numero;
        this.fila=fila;
        this.columna=columna;
        this.posicion=posicion;
        this.casilla=new Rectangle(40,posicion+columna*40,fila*40,"black");
        if(this.numero!=0){
            this.casilla=new Rectangle(40,posicion+columna*40,fila*40,"gray");
        }else{
            this.casilla=new Rectangle(40,posicion+columna*40,fila*40,"white");
        }
    }
    
    public void makeVisible(){
        casilla.makeVisible();
    }
    
    public void makeInvisible(){
        casilla.makeInvisible();
    }
    
    public int[] getPosicion(){
        int[] posicion={fila,columna};
        return posicion;
    }
}
