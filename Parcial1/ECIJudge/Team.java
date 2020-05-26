import java.util.HashMap;
/**
 *Esta clase tiene toda la informacion de un equipo
 */	
public class Team {
    private String name;
    private HashMap<String, Student> student;
    private HashMap<Integer, Submission> submissions;

    public Team(){

    }

    /**
     * Calcula el puntaje acumulado
     * @param competencia
     * @return puntaje acumulado
     */
    public int score(String c){
        int acumScore=0;
        for(s:submissions){
            boolean isForC = s.isFor(c);
	    if(isForC){
	    	int scr=s.score();
		acumScore+=scr;
            }	
        }
	return acumScore;
    }

}
