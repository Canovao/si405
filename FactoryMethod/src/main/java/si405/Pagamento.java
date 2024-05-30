package si405;

public interface Pagamento {
    String iniciarPagamento(double quantia);
    boolean confirmarPagamento(String codigoPagamento);
    void cancelarPagamento(String codigoPagamento);
}
