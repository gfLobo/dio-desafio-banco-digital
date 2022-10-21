package banco;

import banco.exceptions.IllegalOperation;

public interface IConta {
	
	void sacar(double valor) throws IllegalOperation;
	
	void depositar(double valor) throws IllegalOperation;
	
	void transferir(double valor, IConta contaDestino) throws IllegalOperation;
	
	void imprimirExtrato();
}
