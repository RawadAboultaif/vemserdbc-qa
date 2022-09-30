import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite a hora do inicio do jogo: ");
        int inicioHoraJogo = leitor.nextInt();
        leitor.nextLine();

        System.out.print("Digite os minutos do inicio do jogo: ");
        int inicioMinutosJogo = leitor.nextInt();
        leitor.nextLine();

        System.out.print("Digite a hora do final do jogo: ");
        int finalHoraJogo = leitor.nextInt();
        leitor.nextLine();

        System.out.print("Digite os minutos do final do jogo: ");
        int finalMinutosJogo = leitor.nextInt();
        leitor.nextLine();

        // O calculo esta correto !!


        if (inicioHoraJogo  > finalHoraJogo) {
            finalHoraJogo += 24;
        }

        int totalMinutos = (finalHoraJogo*60) + finalMinutosJogo - (inicioHoraJogo*60) - inicioMinutosJogo;

        int duracaoJogoHora = totalMinutos/60;

        int duracaoJogoMinutos = totalMinutos % 60;

        System.out.println("Duracao total do jogo é " + duracaoJogoHora +"Horas e " + duracaoJogoMinutos + "Minutos.");
    }
}
