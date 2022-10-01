import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner numeroUsuario = new Scanner(System.in);

        System.out.println("Digite um numero para que seu amigo tente adivinhar: ");
        int numeroDigitadoPrimeiraPessoa = numeroUsuario.nextInt();

        System.out.println("Tente adivinhar o numero que seu amigo digitou: ");
        int numeroDigitadoSegundaPessoa = numeroUsuario.nextInt();
        numeroUsuario.nextLine();


        while (numeroDigitadoPrimeiraPessoa != numeroDigitadoSegundaPessoa) {
            if (numeroDigitadoPrimeiraPessoa < numeroDigitadoSegundaPessoa) {
                System.out.println("O número que digitou é maior, tente novamente !!");
                numeroDigitadoSegundaPessoa = numeroUsuario.nextInt();
                numeroUsuario.nextLine();
            } else {
                System.out.println("O número que digitou é menor, tente novamente !!");
                numeroDigitadoSegundaPessoa = numeroUsuario.nextInt();
                numeroUsuario.nextLine();
            }
        }


            System.out.println("Parabens Você Acertou !!");

    }
}
