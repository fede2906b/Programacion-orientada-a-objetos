package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VirusTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VirusTest
{
    /**
     * Default constructor for test class VirusTest
     */
    public VirusTest(){
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void deberiaVivirSiHayUnElementoVivoEnLaMismaFilaOColumna(){
        AutomataCelular ac = new AutomataCelular();
        Virus a =new Virus(ac,5,5);
        Celula c1=new Celula(ac,0,5);
        ac.ticTac();
        assertEquals(true,a.isVivo());
    }
    
    @Test
    public void deberiaMorirSiHayUnElementoMuertoEnLaMismaFilaOColumna(){
        AutomataCelular ac = new AutomataCelular();
        Virus a =new Virus(ac,5,5);
        Barrera c1=new Barrera(ac,5,0);
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