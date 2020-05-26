package aplicacion;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IzquierdosaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IzquierdosaTest
{
    /**
     * Default constructor for test class IzquierdosaTest
     */
    public IzquierdosaTest()
    {
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void deberiaMorirSiHayUnElementoVivoASuIzquierda(){
        AutomataCelular automata=new AutomataCelular();
        Izquierdosa celula1=new Izquierdosa(automata,4,4);
        Izquierdosa celula2=new Izquierdosa(automata,4,3);
        
        automata.ticTac();
        
        assertEquals(false,celula1.isVivo());
    }
    
    @Test
    public void deberiaVivirSiNoHayUnElementoVivoASuIzquierda(){
        AutomataCelular automata=new AutomataCelular();
        Izquierdosa celula1=new Izquierdosa(automata,4,4);
        Izquierdosa celula2=new Izquierdosa(automata,4,3);
        
        automata.ticTac();
        
        assertEquals(true,celula2.isVivo());
    }
}
