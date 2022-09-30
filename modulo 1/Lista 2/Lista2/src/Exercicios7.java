public class Exercicios7 {
    public static void main(String[] args) {
        double[][] listaMercados = {
                {10.9,10.8,10.9},
                {6,8,9},
                {6.7,5.8,4.9},
                {8.6,8,7.9},
                {5.6,4.8,4.9},
                {6,5.8,5.9},
                {4.2,3.8,3.9},
                {9,9,9},
                {12,15,14},
                {17,10,11}
        };

        double somaTodosValoresMercados = 0;
        double[] somaValoresPorMercado = {0, 0, 0};


        for(int j = 0; j < listaMercados[0].length; j++) {
            for(int i = 0; i < listaMercados.length; i++) {
                somaTodosValoresMercados += listaMercados[i][j];
            }

            somaValoresPorMercado[j] =  somaTodosValoresMercados;

            somaTodosValoresMercados = 0;

        }

        double mercadoMaisBarato = somaValoresPorMercado[0];

        for(int i = 0; i < somaValoresPorMercado.length; i++) {
            if(mercadoMaisBarato > somaValoresPorMercado[i]) {
                mercadoMaisBarato = somaValoresPorMercado[i];
            }
        }

        System.out.println("O Mercado mais barato é de R$ " + mercadoMaisBarato);
    }
}
