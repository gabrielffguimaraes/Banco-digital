public class ContaCorrente extends Conta {
    private boolean cartaoDeCredito;

    public ContaCorrente(Cliente cliente,boolean cartaoDeCredito) {
        super(cliente);
        this.cartaoDeCredito = cartaoDeCredito;
    }
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        this.extrato();
        System.out.println(String.format("Cartao de crédito : %b", this.cartaoDeCredito));
    }

    @Override
    public void historicoBancario() {
        System.out.println(String.format("Histórico conta corrente | Agencia : %d , Numero : %d ",this.getAgencia(),this.getNumero()));
        super.historicoBancario();
    }
}
