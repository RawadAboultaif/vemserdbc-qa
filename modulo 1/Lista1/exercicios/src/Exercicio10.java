import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner aluno = new Scanner(System.in);

        System.out.print("Digite seu numero de matricula: ");
        int nomeAluno = aluno.nextInt();

        System.out.println("Digite sua nota1: ");
        double nota1Aluno = aluno.nextDouble();

        System.out.println("Digite sua nota2: ");
        double nota2Aluno = aluno.nextDouble();

        System.out.println("Digite sua nota3: ");
        double nota3Aluno = aluno.nextDouble();

        System.out.println("Digite sua media dos exercicios: ");
        double mediaExercicioAluno = aluno.nextDouble();

        double mediaDeAproveitamento = (nota1Aluno + nota2Aluno*2 + nota3Aluno*3 + mediaExercicioAluno)/7;

        String conceito = "";

        if(mediaDeAproveitamento >= 9) {
            conceito = "A";
        } else if (mediaDeAproveitamento >= 7.5 && mediaDeAproveitamento < 9) {
            conceito = "B";
        } else if (mediaDeAproveitamento >= 6 && mediaDeAproveitamento < 7.5) {
            conceito = "C";
        } else if (mediaDeAproveitamento >= 4 && mediaDeAproveitamento < 6) {
            conceito = "D";
        } else {
            conceito = "E";
        }

        String resultadoFinal = "";

        if (conceito == "A" || conceito == "B" || conceito == "C") {
            resultadoFinal = "APROVADO";
        } else {
            resultadoFinal = "REPROVADO";
        }

        System.out.println("Seu numero de matricula eh" + nomeAluno + " \n " +
                "Sua nota 1 eh " + nota1Aluno + " \n " +
                "Sua nota 2 eh " + nota2Aluno + " \n " +
                "Sua nota 3 eh " + nota3Aluno + " \n " +
                "Sua media dos exercicios eh " + mediaExercicioAluno + " \n " +
                "Sua media de aproveitamento eh " + String.format("%.2f",mediaDeAproveitamento) + " \n " +
                "Seu Conceito eh " + conceito + " \n " +
                "Voce foi " + resultadoFinal );
    }
}
