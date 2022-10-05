abstract class Conta implements Movimentacao  {

    private Cliente Cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;

    public Conta(Cliente cliente, String numeroConta, int agencia, double saldo) {
        Cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }


    // Getters and Setters

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    public boolean transferir(Conta conta, double valor) {
        if (saldo > valor) {
            sacar(valor);
            conta.depositar(valor);
            System.out.println("\n" + "Transferencia realizada com sucesso !!" + "\n");
            System.out.printf("\n" + "Transferencia: R$ -%.2f \n", valor);
            System.out.printf("Saldo: R$ %.2f \n", getSaldo());
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
        return true;
    }

}