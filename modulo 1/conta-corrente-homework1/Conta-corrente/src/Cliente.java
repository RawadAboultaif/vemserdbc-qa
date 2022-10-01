public class Cliente {
    String nome;
    String cpf;
    Contato[] contato = new Contato[2];
    Endereco[] endereco = new Endereco[2];


    public  void imprimirContatos() {
        contato[0].imprimirContato();
        contato[1].imprimirContato();
    }

    public void imprimirEnderecos() {
        endereco[0].imprimirEndereco();
        endereco[1].imprimirEndereco();
    }

    public void imprimirCliente() {
        System.out.println("\n");
        System.out.println("--------------Cliente-------------- \n");
        System.out.println("Nome: " + nome);
        System.out.println("Cpf: " + cpf);
        imprimirContatos();
        imprimirEnderecos();
    }
}
