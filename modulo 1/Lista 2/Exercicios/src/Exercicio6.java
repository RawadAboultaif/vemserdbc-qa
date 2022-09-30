public class Exercicio6 {
    public static void main(String[] args) {
        double[][] alunosVsDisciplinas = {
                {8, 9, 10, 10},
                {8, 9, 10, 6},
                {8, 5, 5, 7},
                {3, 6, 10, 9},
                {6, 9, 6, 10}
        };

        double mediaDisciplinas = 0;
        double somaTodasMediasDisciplinas = 0;
        int disciplinas = 1;

        for (int i = 0; i < alunosVsDisciplinas.length; i++) {
            for (int j = 0; j < alunosVsDisciplinas.length - 1; j++) {
                mediaDisciplinas += (alunosVsDisciplinas[i][j]) / (alunosVsDisciplinas.length - 1);
            }
            System.out.println("Media da disciplina " + disciplinas + " é : " + mediaDisciplinas);
            somaTodasMediasDisciplinas += mediaDisciplinas;
            mediaDisciplinas = 0;
            disciplinas += 1;
        }


        double mediaTodasDiscplinas = somaTodasMediasDisciplinas/(alunosVsDisciplinas.length);

        System.out.println("\n " + "Media de todas as disciplinas é " + mediaTodasDiscplinas);
    }
}
