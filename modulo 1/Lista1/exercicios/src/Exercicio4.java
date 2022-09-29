public class Exercicio4 {
    public static void main(String[] args) {
        int varA = 10;
        int varB = 20;

        int varC = varA + varB;

        varA = varC - varA;
        varB = varC - varB;

        System.out.println("Variavel A eh " + varA + " e a variavel B eh " + varB);
    }
}
