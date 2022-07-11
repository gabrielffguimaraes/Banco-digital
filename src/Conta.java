public abstract class Conta implements IConta{
    private static int AGENDA_PADRAO = 1;
    private static int SEQUENCIAL = 0;

    private int agencia;
    private int numero;
    private double saldo = 0;

    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENDA_PADRAO;
        this.numero = ++SEQUENCIAL;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(double valor,Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
    protected void extrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.getAgencia()));
        System.out.println(String.format("Numero: %d", this.getNumero()));
        System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
    }
}
