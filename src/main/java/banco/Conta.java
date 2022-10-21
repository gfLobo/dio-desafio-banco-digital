package banco;

import banco.exceptions.IllegalOperation;
import com.sun.jdi.event.ExceptionEvent;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	public String tipo;
	private static int SEQUENCIAL = 1;

	public String operacao;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) throws IllegalOperation {
		operacao = "SAQUE";

		if (saldo - valor >= 0 || valor < 0){
			saldo -= valor;
		}else {
			throw new IllegalOperation(operacao, cliente);
		}
	}

	@Override
	public void depositar(double valor) throws IllegalOperation {
		operacao = "DEPÓSITO";

		if (valor < 0){
			throw new IllegalOperation(operacao, cliente);
		}else{
			saldo += valor;
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) throws IllegalOperation {
		operacao = "TRANSFERÊNCIA";

		try{
			this.sacar(valor);
			contaDestino.depositar(valor);

		}catch (IllegalOperation e){
			throw new IllegalOperation(operacao, cliente);
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected String imprimirInfosComuns(String tipoConta) {

		return  "\n" +
				"Titular= " + this.cliente.getNome() + "\n" +
				"Agência= " + this.agencia + "\n" +
				"Conta= " + tipoConta + "\n" +
				"Número: " +  this.numero + "\n" +
				"Saldo: " + this.saldo +
				"\n";

	}

}
