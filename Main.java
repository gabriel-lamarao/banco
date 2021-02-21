package banco;

public class Main {
	public static void main(String[] args) {
		Conta c1 = new Conta("A");
		Conta c2 = new Conta("B");

		c1.deposita(100);
		c1.getDadosBancarios();
		
		System.out.println(c1.transfere(200, c2));
		c1.getDadosBancarios();
		c2.getDadosBancarios();
	}
	
}
