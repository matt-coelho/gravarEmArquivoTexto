package pkgArquivoTexto;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import javax.swing.*;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CriaArquivoTexto {
	private Formatter saida;
	public void abreArquivo(){
		try{
			saida = new Formatter("Cliente.txt");//abre arquivo
		}//fim try
		catch(SecurityException securityException){
			System.out.println("Voce nao possui acesso para modificar esse arquivo");
			System.exit(1);//termina programa
		}//fim catch
		catch(FileNotFoundException fileNotfoundException){
			System.out.println("Erro abrindo ou criando arquivo");
			System.exit(1);//temina programa
		}
	}//fim abreArquivo
	public void adicionarRegistro(){
		
		Scanner entrada = new Scanner(System.in);//CRIAR OBJETO DE NOME ENTRADA DA CLASSE SCANNER
		RegistroConta registro = new RegistroConta();//CRIAR OBJETO CLASSE REGISTROCONTA
		JOptionPane.showMessageDialog(null, "Para finalizar a entrada, digite o indicador "+"de final de arquivo\n"+"Quando for solicitado digite <ctrl> z");
		System.out.println("Numero conta(>0), nome, sobrenome e saldo(c/ decimal separado por virgula): ");
		while(entrada.hasNext()){
			try{
				registro.setConta(entrada.nextInt());
				registro.setNome(entrada.next());
				registro.setSobreNome(entrada.next());
				registro.setSaldo(entrada.nextDouble());
				if(registro.getConta()>0){
					saida.format("%d %s %s %.2f\n",registro.getConta(),registro.getNome(),registro.getSobreNome(),registro.getSaldo());
				}//fim if
				else{
					System.out.println("Numero conta deve ser maior que zero: ");
				}//fim else
			}//fim try
			catch(FormatterClosedException formatterClosedException){
				System.err.println("Erro ao gravar dados");
				return;
			}//fim catch
			catch(NoSuchElementException elementException){
				System.err.println("Entrada invalida. Tente novamente");
				entrada.nextLine();
			}//fim catch
			System.out.println("Numero conta (>0),nome, sobrenome e saldo (c/decimal separado por virgula): ");
		}//fim while
	
		}//fim metodo adicionar registro
	public void fechaArquivo(){
		if(saida != null)saida.close();
	}//fim metodo fechar arquivo
	
}//fim class CriaArquivoTexto
