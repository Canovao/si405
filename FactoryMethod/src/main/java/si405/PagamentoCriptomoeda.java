package si405;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PagamentoCriptomoeda implements Pagamento {
    private double quantia;
    private String enderecoCarteira;

    @Override
    public String iniciarPagamento(double quantia) {
        this.quantia = quantia;
        this.enderecoCarteira = "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa";
        System.out.println("Iniciando pagamento com Criptomoeda: R$ " + quantia);
        System.out.println("Verificando saldo na carteira: " + enderecoCarteira);

        return gerarTransacaoId();
    }

    @Override
    public boolean confirmarPagamento(String codigoPagamento) {
        boolean saldoSuficiente = verificarSaldoCarteira();

        if (saldoSuficiente) {
            System.out.println("Pagamento com Criptomoeda confirmado: R$ " + quantia);
            armazenarTransacao("Criptomoeda", quantia, codigoPagamento, "Confirmado");
        } else {
            System.out.println("Saldo insuficiente na carteira.");
        }

        return saldoSuficiente;
    }

    @Override
    public void cancelarPagamento(String codigoPagamento) {
        System.out.println("Pagamento com Criptomoeda cancelado.");
        armazenarTransacao("Criptomoeda", quantia, codigoPagamento, "Cancelado");
    }

    private boolean verificarSaldoCarteira() {
        return new Random().nextBoolean();
    }

    private String gerarTransacaoId() {
        return "CR-" + System.currentTimeMillis();
    }

    private void armazenarTransacao(String metodo, double quantia, String transacaoId, String status) {
        try (FileWriter writer = new FileWriter("transacoes.txt", true)) {
            writer.write("Método: " + metodo + ", Quantia: " + quantia + ", ID: " + transacaoId + ", Status: " + status + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
