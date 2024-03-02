package br.edu.senaisp.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.edu.util.FuncionarioLog;
import br.edu.senaisp.model.Funcionario;

public class FuncionarioDao {
	private String pathArquivo = "C:\\temp\\arquivo\\BancoDeDados.csv";
	
	public boolean gravarFuncionario(List<Funcionario> func) throws Exception {
		PrintWriter pw;
		try {
			pw = new PrintWriter(pathArquivo, Charset.forName("UTF-8"));

			for (Funcionario f : func) {
				pw.print(f.getId() + "; ");
				pw.print(f.getNome() + "; ");
				pw.print(f.getCpf() + "; ");
				pw.println();
			}
			
			pw.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Erro ao gravar o funcionário: " + e.getMessage());
			throw new Exception("Erro ao gravar o funcionário: " + e.getMessage());
		}
		
	}
	
	public List<Funcionario> lerFuncionario() {
		List<Funcionario> resp = new ArrayList<Funcionario>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(pathArquivo));

			String linha;
			
			Funcionario tmp;
			while ((linha = br.readLine()) != null) {

				String[] palavras = linha.split(";");
				tmp = new Funcionario();
				tmp.setId(Long.parseLong(palavras[0]));
				tmp.setNome(palavras[1]);
				tmp.setCpf(palavras[2]);
				
				resp.add(tmp);
			}
		} catch (Exception e) {
			try {
				br.close();
			} catch (Exception e1) {
				FuncionarioLog.escrever("Não liberou o recurso: " + e1.getMessage());
			}
			
		}
		
		return resp;
		
	}
}

