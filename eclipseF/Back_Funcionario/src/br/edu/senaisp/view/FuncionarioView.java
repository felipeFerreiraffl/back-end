package br.edu.senaisp.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import br.edu.senaisp.dao.FuncionarioDao;
import br.edu.senaisp.edu.util.FuncionarioLog;
import br.edu.senaisp.model.Funcionario;

public class FuncionarioView extends JFrame {
	private List<Funcionario> funcs = new ArrayList<Funcionario>();
	
	JButton btnIr = new JButton("Ir");
	JLabel lblLista = new JLabel("Lista: ");
	JTextArea txtLista = new JTextArea();
	
	public FuncionarioView() {
		inicializar();
		
		FuncionarioDao funDao = new FuncionarioDao();
		funDao.lerFuncionario();
	}
	
	public void inicializar() {
		this.setLayout(null);
		
		this.btnIr.setBounds(20, 40, 100, 30);
		this.lblLista.setBounds(30, 90, 100, 70);
		this.txtLista.setBounds(30, 130, 300, 100);
		
		this.getContentPane().add(btnIr);
		this.getContentPane().add(lblLista);
		this.getContentPane().add(txtLista);
		
		this.setSize(800, 500);
		this.setVisible(true);
		
	}
	
	public void acoes() {
		
	}
}
