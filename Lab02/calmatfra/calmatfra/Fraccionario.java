import java.lang.Math; 
/**
 * Fraccionario
 * Esta clase implementa el tipo de dato Fraccionario; es decir, un n�mero racional que se pueden escribir de la forma p/q, donde p y q son enteros, con q <> 0
 * La implemantacion se hace mediante objetos inmutables
 * INV: El fraccionario se encuentra representado en forma irreductible.
 * @author E.C.I.
 *
 */

public class Fraccionario {
    private int[] fraccionario = new int[2];
    private int mcd;
    private String fraccionEnCadena;
    /**Calcula el maximo comun divisor de dos enteros
     * @param a primer entero
     * @param b segundo entero
     * @return el Maximo Comun Divisor de a y b
     */
    public static int mcd(int a,int b){
        if(b==0){
            return Math.abs(a);
        }else{
            return Math.abs(mcd(b,a%b));
        }
    }    
    
    /**Crea un nuevo fraccionario, dado el numerador y el denominador
     * @param numerador
     * @param denominador. denominador <> 0
     */
    public Fraccionario (int numerador, int denominador) {
        this.mcd = mcd(numerador,denominador);
        if(numerador==0 && denominador != 0){
            this.fraccionario[0] = 0;
            this.fraccionario[1] = 1;
        }else if(numerador/mcd <= 0 && denominador/mcd<0){
            this.fraccionario[0] = (numerador/mcd)*-1;
            this.fraccionario[1] = (denominador/mcd)*-1;
        }else if(numerador/mcd<0 && denominador/mcd>0){
            this.fraccionario[0] = numerador/mcd;
            this.fraccionario[1] = denominador/mcd;
        }else if(numerador/mcd>0 && denominador/mcd<0){
            this.fraccionario[0] = (numerador/mcd)*-1;
            this.fraccionario[1] = (denominador/mcd)*-1;
        }else{
            this.fraccionario[0] = numerador/mcd;
            this.fraccionario[1] = denominador/mcd;
        }
    }
    
    /**Crea un fraccionario correspondiente a un entero
     * @param entero el entero a crear
     */
    public Fraccionario(int entero) {
        this.fraccionario[0]=entero;
        this.fraccionario[1]=1;
    }

    /**Crea un fraccionario, a partir de su representacion mixta. 
     * El numero creado es enteroMixto + numeradorMixto/denominadorMixto
     * @param enteroMixto la parte entera del numero
     * @param numeradorMixto el numerador de la parte fraccionaria
     * @param denominadorMixto el denominador de la parte fraccionaria. denominadorMixto<>0
     */
    public Fraccionario (int enteroMixto, int numeradorMixto, int denominadorMixto) {
        if(numeradorMixto==0 && denominadorMixto != 0){
            this.fraccionario[0]=enteroMixto;
            this.fraccionario[1]=1;
        }
        else if (numeradorMixto<0 && denominadorMixto <0){
            numeradorMixto *= -1;
            denominadorMixto *= -1;
            numeradorMixto += enteroMixto*denominadorMixto;
            this.mcd = mcd(numeradorMixto,denominadorMixto);
            this.fraccionario[0] = numeradorMixto/mcd;
            this.fraccionario[1] = denominadorMixto/mcd;
        }
        else if (numeradorMixto<0 || denominadorMixto<0){
            numeradorMixto = Math.abs(numeradorMixto);
            denominadorMixto = Math.abs(denominadorMixto);
            numeradorMixto += enteroMixto*denominadorMixto;
            this.mcd = mcd(numeradorMixto,denominadorMixto);
            this.fraccionario[0] = numeradorMixto/mcd * -1;
            this.fraccionario[1] = denominadorMixto/mcd;
        }else{
            numeradorMixto += enteroMixto*denominadorMixto;
            this.mcd = mcd(numeradorMixto,denominadorMixto);
            this.fraccionario[0] = numeradorMixto/mcd;
            this.fraccionario[1] = denominadorMixto/mcd;
        }
    }

    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return El numerador simplificado del fraccionario
     */
    public int numerador() {
        this.mcd = mcd(this.fraccionario[0],this.fraccionario[1]);
        return this.fraccionario[0]/mcd;
    }
    
    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero Positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return el denominador simplificado del fraccionario
     */
    public int denominador() {
        this.mcd = mcd(this.fraccionario[0],this.fraccionario[1]);
        return this.fraccionario[1]/mcd;
    }
    
