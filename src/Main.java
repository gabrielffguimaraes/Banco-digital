import exception.ValidacoesBancariasExceptions;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            Cliente venilton = new Cliente();
            venilton.setNome("Venilton");

            Conta corrente = new ContaCorrente(venilton);
            Conta poupanca = new ContaPoupanca(venilton);


            corrente.depositar(800);
            corrente.transferir(400,poupanca);

            poupanca.sacar(255.25);

            corrente.imprimirExtrato();
            poupanca.imprimirExtrato();


            corrente.historicoBancario();
            poupanca.historicoBancario();
        } catch (ValidacoesBancariasExceptions e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        }


    }
}
