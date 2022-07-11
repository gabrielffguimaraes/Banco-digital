public class Main {
    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta corrente = new ContaCorrente(venilton);
        corrente.depositar(200);
        Conta poupanca = new ContaCorrente(venilton);

        corrente.transferir(50,poupanca);
        corrente.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
