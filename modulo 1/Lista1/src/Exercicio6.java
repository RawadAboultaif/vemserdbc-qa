import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner votos = new Scanner(System.in);

        System.out.print("Digite o numero de eleitores do municipio: ");
        double totalVotos = votos.nextDouble();
        votos.nextLine();

        System.out.print("Digite o numero de votos brancos do municipio: ");
        double brancoVotos = votos.nextDouble();
        votos.nextLine();

        System.out.print("Digite o numero de votos nulos do municipio: ");
        double nulosVotos = votos.nextDouble();
        votos.nextLine();

        System.out.print("Digite o numero de votos validos do municipio: ");
        double validoVotos = votos.nextDouble();
        votos.nextLine();

        System.out.println(" O total de votos eh: " + (int)totalVotos + "\n \n" +
                " O total de votos brancos eh " + (brancoVotos/totalVotos)*100 + "% \n " +
                "O total de votos nulos eh " + (nulosVotos/totalVotos)*100 + "% \n " +
                "O total de votos validos eh " + (validoVotos/totalVotos)*100 + "%");

    }
}
