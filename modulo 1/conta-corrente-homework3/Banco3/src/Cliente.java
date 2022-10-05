import java.util.ArrayList;
import java.util.List;

public class Cliente {
   private String nome;
   private String cpf;
   private List<Contato> contato;
   private List<Endereco> endereco;


    public Cliente(String nome, String cpf, List<Contato> contato, List<Endereco> endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.endereco = endereco;
    }

    public  void imprimirContatos() {
        if (contato != null) {
            for (int i = 0; i < contato.size(); i++) {
                if (contato.get(i) != null) {
                    contato.get(i).imprimirContato();
                }
            }
        }
    }

    public void imprimirEnderecos() {
        if (endereco != null) {
            for (int i = 0; i < endereco.size(); i++) {
                if (endereco.get(i) != null) {
                    endereco.get(i).imprimirEndereco();
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

    public List<Contato> getContato() {
        return contato;
    }

    public void setContato(ArrayList<Contato> contato) {
        this.contato = contato;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(ArrayList<Endereco> endereco) {
        this.endereco = endereco;
    }

}
