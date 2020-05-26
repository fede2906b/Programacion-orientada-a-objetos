/**
 * Write a description of class Checkers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Checkers{
    private static final int width=8;
    private Tablero configuracion;
    private Tablero juego;
    private boolean indicador;
    /**
     * Constructor for objects of class Checkers
     */
    public Checkers(){
        this.configuracion=new Tablero(0);
        this.juego=new Tablero(420);
        this.indicador=true;
    }
    
    public void makeVisible(){
        configuracion.makeVisible();
        juego.makeVisible();
    }
    
    public void makeInvisible(){
        configuracion.makeInvisible();
        juego.makeInvisible();
    }
    
    public void add(boolean white,boolean king,int row,int column){
        if(!configuracion.hayUnaFicha(row,column)){
            if(white){
                configuracion.add("white",king,row,column);
            }else{
                configuracion.add("black",king,row,column);
            }
        }else{
            System.out.println("Ya hay una ficha :(");
        }
    }
    
    public void add(boolean white,int[][] men){
        for(int[] ficha:men){
            if(!configuracion.hayUnaFicha(ficha[0],ficha[1])){
                if(white){
                    configuracion.add("white",false,ficha[0],ficha[1]);
                }else{
                    configuracion.add("black",false,ficha[0],ficha[1]);
                }
            }else{
                System.out.println("Ya hay una ficha :(");
            }
        }
    }
    
    public void remove(int row,int column){
        if(configuracion.hayUnaFicha(row,column)){
            configuracion.remove(row,column);
        }else{
            System.out.println("No hay una ficha :(");
        }
    }
    
    public void remove(int[][] pieces){
       for(int[] ficha:pieces){
           if(configuracion.hayUnaFicha(ficha[0],ficha[1])){
               configuracion.remove(ficha[0],ficha[1]);
           }else{
               System.out.println("No hay una ficha :(");
           }
       }
    }
    
    public void swap(){
        if(indicador){
            juego.swap(configuracion.getFichas(),420);
            indicador=false;
        }else{
            configuracion.swap(juego.getFichas(),-420);
            indicador=true;
        }
    }
    
    public void move(String notation){
        if(notation.contains("x")){
            int[] movimiento=notacionALista(notation,"x");
        }else if(notation.contains("-")){
            int[] movimiento=notacionALista(notation,"-");
            juego.movimientoSimple(movimiento);
        }
    }
    
    public void finish(){
        System.exit(0);
    }
    
    public int[] notacionALista(String notacion,String simbolo){
        String[] partes=notacion.split(simbolo);
        int[] movimiento=new int[partes.length];
        for(int i=0;i<partes.length;i++){
            movimiento[i]=Integer.parseInt(partes[i]);
        }
        return movimiento;
    }
}
