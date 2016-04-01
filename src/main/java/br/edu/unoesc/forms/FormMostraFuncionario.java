package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.unoesc.dao.MongoDao;
import br.edu.unoesc.modelo.Funcionario;
import br.edu.unoesc.preencheDados.PreencheDados;

public class FormMostraFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpMostraFuncionario;
	private Vector<String> dados;
	private JTable jttListaFuncionario;
	private DefaultTableModel dtmListaFuncionario;
	private JScrollPane jspListaFuncionario;
	private JButton jbSelecionar;
	private JButton jbCancelar;
	private PreencheDados preencheDados;
	private Funcionario funcionario;
	private List<Funcionario> listaFuncionarios;
	private String descricao;
	
	public void componentesFormMostraFuncionario() {
		dados = new Vector<String>();
		dados.add("Crachá");
		dados.add("Descrição");
		dados.add("Valor");
		
		dtmListaFuncionario = new DefaultTableModel();
		dtmListaFuncionario.setColumnIdentifiers(dados);
		
		jttListaFuncionario = new JTable();
		jttListaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaFuncionario.setModel(dtmListaFuncionario);
		jttListaFuncionario.getColumnModel().getColumn(0).setResizable(false);
		jttListaFuncionario.getColumnModel().getColumn(0).setPreferredWidth(50);
		jttListaFuncionario.getColumnModel().getColumn(1).setResizable(false);
		jttListaFuncionario.getColumnModel().getColumn(1).setPreferredWidth(300);
		jttListaFuncionario.getColumnModel().getColumn(2).setResizable(false);
		jttListaFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
		jpMostraFuncionario.setLayout(null);
		
		jspListaFuncionario = new JScrollPane(jttListaFuncionario);
		jspListaFuncionario.setBounds(10, 11, 450, 300);
		jpMostraFuncionario.add(jspListaFuncionario);
		
		jbSelecionar = new JButton("Selecionar");
		jbSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSelecionar.setBounds(10, 322, 110, 25);
		jpMostraFuncionario.add(jbSelecionar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setBounds(130, 322, 110, 25);
		jpMostraFuncionario.add(jbCancelar);
	}
	
	public void preencheDadosTabelaPorNome() {
		listaFuncionarios = MongoDao.getDAO().listaGenerica(Funcionario.class, "nome", descricao);
		listaFuncionarios.forEach(funcionario->{
			dtmListaFuncionario.addRow(funcionario.vetorDados());
		});
	}
	
	public void acionarBotaoSelecionar() {
		jbSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbSelecionar) {
					Integer funcionarioSelecionado = jttListaFuncionario.getSelectedRow();
					if(funcionarioSelecionado != -1) {
						funcionario = listaFuncionarios.get(funcionarioSelecionado);
						preencheDados.preencherCampos(funcionario);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum funcionário foi selecionado!!!\n"
								+ "Por gentileza, selecionar um funcionário!!!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
	
	public void acionarBotaoCancelar() {
		jbCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public void inicializarForm() {
		listaFuncionarios = new ArrayList<>();
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormMostraFuncionario.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setTitle("Lista de Funcionários");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setBounds(100, 100, 475, 385);
		this.setLocationRelativeTo(null);
		jpMostraFuncionario = new JPanel();
		setContentPane(jpMostraFuncionario);
		jpMostraFuncionario.setLayout(null);
		
		componentesFormMostraFuncionario();
		preencheDadosTabelaPorNome();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
	}

	public FormMostraFuncionario(PreencheDados dados, String descricao) {
		this.preencheDados = dados;
		this.descricao = descricao;
		inicializarForm();
	}
}