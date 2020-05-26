package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CelulaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CelulaTest
{
    /**
     * Default constructor for test class CelulaTest
     */
    public CelulaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void deberiaVivirDespuesDeUnTicTac(){
        AutomataCelular ac=new AutomataCelular();
        Celula a =new Celula(ac,2,2);
        ac.ticTac();
        assertEquals(true,a.isVivo());
    }

    @Test
    public void deberiaVivirDespuesDeDosTicTac(){
        AutomataCelular ac=new AutomataCelular();
        Celula a =new Celula(ac,2,2);
        ac.ticTac();
        ac.ticTac();
        assertEquals(true,a.isVivo());
    }
    
    @Test
    public void deberiaMorirDespuesDeTresTicTac(){
        AutomataCelular ac=new AutomataCelular();
        Celula a =new Celula(ac,2,2);
        ac.ticTac();
        ac.ticTac();
        ac.ticTac();
        assertEquals(false,a.isVivo());
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
