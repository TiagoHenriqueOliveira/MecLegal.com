package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormPrincipal extends JFrame implements ActionListener {

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
		new FormPrincipal();
	}

	public FormPrincipal() {
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
		jbFuncionario.setToolTipText("Cadastro de Funcion�rios");
		jbFuncionario.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/funcionario.png")));
		jbFuncionario.addActionListener(this);
		jpPrincipal.add(jbFuncionario);

		jbCliente = new JButton("");
		jbCliente.setBounds(90, 11, 70, 70);
		jbCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCliente.setToolTipText("Cadastro de Clientes");
		jbCliente.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/cliente.png")));
		jbCliente.addActionListener(this);
		jpPrincipal.add(jbCliente);

		jbOrdemServico = new JButton("");
		jbOrdemServico.setBounds(10, 11, 70, 70);
		jbOrdemServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbOrdemServico.setToolTipText("Agendamento de Servi�os");
		jbOrdemServico.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/ordem_servico.png")));
		jbOrdemServico.addActionListener(this);
		jpPrincipal.add(jbOrdemServico);

		jbTipoServico = new JButton("");
		jbTipoServico.setBounds(250, 11, 70, 70);
		jbTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbTipoServico.setToolTipText("Cadastro de Serv�os");
		jbTipoServico.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/tipo_servico.png")));
		jbTipoServico.addActionListener(this);
		jpPrincipal.add(jbTipoServico);

		jbSair = new JButton("");
		jbSair.setBounds(330, 11, 70, 70);
		jbSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSair.setIcon(new ImageIcon(FormPrincipal.class.getResource("/br/edu/unoesc/imagens/sair.png")));
		jbSair.setToolTipText("Sair do Sistema");
		jbSair.addActionListener(this);
		jpPrincipal.add(jbSair);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/*jbSair*/ if (e.getSource() == jbSair) {
			System.exit(0);			
/*jbTipoServico*/} else if (e.getSource() == jbTipoServico) {
			if (formTipoServico.isVisible()) {
				formTipoServico.requestFocus();
			} else {
				formTipoServico = new FormTipoServico();
				formTipoServico.setVisible(true);
			}			
/*jbOrdemServico*/} else if (e.getSource() == jbOrdemServico){
			if (formOSV.isVisible()) {
				formOSV.requestFocus();
			} else {
				formOSV = new FormOSV();
				formOSV.setVisible(true);
			}			
/*jbFuncionario*/} else if(e.getSource() == jbFuncionario){
			if (formFuncionario.isVisible()) {
				formFuncionario.requestFocus();
			} else {
				formFuncionario = new FormFuncionario();
				formFuncionario.setVisible(true);
			}
/*jbCliente*/}else if (e.getSource() == jbCliente) {
			if (formCliente.isVisible()) {
				formCliente.requestFocus();
			} else {
				formCliente = new FormCliente();
				formCliente.setVisible(true);
			}
		}
	}//Final do actionPerformed
}