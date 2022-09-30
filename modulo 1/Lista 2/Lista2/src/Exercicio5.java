import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        int[][] matrizAlunos = new int[5][4];

        Scanner dados = new Scanner(System.in);

        int numeroMatricula = 0;
        int mediaDeProvas = 0;
        int mediaDeTrabalhos = 0;
        int notasFinais = 0;
        int somaNotasFinais = 0;
        int maiorNotaFinal = 0;

        for (int j = 0; j < matrizAlunos.length; j++) {
            for (int i = 0; i < matrizAlunos.length; i++) {

                if (j == 0) {

                    System.out.println("Digite o numero de matricula do aluno: ");
                    numeroMatricula = dados.nextInt();

                    matrizAlunos[i][j] = numeroMatricula;
                }

                if (j == 1) {
                    System.out.println("Digite a media de provas do aluno: ");
                    mediaDeProvas = dados.nextInt();

                    matrizAlunos[i][j] = mediaDeProvas;
                }

                if (j == 2) {
                    System.out.println("Digite a media dos trabalhos do aluno: ");
                    mediaDeTrabalhos = dados.nextInt();

                    matrizAlunos[i][j] = mediaDeTrabalhos;
                }

                if (j == 3) {
                    notasFinais = (int) (matrizAlunos[i][1]*0.6 + matrizAlunos[i][2]*0.4);


                    matrizAlunos[i][j] = notasFinais;

                    somaNotasFinais += notasFinais;

                    if(notasFinais > maiorNotaFinal) {
                        maiorNotaFinal = notasFinais;
                    }
                }


            }
        }



        for (int j = 0; j < matrizAlunos.length; j++) {
            for (int i = 0; i < matrizAlunos[0].length; i++) {
                System.out.print(matrizAlunos[j][i] + " ");
            }
            System.out.println();
        }

        System.out.println("A media das nos finais é " + somaNotasFinais/5);
        System.out.println("A maior nota final é " + maiorNotaFinal);
    }
}
