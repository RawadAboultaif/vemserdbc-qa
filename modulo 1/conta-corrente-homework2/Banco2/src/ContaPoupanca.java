public class ContaPoupanca extends Conta implements Impressao {
    static final double JUROS_MENSAL = 1.01;

    public void imprimir() {
        System.out.println("\n" + "--------Cliente--------");
        System.out.println("\n" + "Nome: " + getCliente().getNome());
        System.out.println("Numero da conta: " + getNumeroConta());
        System.out.println("Agencia: " + getAgencia());
        System.out.printf("Saldo: R$ %.2f \n", getSaldo());
    }

    public void creditarTaxa() {

        setSaldo(getSaldo() * JUROS_MENSAL);

    }

}