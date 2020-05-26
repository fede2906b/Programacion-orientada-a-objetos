
/**
 * Write a description of class Xook here.
 *
 * @author Barrios-Ruiz
 * @version 01/24/2020
 */
public class Xook{
    public int valor;
    private String numeroMaya;
    public Xook(int value){
        valor=value;
        getValue();
        for(int i=0;i<3;i++){
            
        }
        
        
    }

    /**
     * Convierte el valor dado de decima a base 20
     */
    public void getValue(){
        if (valor<8000){
            numeroMaya = "";
            while (valor%20!=0){
                if(valor==10){
                    numeroMaya+="A";
                }else if(valor%20==11){
                    numeroMaya+="B";
                }else if(valor%20==12){
                    numeroMaya+="C";
                }else if(valor%20==13){
                    numeroMaya+="D";
                }else if(valor%20==14){
                    numeroMaya+="E";
                }else if(valor%20==15){
                    numeroMaya+="F";
                }else if(valor%20==16){
                    numeroMaya+="G";
                }else if(valor%20==17){
                    numeroMaya+="H";
                }else if(valor%20==18){
                    numeroMaya+="I";
                }else if(valor%20==19){
                    numeroMaya+="J";
                }else{
                    numeroMaya+=valor%20;
                }
                valor=(int)valor/20;
            }
            numeroMaya+=valor%20;
            System.out.println(numeroMaya);
        }else{
            System.out.println("El número es muy grande (max 7999)");
        }
    }
    
    public void random(){
        valor=(int) (Math.random()*7999);
        getValue();
        makeVisible();
    }
    
    public void makeVisible(){
    }
    
    public void makeInvisible(){
    }
    
    public void moveHorizontal(int distance){
    }
    
    public void changeColor(String color){
    } 
}
