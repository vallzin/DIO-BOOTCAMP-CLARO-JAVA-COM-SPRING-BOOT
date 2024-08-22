package vallzin.dio.mockito.exemplo;

public class DadosLocalizacao {
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String Estado;

    public DadosLocalizacao(String rua, String complemento, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        Estado = estado;
    }

    public String getRua() { return rua; }

    public void setRua(String rua) { this.rua = rua; }

    public String getBairro() { return bairro; }

    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }

    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return Estado; }

    public void setEstado(String estado) { Estado = estado; }

    public String getComplemento() { return complemento; }

    public void setComplemento(String complemento) { this.complemento = complemento; }
}
