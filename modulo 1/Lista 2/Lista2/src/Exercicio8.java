import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        int[] listaNumeros = {1,4,7,4,3,7,7,8,3,0};

        Scanner numero = new Scanner(System.in);

        System.out.print("Digite um numero: ");
        int numeroUsuario = numero.nextInt();

        int contador = 0;
        int contador1 = 0;
        int contador2 = 0;

        for(int i = 0; i < listaNumeros.length -1; i++) {
            if(numeroUsuario == listaNumeros[i]) {
                contador += 1;
            }
        }

        for(int i = 0; i < listaNumeros.length -1; i++) {
            if(numeroUsuario < listaNumeros[i]) {
                contador1 += 1;
            }
        }

        for(int i = 0; i < listaNumeros.length -1; i++) {
            if(numeroUsuario > listaNumeros[i]) {
                contador2 += 1;
            }
        }


        System.out.println("A quantidade de numeros repetidos é " + contador);
        System.out.println("A quantidade de numeros maior que o numero digitado é " + contador1);
        System.out.println("A quantidade de numeros menor que o numero digitado é " + contador2);
    }
}
