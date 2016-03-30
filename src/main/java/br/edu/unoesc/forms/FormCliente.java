package br.edu.unoesc.forms;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.edu.unoesc.dao.MongoDao;
import br.edu.unoesc.modelo.Carro;
import br.edu.unoesc.modelo.Cliente;
import br.edu.unoesc.modelo.MinhaEntidade;
import br.edu.unoesc.preencheDados.PreencheDados;
import br.edu.unoesc.validaConteudo.ConteudoAlfaNumerico;
import br.edu.unoesc.validaConteudo.ConteudoString;

public class FormCliente extends JFrame implements PreencheDados {

	private static final long serialVersionUID = 1L;
	private JPanel jpInformacoesCliente;
	private JPanel jpVeiculoCliente;
	private String[] dados = new String[]{"Nome do Veículo", "Placa do Veículo"};
	private JTable jttListaVeiculoCliente;
	private DefaultTableModel dtmListaVeiculoCliente;
	private JScrollPane jspListaVeiculoCliente;
	private JTextField jtfBuscarNomeCliente;
	private JTextField jtfBuscarCPFCliente;
	private JTextField jtfBuscarCNPJCliente;
	private JTextField jtfNomeCliente;
	private JTextField jtfCPFCliente;
	private JTextField jtfCNPJCliente;
	private JTextField jtfNomeVeiculo;
	private JFormattedTextField jtfPlacaVeiculo;
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
	private JButton jbCancelarVeiculo;
	private JButton jbExcluirVeiculo;
	private JButton jbEditarVeiculo;
	private JButton jbSalvarVeiculo;
	private JButton jbNovoVeiculo;
	private Cliente cliente = new Cliente();
	private ArrayList<Carro> listaCarros = new ArrayList<Carro>();
	private static FormCliente formCliente;
	private FormMostraCliente formMostraCliente = new FormMostraCliente(null, null);

