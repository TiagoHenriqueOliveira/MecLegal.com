package br.edu.unoesc.forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class PrincipalForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpPrincipal;
	private JDesktopPane jdpPrincipal;
	private JButton jbFuncionario;
	private JButton jbCliente;
	private JButton jbOrdemServico;
	private JButton jbTipoServico;
	private JButton jbSair;
	private ClienteForm clienteForm = new ClienteForm();

	public static void main(String[] args) {
		PrincipalForm principal = new PrincipalForm();
		principal.setVisible(true);
	}
	
	public void componentesForm() {
		this.setTitle("MecLegal.com");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalForm.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 948, 628);
		
		jpPrincipal = new JPanel();
		jpPrincipal.setLayout(null);
		this.setContentPane(jpPrincipal);
		this.setLocationRelativeTo(null);
		
		jdpPrincipal = new JDesktopPane();
		jdpPrincipal.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(102, 153, 255), new Color(102, 153, 255), new Color(102, 153, 255), new Color(102, 153, 255)));
		jdpPrincipal.setBackground(new Color(240, 240, 240));
		jdpPrincipal.setBounds(90, 11, 842, 578);
		jpPrincipal.add(jdpPrincipal);
		
		jbFuncionario = new JButton("");
		jbFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbFuncionario.setToolTipText("Cadastro de Funcionários");
		jbFuncionario.setIcon(new ImageIcon(PrincipalForm.class.getResource("/br/edu/unoesc/imagens/funcionario.png")));
		jbFuncionario.setBounds(10, 173, 70, 70);
		jpPrincipal.add(jbFuncionario);
		
		jbCliente = new JButton("");
		jbCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCliente.setToolTipText("Cadastro de Clientes");
		jbCliente.setIcon(new ImageIcon(PrincipalForm.class.getResource("/br/edu/unoesc/imagens/cliente.png")));
		jbCliente.setBounds(10, 92, 70, 70);
		jpPrincipal.add(jbCliente);
		
		jbOrdemServico = new JButton("");
		jbOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbOrdemServico.setToolTipText("Agendamento de Serviços");
		jbOrdemServico.setIcon(new ImageIcon(PrincipalForm.class.getResource("/br/edu/unoesc/imagens/ordem_servico.png")));
		jbOrdemServico.setBounds(10, 11, 70, 70);
		jpPrincipal.add(jbOrdemServico);
		
		jbTipoServico = new JButton("");
		jbTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbTipoServico.setToolTipText("Cadastro de Serviços");
		jbTipoServico.setIcon(new ImageIcon(PrincipalForm.class.getResource("/br/edu/unoesc/imagens/tipo_servico.png")));
		jbTipoServico.setBounds(10, 254, 70, 70);
		jpPrincipal.add(jbTipoServico);
		
		jbSair = new JButton("");
		jbSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSair.setIcon(new ImageIcon(PrincipalForm.class.getResource("/br/edu/unoesc/imagens/sair.png")));
		jbSair.setToolTipText("Sair do Sistema");
		jbSair.setBounds(10, 519, 70, 70);
		jpPrincipal.add(jbSair);
	}
	
	public void botaoCadastrarCliente() {
		jbCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clienteForm.isVisible()) {
					clienteForm.requestFocus();
					clienteForm.setLocation(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
				} else {
					jdpPrincipal.add(clienteForm);
					clienteForm.setVisible(true);
				}
			}
		});
	}
	
	public void botaoCadastrarFuncionario() {
		jbFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	public void botaoAgendarServico() {
		jbOrdemServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	public void botaoCadastrarServico() {
		jbTipoServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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

	public PrincipalForm() {
		componentesForm();
		botaoAgendarServico();
		botaoCadastrarCliente();
		botaoCadastrarFuncionario();
		botaoCadastrarServico();
		botaoSair();
	}
}