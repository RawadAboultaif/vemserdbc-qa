import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner jogador = new Scanner(System.in);


        String jogadorNome = "";

        int totalJogadores = 0;

        double jogadorMaiorAltura = 0;
        int jogadorMaiorIdade = 0;
        double jogadorMaiorPeso = 0;
        double jogadorSomaAlturaDosJogadores = 0;
        double jogadorMediaAlturaDosJogadores = 0;

        String nomeJogadorMaisPesado = "";
        String nomeJogadorMaisVelho =  "";

        boolean loop = true;

        while (loop){

            System.out.print("Digite o nome do jogador: ");
            jogadorNome = jogador.nextLine();

            switch (jogadorNome.toUpperCase()) {
                case "SAIR" -> {
                    loop = false;
                }

                default -> {
                    totalJogadores += 1;

                    // Request the player hight and check who is the taller one.
                    System.out.print("Digite a altura do jogador: ");
                    double jogadorAltura = jogador.nextDouble();
                    jogador.nextLine();


                    jogadorSomaAlturaDosJogadores += jogadorAltura;

                    jogadorMediaAlturaDosJogadores = jogadorSomaAlturaDosJogadores / totalJogadores;

                    if (jogadorAltura > jogadorMaiorAltura) {
                        jogadorMaiorAltura = jogadorAltura;
                    }

                    // Request player age and check who is the older one.
                    System.out.print("Digite a idade do jogador: ");
                    int jogadorIdade = jogador.nextInt();
                    jogador.nextLine();


                    if (jogadorIdade > jogadorMaiorIdade) {
                        jogadorMaiorIdade = jogadorIdade;
                        nomeJogadorMaisVelho = jogadorNome;
                    }

                    // Request player weight and check who is the heavier one.
                    System.out.print("Digite o peso do jogador: ");
                    double jogadorPeso = jogador.nextDouble();
                    jogador.nextLine();


                    if (jogadorPeso > jogadorMaiorPeso) {
                        jogadorMaiorPeso = jogadorPeso;
                        nomeJogadorMaisPesado = jogadorNome;

                    }

                    System.out.print("Digite o nome de um novo jogador: ");
                    jogadorNome = jogador.nextLine();


                }

            }
        }




        System.out.println("Quantidade de jogadores cadastrados " + totalJogadores);
        System.out.println("Altura do maior jogador: " + jogadorMaiorAltura);
        System.out.println("Jogador mais velho: " + nomeJogadorMaisVelho);
        System.out.println("Jogador mais pesado: " + nomeJogadorMaisPesado);
        System.out.println("Média da altura de todos os jogadores " + jogadorMediaAlturaDosJogadores);


    }
}
