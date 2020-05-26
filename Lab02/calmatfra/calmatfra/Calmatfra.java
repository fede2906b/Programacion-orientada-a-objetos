import java.util.HashMap;
/** Calculadora.java
 * Representa una calculadora de matrices de fraccionarios
 * @author ESCUELA 2018-01
 */
public class Calmatfra{
    private HashMap<String, Matriz> variables;
    private boolean seHizoBien=true;
    //Consultar en el API Java la clase HashMap
    /**
     * Crea una calculadora de matrices de fraccionarios
     */
    public Calmatfra(){
        this.variables = new HashMap<String,Matriz>();
    }

    /**
     * Agrega al mapa una matriz cuya llave es variable
     * @param el nombre de la variable
     * @param una matriz de fraccionarios
     */
    public void asigne(String variable, int [][][] matriz){
        if(this.variables.containsKey(variable)){
            System.out.println("Ya existe una matriz con el mismo nombre, intente de nuevo");
            this.seHizoBien=false;
        }else{
            this.variables.put(variable,new Matriz(matriz));
            this.seHizoBien=true;
        }
    }

    // Los operadores binarios : + (suma), - (resta), . (multiplique elemento a elemento), * (multiplique matricial)
    /**
     * Realiza las operaciones básicas sobre las ,atrices en el mapa
     * @param el nombre de la variable con que se guardará el resultado
     * @param Llave de una de las matrices a operar
     * @param La operación que se quiere realizar
     * @param Llave de la otra matriz a operar
     */
    public void opere(String respuesta, String operando1, char operacion, String operando2){
        if(operacion=='+'){
            Matriz resultado = this.variables.get(operando1).sume(this.variables.get(operando2));
            this.variables.put(respuesta,resultado);
            this.seHizoBien=true;
        }else if(operacion=='-'){
            Matriz resultado = this.variables.get(operando1).reste(this.variables.get(operando2));
            this.variables.put(respuesta,resultado);
            this.seHizoBien=true;
        }else if(operacion=='.'){
            Matriz resultado = this.variables.get(operando1).multipliqueElementos(this.variables.get(operando2));
            this.variables.put(respuesta,resultado);
            this.seHizoBien=true;
        }else if(operacion=='/'){
            Matriz resultado = this.variables.get(operando1).divida(this.variables.get(operando2));
            this.variables.put(respuesta,resultado);
            this.seHizoBien=true;
        }else if(operacion=='T'){//esta es para la transpuesta
            Matriz resultado = this.variables.get(operando1).transponer(); 
            this.variables.put(respuesta,resultado);
            this.seHizoBien=true;
        }else if(operacion=='*'){
            Matriz resultado = this.variables.get(operando1).multipliqueMatrices(this.variables.get(operando1));
            this.variables.put(respuesta,resultado);
            this.seHizoBien=true;
        }else{
            this.seHizoBien=false;
        }
    }
    
    /**
     * Consulta la matriz requerida dentro del mapa
     * @param La llave para buscar la matriz en el mapa
     * @return La representación en cadena de la matriz
     */
    public String consulta(String variable){
        if(this.variables.containsKey(variable)){
            Matriz porConsultar=this.variables.get(variable);
            this.seHizoBien=true;
            return porConsultar.toString();
        }else{
            System.out.println("No existe una matriz con ese nombre, intente de nuevo");
            this.seHizoBien=false;
            return null;
        }
    }
    
    /**
     * Revisa si la ultima operación realizada se hizo de forma satisfactoria
     * @return true si se hizo de forma satisfactoria / false d.l.c
     */
    public boolean ok(){
        return this.seHizoBien;
    }
}
    



