public class Banco {
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente();
        ContaCorrente c2 = new ContaCorrente();

        c1.cliente.contato[0] = new Contato();
        c1.cliente.contato[1] = new Contato();

        c1.cliente.endereco[0] = new Endereco();
        c1.cliente.endereco[1] = new Endereco();

        c2.cliente.contato[0] = new Contato();
        c2.cliente.contato[1] = new Contato();

        c2.cliente.endereco[0] = new Endereco();
        c2.cliente.endereco[1] = new Endereco();

        // Cliente 1
        c1.cliente.nome = "Rawad";
        c1.cliente.cpf = "605.735.230-02";
        // Cliente 1 Conta
        c1.agencia = 3055;
        c1.numeroConta = "734634-3" ;
        c1.saldo = 15000;
        c1.chequeEspecial = 1500;
        // Cliente 1 Contato 1
        c1.cliente.contato[0].descricao = "Whatsapp";
        c1.cliente.contato[0].telefone = "984838585";
        c1.cliente.contato[0].tipo = 2;
        // Cliente 1 Contato 2
        c1.cliente.contato[1].descricao = "Fixo";
        c1.cliente.contato[1].telefone = "4003-8558";
        c1.cliente.contato[1].tipo = 1;
        // Cliente 1 Endereço
        c1.cliente.endereco[0].tipo = 2;
        c1.cliente.endereco[0].logradouro = "Rua Dois";
        c1.cliente.endereco[1].complemento = "Ap 04";
        c1.cliente.endereco[0].numero = 322;
        c1.cliente.endereco[0].cep = "64073-092";
        c1.cliente.endereco[0].cidade = "Teresina";
        c1.cliente.endereco[0].estado = "Piauí";
        c1.cliente.endereco[0].pais = "Brasil";
        // Cliente 1 Endereço 2
        c1.cliente.endereco[1].tipo = 1;
        c1.cliente.endereco[1].logradouro = "Rua Nova Olinda";
        c1.cliente.endereco[1].complemento = "Ap 03";
        c1.cliente.endereco[1].numero = 15;
        c1.cliente.endereco[1].cep = "87403-515";
        c1.cliente.endereco[1].cidade = "Maracanaú";
        c1.cliente.endereco[1].estado = "Ceará";
        c1.cliente.endereco[1].pais = "Brasil";

        // Cliente 2
        c2.cliente.nome = "Bruno";
        c2.cliente.cpf = "554.549.860-54";
        // Cliente 2 Conta
        c2.agencia = 3055;
        c2.numeroConta = "132494-9" ;
        c2.saldo = 73468;
        c2.chequeEspecial = 4392;
        // Cliente 2 Contato 1
        c2.cliente.contato[0].descricao = "Whatsapp";
        c2.cliente.contato[0].telefone = "973498324";
        c2.cliente.contato[0].tipo = 2;
        // Cliente 2 Contato 2
        c2.cliente.contato[1].descricao = "Fixo";
        c2.cliente.contato[1].telefone = "4234-4123";
        c2.cliente.contato[1].tipo = 1;
        // Cliente 2 Endereço
        c2.cliente.endereco[0].tipo = 2;
        c2.cliente.endereco[0].logradouro = " Conjunto Vinícius Cansanção";
        c2.cliente.endereco[0].complemento = "Ap 02";
        c2.cliente.endereco[0].numero = 4843;
        c2.cliente.endereco[0].cep = "57015-420";
        c2.cliente.endereco[0].cidade = "Maceió";
        c2.cliente.endereco[0].estado = "Alagoas";
        c2.cliente.endereco[0].pais = "Brasil";
        // Cliente 2 Endereço 2
        c2.cliente.endereco[1].tipo = 1;
        c2.cliente.endereco[1].logradouro = "Rua Paulo Roberto";
        c2.cliente.endereco[1].complemento = "Ap 01";
        c2.cliente.endereco[1].numero = 34789;
        c2.cliente.endereco[1].cep = "23535-807";
        c2.cliente.endereco[1].cidade = "Rio de Janeiro";
        c2.cliente.endereco[1].estado = "Rio de Janeiro";
        c2.cliente.endereco[1].pais = "Brasil";



        //**************** Transferencias entre contas ********************

        // Transferencia da conta 1 para a conta 2

        c1.transferir(c2, 5000);

        // Transferencia da conta 2 para a conta 1

        c2.transferir(c1, 35754);

        // ************************ Impressão *******************************

        // Imprimindo as duas contas

        c1.imprimirContaCorrente();
        c2.imprimirContaCorrente();


    }
}
