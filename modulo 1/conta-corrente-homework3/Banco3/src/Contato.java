public class Contato {
    private String descricao;
    private String telefone;
    private int tipo;

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public void imprimirContato() {
        switch (tipo) {
            case 1 -> {
                System.out.println( " \n" + "-------------------Contato---------------- \n");
                System.out.println("Descrição: " + descricao);
                System.out.println("Telefone: " + telefone);
                System.out.println("Tipo: Residencial");
            }

            case 2 -> {
                System.out.println( " \n" + "-------------Contato----------- \n ");
                System.out.println("Descrição: " + descricao);
                System.out.println("Telefone: " + telefone);
                System.out.println("Tipo: Comercial");
            }
        }
    }

    // Getters and Setters

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}


