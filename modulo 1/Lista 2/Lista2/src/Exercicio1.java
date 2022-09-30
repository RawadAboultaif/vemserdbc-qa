import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner produto = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nomeProduto = produto.nextLine();

        System.out.print("Digite o valor do produto: ");
        double valorProduto = produto.nextDouble();
        produto.nextLine();

        System.out.println(" \n \n" + " Produto: " + nomeProduto + " \n " +
                "Preço R$: " + valorProduto + " \n " +
                "Promoção: " + nomeProduto + " \n \n " +
                "-----------------------------");

        for (int i = 1; i <= 10; i++) {
            float desconto = (float) (1-(i*0.05));
            float precoFinal = (float) (valorProduto*desconto);
            double valorTotal = Math.round((precoFinal*i) * 10.0) / 10.0;

            System.out.println("   " + i +" x R$ " + precoFinal + " = R$ " + valorTotal );
        }

    }
}
