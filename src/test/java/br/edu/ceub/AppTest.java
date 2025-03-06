package br.edu.ceub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void somar_2_e_3_retorna_5() {

        //preparar
        App appUnderTest = new App();

        //executar
        int result = appUnderTest.somar(2, 3);

        //verificar
        assertEquals(5, result);
    }

    @Test
    void somar_menos_2_e_3_retorna_1() {

        //preparar
        App appUnderTest = new App();

        //executar
        int result = appUnderTest.somar(-2, 3);

        //verificar
        assertEquals(1, result);
    }

    @Test
    void somar_0_e_7_retorna_7() {

        //preparar
        App appUnderTest = new App();

        //executar
        int result = appUnderTest.somar(0, 7);

        //verificar
        assertEquals(7, result);
    }
}