    /**Suma este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario sume (Fraccionario otro) {
        Fraccionario nuevo = new Fraccionario(1);
        if(this.denominador() == otro.denominador()){
            nuevo.fraccionario[0]=this.numerador()+otro.numerador();
            nuevo.fraccionario[1]=this.denominador();
            nuevo.mcd = mcd(nuevo.fraccionario[0],nuevo.fraccionario[1]);
            nuevo.fraccionario[0]=nuevo.fraccionario[0]/nuevo.mcd;
            nuevo.fraccionario[1]=nuevo.fraccionario[1]/nuevo.mcd;
        }else{
            nuevo.fraccionario[0]=(this.numerador()*otro.denominador())+(this.denominador()*otro.numerador());
            nuevo.fraccionario[1]=this.denominador()*otro.denominador();
            nuevo.mcd = mcd(nuevo.fraccionario[0],nuevo.fraccionario[1]);
            nuevo.fraccionario[0]=nuevo.fraccionario[0]/nuevo.mcd;
            nuevo.fraccionario[1]=nuevo.fraccionario[1]/nuevo.mcd;
        }
        return nuevo;
    }
    
    /**Resta este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este-otro
     */
    public Fraccionario reste(Fraccionario otro) {
        Fraccionario nuevo = new Fraccionario(1);
        if(this.denominador() == otro.denominador()){
            nuevo.fraccionario[0]=this.numerador()-otro.numerador();
            nuevo.fraccionario[1]=this.denominador();
            nuevo.mcd = mcd(nuevo.fraccionario[0],nuevo.fraccionario[1]);
            nuevo.fraccionario[0]=nuevo.fraccionario[0]/nuevo.mcd;
            nuevo.fraccionario[1]=nuevo.fraccionario[1]/nuevo.mcd;
        }else{
            nuevo.fraccionario[0]=(this.numerador()*otro.denominador())-(this.denominador()*otro.numerador());
            nuevo.fraccionario[1]=this.denominador()*otro.denominador();
            nuevo.mcd = mcd(nuevo.fraccionario[0],nuevo.fraccionario[1]);
            nuevo.fraccionario[0]=nuevo.fraccionario[0]/nuevo.mcd;
            nuevo.fraccionario[1]=nuevo.fraccionario[1]/nuevo.mcd;
        }
        return nuevo;
    }
    
    /**Multiplica este fraccionario con otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario multiplique (Fraccionario otro) {
        Fraccionario nuevo = new Fraccionario(1);
        nuevo.fraccionario[0] = otro.numerador()*this.numerador();
        nuevo.fraccionario[1] = otro.denominador()*this.denominador();
        nuevo.mcd = mcd(nuevo.fraccionario[0],nuevo.fraccionario[1]);
        nuevo.fraccionario[0]=nuevo.fraccionario[0]/nuevo.mcd;
        nuevo.fraccionario[1]=nuevo.fraccionario[1]/nuevo.mcd;
        return nuevo;
    }
    
    
    /**Divide este fraccionario sobre otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario divida (Fraccionario otro) {
        Fraccionario nuevo = new Fraccionario(1);
        nuevo.fraccionario[0] = this.numerador()*otro.denominador();
        nuevo.fraccionario[1] = this.denominador()*otro.numerador();
        nuevo.mcd = mcd(nuevo.fraccionario[0],nuevo.fraccionario[1]);
        nuevo.fraccionario[0]=nuevo.fraccionario[0]/nuevo.mcd;
        nuevo.fraccionario[1]=nuevo.fraccionario[1]/nuevo.mcd;
        return nuevo;
    }
    
    /**Compara este fraccionario con otro objeto
     * @param otro el otro objeto
     * @return true si este fraccionario es igual matem�ticamente al otro objeto, False d.l.c.
     */
    @Override
    public boolean equals(Object obj) {
        return equals((Fraccionario)obj);
    }    
    
    /**Compara este fraccionario con otro fraccionario
     * @param otro eL otro fraccionario
     * @return true si este fraccionario es igual matem�ticamente al otro fraccionario, False d.l.c.
     */
    public boolean equals (Fraccionario otro) {
        boolean sonIguales=true;
        if(this.fraccionario[0]==otro.fraccionario[0] && this.fraccionario[1]==otro.fraccionario[1]){
            sonIguales=true;
        }else{
            sonIguales=false;
        }
        return sonIguales;
    }


    /** Calcula la representacion en cadena de un fraccionario en formato mixto simplificado
     * @see java.lang.Object#toString(java.lang.Object)
     */
    @Override
    public String toString() {
        this.fraccionEnCadena = "";
        this.fraccionEnCadena += this.fraccionario[0];
        this.fraccionEnCadena += "/";
        this.fraccionEnCadena += this.fraccionario[1];
        return this.fraccionEnCadena;
    }
    
    /**
     * Calcula el fraccionario resultante de multiplicar numerador y denominador por el mcd
     * @return fraccionario amplificado
     */
    public Fraccionario amplificar(){
        this.fraccionario[0] *= this.mcd;
        this.fraccionario[1] *= this.mcd;
        return this;
    }
}