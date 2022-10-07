import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {



        private Cliente c1;
        ContaCorrente testeContaCorrente = new ContaCorrente(c1, "734634-3", 3055, 15000, 1500 );
        ContaPagamento testeContaPagamento = new ContaPagamento(c1, "734634-32", 4212, 32234);
        ContaPoupanca testeContaPoupanca = new ContaPoupanca(c1, "132494-9", 3022, 73468 );

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        testeContaCorrente.setSaldo(1000);
        double valorSaque = 50;


        boolean retorno = testeContaCorrente.sacar(valorSaque);


        assertFalse(retorno);


    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        testeContaPoupanca.setSaldo(10000);
        double valorSaque = 1500;

        boolean retorno = testeContaPoupanca.sacar(valorSaque);

        assertTrue(retorno);
        assertEquals(8500, testeContaPoupanca.getSaldo());



    }
}
