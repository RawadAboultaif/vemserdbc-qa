public class Exercicio4 {
    public static void main(String[] args) {
        int varA = 10;
        int varB = 20;

        int varC = varA;

        varA = varB;
        varB = varA;

        System.out.println("Variavel A é " + varA + " e a variavel B é " + varB);
    }
}
