import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Calculo soma = (valor, valor2) -> valor + valor2;
        Calculo multiplicacao = (valor, valor2) -> valor * valor2;


        System.out.println(soma.numero(2, 2));
        System.out.println(multiplicacao.numero(4,3));


        Function<Double, Double> multi10 = (value) -> value*10;
        Function<Double, Double> raizQuadrada = (value) -> Math.sqrt(value);

        Function<Double, Double> funcoesJuntas = multi10.andThen(raizQuadrada);


        System.out.println(multi10.apply(10.0));
        System.out.println(raizQuadrada.apply(2.0));

        System.out.println(funcoesJuntas.apply(9.0));
    }
}
