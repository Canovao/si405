package si405.fabricas;

import si405.Pagamento;

public abstract class FabricaPagamento {
    protected abstract Pagamento criarPagamento();

    public void processarPagamento(double quantia) {
        Pagamento pagamento = criarPagamento();

        String codigoPagamento = pagamento.iniciarPagamento(quantia);

        // Se o pagamento deu errado, então cancele
        if (!pagamento.confirmarPagamento(codigoPagamento))
            pagamento.cancelarPagamento(codigoPagamento);
    }
}

