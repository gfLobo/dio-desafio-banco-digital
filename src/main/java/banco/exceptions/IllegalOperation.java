package banco.exceptions;


import banco.Cliente;

public class IllegalOperation extends Exception{
    public String operacao;
    public Cliente cliente;


    public IllegalOperation(String operacao, Cliente cliente) {
        super("Operação não permitida");
        this.operacao = operacao;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "IllegalOperation{" +
                "Operacao='" + operacao + '\'' +
                ", Cliente=" + cliente.getNome() +
                '}';
    }


}
