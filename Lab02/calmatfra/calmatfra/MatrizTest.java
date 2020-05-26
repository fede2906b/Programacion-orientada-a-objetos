
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MatrizTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MatrizTest{
    @Test
    public void multiplicarPorLaIdentidadDaIgual(){
        int[][][] matriz={{{1,2},{3,2},{4,3}},{{5,8},{8,7},{7,3}},{{3,5},{5,4},{2,3}}};
        Matriz matriz1 = new Matriz(matriz);
        Matriz matriz2 = new Matriz(3);
        assertEquals(matriz1, matriz1.multipliqueMatrices(matriz2));
    }
    
    @Test
    public void dosMatricesDeberianSerIguales(){
        int[][][] mat1={{{1,2},{3,2},{4,3}},{{5,8},{8,7},{7,3}},{{3,5},{5,4},{2,3}}};
        int[][][] mat2={{{2,4},{6,4},{8,6}},{{10,16},{16,14},{14,6}},{{6,10},{10,8},{4,6}}};
        Matriz matriz1 = new Matriz(mat1);
        Matriz matriz2 = new Matriz(mat2);
        assertEquals(matriz1, matriz2);
    }
    
    @Test
    public void restarIgualesDeberiaDarCero(){
        int[][][] matriz={{{1,2},{3,2},{4,3}},{{5,8},{8,7},{7,3}},{{3,5},{5,4},{2,3}}};
        Matriz matriz1 = new Matriz(matriz);
        Matriz matriz2 = new Matriz(matriz);
        assertEquals(new Matriz(new Fraccionario(0),3,3), matriz1.reste(matriz2));
    }
    
    @Test
    public void sumarDosIgualesDeberiaSerloMismoQueMultiplicarPorDos(){
        int[][][] matriz={{{1,2},{3,2},{4,3}},{{5,8},{8,7},{7,3}},{{3,5},{5,4},{2,3}}};
        Matriz matriz1 = new Matriz(matriz);
        Matriz matriz2 = new Matriz(matriz);
        Matriz matriz3 = new Matriz(new Fraccionario(2),3,3);
        assertEquals(matriz1.multipliqueElementos(matriz3),matriz1.sume(matriz2));
    }
}


