import java.util.*;
import static java.util.stream.Collectors.toMap;

public class Stream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro Paulo", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Enzo", 2350, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        //1- listar todas as pessoas
        lista.stream()
               .forEach(pessoa -> System.out.println(pessoa));

        //2- filtrar todas as pessoas com salario maior do que 5 mil (filter)
        List<Pessoa> ganhaMaisQueCincoMil = lista.stream()
                .filter(pessoa -> pessoa.getSalario() > 5000)
                .toList();
        System.out.println(ganhaMaisQueCincoMil);

        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente (filter, sorted)
        List<Pessoa> desenvolvedorPorSalario = lista.stream()
                .filter(pessoa -> pessoa.getCargo().equalsIgnoreCase("Desenvolvedor"))
                .sorted(Comparator.comparing(Pessoa::getSalario))
                .toList();
        System.out.println(desenvolvedorPorSalario);

        //4- fazer a média salarial de todos
        double media = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble();
        System.out.println(media);

        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
        boolean alguemGanhaMaisQueVinteMil = lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() > 20000);
        if(alguemGanhaMaisQueVinteMil) {
            System.out.println("Alguem ganha mais que vinte mil reais.");
        } else {
            System.out.println("Ninguem ganha mais que vinte mil reais.");
        }


        //6- retornar uma lista de todos os ids das pessoas
        List<Integer> listaId = lista.stream()
                .map(pessoa -> pessoa.getId())
                .toList();
        System.out.println(listaId);

        //7- criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto
        List<Salario> listaIdSalario = lista.stream()
                .map(pessoa -> new Salario(pessoa.getId(), pessoa.getSalario()))
                .toList();
        System.out.println(listaIdSalario);


       //8- retornar um HashMap (estrutura de dados, e não uma função map) contendo os ids e os nomes dos colaboradores
        HashMap<Integer, String> map = new HashMap<>();
                lista.stream()
                   .forEach(pessoa -> map.put(pessoa.getId(), pessoa.getNome()));

        System.out.println(map);

        //9- com o mapa da 8, retornar o nome com o id=2
        System.out.println(map.get(2));

        //10- verificar se tem alguém que contenha o nome "Paulo" (containsignorecase) na lista e retornar o primeiro elemento que encontrar (findFirst).
        Optional<Pessoa> possivelPessoa = lista.stream()
                .filter(pessoa -> pessoa.getNome().toLowerCase().contains("paulo"))
                .findFirst();
        System.out.println(possivelPessoa);


        //    Imprimir o nome e salário dessa pessoa
//        possivelPessoa.ifPresent(System.out.println(possivelPessoa));
        if(possivelPessoa.isPresent()) {
            System.out.println("Nome: " + possivelPessoa.get().getNome());
            System.out.println("Salario: R$"+possivelPessoa.get().getSalario());
        }
    }

    static class Salario {
        private int id;
        private double salario;

        public Salario(int id, double salario) {
            this.id = id;
            this.salario = salario;
        }

        @Override
        public String toString() {
            return "Salario{" +
                    "id=" + id +
                    ", salario=" + salario +
                    '}';
        }
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        @Override
        public String toString() {
            return "Pessoa{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", salario=" + salario +
                    ", cargo='" + cargo + '\'' +
                    '}';
        }

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }
    }
}