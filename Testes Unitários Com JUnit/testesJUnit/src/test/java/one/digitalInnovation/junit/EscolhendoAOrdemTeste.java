package one.digitalInnovation.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //ordem numérica
//@TestMethodOrder(MethodOrderer.MethodName.class)//ordem alfabética
//@TestMethodOrder(MethodOrderer.Random.class)//ordem randômica
@TestMethodOrder(MethodOrderer.DisplayName.class)//nomeando os testes
public class EscolhendoAOrdemTeste {

    @DisplayName("A")
//    @Order(4)//usado quano o teste for para ordem numérica
    @Test
    void validaFluxoA(){assertTrue(true);}

    @DisplayName("B")
//    @Order(3)//usado quano o teste for para ordem numérica
    @Test
    void validaFluxoB(){assertTrue(true);}

    @DisplayName("C")
//    @Order(2)//usado quano o teste for para ordem numérica
    @Test
    void validaFluxoC(){Assertions.assertTrue(true);}

    @DisplayName("D")
//    @Order(1)//usado quano o teste for para ordem numérica
    @Test
    void validaFluxoD(){Assertions.assertTrue(true);}

}


