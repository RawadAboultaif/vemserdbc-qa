abstract class Conta implements Movimentacao  {
    private Cliente Cliente = new Cliente();
    private String numeroConta;
    private int agencia;
    private double saldo;


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


    public abstract boolean sacar(double diminuirSaldo);

    public abstract boolean depositar(double adicionarSaldo);

    public abstract boolean transferir(Conta contaCorrente, double valor);
}