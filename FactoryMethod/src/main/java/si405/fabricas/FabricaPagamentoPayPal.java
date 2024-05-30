package si405.fabricas;

import si405.Pagamento;
import si405.PagamentoPayPal;

public class FabricaPagamentoPayPal extends FabricaPagamento {
    @Override
    protected Pagamento criarPagamento() {
        return new PagamentoPayPal();
    }
}
