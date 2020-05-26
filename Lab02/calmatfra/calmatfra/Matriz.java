/**
 * Matriz
 * Esta clase implementa el tipo de objeto Matriz que es una matriz cuyos elementos son objetos de la clase fraccionario
 */
public class Matriz{
    private Fraccionario [][] matriz;
    /**
     * Dice si una matriz es o no matriz
     * @param una matriz cuyos elementos son fraccionarios representados como {numerador, denominador}
     * @return true si la matriz es matriz, false e.o.c
    */
    public static boolean esMatriz (int [][][] elementos){
        Matriz temporal = new Matriz(elementos);
        if(temporal.matriz.length==0 || temporal.matriz[0].length==0){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * Crea una matriz dados sus elementos. Los fraccionarios se representan como {numerador, denominador}
     * @param una matriz cuyos elementos son fraccionarios representados como {numerador, denominador}
     */
    public Matriz(int[][][] elementos) {
        this.matriz = new Fraccionario[elementos.length][elementos[0].length];
        for(int i=0;i<elementos.length;i++){
            for(int j=0;j<elementos[0].length;j++){
                this.matriz[i][j] = new Fraccionario(elementos[i][j][0],elementos[i][j][1]);
            }
        }
    }    
    
    /**
     * Crea una matriz dados sus elementos.
     * @param una matriz con fraccionarios, que serán los elementos de la matriz
     */
    public Matriz(Fraccionario[][] elementos) {
        this.matriz = elementos;
    }
    
     /**
     * Crea una matriz dada su diagonal.
     * @param un arreglo de fraccionarios, cuyos elementos serán la diagonal de la matriz
     */    
    public Matriz (Fraccionario[] d){
        this.matriz = new Fraccionario[d.length][d.length];
        for(int i=0;i<d.length;i++){
            for(int j=0;j<d.length;j++){
                if(i==j){
                    this.matriz[i][j]=d[i];
                }else{
                    this.matriz[i][j] = new Fraccionario(0);
                }
            }
        }
    }    

    /**
     * Crea una matriz de un numero repetido dada su dimension. 
     * @param Un objeto de tipo fraccionario
     * @param El número de filas de la matriz
     * @param El número de columnas de la matriz
     */
    public Matriz (Fraccionario e, int f, int c) {
        this.matriz = new Fraccionario[f][c];
        for(int i=0;i<f;i++){
            for(int j=0;j<c;j++){
                this.matriz[i][j]=e;
            }
        }
    }
    
    /**
     * Crea una matriz identidad dada su dimension. 
     * @param dimensión de la matriz
     */
    public Matriz (int n) {
        this.matriz = new Fraccionario[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    this.matriz[i][j]=new Fraccionario(1);
                }else{
                    this.matriz[i][j] = new Fraccionario(0);
                }
            }
        }
    }
    
    /**
     * Retorna la dimensión de la matriz representada como una matriz
     * @return una matriz que indica cual es la dimensión de esta matriz
     */
    public Matriz dimension(){
        Fraccionario[] filasColumnas=new Fraccionario[1];
        filasColumnas[0]=new Fraccionario(this.matriz.length,this.matriz[0].length);
        filasColumnas[0]=filasColumnas[0].amplificar();
        Matriz dimension = new Matriz(filasColumnas);
        System.out.println(dimension.toString());
        return dimension;  
    }
    
    /**
     * Retorna el fraccionario en la posición [f][c] de esta matriz
     * @param El número de filas de la matriz
     * @param El número de columnas de la matriz
     * @return Onjeto de tipo fraccionario en la posición[f][c]
     */
    public Fraccionario get(int f, int c){
        return matriz[f][c];
    }
   
    /**
     * Compara esta matriz con otra
     * @param otra matriz
     * @return Un boolean que indica si esta matriz es igual a otra
     */
    public boolean equals (Matriz otra) {
        boolean esIgual=true;
        if(this.matriz.length==otra.matriz.length && this.matriz[0].length==otra.matriz[0].length){
           for(int i=0;i<this.matriz.length;i++){
               if(esIgual==true){ 
                   for(int j=0;j<this.matriz[0].length;j++){
                        if(this.matriz[i][j].numerador()==otra.matriz[i][j].numerador()
                        && this.matriz[i][j].denominador()==otra.matriz[i][j].denominador()){
                            esIgual=true;
                        }else{
                            esIgual=false;
                            break;
                        }
                   }
               }else{
                   break;
               }
           }
        }else{
            esIgual=false;
        }
        return esIgual;
    }

    /** 
     * Compara esta matriz con otro objeto
     * @param otro objeto
     * @return Un boolean que indica si esta matriz es igual al otro objeto
     */
    @Override
    public boolean equals(Object otra) {
        boolean esIgual=true;
        if(otra instanceof Matriz == false){
            esIgual=false;
        }else{
            esIgual=this.equals((Matriz) otra);
        }
        return esIgual;
    }
    
    /** 
     * Retorna una cadena con los datos de la matriz alineado a derecha por columna
     * @return La representación en cadena de esta matriz
    */
    @Override
    public String toString () {
        String s = "[";
        for (int i=0;i<this.matriz.length;i++){
            s+="[";
            for (int j=0;j<this.matriz.length;j++){
                  if(j==this.matriz.length-1){
                      s+=this.matriz[i][j].toString()+"";
                  }else{
                      s+=this.matriz[i][j].toString()+", ";
                  }
            }
            s+="]";
        }
        s+="]";
        return s;
    }   
    
