package vallzin.dio.mockito.exemplo;

import java.time.LocalDate;

public class CadastrarPessoa {

    private ApiDosCorreios apiDosCorreios;

    public CadastrarPessoa(final ApiDosCorreios apiDosCorreios){
        this.apiDosCorreios = apiDosCorreios;
    }

    public Pessoa cadastrarPessoa(String nome, String documento, LocalDate nascimento, String cep){
        Pessoa pessoa = new Pessoa(nome, documento, nascimento);
        DadosLocalizacao dadosLocalizacao = apiDosCorreios,buscaDadosComBaseNoCep(cep);
        pessoa.adicionarDadosDeEndereco(dadosLocalizacao);
        return pessoa;
    }

}
