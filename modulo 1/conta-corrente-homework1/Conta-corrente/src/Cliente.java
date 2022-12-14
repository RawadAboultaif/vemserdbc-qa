public class Cliente {
    String nome;
    String cpf;
    Contato[] contato = new Contato[2];
    Endereco[] endereco = new Endereco[2];


    public  void imprimirContatos() {
        if (contato != null) {
            for (int i = 0; i < contato.length; i++) {
                if (contato[i] != null) {
                    contato[i].imprimirContato();
                }
            }
        }
    }

    public void imprimirEnderecos() {
        if (endereco != null) {
            for (int i = 0; i < endereco.length; i++) {
                if (endereco[i] != null) {
                    endereco[i].imprimirEndereco();
                }
            }
        }
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
