import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner produto = new Scanner(System.in);

        System.out.print("Digite o codigo do produto: ");
        String codigoProduto = produto.nextLine().toUpperCase();

        System.out.print("Digite a quantidade de produtos: ");
        int quantidadeProduto = produto.nextInt();


        switch (codigoProduto) {
            case "ABCD" -> {
                System.out.println("O Valor total eh: " + 5.3*quantidadeProduto);
            }

            case "XYPK" -> {
                System.out.println("O Valor total eh: " + 6*quantidadeProduto);
            }

            case "KLMP" -> {
                System.out.println("O Valor total eh: " + 3.2*quantidadeProduto);
            }

            case "QRST" -> {
                System.out.println("O Valor total eh: " + 2.5*quantidadeProduto);
            }

            default -> {
                System.out.println("Produto invalido !!");
            }
        }

    }
}
