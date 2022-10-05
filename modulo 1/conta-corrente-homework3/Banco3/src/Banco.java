import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Banco {
    public static void main(String[] args) {

        Contato contato1c1 = new Contato("Whatsapp", "984838585", 2);
        Contato contato2c1 = new Contato("Fixo", "4003-8558", 1);
        Endereco endereco1c1 = new Endereco(2, "Rua dois", 304, "Ap 04", "64073-092", "Teresina", "Piaui", "Brasil");
        Endereco endereco2c1 = new Endereco(1, "Rua Nova Olinda", 15, "Ap 03", "87403-515", "Maracanaú", "Ceará", "Brasil");

        Contato contato1c2 = new Contato("Whatsapp", "973498324", 2);
        Contato contato2c2 = new Contato("Fixo", "4234-4123", 1);
        Endereco endereco1c2 = new Endereco(2, "Conjunto Vinícius Cansanção", 4843, "Ap 02", "57015-420", "Maceió", "Alagoas", "Brasil");
        Endereco endereco2c2 = new Endereco(1, "Rua Paulo Roberto", 34789, "Ap 01", "23535-807", "Rio de Janeiro", "Rio de Janeiro", "Brasil");


        Cliente c1 = new Cliente("Rawad", "605.735.230-02", Arrays.asList(contato1c1,contato2c1), Arrays.asList(endereco1c1, endereco2c1));
        Cliente c2 = new Cliente("Bruno", "605.735.230-02", Arrays.asList(contato1c2,contato2c2), Arrays.asList(endereco1c2, endereco2c2));

        ContaCorrente cc1 = new ContaCorrente(c1, "734634-3", 3055, 15000, 1500 );
        ContaPagamento cpag1 = new ContaPagamento(c1, "734634-32", 4212, 32234);
        ContaPoupanca cp2 = new ContaPoupanca(c2, "132494-9", 3022, 73468 );

        cc1.transferir(cpag1, 4367);
        cpag1.transferir(cp2, 3234);
        cp2.transferir(cc1, 3843);

        cc1.depositar(1000);
        cpag1.depositar(4232);
        cp2.depositar(2132);

        cc1.sacar(3252);
        cpag1.sacar(4532);
        cp2.sacar(2315);


        cc1.imprimir();
        cpag1.imprimir();
        cp2.imprimir();

    }
}
