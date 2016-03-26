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
import br.edu.unoesc.modelo.TipoServico;
import br.edu.unoesc.preencheDados.PreencheDados;

public class FormMostraTipoServico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpListaTipoServico;
	private Vector<String> dados;
	private JTable jttListaTipoServico;
	private DefaultTableModel dtmListaTipoServico;
	private JScrollPane jspListaTipoServico;
	private JButton jbSelecionar;
	private JButton jbCancelar;
	private PreencheDados preencheDados;
	private TipoServico tipoServico;
	private List<TipoServico> listaTiposServicos;
	private String descricao;
	
	public void componentesMostraTipoServico() {
		dados = new Vector<String>();
		dados.add("Descri��o");
		dados.add("Valor");
		
		dtmListaTipoServico = new DefaultTableModel();
		dtmListaTipoServico.setColumnIdentifiers(dados);
		
		jttListaTipoServico = new JTable();
		jttListaTipoServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaTipoServico.setModel(dtmListaTipoServico);
		jttListaTipoServico.getColumnModel().getColumn(0).setResizable(false);
		jttListaTipoServico.getColumnModel().getColumn(0).setPreferredWidth(320);
		jttListaTipoServico.getColumnModel().getColumn(1).setResizable(false);
		jttListaTipoServico.getColumnModel().getColumn(1).setPreferredWidth(100);
		jpListaTipoServico.setLayout(null);
		
		jspListaTipoServico = new JScrollPane(jttListaTipoServico);
		jspListaTipoServico.setBounds(10, 11, 450, 300);
		jpListaTipoServico.add(jspListaTipoServico);
		
		jbSelecionar = new JButton("Selecionar");
		jbSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSelecionar.setBounds(10, 322, 110, 25);
		jpListaTipoServico.add(jbSelecionar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setBounds(130, 322, 110, 25);
		jpListaTipoServico.add(jbCancelar);
	}
	
	@SuppressWarnings("unchecked")
	public void preencheDadosTabela() {
		listaTiposServicos = (List<TipoServico>) MongoDao.getDAO().listaGenerica(TipoServico.class, "nome", descricao);
		
		
		//For java 8 com a funcao que retorna o String[] com os dados.
listaTiposServicos.forEach(servico->{			
dtmListaTipoServico.addRow(servico.listaDados());
});
// ----------------- FOR original que o Tiago Fez --		
//		for(TipoServico servicos : listaTiposServicos) {
//dtmListaTipoServico.addRow(new String[] {servicos.getNome(),new DecimalFormat("R$ #,##0.00").format(servicos.getValor()).toString()
//});
//		}
	}
	
	public void acionarBotaoSelecionar() {
		jbSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbSelecionar) {
					Integer servicoSelecionado = jttListaTipoServico.getSelectedRow();
					if(servicoSelecionado != -1) {
					tipoServico = listaTiposServicos.get(servicoSelecionado);
					preencheDados.preencherCampos(tipoServico);
					dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum servi�o foi selecionado!!!\n"
								+ "Por gentileza, selecionar um servi�o!!!", "Erro", JOptionPane.ERROR_MESSAGE);
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
		listaTiposServicos = new ArrayList<>();
		this.setTitle("Lista Tipos de Servi�os");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormMostraTipoServico.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setSize(475, 385);
		jpListaTipoServico = new JPanel();
		this.setContentPane(jpListaTipoServico);
		
		componentesMostraTipoServico();
		preencheDadosTabela();
		acionarBotaoSelecionar();
		acionarBotaoCancelar();
	}
	
	public FormMostraTipoServico(PreencheDados dados, String descricao) {
		this.preencheDados = dados;
		this.descricao = descricao;
		inicializarForm();
	}
}