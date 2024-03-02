package br.edu.senaisp.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.dao.FuncionarioDao;
import br.edu.senaisp.edu.util.FuncionarioLog;
import br.edu.senaisp.model.Funcionario;
import br.edu.senaisp.view.FuncionarioDetView;
import br.edu.senaisp.view.FuncionarioView;

public class FuncionarioController {

	public static void main(String[] args) {
		//FuncionarioDetView funcV = new FuncionarioDetView();
		//funcV.show();
		
		FuncionarioView func = new FuncionarioView();
		func.show();
		
		Funcionario f1 = new Funcionario(2000L, "Felipe", "300.200.100-80");
		Funcionario f2 = new Funcionario(2500L, "Roberto", "111.111.111-11");
		Funcionario f3 = new Funcionario(2300L, "Gilberto", "222.222.222-22");
		Funcionario f4 = new Funcionario(2400L, "Allany", "333.333.333-33");
		Funcionario f5 = new Funcionario(2700L, "Walter White", "444.444.444-44");
		
		List<Funcionario> lista = new ArrayList<Funcionario>();
		lista.add(f1);
		lista.add(f2);
		lista.add(f3);
		lista.add(f4);
		lista.add(f5);
		
		FuncionarioDao funDao = new FuncionarioDao();
		try {
			funDao.gravarFuncionario(lista);
			FuncionarioLog.escrever("Tudo certo.");
		} catch (Exception e) {
			FuncionarioLog.escrever("Erro ao liberar recurso: " + e.getMessage());
		}
		
		List<Funcionario> lerLista = new ArrayList<Funcionario>();
		lerLista = funDao.lerFuncionario();
		
		for (Funcionario f : lerLista) {
			System.err.println("[" + f.getId() + "] "
					+ "[" + f.getNome() + "] "
					+ "[" + f.getCpf() + "]");
		}
		
	}

}
