package aplicacion;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BarreraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BarreraTest
{
    /**
     * Default constructor for test class BarreraTest
     */
    public BarreraTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void noDeberiaAfectarUnaCelulaIzquierdosa(){
        AutomataCelular automata=new AutomataCelular();
        Izquierdosa celula=new Izquierdosa(automata,4,4);
        Barrera barrera=new Barrera(automata,4,3);
        
        automata.ticTac();
        
        assertEquals(true,celula.isVivo());
    }
    
        /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void deberiaSeguirMuertaSiCambia(){
        AutomataCelular automata=new AutomataCelular();
        Barrera barrera=new Barrera(automata,4,5);
        
        automata.ticTac();
        
        assertEquals(false,barrera.isVivo());
    }
}
