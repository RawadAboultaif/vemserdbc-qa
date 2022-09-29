import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner infoUsario = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = infoUsario.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = infoUsario.nextInt();
        infoUsario.nextLine();


        System.out.print("Digite a cidade onde mora: ");
        String cidade = infoUsario.nextLine();

        System.out.print("Digite o estado onde mora: ");
        String estado = infoUsario.nextLine();

        System.out.println("Ola seu nome eh " + nome + ", voce tem "
                + idade + " anos, eh da cidade de" + cidade + ", situada no estado de " + estado);
    }
}
