public class ContaPoupanca extends Conta implements Impressao {
    static final double JUROS_MENSAL = 1.01;

    public void creditarTaxa() {
        setSaldo(getSaldo() * JUROS_MENSAL);
    }


    public boolean sacar(double diminuirSaldo) {
        if (diminuirSaldo > getSaldo()) {
            double contadorSaldo = getSaldo() - diminuirSaldo;
            setSaldo(contadorSaldo);
            return true;
        } else if (diminuirSaldo < 0) {

            System.out.println("Não é possivel sacar um valor negativo.");
            return false;

        }
        return true;
    }


    public boolean depositar(double adicionarSaldo) {

        if (adicionarSaldo > 0) {
            double contadorSaldo = getSaldo() + adicionarSaldo;
            setSaldo(contadorSaldo);

        } else {
            System.out.println("Nao é possivel depositar um saldo negativo.");
        }
        return true;
    }


    public boolean transferir(Conta contaPoupanca, double valor) {
        if (getSaldo() > valor) {
            sacar(valor);
            contaPoupanca.depositar(valor);
            System.out.println("\n" + "Transferencia realizada com sucesso !!" + "\n");
            System.out.printf("\n" + "Transferencia: R$ -%.2f \n", valor);
            System.out.printf("Saldo: R$ %.2f \n", getSaldo());
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
    }


}