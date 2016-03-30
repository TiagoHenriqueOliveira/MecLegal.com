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
import br.edu.unoesc.modelo.Cliente;
import br.edu.unoesc.preencheDados.PreencheDados;

public class FormMostraCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpListaCliente;
	private Vector<String> dados;
	private JTable jttListaCliente;
	private DefaultTableModel dtmListaCliente;
	private JScrollPane jspListaCliente;
	private JButton jbSelecionar;
	private JButton jbCancelar;
	private PreencheDados preencheDados;
	private Cliente cliente;
	private List<Cliente> listaClientes;
	private String descricao;
	
	public void componentesMostraCliente() {
		dados = new Vector<String>();
		dados.add("Descrição");
		dados.add("CPF");
		dados.add("CNPJ");
		
		dtmListaCliente = new DefaultTableModel();
		dtmListaCliente.setColumnIdentifiers(dados);
		
		jttListaCliente = new JTable();
		jttListaCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaCliente.setModel(dtmListaCliente);
		jttListaCliente.getColumnModel().getColumn(0).setResizable(false);
		jttListaCliente.getColumnModel().getColumn(0).setPreferredWidth(320);
		jttListaCliente.getColumnModel().getColumn(1).setResizable(false);
		jttListaCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
		jttListaCliente.getColumnModel().getColumn(2).setResizable(false);
		jttListaCliente.getColumnModel().getColumn(2).setPreferredWidth(110);
		jpListaCliente.setLayout(null);
		
		jspListaCliente = new JScrollPane(jttListaCliente);
		jspListaCliente.setBounds(10, 11, 589, 300);
		jpListaCliente.add(jspListaCliente);
		
		jbSelecionar = new JButton("Selecionar");
		jbSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSelecionar.setBounds(10, 322, 110, 25);
		jpListaCliente.add(jbSelecionar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setBounds(130, 322, 110, 25);
		jpListaCliente.add(jbCancelar);
	}
	
	@SuppressWarnings("unchecked")
	public void preencheDadosTabelaBuscaPorNome() {
		listaClientes = (List<Cliente>) MongoDao.getDAO().listaGenerica(Cliente.class, "nome", descricao);
		listaClientes.forEach(cliente->{
			dtmListaCliente.addRow(cliente.vetorDados());
		});
	}

	public void acionarBotaoSelecionar() {
		jbSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbSelecionar) {
					Integer servicoSelecionado = jttListaCliente.getSelectedRow();
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
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormMostraCliente.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Lista Clientes");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 615, 382);
		jpListaCliente = new JPanel();
		setContentPane(jpListaCliente);
		
		componentesMostraCliente();
		preencheDadosTabelaBuscaPorNome();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
	}

	public FormMostraCliente(PreencheDados dados, String descricao) {
		this.preencheDados = dados;
		this.descricao = descricao;
		inicializarForm();
	}
}