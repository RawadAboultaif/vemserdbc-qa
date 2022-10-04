public class Endereco {
    private int tipo;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

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

    // Getters and Settters

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
