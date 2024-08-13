package one.digitalInnovation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

public class AssumptionTeste {

    @Test
    void validarAlgoSomenteNoUsuarioValzin(){
//        Assumptions.assumeTrue("valzin".equals(System.getenv("USER")));
//        Assertions.assertEquals(10, 5+5);

        Assumptions.assumeFalse("valzin".equals(System.getenv("USER")));
        Assertions.assertEquals(10, 5+5);
    }
}
