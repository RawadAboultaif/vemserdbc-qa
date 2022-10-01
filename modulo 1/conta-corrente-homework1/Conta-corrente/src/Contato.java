public class Contato {
    String descricao;
    String telefone;
    int tipo;

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
}


