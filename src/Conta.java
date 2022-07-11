import exception.ValidacoesBancariasExceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta implements IConta{
    private static int AGENDA_PADRAO = 1;
    private static int SEQUENCIAL = 0;

    private int agencia;
    private int numero;
    private double saldo = 0;

    private List<HistoricoBancario> historicoBancario = new ArrayList<>();
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENDA_PADRAO;
        this.numero = ++SEQUENCIAL;
    }

    private boolean verificarSaldo(double valor) {
        return saldo - valor < 0;
    }

    public void sacar(double valor) {
        if (verificarSaldo(valor)) {
            throw new ValidacoesBancariasExceptions("Saldo insuficiente .");
        }
        this.historicoBancario.add(new HistoricoBancario("Saque",new Date(),String.format("Saque realizado de R$ %.2f ",valor)));
        saldo -= valor;
    }

    public void depositar(double valor) {
        saldo += valor;
        String operacao = "Depósito";
        String descricao = String.format("Depósito realizado de R$ %.2f",valor);
        this.historicoBancario.add(new HistoricoBancario(operacao,new Date(),descricao));
    }

    public void transferir(double valor,Conta contaDestino) {
        if (verificarSaldo(valor)) {
            throw new ValidacoesBancariasExceptions("Erro ao realizar transferência , Saldo insuficiente .");
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
        String operacao = "Transferencia";
        String descricao = String.format("Saque realizado de R$ %.2f para o Cliente %s , Agencia : %d , Numero : %d",valor,contaDestino.cliente,contaDestino.agencia,contaDestino.numero);
        this.historicoBancario.add(new HistoricoBancario(operacao,new Date(),descricao));
    }
    public void historicoBancario() {
        this.historicoBancario.forEach(System.out::println);
    }
    protected void extrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.getAgencia()));
        System.out.println(String.format("Numero: %d", this.getNumero()));
        System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
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


}
