package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.unoesc.dao.MongoDao;
import br.edu.unoesc.modelo.OSV;
import br.edu.unoesc.preencheDados.PreencheDados;
import lombok.NoArgsConstructor;
@NoArgsConstructor

public class FormMostraOSV extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpListaOSV = new JPanel(null);;
	private String[] dados = new String[]{"Nome do Cliente", "Tipo do Servico", "Carro", "Data"};
	private JTable jttListaOSV = new JTable();
	private DefaultTableModel dtmListaOSV;
	private JScrollPane jspListaOSV;
	private JButton jbSelecionar, jbCancelar;
	private PreencheDados preencheDados;
	private ArrayList<OSV> listaOSV = new ArrayList<OSV>();
	
	public void componentesMostraOSV() {
		dtmListaOSV = new DefaultTableModel();
		dtmListaOSV.setColumnIdentifiers(dados);
		
		jttListaOSV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaOSV.setModel(dtmListaOSV);
		jttListaOSV.getColumnModel().getColumn(0).setResizable(false);
		jttListaOSV.getColumnModel().getColumn(0).setPreferredWidth(320);
		jttListaOSV.getColumnModel().getColumn(1).setResizable(false);
		jttListaOSV.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		jspListaOSV = new JScrollPane(jttListaOSV);
		jspListaOSV.setBounds(10, 11, 520, 300);
		jpListaOSV.add(jspListaOSV);
		
		jbSelecionar = new JButton("Selecionar");
		jbSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSelecionar.setBounds(10, 322, 110, 25);
		jbSelecionar.addActionListener(this);
		jpListaOSV.add(jbSelecionar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setBounds(130, 322, 110, 25);
		jbCancelar.addActionListener(this);
		jpListaOSV.add(jbCancelar);
	}
	
	public void  inicializarForm() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormMostraOSV.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Lista de OSVs");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 549, 382);
		this.setLocationRelativeTo(null);
		setContentPane(jpListaOSV);
		componentesMostraOSV();
	}

	public FormMostraOSV(PreencheDados dados, String busca) {
		this.preencheDados = dados;
		inicializarForm();
		listaOSV = MongoDao.getDAO().listaDeOSV(busca);
		listaOSV.forEach(osvl->{
			dtmListaOSV.addRow(osvl.vetorDados());
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbSelecionar) {
			int selecionado = jttListaOSV.getSelectedRow();
			if(selecionado != -1) {
				preencheDados.preencherCampos(listaOSV.get(selecionado));
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Nenhum OSV foi selecionado!!!\n"
						+ "Por gentileza, selecionar um OSV!!!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			dispose();
		}
		
	}
}