package one.digitalInnovation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionTeste {

    @Test
    void validarLancamentos(){
        int[] primeiroLancamento = {10,20,30,40,50};
        int[] seguntoLancamento = {10,2,5,10,16};

//        Assertions.assertArrayEquals(primeiroLancamento, seguntoLancamento);
        Assertions.assertNotEquals(primeiroLancamento, seguntoLancamento);
    }

    @Test
    void validarSeObjetoEstaNulo(){
        Pessoa pessoa = null;

        Assertions.assertNull(pessoa);

        pessoa = new Pessoa("valzin", LocalDateTime.now());

        Assertions.assertNull(pessoa);
    }

    @Test
    void validarNumerosDeTiposDiferentes(){

        double valor = 3.0;
        double outroValor = 3.0;

        assertEquals(valor, outroValor);
    }
}
