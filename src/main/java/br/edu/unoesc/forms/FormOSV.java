package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import br.edu.unoesc.validaConteudo.ConteudoAlfaNumerico;
import br.edu.unoesc.validaConteudo.ConteudoNumerico;
import br.edu.unoesc.validaConteudo.ConteudoString;

public class FormOSV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpAgendaServico;
	private JTextField jtfBuscarNomeCliente;
	private JTextField jtfBuscarCPFCliente;
	private JTextField jtfBuscarCNPJCliente;
	private JTextField jtfNomeCliente;
	private JTextField jtfCPFCliente;
	private JTextField jtfCNPJCliente;
	private JTextField jtfNomeVeiculo;
	private JTextField jtfPlacaVeiculo;
	private JTextField jtfServicoAgendado;
	private JTextField jtfValorServico;
	private JTextField jtfNomeFuncionario;
	private JTextField jtfCrachaFuncionario;
	private JLabel jlBuscarNomeCliente;
	private JLabel jlBuscarCPFCliente;
	private JLabel jlBuscarCNPJCliente;
	private JLabel jlNomeCliente;
	private JLabel jlCPFCliente;
	private JLabel jlCNPJCliente;
	private JLabel jlNomeVeiculo;
	private JLabel jlPlacaVeiculo;
	private JLabel jlServicoAgendado;
	private JLabel jlValorServico;
	private JLabel jlNomeFuncionario;
	private JLabel jlCrachaFuncionario;
	private JButton jbBuscar;
	private JButton jbNovo;
	private JButton jbSalvar;
	private JButton jbEditar;
	private JButton jbCancelar;
	private JButton jbFechar;
	
	public void componentesFormOSV() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormOSV.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setResizable(false);
		this.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setTitle("Agendamento de Serviços");
		this.setBounds(100, 100, 660, 328);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		
		jpAgendaServico = new JPanel();
		jpAgendaServico.setLayout(null);
		jpAgendaServico.setBorder(UIManager.getBorder("PopupMenu.border"));
		jpAgendaServico.setBounds(10, 57, 626, 232);
		getContentPane().add(jpAgendaServico);
		
		jlBuscarNomeCliente = new JLabel("Buscar por cliente");
		jlBuscarNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlBuscarNomeCliente.setBounds(10, 11, 120, 14);
		getContentPane().add(jlBuscarNomeCliente);
		
		jlBuscarCPFCliente = new JLabel("Buscar CPF");
		jlBuscarCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlBuscarCPFCliente.setBounds(320, 11, 120, 14);
		getContentPane().add(jlBuscarCPFCliente);
		
		jlBuscarCNPJCliente = new JLabel("Buscar CNPJ");
		jlBuscarCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlBuscarCNPJCliente.setBounds(430, 11, 120, 14);
		getContentPane().add(jlBuscarCNPJCliente);
		
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
		jtfNomeCliente.setColumns(10);
		jtfNomeCliente.setBounds(10, 26, 300, 20);
		jpAgendaServico.add(jtfNomeCliente);
		
		try {
			jtfCPFCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCPFCliente.setEditable(false);
		jtfCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCPFCliente.setColumns(10);
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
		jtfCNPJCliente.setColumns(10);
		jtfCNPJCliente.setBounds(430, 26, 110, 20);
		jpAgendaServico.add(jtfCNPJCliente);
		
		jtfNomeVeiculo = new JTextField();
		jtfNomeVeiculo.setDocument(new ConteudoAlfaNumerico());
		jtfNomeVeiculo.setEditable(false);
		jtfNomeVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeVeiculo.setToolTipText("Informar nome do veículo");
		jtfNomeVeiculo.setColumns(10);
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
		jtfPlacaVeiculo.setColumns(10);
		jtfPlacaVeiculo.setBounds(320, 72, 100, 20);
		jpAgendaServico.add(jtfPlacaVeiculo);
		
		jtfServicoAgendado = new JTextField();
		jtfServicoAgendado.setDocument(new ConteudoAlfaNumerico());
		jtfServicoAgendado.setEditable(false);
		jtfServicoAgendado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfServicoAgendado.setToolTipText("Informar serviço a ser executado");
		jtfServicoAgendado.setColumns(10);
		jtfServicoAgendado.setBounds(10, 118, 300, 20);
		jpAgendaServico.add(jtfServicoAgendado);
		
		jtfValorServico = new JTextField();
		jtfValorServico.setDocument(new ConteudoNumerico());
		jtfValorServico.setEditable(false);
		jtfValorServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorServico.setToolTipText("");
		jtfValorServico.setColumns(10);
		jtfValorServico.setBounds(320, 118, 100, 20);
		jpAgendaServico.add(jtfValorServico);
		
		jtfNomeFuncionario = new JTextField();
		jtfNomeFuncionario.setDocument(new ConteudoString());
		jtfNomeFuncionario.setEditable(false);
		jtfNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFuncionario.setToolTipText("Informar nome do funcionário");
		jtfNomeFuncionario.setColumns(10);
		jtfNomeFuncionario.setBounds(10, 164, 300, 20);
		jpAgendaServico.add(jtfNomeFuncionario);
		
		jtfCrachaFuncionario = new JTextField();
		jtfCrachaFuncionario.setDocument(new ConteudoNumerico());
		jtfCrachaFuncionario.setEditable(false);
		jtfCrachaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCrachaFuncionario.setColumns(10);
		jtfCrachaFuncionario.setBounds(320, 164, 50, 20);
		jpAgendaServico.add(jtfCrachaFuncionario);
		
		jtfBuscarNomeCliente = new JTextField();
		jtfBuscarNomeCliente.setDocument(new ConteudoString());
		jtfBuscarNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBuscarNomeCliente.setToolTipText("Informar nome do cliente");
		jtfBuscarNomeCliente.setBounds(10, 26, 300, 20);
		getContentPane().add(jtfBuscarNomeCliente);
		jtfBuscarNomeCliente.setColumns(10);
		
		try {
			jtfBuscarCPFCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfBuscarCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBuscarCPFCliente.setToolTipText("Informar CPF completo");
		jtfBuscarCPFCliente.setColumns(10);
		jtfBuscarCPFCliente.setBounds(320, 26, 100, 20);
		getContentPane().add(jtfBuscarCPFCliente);
		
		try {
			jtfBuscarCNPJCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfBuscarCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBuscarCNPJCliente.setToolTipText("Informar CNPJ completo");
		jtfBuscarCNPJCliente.setColumns(10);
		jtfBuscarCNPJCliente.setBounds(430, 26, 110, 20);
		getContentPane().add(jtfBuscarCNPJCliente);
		
		jbNovo = new JButton("Novo");
		jbNovo.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/novo.png")));
		jbNovo.setToolTipText("Novo cadastro da Ordem de Serviço");
		jbNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbNovo.setBounds(10, 195, 100, 25);
		jpAgendaServico.add(jbNovo);
		
		jbSalvar = new JButton("Salvar");
		jbSalvar.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/salvar.png")));
		jbSalvar.setToolTipText("Salvar cadastro da Ordem de Serviço");
		jbSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSalvar.setEnabled(false);
		jbSalvar.setBounds(120, 195, 100, 25);
		jpAgendaServico.add(jbSalvar);
		
		jbEditar = new JButton("Editar");
		jbEditar.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/editar.png")));
		jbEditar.setToolTipText("Editar cadastro da Ordem de Serviço");
		jbEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbEditar.setEnabled(false);
		jbEditar.setBounds(230, 195, 100, 25);
		jpAgendaServico.add(jbEditar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/cancelar.png")));
		jbCancelar.setToolTipText("Cancelar cadastro da Ordem de Serviço");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setEnabled(false);
		jbCancelar.setBounds(340, 195, 100, 25);
		jpAgendaServico.add(jbCancelar);
		
		jbFechar = new JButton("Fechar");
		jbFechar.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/fechar.png")));
		jbFechar.setToolTipText("Fechar tela de cadastro");
		jbFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbFechar.setBounds(450, 195, 100, 25);
		jpAgendaServico.add(jbFechar);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setIcon(new ImageIcon(FormOSV.class.getResource("/br/edu/unoesc/imagens/buscar.png")));
		jbBuscar.setToolTipText("Buscar informações da Ordem de Serviço");
		jbBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbBuscar.setBounds(547, 22, 89, 25);
		getContentPane().add(jbBuscar);
	}

	public void acionarBotaoBuscar() {
		jtfBuscarNomeCliente.setText("");
		jtfBuscarCPFCliente.setText("");
		jtfBuscarCNPJCliente.setText("");
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
		//faz procedimentos para salvar
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
		//faz procedimentos para ediï¿½ï¿½o do registro
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
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
	
	public void botaoBuscar() {
		jbBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbBuscar) {
					acionarBotaoBuscar();
				}
			}
		});
	}
	
	public void botaoNovo() {
		jbNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbNovo) {
					acionarBotaoNovo();
				}
			}
		});
	}
	
	public void botaoSalvar() {
		jbSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbSalvar) {
					acionarBotaoSalvar();
				}
			}
		});
	}
	
	public void botaoEditar() {
		jbEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbEditar) {
					acionarBotaoEditar();
				}
			}
		});
	}
	
	public void botaoCancelar() {
		jbCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbCancelar) {
					acionarBotaoCancelar();
				}
			}
		});
	}
	
	public void botaoFechar() {
		jbFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbFechar) {
					dispose();
				}
			}
		});
	}
	
	public FormOSV() {
		componentesFormOSV();
		botaoBuscar();
		botaoNovo();
		botaoSalvar();
		botaoEditar();
		botaoCancelar();
		botaoFechar();
	}
}