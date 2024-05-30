package si405;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PagamentoPayPal implements Pagamento {
    private double quantia;
    private String contaPayPal;

    @Override
    public String iniciarPagamento(double quantia) {
        this.quantia = quantia;
        this.contaPayPal = "usuario@paypal.com";
        System.out.println("Iniciando pagamento com PayPal: R$ " + quantia);
        System.out.println("Autenticando conta PayPal: " + contaPayPal);

        return gerarTransacaoId();
    }

    @Override
    public boolean confirmarPagamento(String codigoPagamento) {
        boolean autenticado = autenticarContaPayPal();

        if (autenticado) {
            System.out.println("Pagamento com PayPal aprovado: R$ " + quantia);
            armazenarTransacao("PayPal", quantia, codigoPagamento, "Aprovado");
        } else {
            System.out.println("Autenticação do PayPal falhou.");
        }

        return autenticado;
    }

    @Override
    public void cancelarPagamento(String codigoPagamento) {
        System.out.println("Pagamento com PayPal cancelado.");
        armazenarTransacao("PayPal", quantia, codigoPagamento, "Cancelado");
    }

    private boolean autenticarContaPayPal() {
        return new Random().nextBoolean();
    }

    private String gerarTransacaoId() {
        return "PP-" + System.currentTimeMillis();
    }

    private void armazenarTransacao(String metodo, double quantia, String transacaoId, String status) {
        try (FileWriter writer = new FileWriter("transacoes.txt", true)) {
            writer.write("Método: " + metodo + ", Quantia: " + quantia + ", ID: " + transacaoId + ", Status: " + status + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

