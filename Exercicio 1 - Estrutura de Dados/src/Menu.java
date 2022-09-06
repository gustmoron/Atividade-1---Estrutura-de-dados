import static java.lang.Integer.*;
import static javax.swing.JOptionPane.*;

public class Menu {
		
	Lista<Conta> contas = new Lista<Conta>();
	int opcao;
	int contador = 0;
	
	
	
	public void menu() {
		String aux = "Escolha uma op��o:\n";
		aux += "1. Abrir conta\n";
		aux += "2. Realizar saque\n";
		aux += "3. Realizar deposito\n";
		aux += "4. Relat�rio de contas\n";
		aux += "5. Encerrar conta\n";
		aux += "6. Encerrar aplica��o\n";
		
		do {
			opcao = parseInt(showInputDialog(aux));
			if(opcao < 1 || opcao > 6) {
				showMessageDialog(null, "Op��o inv�lida");
			} else {
				switch(opcao) {
					case 1:
						abrirConta();
						break;
					case 2:
						saque();
						break;
					case 3:
						deposito();
						break;
					case 4:
						listarContas();
						break;
					case 5:
						removerConta();
						break;
				}
			}
		} while(opcao != 6);
	}
		
	public void saque() {
		Conta contacpf = new Conta(parseInt(showInputDialog("Digite o CPF: ")));
		
		if (contas.search(contacpf) != null) {
			double vsaque = Double.parseDouble(showInputDialog(
					"Saldo dispon�vel: " + contas.search(contacpf).info.saldo + "\n Informe o valor do saque: "));
			
			if (vsaque <= 0) {
				showMessageDialog(null, "Valor inv�lido");
			} else if (vsaque < contas.search(contacpf).info.saldo) {
				contas.search(contacpf).info.saldo -= vsaque;
				
				showMessageDialog(null, "Valor retirado com sucesso");
			} else {
				showMessageDialog(null, "N�o � poss�vel retirar esse valor (valor de saque invalido)");
			}
		}else {
			showMessageDialog(null, "Essa conta n�o existe (cpf invalido).");
		}
	}
	
	public void deposito() {
		Conta contacpf = new Conta(parseInt(showInputDialog("Digite o CPF: ")));
		
		if (contas.search(contacpf) != null) {
			double depositar = Double.parseDouble(showInputDialog("Informe o valor do deposito: "));
			
			if (depositar > 0) {
				contas.search(contacpf).info.saldo += depositar;
				
				showMessageDialog(null, "Valor depositado com sucesso.");
			} else {
				showMessageDialog(null, "N�o � poss�vel depositar esse valor (valor de deposito invalido)");
			}
		} else {
			showMessageDialog(null, "Essa conta n�o existe (cpf invalido).");
		}
	}
	
	public void listarContas() {
		String aux = "";
		int cont = 0;
	
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if (contas.search(new Conta(i)) != null) {
				aux += contas.search(new Conta(i)).info.toString() + "\n";
				cont++;
			}
			
			if(cont == contador) {
				break;
			}
		}
	
	showMessageDialog(null, "Existem as seguintes contas: \n" + aux);	
	}
	
	public void removerConta() {
		Conta contacpf = new Conta(parseInt(showInputDialog("Digite o CPF da conta que voc� deseja apagar: ")));
		if (contas.search(contacpf) != null) {
			contas.deleteFromStart2(contacpf);
			
			showMessageDialog(null, "Conta apagada com sucesso");
			contador--;
		} else {
			showMessageDialog(null, "Conta Inexistente (CPF Invalido)");
		}
	}	
	
	
	public void abrirConta() {
		Conta contacpf = new Conta(parseInt(showInputDialog("Digite o CPF: ")));
			if (contas.search(contacpf) != null) {
				
			showMessageDialog(null, "Uma conta com este cpf j� existe");
		} else if (contacpf.cpf <= 0) {
			showMessageDialog(null, "CPF inv�lido");
		} else {
			contas.insertEnd(new Conta(contacpf.cpf, showInputDialog("Digite o nome do correntista:")));
			contador++;
		}
	}
}