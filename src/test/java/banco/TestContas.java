package banco;

import banco.exceptions.IllegalOperation;

import org.junit.*;

public class TestContas {

    public static Cliente cliente = new Cliente();
    public static final  Cliente clienteDeposito = new Cliente();
    public static final Conta contaDeposito = new ContaCorrente(clienteDeposito);



    @BeforeClass
    public static void conexao(){
        System.out.println("Conectando ao banco...");
        clienteDeposito.setNome("Adalberto Farias");
    }

    @AfterClass
    public static void checkout(){

        System.out.println("Conta para deposito: ");
        System.out.println(contaDeposito.imprimirInfosComuns(contaDeposito.tipo));
        System.out.println("Desconectando ao banco...");
    }


    @Test
    public void contaPoupanca() throws IllegalOperation {
        cliente.setNome("Gustavo");

        Conta conta = new ContaPoupanca(cliente);

        /*
        * Saque incorreto
        * */
        Assert.assertThrows(
                IllegalOperation.class,
                () -> conta.sacar(5000));

        /*
         * Transferência incorreta
         * */
        Assert.assertThrows(
                IllegalOperation.class,
                () -> conta.transferir(5000,contaDeposito));


        /*
        * Operações:
        * */
        conta.depositar(100);
        conta.transferir(50,contaDeposito);

        Assume.assumeTrue(conta.saldo == 50 && contaDeposito.saldo == 50);

        System.out.println("Conta Operacional:");
        System.out.println(conta.imprimirInfosComuns(conta.tipo));

    }

    @Test
    public void contaCorrente() throws IllegalOperation {
        cliente.setNome("Augusto");

        Conta conta = new ContaCorrente(cliente);

        /*
         * Saque incorreto
         * */
        Assert.assertThrows(
                IllegalOperation.class,
                () -> conta.sacar(5000));

        /*
         * Transferência incorreta
         * */
        Assert.assertThrows(
                IllegalOperation.class,
                () -> conta.transferir(5000,contaDeposito));


        /*
         * Operações:
         * */
        conta.depositar(1000);
        conta.transferir(500,contaDeposito);

        Assume.assumeTrue(conta.saldo == 500 && contaDeposito.saldo == 500);


        System.out.println("Conta Operacional:");
        System.out.println(conta.imprimirInfosComuns(conta.tipo));
    }
}
