package one.digitalInnovation.junit;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class CondicionalTeste {

//    @Test
//    @EnabledIfEnvironmentVariable(named = "USER", matches = "valzin")
//    void validarAlgoSomenteNoUsuarioValzin(){
//        Assertions.assertEquals(10, 5+5);
//    }

//    @Test
//    @DisabledIfEnvironmentVariable(named = "USER", matches = "valzin")
//    void validarAlgoSomenteNoUsuarioValzin(){
//        Assertions.assertEquals(10, 5+5);
//    }

//    @Test
//    @EnabledOnOs(OS.WINDOWS)
//    void validarAlgoSomenteNoUsuarioValzin(){
//        Assertions.assertEquals(10, 5+5);
//    }

    @Test
    @EnabledOnJre(JRE.JAVA_22)
    void validarAlgoSomenteNoUsuarioValzin(){
        Assertions.assertEquals(10, 5+5);
    }
}
