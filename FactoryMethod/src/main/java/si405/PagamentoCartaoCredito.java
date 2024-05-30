package si405;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PagamentoCartaoCredito implements Pagamento {
    private double quantia;
    private String numeroCartao;

    @Override
    public String iniciarPagamento(double quantia) {
        this.quantia = quantia;
        this.numeroCartao = "1234-5678-9101-1121";
        System.out.println("Iniciando pagamento com Cartão de Crédito: R$ " + quantia);
        System.out.println("Verificando crédito para o cartão: " + numeroCartao);

        return gerarTransacaoId();
    }

    @Override
    public boolean confirmarPagamento(String codigoPagamento) {
        boolean aprovado = new Random().nextBoolean();

        if (aprovado) {
            System.out.println("Pagamento com Cartão de Crédito aprovado: R$ " + quantia);
            armazenarTransacao("Cartão de Crédito", quantia, codigoPagamento, "Aprovado");
        } else {
            System.out.println("Pagamento com Cartão de Crédito recusado.");
        }

        return aprovado;
    }

    @Override
    public void cancelarPagamento(String codigoPagamento) {
        System.out.println("Pagamento com Cartão de Crédito cancelado.");
        armazenarTransacao("Cartão de Crédito", quantia, codigoPagamento, "Cancelado");
    }

    private String gerarTransacaoId() {
        return "CC-" + System.currentTimeMillis();
    }

    private void armazenarTransacao(String metodo, double quantia, String transacaoId, String status) {
        try (FileWriter writer = new FileWriter("transacoes.txt", true)) {
            writer.write("Método: " + metodo + ", Quantia: " + quantia + ", ID: " + transacaoId + ", Status: " + status + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
