import java.util.ArrayList;
import java.util.List;

public class Lista {
    public static void main(String[] args) {
        List<String> minhaLista = new ArrayList<>();
        minhaLista.add("Rawad");
        minhaLista.add("Rawad1");
        minhaLista.add("Rawad2");
        minhaLista.add("Rawad3");


        if(minhaLista.size() >= 1) {
            System.out.println(minhaLista.get(minhaLista.size() - 2));
        }

        System.out.println(minhaLista.get(0));
        System.out.println(minhaLista.remove(minhaLista.size() - 1));

        System.out.println("Minha lista completa: " + minhaLista);
        System.out.println("Total de nomes na lista: " + minhaLista.size());

    }
}
