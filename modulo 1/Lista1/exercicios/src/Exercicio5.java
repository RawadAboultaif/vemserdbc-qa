import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner retangulo = new Scanner(System.in);

        System.out.print("Digite o valor da base do retangulo: ");
        int baseRetangulo = retangulo.nextInt();
        retangulo.nextLine();

        System.out.print("Digite o valor da altura do retangulo: ");
        int alturaRetangulo = retangulo.nextInt();
        retangulo.nextLine();

        System.out.println("A area do retangulo eh " + baseRetangulo*alturaRetangulo + ".");
    }
}
