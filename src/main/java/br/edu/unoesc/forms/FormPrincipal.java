package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpPrincipal;
	private JButton jbFuncionario;
	private JButton jbCliente;
	private JButton jbOrdemServico;
	private JButton jbTipoServico;
	private JButton jbSair;
	private FormCliente formCliente = new FormCliente();
	private FormFuncionario formFuncionario = new FormFuncionario();
	private FormTipoServico formTipoServico = new FormTipoServico();
	private FormOSV formOSV = new FormOSV();

	public static void main(String[] args) {
		FormPrincipal principal = new FormPrincipal();
		principal.setVisible(true);
	}
	
	public void componentesForm() {
		this.setTitle("MecLegal.com");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 415, 121);
		setResizable(false);
		
		jpPrincipal = new JPanel();
		this.setContentPane(jpPrincipal);
		this.setLocation(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
		jpPrincipal.setLayout(null);
		
		jbFuncionario = new JButton("");
		jbFuncionario.setBounds(170, 11, 70, 70);
		jbFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbFuncionario.setToolTipText("Cadastro de Funcionários");
		jbFuncionario.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/funcionario.png")));
		jpPrincipal.add(jbFuncionario);
		
		jbCliente = new JButton("");
		jbCliente.setBounds(90, 11, 70, 70);
		jbCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCliente.setToolTipText("Cadastro de Clientes");
		jbCliente.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/cliente.png")));
		jpPrincipal.add(jbCliente);
		
		jbOrdemServico = new JButton("");
		jbOrdemServico.setBounds(10, 11, 70, 70);
		jbOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbOrdemServico.setToolTipText("Agendamento de Serviços");
		jbOrdemServico.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/ordem_servico.png")));
		jpPrincipal.add(jbOrdemServico);
		
		jbTipoServico = new JButton("");
		jbTipoServico.setBounds(250, 11, 70, 70);
		jbTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbTipoServico.setToolTipText("Cadastro de Servços");
		jbTipoServico.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/tipo_servico.png")));
		jpPrincipal.add(jbTipoServico);
		
		jbSair = new JButton("");
		jbSair.setBounds(330, 11, 70, 70);
		jbSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSair.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/sair.png")));
		jbSair.setToolTipText("Sair do Sistema");
		jpPrincipal.add(jbSair);
	}
	
	public void botaoCadastrarCliente() {
		jbCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbCliente) {
					if(formCliente.isVisible()) {
						formCliente.requestFocus();
						formCliente.setLocationRelativeTo(null);
					} else {
						formCliente = new FormCliente();
						formCliente.setVisible(true);
					}
				}
			}
		});
	}
	
	public void botaoCadastrarFuncionario() {
		jbFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbFuncionario) {
					if(formFuncionario.isVisible()) {
						formFuncionario.requestFocus();
						formFuncionario.setLocationRelativeTo(null);
					} else {
						formFuncionario = new FormFuncionario();
						formFuncionario.setVisible(true);
					}
				}
			}
		});
	}
	
	public void botaoAgendarServico() {
		jbOrdemServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbOrdemServico) {
					if(formOSV.isVisible()) {
						formOSV.requestFocus();
						formOSV.setLocationRelativeTo(null);
					} else {
						formOSV = new FormOSV();
						formOSV.setVisible(true);
					}
				}
			}
		});
	}
	
	public void botaoCadastrarServico() {
		jbTipoServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbTipoServico) {
					if(formTipoServico.isVisible()) {
						formTipoServico.requestFocus();
						formTipoServico.setLocationRelativeTo(null);
					} else {
						formTipoServico = new FormTipoServico();
						formTipoServico.setVisible(true);
					}
				}
			}
		});
	}
	
	public void botaoSair() {
		jbSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbSair) {
					System.exit(0);
				}
			}
		});
	}

	public FormPrincipal() {
		componentesForm();
		botaoAgendarServico();
		botaoCadastrarCliente();
		botaoCadastrarFuncionario();
		botaoCadastrarServico();
		botaoSair();
	}
}