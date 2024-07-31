import lanchonete.antedimento.Atendente;
import lanchonete.antedimento.cozinha.Almoxarife;
import lanchonete.antedimento.cozinha.Cozinheiro;
import lanchonete.area.cliente.Cliente;

public class Estabelecimento {
    public static void main(String[] args){
        Cozinheiro cozinheiro = new Cozinheiro();

        /*
        //ações que não precisam estarem disponíveis para toda a aplicação
        cozinheiro.lavarIngredientes();
        cozinheiro.baterVitaminaLiquidificador();
        cozinheiro.selecionarIngredientesVitamina();
        cozinheiro.prepararLanche();
        cozinheiro.prepararVitamina();
        cozinheiro.selecionarIngredientesLanche();
        cozinheiro.prepararCombo();

         */

        cozinheiro.adicionarSucoNoBalcao();
        cozinheiro.adicionarLancheNoBalcao();
        cozinheiro.adicionarComboNoBalcao();

        /*
        Almoxarife almoxarife = new Almoxarife();
        //ações que o estabelecimento não precisa ter conciência
        almoxarife.controlarEntrada();
        almoxarife.controlarSaida();
         */
        /*
        //ação que somente jo seu pacote cozinha precisa conhecer (default)
        almoxarife.entregarIngredientes();
        almoxarife.trocarGas();
        */

        Atendente atendente = new Atendente();
        /*
        atendente.pegarLancheCozinha();
         */
        atendente.receberPagamento();
        atendente.servindoMesa();
        /*
        //ação que somente jo seu pacote cozinha precisa conhecer (default)
        atendente.trocarGas();
         */

        Cliente cliente = new Cliente();

        cliente.escolherLanche();
        cliente.fazerPedido();
        cliente.pagarConta();
        cliente.pegarPedidoBalcao();
        /*
        cliente.consultarSaldoAplicativo();
         */
        /*
        cozinheiro.pedirParaTrocarGas(atendente);
        cozinheiro.pedirParaTrocarGas(almoxarife);
        */
    }
}
