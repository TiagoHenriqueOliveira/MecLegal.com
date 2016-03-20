package br.edu.unoesc.forms;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import br.edu.unoesc.validaConteudo.ConteudoAlfaNumerico;
import br.edu.unoesc.validaConteudo.ConteudoString;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteForm extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpInformacoesCliente;
	private JTextField jtfBuscarNomeCliente;
	private JTextField jtfBuscarCPFCliente;
	private JTextField jtfBuscarCNPJCliente;
	private JTextField jtfNomeCliente;
	private JTextField jtfCPFCliente;
	private JTextField jtfCNPJCliente;
	private JTextField jtfNomeVeiculo;
	private JTextField jtfPlacaVeiculo;
	private JLabel jlBuscarClienteNome;
	private JLabel jlBuscarClienteCNPJ;
	private JLabel jlBuscarClienteCPF;
	private JLabel jlNomeCliente;
	private JLabel jlCPF;
	private JLabel jlCNPJ;
	private JLabel jlNomeVeiculo;
	private JLabel jlPlacaVeiculo;
	private JButton jbNovo;
	private JButton jbSalvar;
	private JButton jbEditar;
	private JButton jbCancelar;
	private JButton jbFechar;
	private JButton jbExcluir;
	private JButton jbBuscar;
	
	public void componentesClienteForm() {
		this.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setFrameIcon(new ImageIcon(ClienteForm.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setTitle("Cadastro de Clientes");
		this.setBounds(100, 100, 703, 240);
		this.getContentPane().setLayout(null);
		
		jlBuscarClienteNome = new JLabel("Buscar cliente por nome");
		jlBuscarClienteNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlBuscarClienteNome.setBounds(10, 11, 190, 14);
		getContentPane().add(jlBuscarClienteNome);
		
		jlBuscarClienteCPF = new JLabel("Buscar cliente por CPF");
		jlBuscarClienteCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlBuscarClienteCPF.setBounds(288, 11, 140, 14);
		getContentPane().add(jlBuscarClienteCPF);
		
		jlBuscarClienteCNPJ = new JLabel("Buscar cliente por CNPJ");
		jlBuscarClienteCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlBuscarClienteCNPJ.setBounds(438, 11, 140, 14);
		getContentPane().add(jlBuscarClienteCNPJ);
		
		jtfBuscarNomeCliente = new JTextField();
		jtfBuscarNomeCliente.setDocument(new ConteudoString());
		jtfBuscarNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBuscarNomeCliente.setBounds(10, 25, 268, 20);
		getContentPane().add(jtfBuscarNomeCliente);
		jtfBuscarNomeCliente.setColumns(10);
		
		try {
			jtfBuscarCPFCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfBuscarCPFCliente.setToolTipText("Informar CPF completo");
		jtfBuscarCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBuscarCPFCliente.setColumns(10);
		jtfBuscarCPFCliente.setBounds(288, 25, 110, 20);
		getContentPane().add(jtfBuscarCPFCliente);
		
		try {
			jtfBuscarCNPJCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfBuscarCNPJCliente.setToolTipText("Informar CNPJ completo");
		jtfBuscarCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBuscarCNPJCliente.setColumns(10);
		jtfBuscarCNPJCliente.setBounds(438, 25, 125, 20);
		getContentPane().add(jtfBuscarCNPJCliente);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setToolTipText("Buscar informa\u00E7\u00F5es do cliente");
		jbBuscar.setIcon(new ImageIcon(ClienteForm.class.getResource("/br/edu/unoesc/imagens/buscar.png")));
		jbBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbBuscar.setBounds(588, 21, 89, 25);
		getContentPane().add(jbBuscar);
		
		jpInformacoesCliente = new JPanel();
		jpInformacoesCliente.setBorder(UIManager.getBorder("PopupMenu.border"));
		jpInformacoesCliente.setToolTipText("");
		jpInformacoesCliente.setBounds(10, 56, 670, 142);
		getContentPane().add(jpInformacoesCliente);
		jpInformacoesCliente.setLayout(null);
		
		jlNomeCliente = new JLabel("Nome do Cliente");
		jlNomeCliente.setBounds(10, 11, 132, 15);
		jlNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jpInformacoesCliente.add(jlNomeCliente);
		
		jlCPF = new JLabel("CPF do Cliente");
		jlCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCPF.setBounds(277, 11, 132, 15);
		jpInformacoesCliente.add(jlCPF);
		
		jlCNPJ = new JLabel("CNPJ do Cliente");
		jlCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCNPJ.setBounds(428, 11, 132, 15);
		jpInformacoesCliente.add(jlCNPJ);
		
		jlNomeVeiculo = new JLabel("Nome do Veículo");
		jlNomeVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlNomeVeiculo.setBounds(10, 59, 132, 15);
		jpInformacoesCliente.add(jlNomeVeiculo);
		
		jlPlacaVeiculo = new JLabel("Placa do Veículo");
		jlPlacaVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlPlacaVeiculo.setBounds(277, 59, 132, 15);
		jpInformacoesCliente.add(jlPlacaVeiculo);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setEditable(false);
		jtfNomeCliente.setDocument(new ConteudoString());
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setBounds(10, 28, 257, 20);
		jpInformacoesCliente.add(jtfNomeCliente);
		jtfNomeCliente.setColumns(10);
		
		try {
			jtfCPFCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			jtfCPFCliente.setEditable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCPFCliente.setToolTipText("Informar CPF completo");
		jtfCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCPFCliente.setColumns(10);
		jtfCPFCliente.setBounds(277, 28, 110, 20);
		jpInformacoesCliente.add(jtfCPFCliente);
		
		try {
			jtfCNPJCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
			jtfCNPJCliente.setEditable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfCNPJCliente.setToolTipText("Informar CNPJ completo");
		jtfCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCNPJCliente.setColumns(10);
		jtfCNPJCliente.setBounds(428, 28, 125, 20);
		jpInformacoesCliente.add(jtfCNPJCliente);
		
		jtfNomeVeiculo = new JTextField();
		jtfNomeVeiculo.setEditable(false);
		jtfNomeVeiculo.setDocument(new ConteudoAlfaNumerico());
		jtfNomeVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeVeiculo.setColumns(10);
		jtfNomeVeiculo.setBounds(10, 74, 257, 20);
		jpInformacoesCliente.add(jtfNomeVeiculo);
		
		try {
			jtfPlacaVeiculo = new JFormattedTextField(new MaskFormatter("UUU-####"));
			jtfPlacaVeiculo.setEditable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPlacaVeiculo.setToolTipText("Informar placa do veículo completa");
		jtfPlacaVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlacaVeiculo.setColumns(10);
		jtfPlacaVeiculo.setBounds(277, 74, 80, 20);
		jpInformacoesCliente.add(jtfPlacaVeiculo);
		
		jbNovo = new JButton("Novo");
		jbNovo.setToolTipText("Novo cadastro do Cliente");
		jbNovo.setIcon(new ImageIcon(ClienteForm.class.getResource("/br/edu/unoesc/imagens/novo.png")));
		jbNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbNovo.setBounds(10, 105, 100, 25);
		jpInformacoesCliente.add(jbNovo);
		
		jbSalvar = new JButton("Salvar");
		jbSalvar.setEnabled(false);
		jbSalvar.setIcon(new ImageIcon(ClienteForm.class.getResource("/br/edu/unoesc/imagens/salvar.png")));
		jbSalvar.setToolTipText("Salvar cadastro do Cliente");
		jbSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSalvar.setBounds(120, 105, 100, 25);
		jpInformacoesCliente.add(jbSalvar);
		
		jbEditar = new JButton("Editar");
		jbEditar.setEnabled(false);
		jbEditar.setIcon(new ImageIcon(ClienteForm.class.getResource("/br/edu/unoesc/imagens/editar.png")));
		jbEditar.setToolTipText("Editar cadastro do Cliente");
		jbEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbEditar.setBounds(230, 105, 100, 25);
		jpInformacoesCliente.add(jbEditar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setEnabled(false);
		jbCancelar.setIcon(new ImageIcon(ClienteForm.class.getResource("/br/edu/unoesc/imagens/cancelar.png")));
		jbCancelar.setToolTipText("Cancelar cadastro do Cliente");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setBounds(450, 105, 100, 25);
		jpInformacoesCliente.add(jbCancelar);
		
		jbFechar = new JButton("Fechar");
		jbFechar.setIcon(new ImageIcon(ClienteForm.class.getResource("/br/edu/unoesc/imagens/fechar.png")));
		jbFechar.setToolTipText("Fechar tela de cadastro");
		jbFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbFechar.setBounds(560, 105, 100, 25);
		jpInformacoesCliente.add(jbFechar);
		
		jbExcluir = new JButton("Excluir");
		jbExcluir.setEnabled(false);
		jbExcluir.setIcon(new ImageIcon(ClienteForm.class.getResource("/br/edu/unoesc/imagens/deletar.png")));
		jbExcluir.setToolTipText("Excluir cadastro do Cliente");
		jbExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbExcluir.setBounds(340, 105, 100, 25);
		jpInformacoesCliente.add(jbExcluir);
	}
	
	public void acionarBotaoBuscar() {
		jtfBuscarNomeCliente.setText("");
		jtfBuscarCPFCliente.setText("");
		jtfBuscarCNPJCliente.setText("");
	}
	
	public void acionarBotaoNovo() {
		jtfNomeCliente.setEditable(true);
		jtfCPFCliente.setEditable(true);
		jtfCNPJCliente.setEditable(true);
		jtfNomeVeiculo.setEditable(true);
		jtfPlacaVeiculo.setEditable(true);
		jtfNomeCliente.setText("");
		jtfCPFCliente.setText("");
		jtfCNPJCliente.setText("");
		jtfNomeVeiculo.setText("");
		jtfPlacaVeiculo.setText("");
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(false);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoSalvar() {
		jtfNomeCliente.setEditable(false);
		jtfCPFCliente.setEditable(false);
		jtfCNPJCliente.setEditable(false);
		jtfNomeVeiculo.setEditable(false);
		jtfPlacaVeiculo.setEditable(false);
		//faz procedimentos para salvar
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(true);
		jbExcluir.setEnabled(true);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void acionarBotaoEditar() {
		jtfNomeCliente.setEditable(true);
		jtfCPFCliente.setEditable(true);
		jtfCNPJCliente.setEditable(true);
		jtfNomeVeiculo.setEditable(true);
		jtfPlacaVeiculo.setEditable(true);
		//faz procedimentos para edição do registro
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoExcluir() {
		//faz procedimento para exclusão do registro
		//da mensagem ao usuário que exclui
		jtfNomeCliente.setEditable(false);
		jtfCPFCliente.setEditable(false);
		jtfCNPJCliente.setEditable(false);
		jtfNomeVeiculo.setEditable(false);
		jtfPlacaVeiculo.setEditable(false);
		jtfNomeCliente.setText("");
		jtfCPFCliente.setText("");
		jtfCNPJCliente.setText("");
		jtfNomeVeiculo.setText("");
		jtfPlacaVeiculo.setText("");
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(false);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void acionarBotaoCancelar() {
		jtfNomeCliente.setEditable(false);
		jtfCPFCliente.setEditable(false);
		jtfCNPJCliente.setEditable(false);
		jtfNomeVeiculo.setEditable(false);
		jtfPlacaVeiculo.setEditable(false);
		jtfNomeCliente.setText("");
		jtfCPFCliente.setText("");
		jtfCNPJCliente.setText("");
		jtfNomeVeiculo.setText("");
		jtfPlacaVeiculo.setText("");
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(false);
		jbExcluir.setEnabled(false);
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
	
	public void botaoExcluir() {
		jbExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbExcluir) {
					acionarBotaoExcluir();
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

	public ClienteForm() {
		componentesClienteForm();
		botaoBuscar();
		botaoNovo();
		botaoSalvar();
		botaoEditar();
		botaoExcluir();
		botaoCancelar();
		botaoFechar();
	}
}