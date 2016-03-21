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

public class FormPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpPrincipal;
	private JDesktopPane jdpPrincipal;
	private JButton jbFuncionario;
	private JButton jbCliente;
	private JButton jbOrdemServico;
	private JButton jbTipoServico;
	private JButton jbSair;
	private FormCliente formcliente = new FormCliente();
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
		this.setBounds(100, 100, 1260, 694);
		
		jpPrincipal = new JPanel();
		this.setContentPane(jpPrincipal);
		this.setLocationRelativeTo(null);
		jpPrincipal.setLayout(null);
		
		jdpPrincipal = new JDesktopPane();
		jdpPrincipal.setBounds(101, 11, 1138, 638);
		jdpPrincipal.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(102, 153, 255), new Color(102, 153, 255), new Color(102, 153, 255), new Color(102, 153, 255)));
		jdpPrincipal.setBackground(new Color(240, 240, 240));
		jpPrincipal.add(jdpPrincipal);
		
		jbFuncionario = new JButton("");
		jbFuncionario.setBounds(10, 173, 70, 70);
		jbFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbFuncionario.setToolTipText("Cadastro de Funcion�rios");
		jbFuncionario.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/funcionario.png")));
		jpPrincipal.add(jbFuncionario);
		
		jbCliente = new JButton("");
		jbCliente.setBounds(10, 92, 70, 70);
		jbCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCliente.setToolTipText("Cadastro de Clientes");
		jbCliente.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/cliente.png")));
		jpPrincipal.add(jbCliente);
		
		jbOrdemServico = new JButton("");
		jbOrdemServico.setBounds(10, 11, 70, 70);
		jbOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbOrdemServico.setToolTipText("Agendamento de Servi�os");
		jbOrdemServico.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/ordem_servico.png")));
		jpPrincipal.add(jbOrdemServico);
		
		jbTipoServico = new JButton("");
		jbTipoServico.setBounds(10, 254, 70, 70);
		jbTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbTipoServico.setToolTipText("Cadastro de Servi�os");
		jbTipoServico.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/tipo_servico.png")));
		jpPrincipal.add(jbTipoServico);
		
		jbSair = new JButton("");
		jbSair.setBounds(10, 580, 70, 70);
		jbSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSair.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/sair.png")));
		jbSair.setToolTipText("Sair do Sistema");
		jpPrincipal.add(jbSair);
	}
	
	public void botaoCadastrarCliente() {
		jbCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbCliente) {
					if(formcliente.isVisible()) {
						formcliente.requestFocus();
						formcliente.setLocation(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
					} else {
						jdpPrincipal.add(formcliente);
						formcliente.setVisible(true);
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
						formFuncionario.setLocation(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
					} else {
						jdpPrincipal.add(formFuncionario);
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
						formOSV.setLocation(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
					} else {
						jdpPrincipal.add(formOSV);
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
						formTipoServico.setLocation(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
					} else {
						jdpPrincipal.add(formTipoServico);
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
		setResizable(false);
		componentesForm();
		botaoAgendarServico();
		botaoCadastrarCliente();
		botaoCadastrarFuncionario();
		botaoCadastrarServico();
		botaoSair();
	}
}