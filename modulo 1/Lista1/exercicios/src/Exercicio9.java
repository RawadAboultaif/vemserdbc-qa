import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner jogo = new Scanner(System.in);

        System.out.print("Digite a hora do inicio do jogo: ");
        int inicioHJogo = jogo.nextInt();
        jogo.nextLine();

        System.out.print("Digite os minutos do inicio do jogo: ");
        int inicioMJogo = jogo.nextInt();
        jogo.nextLine();

        System.out.print("Digite a hora do final do jogo: ");
        int finalHJogo = jogo.nextInt();
        jogo.nextLine();

        System.out.print("Digite os minutos do final do jogo: ");
        int finalMJogo = jogo.nextInt();
        jogo.nextLine();


        if (inicioHJogo  > finalHJogo) {
            finalHJogo += 24;
        }

        int totalminutos = (finalHJogo*60) + finalMJogo - (inicioHJogo*60) - inicioMJogo;

        int horaDoJogo = totalminutos/60;

        int minDoJogo = totalminutos % 60;

        System.out.println("Duracao total do jogo eh " + horaDoJogo +":" + minDoJogo);
    }
}
