package banco;

public class ContaCorrente extends Conta {



	public ContaCorrente(Cliente cliente) {
		super(cliente);
		super.tipo = "CC";
	}

	@Override
	public void imprimirExtrato() {
		super.imprimirInfosComuns(super.tipo);
	}


}
