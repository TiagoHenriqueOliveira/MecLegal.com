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
import br.edu.unoesc.modelo.Carro;
import br.edu.unoesc.modelo.Cliente;
import br.edu.unoesc.preencheDados.PreencheDados;

public class FormMostraCarro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpListaCarro;
	private Vector<String> dados;
	private JTable jttListaCarro;
	private DefaultTableModel dtmListaCarro;
	private JScrollPane jspListaCarro;
	private JButton jbSelecionar;
	private JButton jbCancelar;
	private PreencheDados preencheDados;
	private Cliente cliente;
	private List<Cliente> listaClientes;
	private ArrayList<Carro> listaCarros;
	private String descricao;
	
	public void componentesMostraCarro() {
		dados = new Vector<String>();
		dados.add("Nome do veículo");
		dados.add("Placa");
		
		dtmListaCarro = new DefaultTableModel();
		dtmListaCarro.setColumnIdentifiers(dados);
		
		jttListaCarro = new JTable();
		jttListaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaCarro.setModel(dtmListaCarro);
		jttListaCarro.getColumnModel().getColumn(0).setResizable(false);
		jttListaCarro.getColumnModel().getColumn(0).setPreferredWidth(320);
		jttListaCarro.getColumnModel().getColumn(1).setResizable(false);
		jttListaCarro.getColumnModel().getColumn(1).setPreferredWidth(100);
		jpListaCarro.setLayout(null);
		
		jspListaCarro = new JScrollPane(jttListaCarro);
		jspListaCarro.setBounds(10, 11, 520, 300);
		jpListaCarro.add(jspListaCarro);
		
		jbSelecionar = new JButton("Selecionar");
		jbSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSelecionar.setBounds(10, 322, 110, 25);
		jpListaCarro.add(jbSelecionar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setBounds(130, 322, 110, 25);
		jpListaCarro.add(jbCancelar);
	}
	
	public void preencheDadosTabelaBuscaPorNome() {
		cliente = MongoDao.getDAO().buscaGenerica(Cliente.class, "nome", descricao);
		listaCarros = cliente.getCarros();
		listaCarros.forEach(carro->{
			dtmListaCarro.addRow(carro.vetorDados());
		});
	}

	public void acionarBotaoSelecionar() {
		jbSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbSelecionar) {
					Integer servicoSelecionado = jttListaCarro.getSelectedRow();
					if(servicoSelecionado != -1) {
						cliente = listaClientes.get(servicoSelecionado);
						preencheDados.preencherCampos(cliente);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum cliente foi selecionado!!!\n"
								+ "Por gentileza, selecionar um cliente!!!", "Erro", JOptionPane.ERROR_MESSAGE);
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
	
	public void  inicializarForm() {
		listaClientes = new ArrayList<>();
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormMostraCarro.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Lista de Carros");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 549, 382);
		this.setLocationRelativeTo(null);
		jpListaCarro = new JPanel();
		setContentPane(jpListaCarro);
		
		componentesMostraCarro();
		preencheDadosTabelaBuscaPorNome();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
	}

	public FormMostraCarro(PreencheDados dados, String descricao) {
		this.preencheDados = dados;
		this.descricao = descricao;
		inicializarForm();
	}
}