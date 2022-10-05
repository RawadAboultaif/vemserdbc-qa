  public interface Movimentacao {
      boolean sacar(double diminuirSaldo);

      boolean depositar(double adicionarSaldo);

      boolean transferir(Conta conta, double valor);

  }
