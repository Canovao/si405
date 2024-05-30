package si405.fabricas;

import si405.Pagamento;
import si405.PagamentoCriptomoeda;

public class FabricaPagamentoCriptomoeda extends FabricaPagamento {
    @Override
    protected Pagamento criarPagamento() {
        return new PagamentoCriptomoeda();
    }
}
