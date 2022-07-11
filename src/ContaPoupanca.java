import exception.ValidacoesBancariasExceptions;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.extrato();
    }

    @Override
    public void sacar(double valor) {
        if (valor > 600) {
            throw new ValidacoesBancariasExceptions("Limite máximo permitido para saques de 600 reais ");
        }
        super.sacar(valor);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor > 600) {
            throw new ValidacoesBancariasExceptions("Limite máximo permitido para transferencias de 600 reais ");
        }
        super.transferir(valor, contaDestino);
    }

    @Override
    public void historicoBancario() {
        System.out.println(String.format("Histórico conta poupança | Agencia : %d , Numero : %d ",this.getAgencia(),this.getNumero()));
        super.historicoBancario();
    }
}
