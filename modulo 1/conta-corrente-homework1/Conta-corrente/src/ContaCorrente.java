public class ContaCorrente {
    Cliente cliente = new Cliente();
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    public void imprimirContaCorrente() {
        System.out.println("\n" + "--------Cliente--------");
        System.out.println("\n" + "Nome: " + cliente.nome);
        System.out.println("Numero da conta: " + numeroConta);
        System.out.println("Agencia: " + agencia);
        System.out.printf("Saldo: R$ %.2f \n", saldo);
        System.out.printf("Cheque Especial: R$ %.2f \n", chequeEspecial);
    }

    public boolean sacar(double diminuirSaldo) {
        if (diminuirSaldo > saldo+chequeEspecial) {
            System.out.println("Nao é possivel sacar esse valor.");
            return false;
        } else if (diminuirSaldo < 0){

            System.out.println("Não é possivel sacar um valor negativo.");

        } else {
            saldo -= diminuirSaldo;
            System.out.println("Saque efetuado com sucesso.");

        }
        return true;
    }

    public boolean depositar(double adicionarSaldo) {

        if(adicionarSaldo > 0) {
            saldo += adicionarSaldo;
            System.out.println("Deposito efetuado com sucesso.");

        } else {
            System.out.println("Nao é possivel depositar um saldo negativo.");
        }
        return true;
    }

    public double retornarSaldoComChequeEspecial() {

        System.out.print("Saldo + ChequeEspecial: ");

        return saldo+chequeEspecial;
    }

    public boolean transferir(ContaCorrente contaCorrente, double valor) {
        if(valor > saldo+chequeEspecial) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
        if(valor > 0 && valor < saldo+chequeEspecial) {

            contaCorrente.saldo += valor;
            saldo -=  valor;
            System.out.println("\n" + "Transferencia realizada com sucesso !!" + "\n");
            System.out.printf("\n" + "Transferencia: R$ -%.2f \n", valor);
            System.out.printf("Saldo: R$ %.2f \n", saldo);
            System.out.printf("Cheque Especial: R$ %.2f \n \n", chequeEspecial);
        }
        return true;
    }
}
