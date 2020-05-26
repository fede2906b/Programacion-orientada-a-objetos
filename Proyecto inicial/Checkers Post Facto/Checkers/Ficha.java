public abstract class Ficha{
    protected String equipo;
    protected int fila;
    protected int columna;
    protected Circle ficha;
    /**
     * Constructor for objects of class Ficha
     */
    public Ficha(int fila,int columna,String equipo){
        this.fila=fila;
        this.columna=columna;
        this.equipo=equipo;
    }
    
    public void remove(){
        ficha.makeInvisible();
    }
    
    public void moverHorizontal(int distancia){
        ficha.moveHorizontal(distancia);
    }
    
    public void move(int[] posicionNueva){
        int distanciaVertical;
        int distanciaHorizontal;
        distanciaVertical=(posicionNueva[0]-this.fila)*40;
        distanciaHorizontal=(posicionNueva[1]-this.columna)*40;
        ficha.moveVertical(distanciaVertical);
        ficha.moveHorizontal(distanciaHorizontal);
        this.fila=posicionNueva[0];
        this.columna=posicionNueva[1];
    }
}
