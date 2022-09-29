import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner aumento = new Scanner(System.in);

        System.out.print("Digite o codigo referente ao cargo: ");
        int codigoFuncionario = aumento.nextInt();
        aumento.nextLine();

        switch (codigoFuncionario) {
            case 101 -> {
                System.out.println("O gerente recebera um aumento de 10% !! \n " +
                        "O salario antigo eh " +10000 +".\n " +
                        "O salario atual eh " + (int)(10000*1.1) + ".\n " +
                        "A diferenca do salario antigo e o atual eh " + (int)((10000*1.1)-10000)+ ".") ;
            }

            case 102 -> {
                System.out.println("O Engenheiro recebera um aumento de 20% !! \n " +
                        "O salario antigo eh " +8000 +".\n " +
                        "O salario atual eh " + (int)(8000*1.2) + ".\n " +
                        "A diferenca do salario antigo e o atual eh " + (int)((8000*1.2)-8000)+ ".");
            }

            case 103 -> {
                System.out.println("O Tecnico recebera um aumento de 30% !! \n " +
                        "O salario antigo eh " +4000 +".\n " +
                        "O salario atual eh " + (int)(4000*1.3) + ".\n " +
                        "A diferenca do salario antigo e o atual eh " + (int)((4000*1.3)-4000)+ ".");
            }

            default -> {
                System.out.println("O estagiario recebera um aumento de 40% !! \n " +
                        "O salario antigo eh " +800 +".\n " +
                        "O salario atual eh " + (int)(800*1.4) + ".\n " +
                        "A diferenca do salario antigo e o atual eh " + (int)((800*1.4)-800)+ ".");
            }
        }
    }
}
