package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import br.edu.unoesc.dao.mongoDao;
import br.edu.unoesc.modelo.MinhaEntidade;
import br.edu.unoesc.modelo.TipoServico;
import br.edu.unoesc.preencheDados.PreencheDados;
import br.edu.unoesc.validaConteudo.ConteudoAlfaNumerico;
import br.edu.unoesc.validaConteudo.ConteudoNumerico;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class FormTipoServico extends JFrame implements PreencheDados {

	private static final long serialVersionUID = 1L;
	private JPanel jpServicos;
	private JTextField jtfBuscarServicoNome;
	private JTextField jtfNomeServico;
	private JTextField jtfValorServico;
	private JLabel jlbBuscarServicoNome;
	private JLabel jlNomeServico;
	private JLabel jlValorServico;
	private JButton jbBuscar;
	private JButton jbNovo;
	private JButton jbSalvar;
	private JButton jbEditar;
	private JButton jbCancelar;
	private JButton jbFechar;
	private TipoServico tipoServico;
	private static FormTipoServico formTipoServico;
	private FormMostraTipoServico formMostraTipoServico = new FormMostraTipoServico(null, null);
	
	public void componentesFormTipoServico() {
		formTipoServico = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormTipoServico.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setTitle("Cadastro de Serviços");
		this.setBounds(100, 100, 600, 190);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		
		jlbBuscarServicoNome = new JLabel("Buscar Servi\u00E7o por nome");
		jlbBuscarServicoNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlbBuscarServicoNome.setBounds(10, 11, 190, 14);
		getContentPane().add(jlbBuscarServicoNome);
		
		jtfBuscarServicoNome = new JTextField();
		jtfBuscarServicoNome.setDocument(new ConteudoAlfaNumerico());
		jtfBuscarServicoNome.setToolTipText("Informar o nome do Servi\u00E7o");
		jtfBuscarServicoNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfBuscarServicoNome.setColumns(10);
		jtfBuscarServicoNome.setBounds(10, 25, 328, 20);
		getContentPane().add(jtfBuscarServicoNome);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setIcon(new ImageIcon(FormTipoServico.class.getResource("/br/edu/unoesc/imagens/buscar.png")));
		jbBuscar.setToolTipText("Buscar informa\u00E7\u00F5es do Fruncion\u00E1rio");
		jbBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbBuscar.setBounds(348, 21, 89, 25);
		getContentPane().add(jbBuscar);
		
		jpServicos = new JPanel();
		jpServicos.setLayout(null);
		jpServicos.setToolTipText("");
		jpServicos.setBorder(UIManager.getBorder("PopupMenu.border"));
		jpServicos.setBounds(10, 56, 563, 94);
		getContentPane().add(jpServicos);
		
		jlNomeServico = new JLabel("Nome do Servi\u00E7o");
		jlNomeServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlNomeServico.setBounds(10, 11, 132, 15);
		jpServicos.add(jlNomeServico);
		
		jlValorServico = new JLabel("Valor");
		jlValorServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlValorServico.setBounds(397, 14, 80, 14);
		jpServicos.add(jlValorServico);
		
		jtfNomeServico = new JTextField();
		jtfNomeServico.setDocument(new ConteudoAlfaNumerico());
		jtfNomeServico.setToolTipText("Informar nome do Fruncion\u00E1rio");
		jtfNomeServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeServico.setEditable(false);
		jtfNomeServico.setColumns(10);
		jtfNomeServico.setBounds(10, 28, 377, 20);
		jpServicos.add(jtfNomeServico);
		
		jtfValorServico = new JTextField();
		jtfValorServico.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfValorServico.setDocument(new ConteudoNumerico());
		jtfValorServico.setToolTipText("Formato do valor: 20.0");
		jtfValorServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfValorServico.setEditable(false);
		jtfValorServico.setColumns(10);
		jtfValorServico.setBounds(397, 28, 60, 20);
		jpServicos.add(jtfValorServico);
		
		jbNovo = new JButton("Novo");
		jbNovo.setIcon(new ImageIcon(FormTipoServico.class.getResource("/br/edu/unoesc/imagens/novo.png")));
		jbNovo.setToolTipText("Novo cadastro de Servi\u00E7o");
		jbNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbNovo.setBounds(10, 59, 100, 25);
		jpServicos.add(jbNovo);
		
		jbSalvar = new JButton("Salvar");
		jbSalvar.setIcon(new ImageIcon(FormTipoServico.class.getResource("/br/edu/unoesc/imagens/salvar.png")));
		jbSalvar.setToolTipText("Salvar cadastro do Servi\u00E7o");
		jbSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSalvar.setEnabled(false);
		jbSalvar.setBounds(120, 59, 100, 25);
		jpServicos.add(jbSalvar);
		
		jbEditar = new JButton("Editar");
		jbEditar.setIcon(new ImageIcon(FormTipoServico.class.getResource("/br/edu/unoesc/imagens/editar.png")));
		jbEditar.setToolTipText("Editar cadastro do Servi\u00E7o");
		jbEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbEditar.setEnabled(false);
		jbEditar.setBounds(230, 59, 100, 25);
		jpServicos.add(jbEditar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setIcon(new ImageIcon(FormTipoServico.class.getResource("/br/edu/unoesc/imagens/cancelar.png")));
		jbCancelar.setToolTipText("Cancelar cadastro do Servi\u00E7o");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setEnabled(false);
		jbCancelar.setBounds(340, 59, 100, 25);
		jpServicos.add(jbCancelar);
		
		jbFechar = new JButton("Fechar");
		jbFechar.setIcon(new ImageIcon(FormTipoServico.class.getResource("/br/edu/unoesc/imagens/fechar.png")));
		jbFechar.setToolTipText("Fechar tela de cadastro");
		jbFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbFechar.setBounds(450, 59, 100, 25);
		jpServicos.add(jbFechar);
	}
	
	public void acionarBotaoBuscar() {
		jtfNomeServico.setText("");
		jtfValorServico.setText("");
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		if(jtfBuscarServicoNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar um parâmetro de busca!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfBuscarServicoNome.requestFocus();
			jbNovo.setEnabled(true);
			jbEditar.setEnabled(false);
		} else {
			if(formMostraTipoServico.isVisible()) {
				formMostraTipoServico.requestFocus();
				formMostraTipoServico.setLocationRelativeTo(null);
			} else {
				formMostraTipoServico = new FormMostraTipoServico(formTipoServico, jtfBuscarServicoNome.getText());
				formMostraTipoServico.setVisible(true);
				formMostraTipoServico.setLocationRelativeTo(null);
				jtfBuscarServicoNome.setText("");
			}
		}
	}
	
	public void acionarBotaoNovo() {
		jtfNomeServico.requestFocus();
		jtfNomeServico.setEditable(true);
		jtfValorServico.setEditable(true);
		jtfNomeServico.setText("");
		jtfValorServico.setText("");
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(false);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoSalvar() {
		jtfBuscarServicoNome.requestFocus();
		jtfNomeServico.setEditable(false);
		jtfValorServico.setEditable(false);
		
		if(jtfNomeServico.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar a descrição do serviço!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeServico.requestFocus();
		} else if(jtfValorServico.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar o valor do serviço!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfValorServico.requestFocus();
		} else {
			tipoServico = new TipoServico();
			if(mongoDao.getDAO().buscaGenerica(TipoServico.class, "nome", jtfNomeServico.getText()) == null) {
				tipoServico.setNome(jtfNomeServico.getText());
				tipoServico.setValor(Double.valueOf(jtfValorServico.getText()));
				mongoDao.getDAO().salvar(tipoServico);
				jtfValorServico.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(tipoServico.getValor())));
			} else {
				tipoServico.setNome(jtfNomeServico.getText());
				tipoServico.setValor(Double.valueOf(jtfValorServico.getText()));
				mongoDao.getDAO().update(tipoServico, "nome", tipoServico.getNome());
				jtfValorServico.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(tipoServico.getValor())));
			}
		}
			
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(true);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void acionarBotaoEditar() {
		jtfNomeServico.requestFocus();
		jtfNomeServico.setEditable(true);
		jtfValorServico.setEditable(true);
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoCancelar() {
		jtfBuscarServicoNome.requestFocus();
		jtfNomeServico.setEditable(false);
		jtfValorServico.setEditable(false);
		jtfNomeServico.setText("");
		jtfValorServico.setText("");
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(false);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void preencheCamposTipoServico(TipoServico tipoServico) {
		jtfNomeServico.setText(tipoServico.getNome());
		jtfValorServico.setText(String.valueOf(new DecimalFormat("R$ #,##0.00").format(tipoServico.getValor())));
		jtfBuscarServicoNome.requestFocus();
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

	public FormTipoServico() {
		componentesFormTipoServico();
		botaoBuscar();
		botaoNovo();
		botaoSalvar();
		botaoEditar();
		botaoCancelar();
		botaoFechar();
	}

	@Override
	public void preencherCampos(MinhaEntidade entidade) {
		this.preencheCamposTipoServico((TipoServico)entidade);
	}
}