public class Banco {
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente();
        ContaCorrente c2 = new ContaCorrente();

        ContaPoupanca cp1 = new ContaPoupanca();
        ContaPoupanca cp2 = new ContaPoupanca();


        c1.getCliente().getContato()[0] = new Contato();
        c1.getCliente().getContato()[1] = new Contato();

        c1.getCliente().getEndereco()[0] = new Endereco();
        c1.getCliente().getEndereco()[1] = new Endereco();

        c2.getCliente().getContato()[0] = new Contato();
        c2.getCliente().getContato()[1] = new Contato();

        c2.getCliente().getEndereco()[0] = new Endereco();
        c2.getCliente().getEndereco()[1] = new Endereco();

        // Cliente 1
        c1.getCliente().setNome("Rawad");
        c1.getCliente().setCpf("605.735.230-02");
        // Cliente 1 ContaCorrente
        c1.setAgencia(3055);
        c1.setNumeroConta("734634-3");
        c1.setSaldo(15000);
        c1.setChequeEspecial(1500);
        // Cliente 1 ContaPoupanca
        cp1.setCliente(c1.getCliente());
        cp1.setAgencia(c1.getAgencia());
        cp1.setNumeroConta(c1.getNumeroConta()+"00");
        cp1.setSaldo(1500);

        // Cliente 1 Contato 1
        c1.getCliente().getContato()[0].setDescricao("Whatsapp");
        c1.getCliente().getContato()[0].setTelefone("984838585");
        c1.getCliente().getContato()[0].setTipo(2);
        // Cliente 1 Contato 2
        c1.getCliente().getContato()[1].setDescricao("Fixo");
        c1.getCliente().getContato()[1].setTelefone("4003-8558");
        c1.getCliente().getContato()[1].setTipo(1);
        // Cliente 1 Endereço
        c1.getCliente().getEndereco()[0].setTipo(2);
        c1.getCliente().getEndereco()[0].setLogradouro("Rua Dois");
        c1.getCliente().getEndereco()[1].setComplemento("Ap 04");
        c1.getCliente().getEndereco()[0].setNumero(322);
        c1.getCliente().getEndereco()[0].setCep("64073-092");
        c1.getCliente().getEndereco()[0].setCidade("Teresina");
        c1.getCliente().getEndereco()[0].setEstado("Piauí");
        c1.getCliente().getEndereco()[0].setPais("Brasil");
        // Cliente 1 Endereço 2
        c1.getCliente().getEndereco()[1].setTipo(1);
        c1.getCliente().getEndereco()[1].setLogradouro("Rua Nova Olinda");
        c1.getCliente().getEndereco()[1].setComplemento("Ap 03");
        c1.getCliente().getEndereco()[1].setNumero(15);
        c1.getCliente().getEndereco()[1].setCep("87403-515");
        c1.getCliente().getEndereco()[1].setCidade("Maracanaú");
        c1.getCliente().getEndereco()[1].setEstado("Ceará");
        c1.getCliente().getEndereco()[1].setPais("Brasil");

        // Cliente 2
        c2.getCliente().setNome("Bruno");
        c2.getCliente().setCpf("554.549.860-54");
        // Cliente 2 ContaCorrente
        c2.setAgencia(3055);
        c2.setNumeroConta("132494-9");
        c2.setSaldo(73468);
        c2.setChequeEspecial(4392);
        // Cliente 2 ContaPoupanca
        cp2.setCliente(c2.getCliente());
        cp2.setAgencia(c2.getAgencia());
        cp2.setNumeroConta(c2.getNumeroConta()+"00");
        cp2.setSaldo(1500);
        // Cliente 2 Contato 1
        c2.getCliente().getContato()[0].setDescricao("Whatsapp");
        c2.getCliente().getContato()[0].setTelefone("973498324");
        c2.getCliente().getContato()[0].setTipo(2);
        // Cliente 2 Contato 2
        c2.getCliente().getContato()[1].setDescricao("Fixo");
        c2.getCliente().getContato()[1].setTelefone("4234-4123");
        c2.getCliente().getContato()[1].setTipo(1);
        // Cliente 2 Endereço
        c2.getCliente().getEndereco()[0].setTipo(2);
        c2.getCliente().getEndereco()[0].setLogradouro(" Conjunto Vinícius Cansanção");
        c2.getCliente().getEndereco()[0].setComplemento("Ap 02");
        c2.getCliente().getEndereco()[0].setNumero(4843);
        c2.getCliente().getEndereco()[0].setCep("57015-420");
        c2.getCliente().getEndereco()[0].setCidade("Maceió");
        c2.getCliente().getEndereco()[0].setEstado("Alagoas");
        c2.getCliente().getEndereco()[0].setPais("Brasil");
        // Cliente 2 Endereço 2
        c2.getCliente().getEndereco()[1].setTipo(1);
        c2.getCliente().getEndereco()[1].setLogradouro("Rua Paulo Roberto");
        c2.getCliente().getEndereco()[1].setComplemento("Ap 01");
        c2.getCliente().getEndereco()[1].setNumero(34789);
        c2.getCliente().getEndereco()[1].setCep("23535-807");
        c2.getCliente().getEndereco()[1].setCidade("Rio de Janeiro");
        c2.getCliente().getEndereco()[1].setEstado("Rio de Janeiro");
        c2.getCliente().getEndereco()[1].setPais("Brasil");



        //**************** Transferencias entre contas ********************


        // Transferencia da conta 1 para a conta 2

        c1.transferir(c2, 5000);

        // Transferencia da conta 2 para a conta 1

        c2.transferir(c1, 35754);

        c2.transferir(cp2, 5000);
        cp1.transferir(c1, 500);

        // ************************ Impressão *******************************

        // Imprimindo as duas contas

        c1.imprimir();
        c2.imprimir();
        cp1.imprimir();
        cp2.imprimir();

    }
}
