import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o cargo do funcionario: ");
        String codigoFuncionario = leitor.nextLine();


        switch (codigoFuncionario.toLowerCase()) {
            case "gerente" -> {
                System.out.print("Digite o salario do funcionario: ");
                double salarioFuncionario = leitor.nextDouble();
                System.out.println("O gerente recebera um aumento de 10% !! \n " +
                        "O salario antigo eh " +salarioFuncionario +"\n " +
                        "O salario atual eh " + (salarioFuncionario*1.1) + "\n " +
                        "A diferenca do salario antigo e o atual eh " + ((salarioFuncionario*1.1)-salarioFuncionario)) ;
            }

            case "engenheiro" -> {
                System.out.print("Digite o salario do funcionario: ");
                double salarioFuncionario = leitor.nextDouble();
                System.out.println("O Engenheiro recebera um aumento de 20% !! \n " +
                        "O salario antigo eh " +salarioFuncionario +"\n " +
                        "O salario atual eh " + (salarioFuncionario*1.2) + "\n " +
                        "A diferenca do salario antigo e o atual eh " + ((salarioFuncionario*1.2)-salarioFuncionario));
            }

            case "tecnico" -> {
                System.out.print("Digite o salario do funcionario: ");
                double salarioFuncionario = leitor.nextDouble();
                System.out.println("O Tecnico recebera um aumento de 30% !! \n " +
                        "O salario antigo eh " +salarioFuncionario +"\n " +
                        "O salario atual eh " + (salarioFuncionario*1.3) + "\n " +
                        "A diferenca do salario antigo e o atual eh " + ((salarioFuncionario*1.3)-salarioFuncionario));
            }

            default -> {
                System.out.print("Digite o salario do funcionario: ");
                double salarioFuncionario = leitor.nextDouble();
                System.out.println("O funcionario recebera um aumento de 40% !! \n " +
                        "O salario antigo eh " +salarioFuncionario +"\n " +
                        "O salario atual eh " + (salarioFuncionario*1.4) + "\n " +
                        "A diferenca do salario antigo e o atual eh " + ((salarioFuncionario*1.4)-salarioFuncionario));
            }
        }
    }
}
