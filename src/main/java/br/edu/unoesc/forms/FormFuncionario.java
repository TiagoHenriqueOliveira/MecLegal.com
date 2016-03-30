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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import br.edu.unoesc.dao.MongoDao;
import br.edu.unoesc.modelo.Funcionario;
import br.edu.unoesc.modelo.MinhaEntidade;
import br.edu.unoesc.preencheDados.PreencheDados;
import br.edu.unoesc.validaConteudo.ConteudoNumerico;
import br.edu.unoesc.validaConteudo.ConteudoString;

public class FormFuncionario extends JFrame implements PreencheDados {

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
	private Funcionario funcionario;
	private static FormFuncionario formFuncionario;
	private FormMostraFuncionario formMostraFuncionario = new FormMostraFuncionario(null, null);

	public void componentesFormCliente() {
		formFuncionario = this;
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setResizable(false);
		this.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setTitle("Cadastro de Funcionários");
		this.setBounds(100, 100, 703, 189);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		
		jlBuscarFuncionario = new JLabel("Buscar Fruncionário por nome");
		jlBuscarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlBuscarFuncionario.setBounds(10, 11, 190, 14);
		getContentPane().add(jlBuscarFuncionario);
		
		jlBuscarCracha = new JLabel("Crachá");
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
		jtfBuscarCrachaFuncionario.setToolTipText("Informar o número do crachá");
		jtfBuscarCrachaFuncionario.setBounds(288, 25, 50, 20);
		getContentPane().add(jtfBuscarCrachaFuncionario);
		jtfBuscarCrachaFuncionario.setColumns(10);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/buscar.png")));
		jbBuscar.setToolTipText("Buscar informações do Funcionário");
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
		
		jlCPFFuncionario = new JLabel("CPF do Funcionário");
		jlCPFFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCPFFuncionario.setBounds(347, 11, 132, 15);
		jpFuncionario.add(jlCPFFuncionario);
		
		jlCrachaFuncionario = new JLabel("Crachá");
		jlCrachaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCrachaFuncionario.setBounds(500, 11, 80, 14);
		jpFuncionario.add(jlCrachaFuncionario);
		
		jtfNomeFuncionario = new JTextField();
		jtfNomeFuncionario.setDocument(new ConteudoString());
		jtfNomeFuncionario.setToolTipText("Informar nome do Funcionário");
		jtfNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeFuncionario.setEditable(false);
		jtfNomeFuncionario.setColumns(10);
		jtfNomeFuncionario.setBounds(10, 28, 308, 20);
		jpFuncionario.add(jtfNomeFuncionario);
		
		try {
			jtfCPFFuncionario = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			jtfCPFFuncionario.setEditable(false);
			jtfCPFFuncionario.setToolTipText("Informar CPF completo");
			jtfCPFFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jtfCPFFuncionario.setEditable(false);
			jtfCPFFuncionario.setColumns(10);
			jtfCPFFuncionario.setBounds(347, 28, 110, 20);
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
		jtfCrachaFuncionario.setBounds(500, 28, 50, 20);
		jpFuncionario.add(jtfCrachaFuncionario);
		
		jbNovo = new JButton("Novo");
		jbNovo.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/novo.png")));
		jbNovo.setToolTipText("Novo cadastro do Funcionário");
		jbNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbNovo.setBounds(10, 59, 100, 25);
		jpFuncionario.add(jbNovo);
		
		jbSalvar = new JButton("Salvar");
		jbSalvar.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/salvar.png")));
		jbSalvar.setToolTipText("Salvar cadastro do Funcionário");
		jbSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSalvar.setEnabled(false);
		jbSalvar.setBounds(120, 59, 100, 25);
		jpFuncionario.add(jbSalvar);
		
		jbEditar = new JButton("Editar");
		jbEditar.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/editar.png")));
		jbEditar.setToolTipText("Editar cadastro do Funcionário");
		jbEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbEditar.setEnabled(false);
		jbEditar.setBounds(230, 59, 100, 25);
		jpFuncionario.add(jbEditar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setIcon(new ImageIcon(FormFuncionario.class.getResource("/br/edu/unoesc/imagens/cancelar.png")));
		jbCancelar.setToolTipText("Cancelar cadastro do Funcionário");
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
		jbExcluir.setToolTipText("Excluir cadastro do Funcionário");
		jbExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbExcluir.setEnabled(false);
		jbExcluir.setBounds(340, 59, 100, 25);
		jpFuncionario.add(jbExcluir);
	}

	public void acionarBotaoBuscar() {
		jtfNomeFuncionario.setText("");
		jtfCPFFuncionario.setText("");
		jtfCrachaFuncionario.setText("");
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		jbCancelar.setEnabled(true);
		jbExcluir.setEnabled(true);
		
		if(jtfBuscarNomeFuncionario.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar um parâmetro de busca!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfBuscarNomeFuncionario.requestFocus();
			jbNovo.setEnabled(true);
			jbEditar.setEnabled(false);
		} else if(!jtfBuscarNomeFuncionario.getText().equals("")) {
			if(formMostraFuncionario.isVisible()) {
				formMostraFuncionario.requestFocus();
				formMostraFuncionario.setLocationRelativeTo(null);
			} else {
				formMostraFuncionario = new FormMostraFuncionario(formFuncionario, jtfBuscarNomeFuncionario.getText());
				formMostraFuncionario.setVisible(true);
				jtfBuscarNomeFuncionario.setText("");
				jtfBuscarCrachaFuncionario.setText("");
			}
		} else {
			Funcionario funcionario = (Funcionario) MongoDao.getDAO().buscaGenerica(Funcionario.class, "cracha", Integer.valueOf(jtfBuscarCrachaFuncionario.getText()));
			jtfNomeFuncionario.setText(funcionario.getNome());
			jtfCPFFuncionario.setText(funcionario.getCpf());
			jtfCrachaFuncionario.setText(String.valueOf(funcionario.getCracha()));
			jtfBuscarNomeFuncionario.requestFocus();
			jtfBuscarCrachaFuncionario.setText("");
		}
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
		
		if(jtfNomeFuncionario.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar um nome para o funcionário!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeFuncionario.requestFocus();
		} else if(jtfCPFFuncionario.getText().equals("   .   .   -  ")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o CPF do funcinário!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfCPFFuncionario.requestFocus();
		} else if(jtfCrachaFuncionario.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o crachá do funcionário!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfCrachaFuncionario.requestFocus();
		} else {
			funcionario = new Funcionario();
			if(MongoDao.getDAO().buscaGenerica(Funcionario.class, "nome", jtfNomeFuncionario.getText()) == null) {
				funcionario.setNome(jtfNomeFuncionario.getText());
				funcionario.setCpf(jtfCPFFuncionario.getText());
				funcionario.setCracha(Integer.valueOf(jtfCrachaFuncionario.getText()));
				MongoDao.getDAO().salvar(funcionario);
				JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				jtfBuscarNomeFuncionario.requestFocus();
			} else {
				funcionario.setNome(jtfNomeFuncionario.getText());
				funcionario.setCpf(jtfCPFFuncionario.getText());
				funcionario.setCracha(Integer.valueOf(jtfCrachaFuncionario.getText()));
				MongoDao.getDAO().update(funcionario, "nome", funcionario.getNome());
				JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				jtfBuscarNomeFuncionario.requestFocus();
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
		jtfNomeFuncionario.requestFocus();
		jtfNomeFuncionario.setEditable(true);
		jtfCPFFuncionario.setEditable(true);
		jtfCrachaFuncionario.setEditable(true);
		
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoExcluir() {
		//O mongoDao tem 2 metodos de exclusão, um usa String e ou Integer
		//Poderia ter usado Integer para garantir que se tiver 2 nomes exatamente iguais os dois não serão exclusos
		//Mas o trabalho é só para mostrar que sabemos usar DML usando o Mongo
		//Várias vezes fizemos desta maneira, mas sabendo do risco
		funcionario = new Funcionario();
		funcionario.setNome(jtfNomeFuncionario.getText());
		MongoDao.getDAO().remove(funcionario, "nome", funcionario.getNome());
		
		JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
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
	
	public void preencheCamposFuncionario(Funcionario funcionario) {
		jtfNomeFuncionario.setText(funcionario.getNome());
		jtfCPFFuncionario.setText(funcionario.getCpf());
		jtfCrachaFuncionario.setText(String.valueOf(funcionario.getCracha()));
		jtfBuscarNomeFuncionario.requestFocus();
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

	@Override
	public void preencherCampos(MinhaEntidade entidade) {
		this.preencheCamposFuncionario((Funcionario)entidade);
	}
}