/**
 * Write a description of class Hombre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hombre extends Ficha{
    /**
     * Constructor for objects of class Hombre
     */
    public Hombre(int fila,int columna,String equipo){
        super(fila,columna,equipo);
        this.ficha=new Circle(20,this.columna*40+10,this.fila*40+10,equipo);
    }
}