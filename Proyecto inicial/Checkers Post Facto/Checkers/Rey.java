
/**
 * Write a description of class Rey here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rey extends Ficha{
    /**
     * Constructor for objects of class Rey
     */
    public Rey(int fila,int columna,String equipo){
        super(fila,columna,equipo);
        this.ficha=new Circle(40,this.columna*40,this.fila*40,equipo);
    }
}
