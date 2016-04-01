package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import br.edu.unoesc.dao.MongoDao;
import br.edu.unoesc.modelo.Carro;
import br.edu.unoesc.modelo.Cliente;
import br.edu.unoesc.modelo.Funcionario;
import br.edu.unoesc.modelo.MinhaEntidade;
import br.edu.unoesc.modelo.OSV;
import br.edu.unoesc.modelo.TipoServico;
import br.edu.unoesc.preencheDados.PreencheDados;
import br.edu.unoesc.validaConteudo.ConteudoAlfaNumerico;
import br.edu.unoesc.validaConteudo.ConteudoNumerico;
import br.edu.unoesc.validaConteudo.ConteudoString;

public class FormOSV extends JFrame implements PreencheDados, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel jpAgendaServico = new JPanel(null);
	private JTextField jtfBuscarNomeCliente, jtfNomeCliente, jtfCPFCliente, jtfCNPJCliente, jtfNomeVeiculo, jtfPlacaVeiculo, jtfServicoAgendado,jtfValorServico, jtfNomeFuncionario,jtfCrachaFuncionario;
	private JLabel jlBuscarNomeCliente, jlNomeCliente, jlCPFCliente, jlCNPJCliente, jlNomeVeiculo, jlPlacaVeiculo, jlServicoAgendado, jlValorServico, jlNomeFuncionario,jlCrachaFuncionario;
	private JButton jbBuscar,jbNovo, jbSalvar, jbEditar,jbCancelar, jbFechar;
	private static FormOSV formOSV;
	private FormMostraCliente formMostraCliente = new FormMostraCliente();
	private FormMostraFuncionario formMostraFuncionario = new FormMostraFuncionario();
	private FormMostraTipoServico formMostraTipoServico = new FormMostraTipoServico();
	private FormMostraCarro formMostraCarro = new FormMostraCarro();
	private FormMostraOSV formMostraOsv = new FormMostraOSV();
	private Cliente clienteOSV;
	private Carro carroOSV;
	private Funcionario funcionarioOSV;
	private TipoServico tipoServicoOSV;
	private OSV osvOSV;
	
	public void componentesFormOSV() {
		formOSV = this;
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormOSV.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setResizable(false);
		this.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setTitle("Agendamento de Serviços");
		this.setBounds(100, 100, 586, 328);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		
		jpAgendaServico.setBorder(UIManager.getBorder("PopupMenu.border"));
		jpAgendaServico.setBounds(10, 57, 560, 232);
		getContentPane().add(jpAgendaServico);
		
		jlBuscarNomeCliente = new JLabel("Buscar ordens de serviço");
		jlBuscarNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlBuscarNomeCliente.setBounds(10, 11, 300, 14);
		getContentPane().add(jlBuscarNomeCliente);
		
		jlNomeCliente = new JLabel("Nome do Cliente");
		jlNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlNomeCliente.setBounds(10, 11, 120, 14);
		jpAgendaServico.add(jlNomeCliente);
		
		jlCPFCliente = new JLabel("CPF do Cliente");
		jlCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCPFCliente.setBounds(320, 11, 100, 14);
		jpAgendaServico.add(jlCPFCliente);
		
		jlCNPJCliente = new JLabel("CNPJ do Cliente");
		jlCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCNPJCliente.setBounds(430, 11, 120, 14);
		jpAgendaServico.add(jlCNPJCliente);
		
		jlNomeVeiculo = new JLabel("Nome do Veículo");
		jlNomeVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlNomeVeiculo.setBounds(10, 57, 120, 14);
		jpAgendaServico.add(jlNomeVeiculo);
		
		jlPlacaVeiculo = new JLabel("Placa do Veículo");
		jlPlacaVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlPlacaVeiculo.setBounds(320, 57, 120, 14);
		jpAgendaServico.add(jlPlacaVeiculo);
		
		jlServicoAgendado = new JLabel("Serviço Agendado");
		jlServicoAgendado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlServicoAgendado.setBounds(10, 103, 120, 14);
		jpAgendaServico.add(jlServicoAgendado);
		
		jlValorServico = new JLabel("Valor do Serviço");
		jlValorServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlValorServico.setBounds(320, 104, 120, 14);
		jpAgendaServico.add(jlValorServico);
		
		jlNomeFuncionario = new JLabel("Nome do Funcionário");
		jlNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlNomeFuncionario.setBounds(10, 149, 140, 14);
		jpAgendaServico.add(jlNomeFuncionario);
		
		jlCrachaFuncionario = new JLabel("Crachá");
		jlCrachaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCrachaFuncionario.setBounds(320, 150, 100, 14);
		jpAgendaServico.add(jlCrachaFuncionario);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setDocument(new ConteudoString());
		jtfNomeCliente.setEditable(false);
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setToolTipText("Informar nome do cliente");
		jtfNomeCliente.setBounds(10, 26, 300, 20);
		jpAgendaServico.add(jtfNomeCliente);
		
		try {
			jtfCPFCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCPFCliente.setEditable(false);
		jtfCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCPFCliente.setBounds(320, 26, 100, 20);
		jpAgendaServico.add(jtfCPFCliente);
		
		try {
			jtfCNPJCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCNPJCliente.setEditable(false);
		jtfCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCNPJCliente.setToolTipText("");
		jtfCNPJCliente.setBounds(430, 26, 120, 20);
		jpAgendaServico.add(jtfCNPJCliente);
		
		jtfNomeVeiculo = new JTextField();
		jtfNomeVeiculo.setDocument(new ConteudoAlfaNumerico());
		jtfNomeVeiculo.setEditable(false);
		jtfNomeVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeVeiculo.setToolTipText("Informar nome do veículo");
		jtfNomeVeiculo.setBounds(10, 72, 300, 20);
		jpAgendaServico.add(jtfNomeVeiculo);
		
		try {
			jtfPlacaVeiculo = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPlacaVeiculo.setEditable(false);
		jtfPlacaVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlacaVeiculo.setToolTipText("");
		jtfPlacaVeiculo.setBounds(320, 72, 100, 20);
		jpAgendaServico.add(jtfPlacaVeiculo);
		
		jtfServicoAgendado = new JTextField();
		jtfServicoAgendado.setDocument(new ConteudoAlfaNumerico());
		jtfServicoAgendado.setEditable(false);
		jtfServicoAgendado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfServicoAgendado.setToolTipText("Informar serviço a ser executado");
		jtfServicoAgendado.setBounds(10, 118, 300, 20);
		jpAgendaServico.add(jtfServicoAgendado);
		
		jtfValorServico = new JTextField();
		jtfValorServico.setDocument(new ConteudoNumerico());
		jtfValorServico.setEditable(false);
		jtfValorServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorServico.setToolTipText("");
		jtfValorServico.setBounds(320, 118, 100, 20);
		jpAgendaServico.add(jtfValorServico);
		
		jtfNomeFuncionario = new JTextField();
		jtfNomeFuncionario.setDocument(new ConteudoString());
		jtfNomeFuncionario.setEditable(false);
		jtfNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFuncionario.setToolTipText("Informar nome do funcionário");
		jtfNomeFuncionario.setBounds(10, 164, 300, 20);
		jpAgendaServico.add(jtfNomeFuncionario);
		
		jtfCrachaFuncionario = new JTextField();
		jtfCrachaFuncionario.setDocument(new ConteudoNumerico());
		jtfCrachaFuncionario.setEditable(false);
		jtfCrachaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCrachaFuncionario.setBounds(320, 164, 50, 20);
		jpAgendaServico.add(jtfCrachaFuncionario);
		
		jtfBuscarNomeCliente = new JTextField();
		jtfBuscarNomeCliente.setDocument(new ConteudoString());
		jtfBuscarNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBuscarNomeCliente.setToolTipText("Informar nome do cliente");
		jtfBuscarNomeCliente.setBounds(10, 26, 300, 20);
		getContentPane().add(jtfBuscarNomeCliente);
		
		jbNovo = new JButton("Novo");
		jbNovo.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/novo.png")));
		jbNovo.setToolTipText("Novo cadastro da Ordem de Serviço");
		jbNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbNovo.setBounds(10, 195, 100, 25);
		jbNovo.addActionListener(this);
		jpAgendaServico.add(jbNovo);
		
		jbSalvar = new JButton("Salvar");
		jbSalvar.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/salvar.png")));
		jbSalvar.setToolTipText("Salvar cadastro da Ordem de Serviço");
		jbSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSalvar.setEnabled(false);
		jbSalvar.setBounds(120, 195, 100, 25);
		jbSalvar.addActionListener(this);
		jpAgendaServico.add(jbSalvar);
		
		jbEditar = new JButton("Editar");
		jbEditar.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/editar.png")));
		jbEditar.setToolTipText("Editar cadastro da Ordem de Serviço");
		jbEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbEditar.setEnabled(false);
		jbEditar.setBounds(230, 195, 100, 25);
		jbEditar.addActionListener(this);
		jpAgendaServico.add(jbEditar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/cancelar.png")));
		jbCancelar.setToolTipText("Cancelar cadastro da Ordem de Serviço");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setEnabled(false);
		jbCancelar.setBounds(340, 195, 100, 25);
		jbCancelar.addActionListener(this);
		jpAgendaServico.add(jbCancelar);
		
		jbFechar = new JButton("Fechar");
		jbFechar.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/fechar.png")));
		jbFechar.setToolTipText("Fechar tela de cadastro");
		jbFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbFechar.setBounds(450, 195, 100, 25);
		jbFechar.addActionListener(this);
		jpAgendaServico.add(jbFechar);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/buscar.png")));
		jbBuscar.setToolTipText("Buscar informações da Ordem de Serviço");
		jbBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbBuscar.setBounds(481, 21, 89, 25);
		jbBuscar.addActionListener(this);
		getContentPane().add(jbBuscar);
	}

	public void acionarBotaoBuscar() {
		if(formMostraOsv.isVisible()) {
			formMostraOsv.requestFocus();
			formMostraOsv.setLocationRelativeTo(null);
		} else if(jtfBuscarNomeCliente.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "É Obrigatório informar um parâmetro para pesquisa!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfBuscarNomeCliente.requestFocus();
		} else {
			formMostraOsv = new FormMostraOSV(formOSV, jtfBuscarNomeCliente.getText());
			System.out.println(jtfBuscarNomeCliente.getText());
			formMostraOsv.setVisible(true);
		}
		
	}
	
	public void acionarBotaoNovo() {
		jtfNomeCliente.requestFocus();
		jtfNomeCliente.setEditable(true);
		jtfNomeVeiculo.setEditable(true);
		jtfServicoAgendado.setEditable(true);
		jtfNomeFuncionario.setEditable(true);
		jtfNomeCliente.setText("");
		jtfCPFCliente.setText("");
		jtfCNPJCliente.setText("");
		jtfNomeVeiculo.setText("");
		jtfPlacaVeiculo.setText("");
		jtfServicoAgendado.setText("");
		jtfValorServico.setText("");
		jtfNomeFuncionario.setText("");
		jtfCrachaFuncionario.setText("");
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(false);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoSalvar() {
		jtfBuscarNomeCliente.requestFocus();
		jtfNomeCliente.setEditable(false);
		jtfNomeVeiculo.setEditable(false);
		jtfServicoAgendado.setEditable(false);
		jtfNomeFuncionario.setEditable(false);

		osvOSV = new OSV(clienteOSV, carroOSV, funcionarioOSV, tipoServicoOSV, LocalDate.now());
		MongoDao.getDAO().salvar(osvOSV);
		
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(true);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void acionarBotaoEditar() {
		jtfNomeCliente.requestFocus();
		jtfNomeCliente.setEditable(true);
		jtfNomeVeiculo.setEditable(true);
		jtfServicoAgendado.setEditable(true);
		jtfNomeFuncionario.setEditable(true);

		
		//faz procedimentos para edi��o do registro
		
		
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		carroOSV = null;
		osvOSV = null;
		clienteOSV = null;
		funcionarioOSV = null;
		tipoServicoOSV = null;
		jtfBuscarNomeCliente.requestFocus();
		jtfNomeCliente.setEditable(false);
		jtfNomeVeiculo.setEditable(false);
		jtfServicoAgendado.setEditable(false);
		jtfNomeFuncionario.setEditable(false);
		jtfNomeCliente.setText("");
		jtfCPFCliente.setText("");
		jtfCNPJCliente.setText("");
		jtfNomeVeiculo.setText("");
		jtfPlacaVeiculo.setText("");
		jtfServicoAgendado.setText("");
		jtfValorServico.setText("");
		jtfNomeFuncionario.setText("");
		jtfCrachaFuncionario.setText("");
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(false);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void buscaCliente() {
		jtfNomeCliente.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(formMostraCliente.isVisible()) {
						formMostraCliente.requestFocus();
						formMostraCliente.setLocationRelativeTo(null);
					} else if(jtfNomeCliente.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "É Obrigatório informar um parâmetro para pesquisa!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						jtfNomeCliente.requestFocus();
					} else {
						formMostraCliente = new FormMostraCliente(formOSV, jtfNomeCliente.getText());
						formMostraCliente.setVisible(true);
					}
				}
			}
		});
	}
	
	public void buscaCarro() {
		jtfNomeVeiculo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(formMostraCarro.isVisible()) {
						formMostraCarro.requestFocus();
						formMostraCarro.setLocationRelativeTo(null);
					} else if(jtfNomeVeiculo.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "É Obrigatório informar um parâmetro para pesquisa!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						jtfNomeVeiculo.requestFocus();
					} else {
						formMostraCarro = new FormMostraCarro(formOSV, clienteOSV);
						formMostraCarro.setVisible(true);
					}
				}
			}
		});
	}
	
	public void buscaServico() {
		jtfServicoAgendado.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(formMostraTipoServico.isVisible()) {
						formMostraTipoServico.requestFocus();
						formMostraTipoServico.setLocationRelativeTo(null);
					} else if(jtfServicoAgendado.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "É Obrigatório informar um parâmetro para pesquisa!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						jtfServicoAgendado.requestFocus();
					} else {
						formMostraTipoServico = new FormMostraTipoServico(formOSV, jtfServicoAgendado.getText());
						formMostraTipoServico.setVisible(true);
					}
				}
			}
		});
	}
	
	public void buscaFuncionario() {
		jtfNomeFuncionario.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(formMostraFuncionario.isVisible()) {
						formMostraFuncionario.requestFocus();
					} else if(jtfNomeFuncionario.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "É Obrigatório informar um parâmetro para pesquisa!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						jtfNomeFuncionario.requestFocus();
					} else {
						formMostraFuncionario = new FormMostraFuncionario(formOSV, jtfNomeFuncionario.getText());
						formMostraFuncionario.setVisible(true);
					}
				}
			}
		});
	}
	
	public void preencheDadosCliente(MinhaEntidade cliente) {
		clienteOSV = (Cliente)cliente;
		jtfNomeCliente.setText(clienteOSV.getNome());
		jtfCPFCliente.setText(clienteOSV.getCpf());
		jtfCNPJCliente.setText(clienteOSV.getCnpj());	
	}
	
	public void preencheDadosServico(MinhaEntidade tipoServico) {
		tipoServicoOSV = (TipoServico)tipoServico;
		jtfServicoAgendado.setText(tipoServicoOSV.getNome());
		jtfValorServico.setText(String.valueOf(tipoServicoOSV.getValor()));
	}
	public void preencheDadosCarro(MinhaEntidade carro){
		carroOSV = (Carro)carro;
		jtfNomeVeiculo.setText(carroOSV.getNome());
		jtfPlacaVeiculo.setText(carroOSV.getPlaca());
	}
	
	public void preencheDadosFuncionario(MinhaEntidade funcionario) {
		funcionarioOSV = (Funcionario)funcionario;
		jtfNomeFuncionario.setText(funcionarioOSV.getNome());
		jtfCrachaFuncionario.setText(funcionarioOSV.getCracha().toString());
	}
	
	public void preencheDadosOSV(MinhaEntidade OSVselecionada){
		this.osvOSV = (OSV) OSVselecionada;
		preencheDadosCliente(osvOSV.getCliente());
		preencheDadosServico(osvOSV.getTipoServico());
		preencheDadosCarro(osvOSV.getCarro());
		preencheDadosFuncionario(osvOSV.getFuncionario());
		jbEditar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public FormOSV() {
		componentesFormOSV();
		buscaCliente();
		buscaCarro();
		buscaFuncionario();
		buscaServico();
	}

	@Override
	public void preencherCampos(MinhaEntidade entidade) {
		if(entidade instanceof Cliente) {
			this.preencheDadosCliente(entidade);
		} else if (entidade instanceof Carro){
			preencheDadosCarro(entidade);
		}
		else if(entidade instanceof TipoServico) {
			this.preencheDadosServico(entidade);
		} else if(entidade instanceof Funcionario) {
			this.preencheDadosFuncionario(entidade);
		}
		else if (entidade instanceof OSV){
			this.preencheDadosOSV(entidade);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object acao = e.getSource();
if(acao == jbFechar){
	dispose();
}
else if (acao == jbCancelar){
	acionarBotaoCancelar();
}
else if (acao == jbEditar){
	acionarBotaoEditar();
}
else if (acao == jbSalvar){
	acionarBotaoSalvar();
}
else if(acao == jbNovo) {
	acionarBotaoNovo();
}
else if(acao == jbBuscar) {
	acionarBotaoBuscar();
}
		
	}//final do actionPerformed
}