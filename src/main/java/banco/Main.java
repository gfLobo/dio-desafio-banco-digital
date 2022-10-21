package banco;

import banco.exceptions.IllegalOperation;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IllegalOperation {
		Cliente venilton = new Cliente();
		Banco banco = new Banco();
		ArrayList<Conta> contas = new ArrayList<>();

		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		contas.add(cc);
		contas.add(poupanca);
		banco.setContas(contas);


		cc.depositar(100);
		cc.transferir(100, poupanca);

		System.out.println(banco.getNome());
		for (int i = 0; i < banco.getContas().size(); i++) {
			System.out.println(banco.getContas().get(i).imprimirInfosComuns(banco.getContas().get(i).tipo));
		}
		

	}

}
