package one.digitalInnovation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class PessoaTeste {

    @Test
    void deveCalcularIdadeCorretamente(){
        Pessoa valzin = new Pessoa("valzin", LocalDateTime.of(1976, 04,22,05,0,0 ));
        Assertions.assertEquals(48,valzin.getIdade());
    }

    @Test
    void deveRetornarSeEhMaiorDeIdade(){
        Pessoa valzin = new Pessoa("valzin", LocalDateTime.of(1976,04,22,05,0,0));
        Assertions.assertTrue(valzin.ehMaiorDeIdade());

        Pessoa joao = new Pessoa("joao", LocalDateTime.now());
        Assertions.assertFalse(joao.ehMaiorDeIdade());
    }
}
