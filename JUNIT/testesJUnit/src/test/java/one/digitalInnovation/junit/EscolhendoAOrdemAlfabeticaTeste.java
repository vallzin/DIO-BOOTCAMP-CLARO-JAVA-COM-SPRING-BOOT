package one.digitalInnovation.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class EscolhendoAOrdemAlfabeticaTeste {


    @Test
    void validaFluxoA(){assertTrue(true);}


    @Test
    void validaFluxoB(){assertTrue(true);}


    @Test
    void validaFluxoC(){Assertions.assertTrue(true);}


    @Test
    void validaFluxoD(){Assertions.assertTrue(true);}

}