    /**
     * Suma una matriz con otra matriz y retorna el resultado en una matriz nueva
     * @param otra matriz llamada m
     * @return Una matriz nueva con el resultado de la suma punto a punto de ambas matrices
     */
    public Matriz sume(Matriz m){
        Matriz temporal = new Matriz(new Fraccionario(0),this.matriz.length,this.matriz[0].length);
        if (this.matriz.length==m.matriz.length && this.matriz[0].length==m.matriz[0].length){
            for (int i=0;i<this.matriz.length;i++){
                for (int j=0;j<this.matriz[0].length;j++){
                    temporal.matriz[i][j]=this.matriz[i][j].sume(m.matriz[i][j]);
                }
            }
            System.out.println(temporal.toString());
            return temporal;
        }else{
            System.out.println("Las matrices no son de mismo tamaño, intente de nuevo");
            return null;
        }
    }
    
    /**
     * Resta una matriz con otra matriz y retorna el resultado en una matriz nueva
     * @param otra matriz llamada m
     * @return Una matriz nueva con el resultado de la resta punto a punto de ambas matrices
     */
    public Matriz reste(Matriz m){
        Matriz temporal = new Matriz(new Fraccionario(0),this.matriz.length,this.matriz[0].length);
        if (this.matriz.length==m.matriz.length && this.matriz[0].length==m.matriz[0].length){
            for (int i=0;i<this.matriz.length;i++){
                for (int j=0;j<this.matriz[0].length;j++){
                    temporal.matriz[i][j]=this.matriz[i][j].reste(m.matriz[i][j]);
                }
            }
            System.out.println(temporal.toString());
            return temporal;
        }else{
            System.out.println("Las matrices no son de mismo tamaño, intente de nuevo");
            return null;
        }
    }
    
    /**
     * Multiplica una matriz con otra matriz y retorna el resultado en una matriz nueva
     * @param otra matriz llamada m
     * @return Una matriz nueva con el resultado de la multiplicación punto a punto de ambas matrices
     */
    public Matriz multipliqueElementos(Matriz m){
        Matriz temporal = new Matriz(new Fraccionario(0),this.matriz.length,this.matriz[0].length);
        if (this.matriz.length==m.matriz.length && this.matriz[0].length==m.matriz[0].length){
            for (int i=0;i<this.matriz.length;i++){
                for (int j=0;j<this.matriz[0].length;j++){
                    temporal.matriz[i][j]=this.matriz[i][j].multiplique(m.matriz[i][j]);
                }
            }
            System.out.println(temporal.toString());
            return temporal;
        }else{
            System.out.println("Las matrices no son de mismo tamaño, intente de nuevo");
            return null;
        }
    }
    
    /**
     * Divide una matriz entre otra matriz y retorna el resultado en una matriz nueva
     * @param otra matriz llamada m
     * @return Una matriz nueva con el resultado de la división punto a punto de ambas matrices
     */
    public Matriz divida(Matriz m){
        Matriz temporal = new Matriz(new Fraccionario(0),this.matriz.length,this.matriz[0].length);
        if (this.matriz.length==m.matriz.length && this.matriz[0].length==m.matriz[0].length){
            for (int i=0;i<this.matriz.length;i++){
                for (int j=0;j<this.matriz[0].length;j++){
                    temporal.matriz[i][j]=this.matriz[i][j].divida(m.matriz[i][j]);
                }
            }
            System.out.println(temporal.toString());
            return temporal;
        }else{
            System.out.println("Las matrices no son de mismo tamaño, intente de nuevo");
            return null;
        }
    }
    
    /**
     *Realiza el producto matricial de una matriz con otra matriz y retorna el resultado en una matriz nueva
     * @param otra matriz llamada m
     * @return Una matriz nueva con el resultado del producto matricial de ambas matrices
     */
    public Matriz multipliqueMatrices(Matriz m){
        if(this.matriz[0].length==m.matriz.length){
            Matriz temporal = new Matriz(new Fraccionario(0),this.matriz.length,m.matriz[0].length);
            for(int i=0;i<this.matriz.length;i++){
                for(int j=0;j<m.matriz[0].length;j++){
                    for(int k=0;k<this.matriz[0].length;k++){
                        temporal.matriz[i][j]=temporal.matriz[i][j].sume(this.matriz[i][k].multiplique(m.matriz[k][j]));
                    }
                }
            }
            System.out.println(temporal.toString());
            return temporal;
        }else{
            System.out.println("Las matrices no son de tamaño compatible, intente de nuevo");
            return null;
        }
    }
    
    /**
     * Transpone esta matriz
     * @return una matriz nueva que es el resultado de transponer la matriz dada
     */
    public Matriz transponer(){
        Matriz temporal = new Matriz(new Fraccionario(0),this.matriz[0].length,this.matriz.length);
        System.out.println(this.dimension());
        System.out.println(temporal.dimension());
        for(int i=0;i<this.matriz.length;i++){
            for(int j=0;j<this.matriz[0].length;j++){
                temporal.matriz[j][i] = this.matriz[i][j]; 
            }
        }
        System.out.println(temporal.toString());
        return temporal;
    }
}
