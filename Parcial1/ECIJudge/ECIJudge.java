/**
 * Inicia un sistema de competencias de programacion
 */
public class ECIJudge{
    private HashMap<String,Problem> problems;
    private HashMap<String,Contest> contests;
    private HashMap<int,Student> students;
    private HashMap<String,Team> teams;

    public ECIJudge(){
        
    }
    
    /**
     * Calcula el puntaje de un equipo en una competencia especifica
     * @param nombre de la competencia, nombre del equipo
     * @return puntaje acumulado del equipo en una competenca
     */
    public int scoreByContest(String contestName,String teamName){
        String t=findTeam(teamName);
        String c=findContest(contestName);
        puntajeDelEquipo=t.score(c);
	return puntajeDelEquipo;
    }
    
    /**
     * Encuentra el equipo por su nombre
     * @param nombre del equipo
     * @return equipo
     */
    public String findTeam(String teamName){
        String team = teams.get(teamName);
        return team;
    }
    
    /**
     * Encuentra la competencia por su nombre
     * @param nombre de la competencia
     * @return competencia
     */
    public String findContest(String contestName){
        String contest = contests.get(contestName);
        return contest;
    }
}