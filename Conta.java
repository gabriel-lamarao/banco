package banco;

public class Conta {
	private Pessoa nome;
	private Data dataAbertura;
	private long numero; // Criar uma classe que gere numeros inteiros
	private double saldo;
	private double limite;
	private String tipo;
	private static int totalDeContas;
	private int id = totalDeContas;
	private double divida;
	
	// Construtor Padrão
	Conta(){
		this.limite = 1000;
		this.id +=1;
		this.numero = id;
		Conta.totalDeContas += 1;
		this.tipo = "corrente";
		this.dataAbertura = new Data();
	}
	// Construtor com nome
	Conta(String nome){
		this.limite = 1000;
		this.id +=1;
		this.numero = id;
		Conta.totalDeContas += 1;
		this.tipo = "corrente";
		this.dataAbertura = new Data();
		this.nome = new Pessoa();
		this.nome.setNome(nome);
	}
	
	public String deposita(double quantidade) {
		if(quantidade <= 0 ) {
			return "Valor invalido!";
		}else {
			this.saldo = quantidade;
			return "Deposito realizado";
		}
	}
	
	public String transfere(double quantidade, Conta conta) {
		if(quantidade <= 0) {
			return "Valor invalido";
		}
		if(quantidade > saldo) {
			if(quantidade > saldo + limite) {
				return "Saldo insuficiente";
			}else {
				sacaLimite(quantidade);
				conta.deposita(quantidade);
				return "Transferencia realizada com o saldo do limite";
			}
		}
		else {
			this.saldo = this.saldo - quantidade;
			conta.saldo = quantidade;
			return "Transferencia realizada com sucesso!";
		}
	}
	
	public String saca(double quantidade) {
		if(quantidade <=0) {
			return "Valor incorreto";
		}
		if(quantidade > saldo) {
			if(quantidade > saldo + limite) {
				return "Saldo insuficiente";
			}else {
				sacaLimite(quantidade);
				return "Saque realizado com o saldo do limite";
			}
		}else {
			this.saldo = saldo - quantidade;
			return "Saque realizado!";
		}
	}
	
	private boolean sacaLimite(double quantidade) {
		this.limite += this.saldo;
		this.saldo = 0;
		this.limite -= quantidade;
		this.divida = this.limite - 1000;
		return true;
	}
	
	public double calculaRendimento() {
		double rendimento = this.saldo * 0.1;
		return rendimento;
	}
	
	public void getDadosBancarios() {
		System.out.println("Id: "+ id);
		System.out.println("Nome: "+ nome.getNome());
		System.out.println("Data de abertura: " + dataAbertura.getData());
		System.out.println("Tipo de Conta: "+ tipo);
		System.out.println("Numero da Conta: "+ numero);
		System.out.println("Saldo: "+ saldo);
		System.out.println("Limite disponível: "+ limite +"  Divida: "+divida);
		System.out.println("\n");
	}
}
