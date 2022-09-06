
public class Conta {
	int cpf;
	String nome;
	double saldo;
	
	public static int contador = 0;
	
	public Conta(int cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
		this.saldo = 0;
		this.contador = contador++;
	}

	public Conta(int cpf) {
		this.cpf = cpf;
	}

	@Override
	
	public String toString() {
		return "Conta " + this.contador + "\n CPF: " + cpf + "\n Nome: " + nome + "\n Saldo: " + saldo;
	}

	public void definirSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean equals(Object obj) {
		Conta verificacao = (Conta) obj;
		return cpf == verificacao.cpf;
	}

}
