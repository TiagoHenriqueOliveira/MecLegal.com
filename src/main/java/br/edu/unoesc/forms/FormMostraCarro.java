package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.unoesc.modelo.Cliente;
import br.edu.unoesc.preencheDados.PreencheDados;
import lombok.NoArgsConstructor;
@NoArgsConstructor

public class FormMostraCarro extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpListaCarro = new JPanel(null);;
	private String[] dados = new String[]{"Nome do veículo", "Placa"};
	private JTable jttListaCarro = new JTable();
	private DefaultTableModel dtmListaCarro;
	private JScrollPane jspListaCarro;
	private JButton jbSelecionar, jbCancelar;
	private PreencheDados preencheDados;
	private Cliente cliente;
	
	public void componentesMostraCarro() {
		dtmListaCarro = new DefaultTableModel();
		dtmListaCarro.setColumnIdentifiers(dados);
		
		jttListaCarro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaCarro.setModel(dtmListaCarro);
		jttListaCarro.getColumnModel().getColumn(0).setResizable(false);
		jttListaCarro.getColumnModel().getColumn(0).setPreferredWidth(320);
		jttListaCarro.getColumnModel().getColumn(1).setResizable(false);
		jttListaCarro.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		jspListaCarro = new JScrollPane(jttListaCarro);
		jspListaCarro.setBounds(10, 11, 520, 300);
		jpListaCarro.add(jspListaCarro);
		
		jbSelecionar = new JButton("Selecionar");
		jbSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSelecionar.setBounds(10, 322, 110, 25);
		jbSelecionar.addActionListener(this);
		jpListaCarro.add(jbSelecionar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setBounds(130, 322, 110, 25);
		jbCancelar.addActionListener(this);
		jpListaCarro.add(jbCancelar);
	}
	
	public void  inicializarForm() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormMostraCarro.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Lista de Carros");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 549, 382);
		this.setLocationRelativeTo(null);
		setContentPane(jpListaCarro);
		componentesMostraCarro();
	}

	public FormMostraCarro(PreencheDados dados, Cliente cliente) {
		this.preencheDados = dados;
		this.cliente = cliente;
		inicializarForm();
		this.cliente.getCarros().forEach(carro->{
			dtmListaCarro.addRow(carro.vetorDados());
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbSelecionar) {
			int selecionado = jttListaCarro.getSelectedRow();
			if(selecionado != -1) {
				preencheDados.preencherCampos(cliente.getCarros().get(selecionado));
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Nenhum carro foi selecionado!!!\n"
						+ "Por gentileza, selecionar um carro!!!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			dispose();
		}
		
	}
}