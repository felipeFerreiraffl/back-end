package br.edu.senaisp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.edu.senaisp.dao.FuncionarioDao;
import br.edu.senaisp.model.Funcionario;

public class FuncionarioView extends JFrame {
	private List<Funcionario> funcs = new ArrayList<Funcionario>();
	
	JButton btnIr = new JButton("Ir");
	JLabel lblLista = new JLabel("Lista: ");
	JTextArea txtLista = new JTextArea();
	
	public FuncionarioView() {
		inicializar();
		acoes();
		
		FuncionarioDao funDao = new FuncionarioDao();
		funcs = funDao.lerFuncionario();
		
		preencherFunc();
	}
	
	// Código inicializado quando o formulário for aberto (como o tamanho da página)
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
	
	/*
	 * Código para ações disponíveis, 
	 * como abrir a página para preencher funcionários para mostrar no principal
	*/
	public void acoes() {
		btnIr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FuncionarioDetView func = new FuncionarioDetView();
				func.show();
				
				Funcionario f = func.getFunc();
				if (f != null) {
					funcs.add(f);
					FuncionarioDao fdao = new FuncionarioDao();
					try {
						fdao.gravarFuncionario(funcs);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(func, e2.getMessage());
					}
				}
				
				preencherFunc();
				
			}
		});
	}
	
	// Preenchimento da lista de funcionários
	public void preencherFunc() {
		txtLista.setText("");
		
		for (Funcionario f : funcs) {
			txtLista.append(f.getNome()	+" ["+f.getCpf()+"]");
			txtLista.append("\n");
		}
	}
}
