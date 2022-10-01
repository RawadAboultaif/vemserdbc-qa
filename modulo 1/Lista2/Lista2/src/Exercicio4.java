import java.util.Arrays;

public class Exercicio4 {
    public static void main(String[] args) {

        int[] totalValores = new int[20];
        int[] totalValoresInvertidos = new int[20];

        int j = 0;

        for(int i = 0; i < (totalValores.length); i++) {
            totalValores[i] = i;
        }

        System.out.println(Arrays.toString(totalValores));


        for(int i = (totalValores.length) -1 ; i > 0; i--) {
            totalValoresInvertidos[(j)] = totalValores[i];
            j += 1;
        }

        System.out.println(Arrays.toString(totalValoresInvertidos));
    }
}
