package si405.fabricas;

import si405.PagamentoCartaoCredito;

public class FabricaPagamentoCartaoDeCredito extends FabricaPagamento {
    @Override
    protected PagamentoCartaoCredito criarPagamento() {
        return new PagamentoCartaoCredito();
    }
}
