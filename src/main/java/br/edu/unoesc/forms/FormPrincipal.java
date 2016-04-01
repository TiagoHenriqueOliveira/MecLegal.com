package br.edu.unoesc.forms;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel jpPrincipal = new JPanel(null);
	private JButton jbFuncionario, jbCliente, jbOrdemServico, jbTipoServico, jbSair;
	private FormCliente formCliente = new FormCliente();
	private FormFuncionario formFuncionario = new FormFuncionario();
	private FormTipoServico formTipoServico = new FormTipoServico();
	private FormOSV formOSV = new FormOSV();

	public static void main(String[] args) {
		new FormPrincipal();
	}

	public FormPrincipal() {
		this.setTitle("MecLegal.com");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 415, 121);
		this.setResizable(false);
		this.setContentPane(jpPrincipal);
		this.setLocation(MAXIMIZED_HORIZ, MAXIMIZED_VERT);

		jbFuncionario = new JButton();
		jbFuncionario.setBounds(170, 11, 70, 70);
		jbFuncionario.setToolTipText("Cadastro de Funcion�rios");
		jbFuncionario.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/funcionario.png")));
		jbFuncionario.addActionListener(this);
		jpPrincipal.add(jbFuncionario);

		jbCliente = new JButton();
		jbCliente.setBounds(90, 11, 70, 70);
		jbCliente.setToolTipText("Cadastro de Clientes");
		jbCliente.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/cliente.png")));
		jbCliente.addActionListener(this);
		jpPrincipal.add(jbCliente);

		jbOrdemServico = new JButton();
		jbOrdemServico.setBounds(10, 11, 70, 70);
		jbOrdemServico.setToolTipText("Agendamento de Servi�os");
		jbOrdemServico.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/ordem_servico.png")));
		jbOrdemServico.addActionListener(this);
		jpPrincipal.add(jbOrdemServico);

		jbTipoServico = new JButton();
		jbTipoServico.setBounds(250, 11, 70, 70);
		jbTipoServico.setToolTipText("Cadastro de Serv�os");
		jbTipoServico.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/tipo_servico.png")));
		jbTipoServico.addActionListener(this);
		jpPrincipal.add(jbTipoServico);
		
		jbSair = new JButton();
		jbSair.setBounds(330, 11, 70, 70);
		jbSair.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/sair.png")));
		jbSair.setToolTipText("Sair do Sistema");
		jbSair.addActionListener(this);
		jpPrincipal.add(jbSair);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* jbSair */ if (e.getSource() == jbSair) {
			System.exit(0);
			/* jbTipoServico */} else if (e.getSource() == jbTipoServico) {
			formTipoServico.setVisible(true);
			formTipoServico.requestFocus();
			/* jbOrdemServico */} else if (e.getSource() == jbOrdemServico) {
			formOSV.setVisible(true);
			formOSV.requestFocus();
			/* jbFuncionario */} else if (e.getSource() == jbFuncionario) {
			formFuncionario.setVisible(true);
			formFuncionario.requestFocus();
			/* jbCliente */} else if (e.getSource() == jbCliente) {
			formCliente.setVisible(true);
			formCliente.requestFocus();
		}
	}// Final do actionPerformed
}