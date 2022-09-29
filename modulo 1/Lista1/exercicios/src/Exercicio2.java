import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        System.out.println("Escolha um destes estados  \n \n 1- Minas Gerais" +
                " \n 2- Sao Paulo \n 3- Parana");
        System.out.print("Digite o numero do estado: ");

        Scanner escolhaEstado = new Scanner(System.in);
        int estado = escolhaEstado.nextInt();

        switch(estado) {
            case 1 -> {
                System.out.println("Escolha uma destas cidades  \n \n " +
                        "1- Belo Horizonte \n " +
                        "2- Ouro Preto ");
                System.out.print("Digite o numero da cidade: ");

                int cidade = escolhaEstado.nextInt();

                switch (cidade) {
                    case 1 -> {
                        System.out.println("\n" +  "População estimada [2021]\t\n" +
                                "2.530.701 pessoas  \n" +
                                "População no último censo [2010]\t\n" +
                                "2.375.151 pessoas  \n" +
                                "Densidade demográfica [2010]\t\n" +
                                "7.167,00 hab/km² ");
                    }

                    case 2 -> {
                        System.out.println();
                        System.out.println("\n" + "População estimada [2021]\t\n" +
                                "74.824 pessoas  \n" +
                                "População no último censo [2010]\t\n" +
                                "70.281 pessoas  \n" +
                                "Densidade demográfica [2010]\t\n" +
                                "56,41 hab/km²  ");
                    }

                    default -> {
                        System.out.println("Numero digitado incorreto !!");
                    }
                }
            }

            case 2 -> {
                System.out.println("Escolha uma destas cidades  \n \n " +
                        "1- Sao Paulo \n " +
                        "2- Sao Bernando do Campo ");
                System.out.print("Digite o numero da cidade: ");

                int cidade = escolhaEstado.nextInt();

                switch (cidade) {
                    case 1 -> {
                        System.out.println("\n" + "População estimada [2021]\t\n" +
                                "46.649.132 pessoas  \n" +
                                "População no último censo [2010]\t\n" +
                                "41.262.199 pessoas  \n" +
                                "Densidade demográfica [2010]\t\n" +
                                "166,23 hab/km²  \n" +
                                "Total de veículos [2021]\t\n" +
                                "31.455.473 veículos  ");
                    }

                    case 2 -> {
                        System.out.println("\n" + "População estimada [2021]\t\n" +
                                "849.874 pessoas  \n" +
                                "População no último censo [2010]\t\n" +
                                "765.463 pessoas  \n" +
                                "Densidade demográfica [2010]\t\n" +
                                "1.869,36 hab/km² ");
                    }

                    default -> {
                        System.out.println("Numero digitado incorreto !!");
                    }
                }
            }

            case 3 -> {
                System.out.println("Escolha uma destas cidades  \n \n " +
                        "1- Curitiba \n " +
                        "2- Foz do iguacu ");
                System.out.print("Digite o numero da cidade: ");

                int cidade = escolhaEstado.nextInt();

                switch (cidade) {
                    case 1 -> {
                        System.out.println("\n" + "População estimada [2021]\t\n" +
                                "1.963.726 pessoas  \n" +
                                "População no último censo [2010]\t\n" +
                                "1.751.907 pessoas  \n" +
                                "Densidade demográfica [2010]\t\n" +
                                "4.027,04 hab/km² ");
                    }

                    case 2 -> {
                        System.out.println("\n" + "População estimada [2021]\t\n" +
                                "257.971 pessoas  \n" +
                                "População no último censo [2010]\t\n" +
                                "256.088 pessoas  \n" +
                                "Densidade demográfica [2010]\t\n" +
                                "414,58 hab/km²  ");
                    }

                    default -> {
                        System.out.println("Numero digitado incorreto !!");
                    }
                }
            }

            default -> {
                System.out.println("Numero digitado incorreto !!");
            }
        }
    }
}
