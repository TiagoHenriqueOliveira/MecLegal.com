package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import br.edu.unoesc.modelo.MinhaEntidade;
import br.edu.unoesc.preencheDados.PreencheDados;
import br.edu.unoesc.validaConteudo.ConteudoAlfaNumerico;
import br.edu.unoesc.validaConteudo.ConteudoString;
import java.awt.Toolkit;

public class FormCliente extends JFrame implements PreencheDados {

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
	private Cliente cliente;
	private Carro carro;
	private static FormCliente formCliente;
	private FormMostraCliente formMostraCliente = new FormMostraCliente(null, null, null, null);
	
	public void componentesClienteForm() {
		formCliente = this;
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormCliente.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setTitle("Cadastro de Clientes");
		this.setBounds(100, 100, 703, 240);
		this.setLocationRelativeTo(null);
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
			jtfBuscarCPFCliente.setToolTipText("Informar CPF completo");
			jtfBuscarCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jtfBuscarCPFCliente.setColumns(10);
			jtfBuscarCPFCliente.setBounds(288, 25, 110, 20);
			getContentPane().add(jtfBuscarCPFCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			jtfBuscarCNPJCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
			jtfBuscarCNPJCliente.setToolTipText("Informar CNPJ completo");
			jtfBuscarCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jtfBuscarCNPJCliente.setColumns(10);
			jtfBuscarCNPJCliente.setBounds(438, 25, 125, 20);
			getContentPane().add(jtfBuscarCNPJCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setToolTipText("Buscar informa\u00E7\u00F5es do cliente");
		jbBuscar.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/buscar.png")));
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
		
		jlNomeVeiculo = new JLabel("Nome do Ve�culo");
		jlNomeVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlNomeVeiculo.setBounds(10, 59, 132, 15);
		jpInformacoesCliente.add(jlNomeVeiculo);
		
		jlPlacaVeiculo = new JLabel("Placa do Ve�culo");
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
			jtfCPFCliente.setToolTipText("Informar CPF completo");
			jtfCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jtfCPFCliente.setColumns(10);
			jtfCPFCliente.setBounds(277, 28, 110, 20);
			jpInformacoesCliente.add(jtfCPFCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			jtfCNPJCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
			jtfCNPJCliente.setEditable(false);
			jtfCNPJCliente.setToolTipText("Informar CNPJ completo");
			jtfCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jtfCNPJCliente.setColumns(10);
			jtfCNPJCliente.setBounds(428, 28, 125, 20);
			jpInformacoesCliente.add(jtfCNPJCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		jtfPlacaVeiculo.setToolTipText("Informar placa do ve�culo completa");
		jtfPlacaVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlacaVeiculo.setColumns(10);
		jtfPlacaVeiculo.setBounds(277, 74, 80, 20);
		jpInformacoesCliente.add(jtfPlacaVeiculo);
		
		jbNovo = new JButton("Novo");
		jbNovo.setToolTipText("Novo cadastro do Cliente");
		jbNovo.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/novo.png")));
		jbNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbNovo.setBounds(10, 105, 100, 25);
		jpInformacoesCliente.add(jbNovo);
		
		jbSalvar = new JButton("Salvar");
		jbSalvar.setEnabled(false);
		jbSalvar.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/salvar.png")));
		jbSalvar.setToolTipText("Salvar cadastro do Cliente");
		jbSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSalvar.setBounds(120, 105, 100, 25);
		jpInformacoesCliente.add(jbSalvar);
		
		jbEditar = new JButton("Editar");
		jbEditar.setEnabled(false);
		jbEditar.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/editar.png")));
		jbEditar.setToolTipText("Editar cadastro do Cliente");
		jbEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbEditar.setBounds(230, 105, 100, 25);
		jpInformacoesCliente.add(jbEditar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setEnabled(false);
		jbCancelar.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/cancelar.png")));
		jbCancelar.setToolTipText("Cancelar cadastro do Cliente");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setBounds(450, 105, 100, 25);
		jpInformacoesCliente.add(jbCancelar);
		
		jbFechar = new JButton("Fechar");
		jbFechar.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/fechar.png")));
		jbFechar.setToolTipText("Fechar tela de cadastro");
		jbFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbFechar.setBounds(560, 105, 100, 25);
		jpInformacoesCliente.add(jbFechar);
		
		jbExcluir = new JButton("Excluir");
		jbExcluir.setEnabled(false);
		jbExcluir.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/deletar.png")));
		jbExcluir.setToolTipText("Excluir cadastro do Cliente");
		jbExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbExcluir.setBounds(340, 105, 100, 25);
		jpInformacoesCliente.add(jbExcluir);
	}
	
	public void acionarBotaoBuscar() {
		jtfNomeCliente.setText("");
		jtfCPFCliente.setText("");
		jtfCNPJCliente.setText("");
		jtfNomeVeiculo.setText("");
		jtfPlacaVeiculo.setText("");
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		if((jtfBuscarNomeCliente.getText().equals("")) && (jtfBuscarCPFCliente.getText().equals("   .   .   -  ")) && (jtfBuscarCNPJCliente.getText().equals("  .   .   /    -  "))) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar um par�metro de busca!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfBuscarNomeCliente.requestFocus();
			jbNovo.setEnabled(true);
			jbEditar.setEnabled(false);
		} else {
			if(formMostraCliente.isVisible()) {
				formMostraCliente.requestFocus();
				formMostraCliente.setLocationRelativeTo(null);
			} else {
				formMostraCliente = new FormMostraCliente(formCliente, jtfBuscarNomeCliente.getText(), jtfBuscarCPFCliente.getText(), jtfBuscarCNPJCliente.getText());
				formMostraCliente.setVisible(true);
				formMostraCliente.setLocationRelativeTo(null);
				jtfBuscarNomeCliente.setText("");
				jtfBuscarCPFCliente.setText("");
				jtfBuscarCNPJCliente.setText("");
			}
		}
	}
	
	public void acionarBotaoNovo() {
		jtfNomeCliente.requestFocus();
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
		jtfBuscarNomeCliente.requestFocus();
		jtfNomeCliente.setEditable(false);
		jtfCPFCliente.setEditable(false);
		jtfCNPJCliente.setEditable(false);
		jtfNomeVeiculo.setEditable(false);
		jtfPlacaVeiculo.setEditable(false);
		
		if(jtfNomeCliente.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar um nome para o cliente!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCliente.requestFocus();
		} else if(jtfCPFCliente.getText().equals("   .   .   -  ") && jtfCNPJCliente.getText().equals("  .   .   /    -  ")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar um CPF ou CNPJ para o cliente!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfCPFCliente.requestFocus();
		} else if(jtfNomeVeiculo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar o nome do ve�culo!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeVeiculo.requestFocus();
		} else if(jtfPlacaVeiculo.getText().equals("   -    ")) {
			JOptionPane.showMessageDialog(null, "Obrigat�rio informar a placa do ve�culo!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfPlacaVeiculo.requestFocus();
		} else {
			cliente = new Cliente();
			carro = new Carro();
			if(MongoDao.getDAO().buscaGenerica(Cliente.class, "nome", jtfNomeCliente.getText()) == null) {
				cliente.setNome(jtfNomeCliente.getText());
				cliente.setCpf(jtfCPFCliente.getText());
				cliente.setCnpj(jtfCNPJCliente.getText());
				carro.setNome(jtfNomeVeiculo.getText());
				carro.setPlaca(jtfPlacaVeiculo.getText());
				cliente.adicionarCarro(carro);
				MongoDao.getDAO().salvar(cliente);
			} else {
				cliente.setNome(jtfNomeCliente.getText());
				cliente.setCpf(jtfCPFCliente.getText());
				cliente.setCnpj(jtfCNPJCliente.getText());
				carro.setNome(jtfNomeVeiculo.getText());
				carro.setPlaca(jtfPlacaVeiculo.getText());
				cliente.adicionarCarro(carro);
				MongoDao.getDAO().update(cliente, "nome", cliente.getNome());
			}
		}
		
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(true);
		jbExcluir.setEnabled(true);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void acionarBotaoEditar() {
		jtfNomeCliente.requestFocus();
		jtfNomeCliente.setEditable(true);
		jtfCPFCliente.setEditable(true);
		jtfCNPJCliente.setEditable(true);
		jtfNomeVeiculo.setEditable(true);
		jtfPlacaVeiculo.setEditable(true);
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoExcluir() {
		//faz procedimento para exclus�o do registro
		//da mensagem ao usu�rio que exclui
		jtfBuscarNomeCliente.requestFocus();
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
		jtfBuscarNomeCliente.requestFocus();
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
	
	public void preencheCamposCliente(Cliente cliente) {
		jtfNomeCliente.setText(cliente.getNome());
		jtfCPFCliente.setText(cliente.getCpf());
		jtfCNPJCliente.setText(cliente.getCnpj());
	//	jtfNomeVeiculo.setText(cliente.getCarros());
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

	public FormCliente() {
		componentesClienteForm();
		botaoBuscar();
		botaoNovo();
		botaoSalvar();
		botaoEditar();
		botaoExcluir();
		botaoCancelar();
		botaoFechar();
	}

	@Override
	public void preencherCampos(MinhaEntidade entidade) {
		this.preencheCamposCliente((Cliente)entidade);
	}
}