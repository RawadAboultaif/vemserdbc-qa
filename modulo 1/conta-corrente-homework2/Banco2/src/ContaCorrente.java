public class ContaCorrente extends Conta implements Impressao{

    private double chequeEspecial;

    @Override
    public boolean sacar(double diminuirSaldo) {
        if (diminuirSaldo > getSaldo()+chequeEspecial) {
            System.out.println("Nao é possivel sacar esse valor.");
            return false;
        } else if (diminuirSaldo < 0){

            System.out.println("Não é possivel sacar um valor negativo.");
            return false;

        } else {
            double contadorSaldo = getSaldo() - diminuirSaldo;
            setSaldo(contadorSaldo);
            return true;

        }
    }

    public boolean depositar(double adicionarSaldo) {

        if(adicionarSaldo > 0) {
            double contadorSaldo = getSaldo() + adicionarSaldo;
            setSaldo(contadorSaldo);

        } else {
            System.out.println("Nao é possivel depositar um saldo negativo.");
        }
        return true;
    }


    public boolean transferir(Conta contaCorrente, double valor) {
        if(getSaldo()+chequeEspecial > valor) {
            sacar(valor);
            contaCorrente.depositar(valor);
            System.out.println("\n" + "Transferencia realizada com sucesso !!" + "\n");
            System.out.printf("\n" + "Transferencia: R$ -%.2f \n", valor);
            System.out.printf("Saldo: R$ %.2f \n", getSaldo());
            System.out.printf("Cheque Especial: R$ %.2f \n \n", chequeEspecial);
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
        return true;
    }


    public void imprimir() {
        System.out.println("\n" + "--------Cliente--------");
        System.out.println("\n" + "Nome: " + getCliente().getNome());
        System.out.println("Numero da conta: " + getNumeroConta());
        System.out.println("Agencia: " + getAgencia());
        System.out.printf("Saldo: R$ %.2f \n", getSaldo());
        System.out.printf("Cheque Especial: R$ %.2f \n", chequeEspecial);
    }


    public double retornarSaldoComChequeEspecial() {

        System.out.print("Saldo + ChequeEspecial: ");

        return getSaldo()+chequeEspecial;
    }



    // Getters and Setters


    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }


}
