import java.lang.annotation.Target;

public class ContaPagamento extends Conta{

    static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, int agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double diminuirSaldo) {
        if (diminuirSaldo > getSaldo() + TAXA_SAQUE) {
            System.out.println("Nao é possivel sacar esse valor.");
            return false;
        } else if (diminuirSaldo < 0) {

            System.out.println("Não é possivel sacar um valor negativo.");
            return false;

        } else {
            double contadorSaldo = getSaldo() - diminuirSaldo - TAXA_SAQUE;
            setSaldo(contadorSaldo);
            return true;

        }
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (getSaldo() > valor) {
            super.sacar(valor);
            conta.depositar(valor);
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
