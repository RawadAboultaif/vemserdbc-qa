import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner nome = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String palavra = nome.nextLine().toLowerCase();


        switch (palavra) {
            case "dog" -> {
                System.out.println("Traduzindo para o portugues = Cachorro ");
            }

            case "time" -> {
                System.out.println("Traduzindo para o portugues = Tempo ");
            }

            case "love" -> {
                System.out.println("Traduzindo para o portugues = Amor ");
            }

            case "city" -> {
                System.out.println("Traduzindo para o portugues = cidade ");
            }

            case "happy" -> {
                System.out.println("Traduzindo para o portugues = feliz ");
            }

            case "sad" -> {
                System.out.println("Traduzindo para o portugues = triste ");
            }

            case "should" -> {
                System.out.println("Traduzindo para o portugues = deveria ");
            }

            case "could" -> {
                System.out.println("Traduzindo para o portugues = poderia ");
            }

            case "cachorro" -> {
                System.out.println("Traduzindo para o ingles = Dog ");
            }

            case "tempo" -> {
                System.out.println("Traduzindo para o ingles = Time ");
            }

            case "amor" -> {
                System.out.println("Traduzindo para o ingles = Love ");
            }

            case "cidade" -> {
                System.out.println("Traduzindo para o ingles = City ");
            }

            case "feliz" -> {
                System.out.println("Traduzindo para o ingles = Happy ");
            }

            case "triste" -> {
                System.out.println("Traduzindo para o ingles = Sad ");
            }

            case "deveria" -> {
                System.out.println("Traduzindo para o ingles = Should ");
            }

            case "poderia" -> {
                System.out.println("Traduzindo para o ingles = Could ");
            }


            default -> {
                System.out.println("A palavra nao eh valida !!");
            }
        }

    }
}
