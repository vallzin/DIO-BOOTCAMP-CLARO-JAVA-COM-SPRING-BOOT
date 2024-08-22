package one.digitalInnovation.junit;

import java.util.logging.Logger;

public class BancoDeDados {

    private static final Logger LOGGER = Logger.getLogger(BancoDeDados.class.getName());

    public static void iniciarConexao(){
        //fez algo
        LOGGER.info("Iniciou conexão");
    }

    public static void finalizarCaonexao(){
        LOGGER.info("finalizaou conexao");
    }

    public static void insereDados(Pessoa pessoa){
        //insere pessoa no DB
        LOGGER.info("inseriu dados");
    }

    public static void removeDados(Pessoa pessoa){
        //remove pessoa no DB
        LOGGER.info("removeu dados");
    }

}

