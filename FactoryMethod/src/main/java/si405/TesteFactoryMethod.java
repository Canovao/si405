package si405;

import si405.fabricas.FabricaPagamento;
import si405.fabricas.FabricaPagamentoCartaoDeCredito;
import si405.fabricas.FabricaPagamentoCriptomoeda;
import si405.fabricas.FabricaPagamentoPayPal;

public class TesteFactoryMethod {
    public static void main(String[] args) {
        FabricaPagamento fabricaCartaoCredito = new FabricaPagamentoCartaoDeCredito();
        FabricaPagamento fabricaPayPal = new FabricaPagamentoPayPal();
        FabricaPagamento fabricaCriptomoeda = new FabricaPagamentoCriptomoeda();

        double quantiaCartaoCredito = 100.0;
        double quantiaPayPal = 200.0;
        double quantiaCriptomoeda = 300.0;

        System.out.println("Processando pagamento com Cartão de Crédito:");
        fabricaCartaoCredito.processarPagamento(quantiaCartaoCredito);

        System.out.println("\nProcessando pagamento com PayPal:");
        fabricaPayPal.processarPagamento(quantiaPayPal);

        System.out.println("\nProcessando pagamento com Criptomoeda:");
        fabricaCriptomoeda.processarPagamento(quantiaCriptomoeda);
    }
}

