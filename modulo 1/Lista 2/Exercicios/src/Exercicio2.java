import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        double numeroAleatorio = Math.ceil(Math.random()*10);


        Scanner numeroUsuario = new Scanner(System.in);

        System.out.print("Adivinhe o número de 1 até 10 em que estou pensando: ");
        int numeroDigitado = numeroUsuario.nextInt();
        numeroUsuario.nextLine();


        while (numeroAleatorio != numeroDigitado) {
            if (numeroAleatorio < numeroDigitado) {
                System.out.println("O número que digitou é maior, tente novamente !!");
                numeroDigitado = numeroUsuario.nextInt();
                numeroUsuario.nextLine();
            } else {
                System.out.println("O número que digitou é menor, tente novamente !!");
                numeroDigitado = numeroUsuario.nextInt();
                numeroUsuario.nextLine();
            }
        }


            System.out.println("Parabens Você Acertou !!");

    }
}
