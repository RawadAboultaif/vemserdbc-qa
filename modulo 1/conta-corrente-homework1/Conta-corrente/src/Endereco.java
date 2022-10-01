public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimirEndereco() {

      if (tipo == 1 || tipo == 2) {

          System.out.println("\n"+"----------------Endereço----------------"+"\n");

          switch (tipo) {
              case 1 -> {
                  System.out.println("Tipo: Residencial");
              }

              case 2 -> {
                  System.out.println("Tipo: Comercial");
              }

          }

          System.out.println("Logradouro: " + logradouro);
          System.out.println("Numero: " + numero);
          System.out.println("Complemento: " + complemento);
          System.out.println("Cep: " + cep);
          System.out.println("Cidade: " + cidade);
          System.out.println("Estado: " + estado);
          System.out.println("Pais: " + pais);

      }
    }
}
