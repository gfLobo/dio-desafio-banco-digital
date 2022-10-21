package banco;

public class ContaPoupanca extends Conta {




	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		super.tipo = "Poupança";

	}

	@Override
	public void imprimirExtrato() {
		super.imprimirInfosComuns(super.tipo);
	}
}
