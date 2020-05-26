package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SandwichTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SandwichTest
{
    /**
     * Default constructor for test class SandwichTest
     */
    public SandwichTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void deberíaVivirSiEstaEntreDosBarrerasALosLados(){
        AutomataCelular automata=new AutomataCelular();
        Sandwich a =new Sandwich(automata,3,3);
        Barrera B1=new Barrera(automata,3,2);
        Barrera B2=new Barrera(automata,3,4);
        
        automata.ticTac();
        
        assertEquals(true,a.isVivo());
    }
    
    @Test
    public void deberíaMorirSiEstaEntreDosElementosVivosALosLados(){
        AutomataCelular automata=new AutomataCelular();
        Sandwich a =new Sandwich(automata,3,3);
        Celula e1=new Celula(automata,3,2);
        Celula e2=new Celula(automata,3,4);
        
        automata.ticTac();
        automata.ticTac();
        
        assertEquals(false,a.isVivo());
    }
    
    @Test
    public void deberíaVivirSiEstaEntreDosElementosArribaYAbajo(){
        AutomataCelular automata=new AutomataCelular();
        Sandwich a =new Sandwich(automata,3,3);
        Barrera B1=new Barrera(automata,2,3);
        Barrera B2=new Barrera(automata,4,3);
        
        automata.ticTac();
        
        assertEquals(true,a.isVivo());
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @Test
    public void deberiaVivirSiSoloTieneUnElementoAIzquierda(){
        AutomataCelular automata1=new AutomataCelular();
        Sandwich a =new Sandwich(automata1,3,3);
        Celula c1=new Celula(automata1,3,4);
        automata1.ticTac();
        assertEquals(true,a.isVivo());    
    }
    
    @Test
    public void deberiaVivirSiSoloTieneUnElementoADerecha(){
        AutomataCelular automata2=new AutomataCelular();
        Sandwich b =new Sandwich(automata2,3,3);
        Celula c2=new Celula(automata2,3,4);
        automata2.ticTac();
        assertEquals(true,b.isVivo());
    }
}
