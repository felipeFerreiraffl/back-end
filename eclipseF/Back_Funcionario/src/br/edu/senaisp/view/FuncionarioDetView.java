package br.edu.senaisp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.edu.senaisp.model.Funcionario;

public class FuncionarioDetView extends JFrame{
	private Funcionario func = new Funcionario();
	
	JLabel lblId = new JLabel("Id:");
	JTextField txtId = new JTextField(null, 20);	
	JLabel lblNome = new JLabel("Nome:");
	JTextField txtNome = new JTextField(null, 20);
	JLabel lblCpf = new JLabel("Cpf:");
	JTextField txtCpf = new JTextField(null, 20);
	
	JButton btnOk = new JButton("OK");
	JButton btnFechar = new JButton("Fechar");
	
	public FuncionarioDetView() {
		this.setLayout(null);
		
		this.lblId.setBounds(50, 30, 80, 20);
		this.txtId.setBounds(80, 30, 150, 30);
		
		this.lblNome.setBounds(50, 70, 80, 20);
		this.txtNome.setBounds(100, 70, 150, 30);
		
		this.lblCpf.setBounds(50, 110, 80, 20);
		this.txtCpf.setBounds(90, 110, 150, 30);
		
		this.getContentPane().add(lblId);
		this.getContentPane().add(txtId);
		
		this.getContentPane().add(lblNome);
		this.getContentPane().add(txtNome);
		
		this.getContentPane().add(lblCpf);
		this.getContentPane().add(txtCpf);
		
		this.getContentPane().add(btnOk);
		this.getContentPane().add(btnFechar);
		
		this.setSize(700, 450);
		this.setVisible(true);
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				func.setId(Long.parseLong(txtId.getText()));
				func.setNome(txtNome.getText());
				func.setCpf(txtCpf.getText());
				
				hide();
				
			}
		
		});
	
	}
	
	
}