	public void componentesClienteForm() {
		formCliente = this;
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FormCliente.class.getResource("/br/edu/unoesc/imagens/logo.png")));
		this.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setTitle("Cadastro de Clientes");
		this.setBounds(100, 100, 703, 571);
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
		jbBuscar.setToolTipText("Buscar informações do cliente");
		jbBuscar.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/buscar.png")));
		jbBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbBuscar.setBounds(588, 21, 89, 25);
		getContentPane().add(jbBuscar);
		
		jpInformacoesCliente = new JPanel();
		jpInformacoesCliente.setBorder(BorderFactory.createTitledBorder("Informações do Cliente"));
		jpInformacoesCliente.setBounds(10, 56, 670, 470);
		getContentPane().add(jpInformacoesCliente);
		jpInformacoesCliente.setLayout(null);
		
		jlNomeCliente = new JLabel("Nome do Cliente");
		jlNomeCliente.setBounds(10, 21, 132, 15);
		jlNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jpInformacoesCliente.add(jlNomeCliente);
		
		jlCPF = new JLabel("CPF do Cliente");
		jlCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCPF.setBounds(277, 21, 132, 15);
		jpInformacoesCliente.add(jlCPF);
		
		jlCNPJ = new JLabel("CNPJ do Cliente");
		jlCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlCNPJ.setBounds(428, 21, 132, 15);
		jpInformacoesCliente.add(jlCNPJ);
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setEditable(false);
		jtfNomeCliente.setDocument(new ConteudoString());
		jtfNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeCliente.setBounds(10, 38, 257, 20);
		jpInformacoesCliente.add(jtfNomeCliente);
		
		try {
			jtfCPFCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			jtfCPFCliente.setEditable(false);
			jtfCPFCliente.setToolTipText("Informar CPF completo");
			jtfCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jtfCPFCliente.setBounds(277, 38, 110, 20);
			jpInformacoesCliente.add(jtfCPFCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			jtfCNPJCliente = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
			jtfCNPJCliente.setEditable(false);
			jtfCNPJCliente.setToolTipText("Informar CNPJ completo");
			jtfCNPJCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jtfCNPJCliente.setBounds(428, 38, 125, 20);
			jpInformacoesCliente.add(jtfCNPJCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		jbNovo = new JButton("Novo");
		jbNovo.setToolTipText("Novo cadastro do Cliente");
		jbNovo.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/novo.png")));
		jbNovo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbNovo.setBounds(10, 434, 100, 25);
		jpInformacoesCliente.add(jbNovo);
		
		jbSalvar = new JButton("Salvar");
		jbSalvar.setEnabled(false);
		jbSalvar.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/salvar.png")));
		jbSalvar.setToolTipText("Salvar cadastro do Cliente");
		jbSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSalvar.setBounds(120, 434, 100, 25);
		jpInformacoesCliente.add(jbSalvar);
		
		jbEditar = new JButton("Editar");
		jbEditar.setEnabled(false);
		jbEditar.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/editar.png")));
		jbEditar.setToolTipText("Editar cadastro do Cliente");
		jbEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbEditar.setBounds(230, 434, 100, 25);
		jpInformacoesCliente.add(jbEditar);
		
		jbCancelar = new JButton("Cancelar");
		jbCancelar.setEnabled(false);
		jbCancelar.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/cancelar.png")));
		jbCancelar.setToolTipText("Cancelar cadastro do Cliente");
		jbCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelar.setBounds(450, 434, 100, 25);
		jpInformacoesCliente.add(jbCancelar);
		
		jbFechar = new JButton("Fechar");
		jbFechar.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/fechar.png")));
		jbFechar.setToolTipText("Fechar tela de cadastro");
		jbFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbFechar.setBounds(560, 434, 100, 25);
		jpInformacoesCliente.add(jbFechar);
		
		jbExcluir = new JButton("Excluir");
		jbExcluir.setEnabled(false);
		jbExcluir.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/deletar.png")));
		jbExcluir.setToolTipText("Excluir cadastro do Cliente");
		jbExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbExcluir.setBounds(340, 434, 100, 25);
		jpInformacoesCliente.add(jbExcluir);
		
		jpVeiculoCliente = new JPanel();
		jpVeiculoCliente.setBorder(BorderFactory.createTitledBorder("Veículos do Cliente"));
		jpVeiculoCliente.setBounds(10, 69, 650, 354);
		jpInformacoesCliente.add(jpVeiculoCliente);
		jpVeiculoCliente.setLayout(null);
		
		dtmListaVeiculoCliente = new DefaultTableModel();
		dtmListaVeiculoCliente.setColumnIdentifiers(dados);
		
		jttListaVeiculoCliente = new JTable();
		jttListaVeiculoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jttListaVeiculoCliente.setModel(dtmListaVeiculoCliente);
		jttListaVeiculoCliente.getColumnModel().getColumn(0).setResizable(false);
		jttListaVeiculoCliente.getColumnModel().getColumn(0).setPreferredWidth(400);
		jttListaVeiculoCliente.getColumnModel().getColumn(1).setResizable(false);
		jttListaVeiculoCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
		jpVeiculoCliente.setLayout(null);
		
		jspListaVeiculoCliente = new JScrollPane(jttListaVeiculoCliente);
		jspListaVeiculoCliente.setBounds(10, 26, 630, 235);
		jpVeiculoCliente.add(jspListaVeiculoCliente);
		
		jbCancelarVeiculo = new JButton("Cancelar");
		jbCancelarVeiculo.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/cancelar.png")));
		jbCancelarVeiculo.setToolTipText("Cancelar cadastro do Cliente");
		jbCancelarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbCancelarVeiculo.setEnabled(false);
		jbCancelarVeiculo.setBounds(498, 318, 100, 25);
		jpVeiculoCliente.add(jbCancelarVeiculo);
		
		jbExcluirVeiculo = new JButton("Excluir");
		jbExcluirVeiculo.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/deletar.png")));
		jbExcluirVeiculo.setToolTipText("Excluir cadastro do Cliente");
		jbExcluirVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbExcluirVeiculo.setEnabled(false);
		jbExcluirVeiculo.setBounds(388, 318, 100, 25);
		jpVeiculoCliente.add(jbExcluirVeiculo);
		
		jbEditarVeiculo = new JButton("Editar");
		jbEditarVeiculo.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/editar.png")));
		jbEditarVeiculo.setToolTipText("Editar cadastro do Cliente");
		jbEditarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbEditarVeiculo.setEnabled(false);
		jbEditarVeiculo.setBounds(278, 318, 100, 25);
		jpVeiculoCliente.add(jbEditarVeiculo);
		
		jbSalvarVeiculo = new JButton("Salvar");
		jbSalvarVeiculo.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/salvar.png")));
		jbSalvarVeiculo.setToolTipText("Salvar cadastro do Cliente");
		jbSalvarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbSalvarVeiculo.setEnabled(false);
		jbSalvarVeiculo.setBounds(168, 318, 100, 25);
		jpVeiculoCliente.add(jbSalvarVeiculo);
		
		jbNovoVeiculo = new JButton("Novo");
		jbNovoVeiculo.setEnabled(false);
		jbNovoVeiculo.setIcon(new ImageIcon(FormCliente.class.getResource("/br/edu/unoesc/imagens/novo.png")));
		jbNovoVeiculo.setToolTipText("Novo cadastro do Cliente");
		jbNovoVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbNovoVeiculo.setBounds(58, 318, 100, 25);
		jpVeiculoCliente.add(jbNovoVeiculo);
		
		jlNomeVeiculo = new JLabel("Nome do Veículo");
		jlNomeVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlNomeVeiculo.setBounds(58, 272, 210, 15);
		jpVeiculoCliente.add(jlNomeVeiculo);
		
		jtfNomeVeiculo = new JTextField();
		jtfNomeVeiculo.setDocument(new ConteudoAlfaNumerico());
		jtfNomeVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfNomeVeiculo.setEditable(false);
		jtfNomeVeiculo.setBounds(58, 287, 430, 20);
		jpVeiculoCliente.add(jtfNomeVeiculo);
		
		try {
			jtfPlacaVeiculo = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		jtfPlacaVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtfPlacaVeiculo.setEditable(false);

		jtfPlacaVeiculo.setBounds(518, 287, 80, 20);
		jpVeiculoCliente.add(jtfPlacaVeiculo);
		
		jlPlacaVeiculo = new JLabel("Placa do Veículo");
		jlPlacaVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlPlacaVeiculo.setBounds(518, 272, 132, 15);
		jpVeiculoCliente.add(jlPlacaVeiculo);
	}
	
	public void acionarBotaoBuscar() {
		jtfNomeCliente.setText("");
		jtfCPFCliente.setText("");
		jtfCNPJCliente.setText("");
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		jbCancelar.setEnabled(true);
		jbExcluir.setEnabled(true);
		
		if((jtfBuscarNomeCliente.getText().equals("")) && (jtfBuscarCPFCliente.getText().equals("   .   .   -  ")) && (jtfBuscarCNPJCliente.getText().equals("  .   .   /    -  "))) {
			JOptionPane.showMessageDialog(null, "Obrigatório informar um parâmetro de busca!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfBuscarNomeCliente.requestFocus();
			jbNovo.setEnabled(true);
			jbEditar.setEnabled(false);
		} else if(!jtfBuscarNomeCliente.getText().equals("")) {
			if(formMostraCliente.isVisible()) {
				formMostraCliente.requestFocus();
				formMostraCliente.setLocationRelativeTo(null);
			} else {
				formMostraCliente = new FormMostraCliente(formCliente, jtfBuscarNomeCliente.getText());
				formMostraCliente.setVisible(true);
				formMostraCliente.setLocationRelativeTo(null);
				jtfBuscarNomeCliente.setText("");
			}
		} else if(!jtfBuscarCPFCliente.getText().equals("   .   .   -  ")) {
			Cliente cliente = (Cliente) MongoDao.getDAO().buscaGenerica(Cliente.class, "cpf", jtfBuscarCPFCliente.getText());
			jtfNomeCliente.setText(cliente.getNome());
			jtfCPFCliente.setText(cliente.getCpf());
			jtfBuscarCPFCliente.setText("");
		} else {
			Cliente cliente = (Cliente) MongoDao.getDAO().buscaGenerica(Cliente.class, "cnpj", jtfBuscarCNPJCliente.getText());
			jtfNomeCliente.setText(cliente.getNome());
			jtfCNPJCliente.setText(cliente.getCnpj());
			jtfBuscarCNPJCliente.setText("");
		}
	}
	
	public void acionarBotaoNovoCliente() {
		jtfNomeCliente.requestFocus();
		jtfNomeCliente.setEditable(true);
		jtfCPFCliente.setEditable(true);
		jtfCNPJCliente.setEditable(true);
		
		jtfNomeCliente.setText("");
		jtfCPFCliente.setText("");
		jtfCNPJCliente.setText("");
		
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbNovoVeiculo.setEnabled(true);
		jbEditar.setEnabled(false);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
	}
	
	public void acionarBotaoNovoVeiculo() {
		if(jtfNomeCliente.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "É Obrigatório ter um cliente informado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCliente.requestFocus();
		} else {
			jtfNomeVeiculo.requestFocus();
			
			jtfNomeVeiculo.setText("");
			jtfPlacaVeiculo.setText("");
			
			jtfNomeVeiculo.setEditable(true);
			jtfPlacaVeiculo.setEditable(true);
			
			jbNovoVeiculo.setEnabled(false);
			jbEditarVeiculo.setEnabled(false);
			jbExcluirVeiculo.setEnabled(false);
			jbSalvarVeiculo.setEnabled(true);
			jbCancelarVeiculo.setEnabled(true);
		}
	}
	
	public void acionarBotaoSalvarCliente() {
		jtfBuscarNomeCliente.requestFocus();
		jtfNomeCliente.setEditable(false);
		jtfCPFCliente.setEditable(false);
		jtfCNPJCliente.setEditable(false);
		
		if(jtfNomeCliente.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "É Obrigatório informar um nome para o cliente!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfNomeCliente.requestFocus();
		} else if(jtfCPFCliente.getText().equals("   .   .   -  ") && jtfCNPJCliente.getText().equals("  .   .   /    -  ")) {
			JOptionPane.showMessageDialog(null, "É Obrigatório informar um CPF ou CNPJ para o cliente!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			jtfCPFCliente.requestFocus();
		} else {
			if(MongoDao.getDAO().buscaGenerica(Cliente.class, "nome", jtfNomeCliente.getText()) == null) {
				cliente.setNome(jtfNomeCliente.getText());
				cliente.setCpf(jtfCPFCliente.getText());
				cliente.setCnpj(jtfCNPJCliente.getText());
//aqui ta o segredo, ele seta a lista de carros do cliente igual a que esta sendo mostrada na tabela.
				cliente.setCarros(this.listaCarros);
//depois eh soh salvar o cliente ele salva a lista de carros..
				MongoDao.getDAO().salvar(cliente);
			} else {
				cliente.setNome(jtfNomeCliente.getText());
				cliente.setCpf(jtfCPFCliente.getText());
				cliente.setCnpj(jtfCNPJCliente.getText());
				//O mesmo o corre no update
				cliente.setCarros(this.listaCarros);
				MongoDao.getDAO().update(cliente, "nome", cliente.getNome());
			}
			
			jbBuscar.setEnabled(true);
			jbNovo.setEnabled(true);
			jbEditar.setEnabled(true);
			jbExcluir.setEnabled(true);
			jbSalvar.setEnabled(false);
			jbCancelar.setEnabled(false);
		}
	}
	
	public void acionarBotaoSalvarVeiculo() {
		//Instancia um novo objeto novoCarro com base nos dados inseridos.
		Carro novoCarro = new Carro(jtfNomeVeiculo.getText(), jtfPlacaVeiculo.getText());
		//Insere o novoCarro na lista.
		this.listaCarros.add(novoCarro);
		//Salva o cliente com a nova lista de carros no banco usando o metodo acionarBotaoSalvarCliente();
		acionarBotaoSalvarCliente();
		//adiciona o novoCarro na tabela. :)
		dtmListaVeiculoCliente.addRow(novoCarro.vetorDados());
		jtfNomeVeiculo.setEditable(false);
		jtfPlacaVeiculo.setEditable(false);
		jtfNomeVeiculo.setText("");
		jtfPlacaVeiculo.setText("");
		jbNovoVeiculo.setEnabled(true);
		jbEditarVeiculo.setEnabled(true);
		jbExcluirVeiculo.setEnabled(true);
		jbSalvarVeiculo.setEnabled(false);
		jbCancelarVeiculo.setEnabled(false);
	}
	
	public void acionarBotaoEditarCliente() {
		jtfNomeCliente.requestFocus();
		jtfNomeCliente.setEditable(true);
		jtfCPFCliente.setEditable(true);
		jtfCNPJCliente.setEditable(true);
		jbBuscar.setEnabled(false);
		jbNovo.setEnabled(false);
		jbEditar.setEnabled(true);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(true);
		jbCancelar.setEnabled(true);
		jbNovoVeiculo.setEnabled(true);
		jbEditarVeiculo.setEnabled(true);
	}
	
	public void acionarBotaoEditarVeiculo() {
		jtfNomeVeiculo.requestFocus();
		jtfNomeVeiculo.setEditable(true);
		jtfPlacaVeiculo.setEditable(true);
		jtfNomeVeiculo.setText("");
		jtfPlacaVeiculo.setText("");
		jbNovoVeiculo.setEnabled(false);
		jbEditarVeiculo.setEnabled(true);
		jbExcluirVeiculo.setEnabled(false);
		jbSalvarVeiculo.setEnabled(true);
		jbCancelarVeiculo.setEnabled(true);
	}
	
	public void acionarBotaoExcluirCliente() {
		cliente = new Cliente();
		if(!jtfBuscarCPFCliente.getText().equals("   .   .   -  ")) {
			cliente.setCpf(jtfCPFCliente.getText());
			MongoDao.getDAO().remove(cliente, "cpf", cliente.getCpf());
			JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jtfBuscarNomeCliente.requestFocus();
		} else {
			cliente.setCnpj(jtfCNPJCliente.getText());
			MongoDao.getDAO().remove(cliente, "cnpj", cliente.getCnpj());
			JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			jtfBuscarNomeCliente.requestFocus();
		}
	
		jtfNomeCliente.setEditable(false);
		jtfCPFCliente.setEditable(false);
		jtfCNPJCliente.setEditable(false);
		
		jtfNomeCliente.setText("");
		jtfCPFCliente.setText("");
		jtfCNPJCliente.setText("");
		
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(false);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void acionarBotaoExcluirVeiculo() {
		//procedimentos para exclusão.
		
		if(jttListaVeiculoCliente.getSelectedRow() == -1){
			JOptionPane.showMessageDialog(null, "Nenhum Carro foi selecionado!!!\n"
					+ "Por gentileza, selecionar um carro para deletar!!!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		else{
			Integer selecionado = jttListaVeiculoCliente.getSelectedRow();
			System.out.println(listaCarros.get(selecionado).getNome());
			listaCarros.remove(selecionado);
			dtmListaVeiculoCliente.removeRow(selecionado);
			acionarBotaoSalvarCliente();
		}
		
		jtfNomeVeiculo.setEditable(false);
		jtfPlacaVeiculo.setEditable(false);
		jtfNomeVeiculo.setText("");
		jtfPlacaVeiculo.setText("");
		jbNovoVeiculo.setEnabled(true);
		jbEditarVeiculo.setEnabled(false);
		jbExcluirVeiculo.setEnabled(false);
		jbSalvarVeiculo.setEnabled(false);
		jbCancelarVeiculo.setEnabled(false);
	}
	
	public void acionarBotaoCancelarCliente() {
		jtfBuscarNomeCliente.requestFocus();
		jtfNomeCliente.setEditable(false);
		jtfCPFCliente.setEditable(false);
		jtfCNPJCliente.setEditable(false);
		
		jtfNomeCliente.setText("");
		jtfCPFCliente.setText("");
		jtfCNPJCliente.setText("");
		
		jbBuscar.setEnabled(true);
		jbNovo.setEnabled(true);
		jbEditar.setEnabled(false);
		jbExcluir.setEnabled(false);
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
	}
	
	public void acionarBotaoCancelarVeiculo() {
		jtfNomeVeiculo.setEditable(false);
		jtfPlacaVeiculo.setEditable(false);
		
		jtfNomeVeiculo.setText("");
		jtfPlacaVeiculo.setText("");
		
		jbNovoVeiculo.setEnabled(true);
		jbEditarVeiculo.setEnabled(false);
		jbExcluirVeiculo.setEnabled(false);
		jbSalvarVeiculo.setEnabled(false);
		jbCancelarVeiculo.setEnabled(false);
	}
	
	public void preencheCamposCliente(Cliente cliente) {
		jtfNomeCliente.setText(cliente.getNome());
		jtfCPFCliente.setText(cliente.getCpf());
		jtfCNPJCliente.setText(cliente.getCnpj());
		listaCarros = cliente.getCarros();
		listaCarros.forEach(carro -> {
			dtmListaVeiculoCliente.addRow(carro.vetorDados());
		});
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
	
	public void botaoNovoCliente() {
		jbNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbNovo) {
					acionarBotaoNovoCliente();
				}
			}
		});
	}
	
	public void botaoNovoVeiculo() {
		jbNovoVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbNovoVeiculo) {
					acionarBotaoNovoVeiculo();
				}
			}
		});
	}
	
	public void botaoSalvarCliente() {
		jbSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbSalvar) {
					acionarBotaoSalvarCliente();
				}
			}
		});
	}
	
	public void botaoSalvarVeiculo() {
		jbSalvarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbSalvarVeiculo) {
					acionarBotaoSalvarVeiculo();
				}
			}
		});
	}
	
	public void botaoEditarCliente() {
		jbEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbEditar) {
					acionarBotaoEditarCliente();
				}
			}
		});
	}
	
	public void botaoEditarVeiculo() {
		jbEditarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbEditarVeiculo) {
					acionarBotaoEditarVeiculo();
				}
			}
		});
	}
	
	public void botaoExcluirCliente() {
		jbExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbExcluir) {
					acionarBotaoExcluirCliente();
				}
			}
		});
	}
	
	public void botaoExcluirVeiculo() {
		jbExcluirVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbExcluirVeiculo) {
					acionarBotaoExcluirVeiculo();
				}
			}
		});
	}
	
	public void botaoCancelarCliente() {
		jbCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbCancelar) {
					acionarBotaoCancelarCliente();
				}
			}
		});
	}
	
	public void botaoCancelarVeiculo() {
		jbCancelarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbCancelarVeiculo) {
					acionarBotaoCancelarVeiculo();
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
		setResizable(false);
		componentesClienteForm();
		botaoBuscar();
		botaoNovoCliente();
		botaoSalvarCliente();
		botaoEditarCliente();
		botaoExcluirCliente();
		botaoCancelarCliente();
		botaoNovoVeiculo();
		botaoSalvarVeiculo();
		botaoEditarVeiculo();
		botaoExcluirVeiculo();
		botaoCancelarVeiculo();
		botaoFechar();
	}
	
	@Override
	public void preencherCampos(MinhaEntidade entidade) {
		this.preencheCamposCliente((Cliente)entidade);
	}
}