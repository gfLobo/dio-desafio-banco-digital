package banco;

import java.util.List;

public class Banco {

	private List<Conta> contas;

	public String getNome() {
		return "Banco DIO";
	}


	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
