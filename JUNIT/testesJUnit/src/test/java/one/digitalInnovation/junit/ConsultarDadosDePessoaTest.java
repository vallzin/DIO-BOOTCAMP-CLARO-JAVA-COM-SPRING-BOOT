package one.digitalInnovation.junit;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

public class ConsultarDadosDePessoaTest {

    @BeforeAll
    static void configuraConexao(){
        BancoDeDados.iniciarConexao();
    }

    @BeforeEach
    void insereDadoParaTeste(){
        BancoDeDados.insereDados(new Pessoa("jojo", LocalDateTime.of(2000,1,5,5,2,1)));
    }

    @AfterEach
    void removeDadosDeTeste(){
        BancoDeDados.removeDados(new Pessoa("jojo", LocalDateTime.of(2000,1,5,5,2,1)));
    }

    @Test
    void validadarDadosDeRetorno(){
        Assertions.assertTrue(true);
    }

    @AfterAll
    static void finalizarConexao(){
        BancoDeDados.finalizarCaonexao();
    }
}
