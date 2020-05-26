import java.time.LocalDateTime;

/**
 *Esta clase tiene toda la informacion de un intento en ecijudge
 */
public class Submission {
    private static int nextSubmissionNumber;
    private int number;
    private String sourceCode;
    private LocalDateTime upload;
    private String status;
    private Contest contest;
    private Problem problem;

    public Submission(){
    }
    
    /**
     * Ve si el intentodel equipo es de la competencia dada
     * @param nombre de la competencia
     * @return true si es de la competencia/false d.l.c
     */
    public boolean isFor(String c){
        if(contest.getName()==c){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Devuelve el puntaje del problema si se subio satisfactoriamente
     * @return puntaje del problema
     */
    public int score(){
	if(status=="PENDING"){
	    evaluate();
	}else if(status=="ACCEPTED"){
	    s=problem.getScore();
	    return s;
	}else{
	    return null;	
	}
    }

    /**
     * Evalua si esta bien el codigo
     * @return Aceptado o rechazado
     */	
    public evaluate(){
    	boolean funciona=Engine.execute(sourceCode,input,output,maxTime);
	if(funciona){
        	status="ACCEPTED";
	}else{
		status="REJECTED";
	}
    }

}
