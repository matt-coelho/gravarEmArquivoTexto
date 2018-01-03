package pkgArquivoTexto;


public class RegistroConta {
	private String nome;
	private String sobreNome;
	private double saldo;

		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getSobreNome() {
			return sobreNome;
		}
		public void setSobreNome(String sobreNome) {
			this.sobreNome = sobreNome;
		}
		public double getSaldo() {
			return saldo;
		}
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
	public RegistroConta(){
		this(0,"","",0.0);//chama construtor com 4 argumentos
	}
	public RegistroConta(int ct,String nom, String sn, double sal){
		setConta(ct);
		setNome(nom);
		setSobreNome(sn);
		setSaldo(sal);
	}
	private int conta;
	public int getConta(){
		return conta;
	}
	public void setConta(int conta){
		this.conta=conta;
	}
}
