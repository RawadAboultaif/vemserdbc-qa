public class Cliente {
   private String nome;
   private String cpf;
   private Contato[] contato = new Contato[2];
   private Endereco[] endereco = new Endereco[2];


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



    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContato() {
        return contato;
    }

    public void setContato(Contato[] contato) {
        this.contato = contato;
    }

    public Endereco[] getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco[] endereco) {
        this.endereco = endereco;
    }
}
