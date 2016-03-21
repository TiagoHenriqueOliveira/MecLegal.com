package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import br.edu.unoesc.validaConteudo.ConteudoNumerico;
import br.edu.unoesc.validaConteudo.ConteudoString;

public class FormFuncionario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpFuncionario;
	private JTextField jtfBuscarNomeFuncionario;
	private JTextField jtfBuscarCrachaFuncionario;
	private JTextField jtfNomeFuncionario;
	private JTextField jtfCrachaFuncionario;
	private JTextField jtfCPFFuncionario;
	private JLabel jlBuscarFuncionario;
	private JLabel jlBuscarCracha;
	private JLabel jlNomeFuncionario;
	private JLabel jlCPFFuncionario;
	private JLabel jlCrachaFuncionario;
	private JButton jbBuscar;
	private JButton jbNovo;
	private JButton jbSalvar;
	private JButton jbEditar;
	private JButton jbCancelar;
	private JButton jbFechar;
	private JButton jbExcluir;

	public void componentesFormCliente() {
		this.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setFrameIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setTitle("Cadastro de Funcionários");
		this.setBounds(100, 100, 703, 189);
		this.getContentPane().setLayout(null);
		
		jlBuscarFuncionario = new JLabel("Buscar Fruncionário por nome");
		jlBuscarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlBuscarFuncionario.setBounds(10, 11, 190, 14);
		getContentPane().add(jlBuscarFuncionario);
		
		jlBuscarCracha = new JLabel("Crach\u00E1");
		jlBuscarCracha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlBuscarCracha.setBounds(288, 11, 80, 14);
		getContentPane().add(jlBuscarCracha);
		
		jtfBuscarNomeFuncionario = new JTextField();
		jtfBuscarNomeFuncionario.setDocument(new ConteudoString());
		jtfBuscarNomeFuncionario.setToolTipText("Informar o nome do Fruncionário");
		jtfBuscarNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBuscarNomeFuncionario.setColumns(10);
		jtfBuscarNomeFuncionario.setBounds(10, 25, 268, 20);
		getContentPane().add(jtfBuscarNomeFuncionario);
		
		jtfBuscarCrachaFuncionario = new JTextField();
		jtfBuscarCrachaFuncionario.setDocument(new ConteudoNumerico());
		jtfBuscarCrachaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBuscarCrachaFuncionario.setToolTipText("Informar o número do crach\u00E1");
		jtfBuscarCrachaFuncionario.setBounds(288, 25, 50, 20);
		getContentPane().add(jtfBuscarCrachaFuncionario);
		jtfBuscarCrachaFuncionario.setColumns(10);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/buscar.png")));
		jbBuscar.setToolTipText("Buscar informações do Fruncionário");
		jbBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbBuscar.setBounds(348, 21, 89, 25);
		getContentPane().add(jbBuscar);
		
		jpFuncionario = new JPanel();
		jpFuncionario.setLayout(null);
		jpFuncionario.setToolTipText("");
		jpFuncionario.setBorder(UIManager.getBorder("PopupMenu.border"));
		jpFuncionario.setBounds(10, 56, 670, 94);
		getContentPane().add(jpFuncionario);
		
		jlNomeFuncionario = new JLabel("Nome do Fruncionário");
		jlNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlNomeFuncionario.setBounds(10, 11, 132, 15);
		jpFuncionario.add(jlNomeFuncionario);
		
		jlCPFFuncionario = new JLabel("CPF do Fruncionário");
		jlCPFFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCPFFuncionario.setBounds(277, 11, 132, 15);
		jpFuncionario.add(jlCPFFuncionario);
		
		jlCrachaFuncionario = new JLabel("Crach\u00E1");
		jlCrachaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCrachaFuncionario.setBounds(397, 14, 80, 14);
		jpFuncionario.add(jlCrachaFuncionario);
		
		jtfNomeFuncionario = new JTextField();
		jtfNomeFuncionario.setDocument(new ConteudoString());
		jtfNomeFuncionario.setToolTipText("Informar nome do Fruncionário");
		jtfNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFuncionario.setEditable(false);
		jtfNomeFuncionario.setColumns(10);
		jtfNomeFuncionario.setBounds(10, 28, 257, 20);
		jpFuncionario.add(jtfNomeFuncionario);
		
		try {
			jtfCPFFuncionario = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			jtfCPFFuncionario.setEditable(false);
			jtfCPFFuncionario.setToolTipText("Informar CPF completo");
			jtfCPFFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jtfCPFFuncionario.setEditable(false);
			jtfCPFFuncionario.setColumns(10);
			jtfCPFFuncionario.setBounds(277, 28, 110, 20);
			jpFuncionario.add(jtfCPFFuncionario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jtfCrachaFuncionario = new JTextField();
		jtfCrachaFuncionario.setDocument(new ConteudoNumerico());
		jtfCrachaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfCrachaFuncionario.setEditable(false);
		jtfCrachaFuncionario.setToolTipText("Informar o número do crachá");
		jtfCrachaFuncionario.setColumns(10);
		jtfCrachaFuncionario.setBounds(397, 28, 50, 20);
		jpFuncionario.add(jtfCrachaFuncionario);
		
		jbNovo = new JButton("Novo");
		jbNovo.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/novo.png")));
		jbNovo.setToolTipText("Novo cadastro do Fruncionário");
		jbNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbNovo.setBounds(10, 59, 100, 25);
		jpFuncionario.add(jbNovo);
		
		jbSalvar = new JButton("Salvar");
		jbSalvar.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/salvar.png")));
		jbSalvar.setToolTipText("Salvar cadastro do Fruncionário");
		jbSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSalvar.setEnabled(false);
		jbSalvar.setBounds(120, 59, 100, 25);
		jpFuncionario.add(jbSalvar);
		
		jbEditar = new JButton("Editar");
		jbEditar.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/editar.png")));
		jbEditar.setToolTipText("Editar cadastro do Fruncionário");
		jbEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbEditar.setEnabled(false);
		jbEditar.setBounds(230, 59, 100, 25);
		jpFuncionario.add(jbEditar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/cancelar.png")));
		jbCancelar.setToolTipText("Cancelar cadastro do Fruncionário");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setEnabled(false);
		jbCancelar.setBounds(450, 59, 100, 25);
		jpFuncionario.add(jbCancelar);
		
		jbFechar = new JButton("Fechar");
		jbFechar.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/fechar.png")));
		jbFechar.setToolTipText("Fechar tela de cadastro");
		jbFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbFechar.setBounds(560, 59, 100, 25);
		jpFuncionario.add(jbFechar);
		
		jbExcluir = new JButton("Excluir");
		jbExcluir.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/deletar.png")));
		jbExcluir.setToolTipText("Excluir cadastro do Fruncionário");
		jbExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbExcluir.setEnabled(false);
		jbExcluir.setBounds(340, 59, 100, 25);
		jpFuncionario.add(jbExcluir);
	}

	public void acionarBotaoBuscar() {
		jtfBuscarNomeFuncionario.setText("");
		jtfBuscarCrachaFuncionario.setText("");
	}
	
	public void acionarBotaoNovo() {
		jtfNomeFuncionario.requestFocus();
		jtfNomeFuncionario.setEditable(true);
		jtfCPFFuncionario.setEditable(true);
		jtfCrachaFuncionario.setEditable(true);
		jtfNomeFuncionario.setText("");
		jtfCPFFuncionario.setText("");
		jtfCrachaFuncionario.setText("");
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(false);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoSalvar() {
		jtfBuscarNomeFuncionario.requestFocus();
		jtfNomeFuncionario.setEditable(false);
		jtfCPFFuncionario.setEditable(false);
		jtfCrachaFuncionario.setEditable(false);
		//faz procedimentos para salvar
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(true);
		jbExcluir.setEnabled(true);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void acionarBotaoEditar() {
		jtfNomeFuncionario.requestFocus();
		jtfNomeFuncionario.setEditable(true);
		jtfCPFFuncionario.setEditable(true);
		jtfCrachaFuncionario.setEditable(true);
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
		jtfBuscarNomeFuncionario.requestFocus();
		jtfNomeFuncionario.setEditable(false);
		jtfCPFFuncionario.setEditable(false);
		jtfCrachaFuncionario.setEditable(false);
		jtfNomeFuncionario.setText("");
		jtfCPFFuncionario.setText("");
		jtfCrachaFuncionario.setText("");
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(false);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void acionarBotaoCancelar() {
		jtfBuscarNomeFuncionario.requestFocus();
		jtfNomeFuncionario.setEditable(false);
		jtfCPFFuncionario.setEditable(false);
		jtfCrachaFuncionario.setEditable(false);
		jtfNomeFuncionario.setText("");
		jtfCPFFuncionario.setText("");
		jtfCrachaFuncionario.setText("");
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
	
	public FormFuncionario() {
		componentesFormCliente();
		botaoBuscar();
		botaoNovo();
		botaoSalvar();
		botaoEditar();
		botaoExcluir();
		botaoCancelar();
		botaoFechar();
	}
}