public class ContaCorrente extends Conta implements Impressao{

    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }


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



    //  Setters

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }


}
