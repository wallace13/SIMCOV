package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.GerenciadorPacientes;
import controller.GerenciadorSintomas;
import controller.ValidadorCampos;
import model.Paciente;
import model.Sintoma;
import model.DAO.PacienteDAO;
import model.DAO.SintomaDAO;

public class PainelPaciente extends JPanel {
	JFormattedTextField textFieldCpf;
	private JTextField textFieldComplemento, textFieldCep, textFieldTelefone , textFieldTelefoneParente;
	Paciente paciente;
	Sintoma sintoma;

	public PainelPaciente(JPanel painelPai) {

		setLayout(null);
		setPreferredSize(new Dimension(800 , 600));

		JPanel subPainel1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) subPainel1.getLayout();
		subPainel1.setBounds(10 , 63 , 780 , 390);

		add(subPainel1);

		JPanel subPainel2 = new JPanel();
		subPainel2.setBounds(10 , 25 , 780 , 40);
		add(subPainel2);
		/////////////////////////////////////////////////////////////////////

		JLabel labelCpf = new JLabel("CPF do Paciente");
		labelCpf.setPreferredSize(new Dimension(100, 25));
		labelCpf.setMinimumSize(new Dimension(200 , 25));
		labelCpf.setMaximumSize(new Dimension(200 , 25));
		labelCpf.setAlignmentX(Component.CENTER_ALIGNMENT);


		try
		{
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");

			textFieldCpf = new JFormattedTextField(mascaraCpf);
			textFieldCpf.setPreferredSize(new Dimension(300, 25));
			textFieldCpf.setMinimumSize(new Dimension(200 , 25));
			textFieldCpf.setMaximumSize(new Dimension(200 , 25));
			textFieldCpf.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		catch (Exception e)
		{

		}

		subPainel2.add(labelCpf);
		subPainel2.add(textFieldCpf);



		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setPreferredSize(new Dimension(200, 25));
		botaoPesquisar.setMinimumSize(new Dimension(200 , 25));
		botaoPesquisar.setMaximumSize(new Dimension(200 , 25));
		botaoPesquisar.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPainel2.add(botaoPesquisar);
		/////////////////////////////////////////////////////////////////////

		JLabel labelPaciente = new JLabel("Dados do Paciente");
		labelPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		labelPaciente.setPreferredSize(new Dimension(780, 25));
		labelPaciente.setMinimumSize(new Dimension(200 , 25));
		labelPaciente.setMaximumSize(new Dimension(200 , 25));
		labelPaciente.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPainel1.add(labelPaciente);



		JLabel labelNome = new JLabel("Nome Completo" , SwingConstants.LEFT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelNome.setPreferredSize(new Dimension(100, 25));
		labelNome.setMinimumSize(new Dimension(200 , 25));
		labelNome.setMaximumSize(new Dimension(200 , 25));
		labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldNome.setPreferredSize(new Dimension(400, 25));
		textFieldNome.setMinimumSize(new Dimension(200 , 25));
		textFieldNome.setMaximumSize(new Dimension(200 , 25));
		textFieldNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		textFieldNome.setEnabled(false);

		subPainel1.add(labelNome);
		subPainel1.add(textFieldNome);

		////////////////////////////////////////////////////////////////////////////////

		JLabel labelSexo = new JLabel("Sexo", SwingConstants.LEFT);
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelSexo.setPreferredSize(new Dimension(100, 25));
		textFieldCpf.setMinimumSize(new Dimension(200 , 25));
		textFieldCpf.setMaximumSize(new Dimension(200 , 25));
		labelSexo.setAlignmentX(Component.CENTER_ALIGNMENT);

		String[] sexos = {"Masculino" , "Feminino"}; 
		JComboBox comboBoxSexo = new JComboBox(sexos);
		comboBoxSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxSexo.setPreferredSize(new Dimension(150, 25));
		comboBoxSexo.setMinimumSize(new Dimension(200 , 25));
		comboBoxSexo.setMaximumSize(new Dimension(200 , 25));
		comboBoxSexo.setAlignmentX(Component.CENTER_ALIGNMENT);  
		comboBoxSexo.setEnabled(false);

		subPainel1.add(labelSexo);
		subPainel1.add(comboBoxSexo);

		/////////////////////////////////////////////////////////////////////

		JLabel labelDataNascimento = new JLabel("Data de Nascimento");
		labelDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelDataNascimento.setPreferredSize(new Dimension(100, 25));
		labelDataNascimento.setMinimumSize(new Dimension(200 , 25));
		labelDataNascimento.setMaximumSize(new Dimension(200 , 25));
		labelDataNascimento.setAlignmentX(Component.CENTER_ALIGNMENT);


		JTextField textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldDataNascimento.setPreferredSize(new Dimension(100, 25));
		textFieldDataNascimento.setMinimumSize(new Dimension(200 , 25));
		textFieldDataNascimento.setMaximumSize(new Dimension(200 , 25));
		textFieldDataNascimento.setEnabled(false);


		subPainel1.add(labelDataNascimento);
		subPainel1.add(textFieldDataNascimento);

		/////////////////////////////////////////////////////////////////////

		JLabel labelIdade = new JLabel("Idade");
		labelIdade.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelIdade.setPreferredSize(new Dimension(50, 25));
		labelIdade.setMinimumSize(new Dimension(50 , 25));
		labelIdade.setMaximumSize(new Dimension(50 , 25));
		labelIdade.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldIdade = new JTextField();
		textFieldIdade.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldIdade.setPreferredSize(new Dimension(50, 25));
		textFieldIdade.setMinimumSize(new Dimension(50 , 25));
		textFieldIdade.setMaximumSize(new Dimension(50 , 25));
		textFieldIdade.setAlignmentX(Component.CENTER_ALIGNMENT);
		textFieldIdade.setEnabled(false);

		subPainel1.add(labelIdade);
		subPainel1.add(textFieldIdade);

		/////////////////////////////////////////////////////////////////////

		JLabel labelTelefoneParente = new JLabel("Telefone Parente" , SwingConstants.LEFT);
		labelTelefoneParente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelTelefoneParente.setPreferredSize(new Dimension(100, 25));
		labelTelefoneParente.setMinimumSize(new Dimension(200 , 25));
		labelTelefoneParente.setMaximumSize(new Dimension(200 , 25));
		labelTelefoneParente.setAlignmentX(Component.CENTER_ALIGNMENT);

		try
		{
			MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
			textFieldTelefoneParente = new JFormattedTextField(mascaraTelefone);
			textFieldTelefoneParente.setFont(new Font("Tahoma", Font.BOLD, 11));
			textFieldTelefoneParente.setPreferredSize(new Dimension(140, 25));
			textFieldTelefoneParente.setMinimumSize(new Dimension(200 , 25));
			textFieldTelefoneParente.setMaximumSize(new Dimension(200 , 25));
			textFieldTelefoneParente.setAlignmentX(Component.CENTER_ALIGNMENT);
			textFieldTelefoneParente.setEnabled(false);
		}
		catch (ParseException e1)
		{

		}

		textFieldTelefoneParente.setEnabled(false);

		subPainel1.add(labelTelefoneParente);
		subPainel1.add(textFieldTelefoneParente);

		/////////////////////////////////////////////////////////////////////

		JLabel labelTelefone = new JLabel("Telefone" , SwingConstants.LEFT);
		labelTelefone.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelTelefone.setPreferredSize(new Dimension(50, 25));
		labelTelefone.setMinimumSize(new Dimension(200 , 25));
		labelTelefone.setMaximumSize(new Dimension(200 , 25));
		labelTelefone.setAlignmentX(Component.CENTER_ALIGNMENT);

		try
		{
			MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
			textFieldTelefone = new JFormattedTextField(mascaraTelefone);
			textFieldTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
			textFieldTelefone.setPreferredSize(new Dimension(140, 25));
			textFieldTelefone.setMinimumSize(new Dimension(200 , 25));
			textFieldTelefone.setMaximumSize(new Dimension(200 , 25));
			textFieldTelefone.setEnabled(false);
		}
		catch (ParseException e1)
		{

		}

		textFieldTelefone.setEnabled(false);

		subPainel1.add(labelTelefone);
		subPainel1.add(textFieldTelefone);

		/////////////////////////////////////////////////////////////////////

		JLabel labelEndereco = new JLabel("Dados do Endere\u00E7o");
		labelEndereco.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		labelEndereco.setPreferredSize(new Dimension(780, 50));
		labelEndereco.setMinimumSize(new Dimension(200 , 25));
		labelEndereco.setMaximumSize(new Dimension(200 , 25));
		labelEndereco.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPainel1.add(labelEndereco);

		/////////////////////////////////////////////////////////////////////

		JLabel labelLogradouro = new JLabel("Logradouro" , SwingConstants.LEFT);
		labelLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelLogradouro.setPreferredSize(new Dimension(100, 25));
		labelLogradouro.setMinimumSize(new Dimension(200 , 25));
		labelLogradouro.setMaximumSize(new Dimension(200 , 25));
		labelLogradouro.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldLogradouro = new JTextField();
		textFieldLogradouro.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldLogradouro.setPreferredSize(new Dimension(460, 25));
		textFieldLogradouro.setMinimumSize(new Dimension(200 , 25));
		textFieldLogradouro.setMaximumSize(new Dimension(200 , 25));
		textFieldLogradouro.setAlignmentX(Component.CENTER_ALIGNMENT);
		textFieldLogradouro.setEnabled(false);

		subPainel1.add(labelLogradouro);
		subPainel1.add(textFieldLogradouro);

		/////////////////////////////////////////////////////////////////////


		JLabel labelNumero = new JLabel("N\u00BA" , SwingConstants.LEFT);
		labelNumero.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelNumero.setPreferredSize(new Dimension(30, 25));
		labelNumero.setMinimumSize(new Dimension(80 , 25));
		labelNumero.setMaximumSize(new Dimension(80 , 25));

		JTextField textFieldNumero = new JTextField();
		textFieldNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldNumero.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldNumero.setPreferredSize(new Dimension(160, 25));
		textFieldNumero.setMinimumSize(new Dimension(80 , 25));
		textFieldNumero.setMaximumSize(new Dimension(80 , 25));
		textFieldNumero.setEnabled(false);

		subPainel1.add(labelNumero);
		subPainel1.add(textFieldNumero);
		/////////////////////////////////////////////////////////////////////	

		JLabel labelComplemento = new JLabel("Complemento");
		labelComplemento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelComplemento.setPreferredSize(new Dimension(100, 25));
		labelComplemento.setMinimumSize(new Dimension(200 , 25));
		labelComplemento.setMaximumSize(new Dimension(200 , 25));
		labelComplemento.setAlignmentX(Component.CENTER_ALIGNMENT);

		textFieldComplemento = new JTextField();
		textFieldComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldComplemento.setPreferredSize(new Dimension(80, 25));
		textFieldComplemento.setMinimumSize(new Dimension(200 , 25));
		textFieldComplemento.setMaximumSize(new Dimension(200 , 25));
		textFieldComplemento.setAlignmentX(Component.CENTER_ALIGNMENT);
		textFieldComplemento.setEnabled(false);

		subPainel1.add(labelComplemento);
		subPainel1.add(textFieldComplemento);


		/////////////////////////////////////////////////////////////////////

		JLabel labelBairro = new JLabel("Bairro" , SwingConstants.LEFT);
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelBairro.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelBairro.setPreferredSize(new Dimension(50, 25));
		labelBairro.setMinimumSize(new Dimension(200 , 25));
		labelBairro.setMaximumSize(new Dimension(200 , 25));
		labelBairro.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldBairro.setPreferredSize(new Dimension(120, 25));
		textFieldBairro.setMinimumSize(new Dimension(200 , 25));
		textFieldBairro.setMaximumSize(new Dimension(200 , 25));
		textFieldBairro.setAlignmentX(Component.CENTER_ALIGNMENT);
		textFieldBairro.setEnabled(false);

		subPainel1.add(labelBairro);
		subPainel1.add(textFieldBairro);


		/////////////////////////////////////////////////////////////////////

		JLabel labelCidade = new JLabel("Cidade" , SwingConstants.LEFT);
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelCidade.setPreferredSize(new Dimension(50, 25));
		labelCidade.setMinimumSize(new Dimension(200 , 25));
		labelCidade.setMaximumSize(new Dimension(200 , 25));
		labelCidade.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldCidade.setPreferredSize(new Dimension(140, 25));
		textFieldCidade.setMinimumSize(new Dimension(200 , 25));
		textFieldCidade.setMaximumSize(new Dimension(200 , 25));
		textFieldCidade.setAlignmentX(Component.CENTER_ALIGNMENT);
		textFieldCidade.setEnabled(false);

		subPainel1.add(labelCidade);
		subPainel1.add(textFieldCidade);

		/////////////////////////////////////////////////////////////////////

		JLabel labelCep = new JLabel("CEP" , SwingConstants.LEFT);
		labelCep.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelCep.setPreferredSize(new Dimension(30, 25));
		labelCep.setMinimumSize(new Dimension(200 , 25));
		labelCep.setMaximumSize(new Dimension(200 , 25));
		labelCep.setAlignmentX(Component.CENTER_ALIGNMENT);

		try
		{
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");
			textFieldCep = new JFormattedTextField(mascaraCep);
			textFieldCep.setFont(new Font("Tahoma", Font.BOLD, 11));
			textFieldCep.setPreferredSize(new Dimension(80, 25));
			textFieldCep.setMinimumSize(new Dimension(200 , 25));
			textFieldCep.setMaximumSize(new Dimension(200 , 25));
			textFieldCep.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		catch (ParseException e1)
		{

		}

		textFieldCep.setEnabled(false);

		subPainel1.add(labelCep);
		subPainel1.add(textFieldCep);
		/////////////////////////////////////////////////////////////////////
		JLabel labelUf = new JLabel("UF");
		labelUf.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelUf.setPreferredSize(new Dimension(20, 25));
		labelUf.setBounds(0 , 0 , 50 , 25);

		String[] estados = {"AC" , "AL" , "AM" , "AP" , "BA" , "CE" , "DF" , "ES" , "GO" , "MA" , "MG" , "MS" , "MT" ,
				"PA" , "PB" , "PE" , "PI" , "PR" , "RJ" , "RN" , "RO" , "RR" , "RS" , "SC" , "SE"  , "SP" ,
		"TO"};

		JComboBox comboBoxUf = new JComboBox(estados);
		comboBoxUf.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxUf.setPreferredSize(new Dimension(50, 25));
		comboBoxUf.setMinimumSize(new Dimension(50 , 25));
		comboBoxUf.setMaximumSize(new Dimension(50 , 25));
		comboBoxUf.setEnabled(false);

		JPanel painelUf = new JPanel();
		painelUf.setLayout(new BoxLayout(painelUf , BoxLayout.PAGE_AXIS));
		painelUf.setPreferredSize(new Dimension(200 , 50));
		painelUf.setBounds(628 , 276 , 85 , 50);

		subPainel1.add(labelUf);
		subPainel1.add(comboBoxUf);

		/////////////////////////////////////////////////////////////////////
		JLabel labelCaso = new JLabel("Dados do Caso");
		labelCaso.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCaso.setHorizontalAlignment(SwingConstants.CENTER);
		labelCaso.setPreferredSize(new Dimension(780, 50));
		labelCaso.setMinimumSize(new Dimension(200 , 25));
		labelCaso.setMaximumSize(new Dimension(200 , 25));
		labelCaso.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPainel1.add(labelCaso);

		/////////////////////////////////////////////////////////////////////
		JLabel labelDataSintoma = new JLabel("Data do Primeiro Sintoma:");
		labelDataSintoma.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDataSintoma.setPreferredSize(new Dimension(200, 25));
		labelDataSintoma.setMinimumSize(new Dimension(200 , 25));
		labelDataSintoma.setMaximumSize(new Dimension(200 , 25));
		labelDataSintoma.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldDataSintoma = new JTextField();
		textFieldDataSintoma.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldDataSintoma.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldDataSintoma.setPreferredSize(new Dimension(200, 25));
		textFieldDataSintoma.setMinimumSize(new Dimension(200 , 25));
		textFieldDataSintoma.setMaximumSize(new Dimension(200 , 25));
		textFieldDataSintoma.setAlignmentX(Component.CENTER_ALIGNMENT);
		textFieldDataSintoma.setEnabled(false);

		subPainel1.add(labelDataSintoma);
		subPainel1.add(textFieldDataSintoma);

		/////////////////////////////////////////////////////////////////////
		JLabel labelSintomas = new JLabel("Sintomas Relatados pelo Paciente:");
		labelSintomas.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelSintomas.setHorizontalAlignment(SwingConstants.LEFT);
		labelSintomas.setPreferredSize(new Dimension(760, 25));
		labelSintomas.setMinimumSize(new Dimension(200 , 25));
		labelSintomas.setMaximumSize(new Dimension(200 , 25));
		labelSintomas.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPainel1.add(labelSintomas);

		JTextField textFieldSintomas = new JTextField();
		textFieldSintomas.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldSintomas.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSintomas.setPreferredSize(new Dimension(700, 50));
		textFieldSintomas.setMinimumSize(new Dimension(200 , 25));
		textFieldSintomas.setMaximumSize(new Dimension(200 , 25));
		textFieldSintomas.setEnabled(false);
		subPainel1.add(textFieldSintomas);

		/////////////////////////////////////////////////////////////////////



		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setPreferredSize(new Dimension(200 , 25));
		botaoVoltar.setBounds(150 , 490 , 200 , 25);

		botaoVoltar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				painelPai.add(new HomePaciente(painelPai));
				setVisible(false);
			}
		});

		add(botaoVoltar);

		/////////////////////////////////////////////////////////////////////

		JButton botaoConfirmar = new JButton("Confirmar Alterações");
		botaoConfirmar.setVisible(false);
		botaoConfirmar.setPreferredSize(new Dimension(200 , 25));
		botaoConfirmar.setBounds(450 , 490 , 200 , 25);

		/////////////////////////////////////////////////////////////////////
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setVisible(false);
		botaoCancelar.setPreferredSize(new Dimension(200 , 25));
		botaoCancelar.setBounds(150 , 490 , 200 , 25);
		/////////////////////////////////////////////////////////////////////
		JButton botaoAtualizar = new JButton("Atualizar Informações");
		botaoAtualizar.setPreferredSize(new Dimension(200 , 25));
		botaoAtualizar.setBounds(450 , 490 , 200 , 25);
		/////////////////////////////////////////////////////////////////////
		botaoCancelar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				textFieldNome.setEnabled(false);
				comboBoxSexo.setEnabled(false);
				textFieldDataNascimento.setEnabled(false);
				textFieldIdade.setEnabled(false);
				textFieldTelefoneParente.setEnabled(false);
				textFieldTelefone.setEnabled(false);
				textFieldLogradouro.setEnabled(false);
				textFieldBairro.setEnabled(false);
				textFieldCidade.setEnabled(false);
				textFieldCep.setEnabled(false);
				textFieldComplemento.setEnabled(false);
				textFieldNumero.setEnabled(false);
				comboBoxUf.setEnabled(false);
				textFieldDataSintoma.setEnabled(false);
				textFieldSintomas.setEnabled(false);


				botaoCancelar.setVisible(false);
				botaoConfirmar.setVisible(false);
				botaoAtualizar.setVisible(true);
				botaoVoltar.setVisible(true);
			}
		});

		add(botaoCancelar);

		/////////////////////////////////////////////////////////////////////

		botaoAtualizar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String[] camposAChecar = {textFieldCpf.getText(), textFieldNome.getText()};
				
				if (ValidadorCampos.checarSeHaVazio(camposAChecar)){					
					new TelaAvisoGenerica("Nenhum CPF foi pesquisado ainda.");
				}else{
					textFieldNome.setEnabled(true);
					comboBoxSexo.setEnabled(true);
					textFieldDataNascimento.setEnabled(true);
					textFieldIdade.setEnabled(true);
					textFieldTelefoneParente.setEnabled(true);
					textFieldTelefone.setEnabled(true);
					textFieldLogradouro.setEnabled(true);
					textFieldBairro.setEnabled(true);
					textFieldCidade.setEnabled(true);
					textFieldCep.setEnabled(true);
					textFieldComplemento.setEnabled(true);
					textFieldNumero.setEnabled(true);
					comboBoxUf.setEnabled(true);
					textFieldDataSintoma.setEnabled(true);
					textFieldSintomas.setEnabled(true);
	
					botaoCancelar.setVisible(true);
					botaoConfirmar.setVisible(true);
					botaoVoltar.setVisible(false);
					botaoAtualizar.setVisible(false);
				}
							
			}
		});

		add(botaoAtualizar);

		/////////////////////////////////////////////////////////////////////
		botaoConfirmar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String[] camposAChecar = {

						textFieldCpf.getText(),
						textFieldNome.getText(),
						(String) comboBoxSexo.getSelectedItem(),
						textFieldDataNascimento.getText(),
						textFieldIdade.getText(),
						textFieldLogradouro.getText() ,
						textFieldNumero.getText(),
						textFieldBairro.getText(),
						textFieldCidade.getText(),
						(String)comboBoxUf.getSelectedItem(),
						textFieldCep.getText(),
						textFieldTelefone.getText(),
						textFieldDataSintoma.getText(),
						textFieldSintomas.getText()
				};

				if (ValidadorCampos.checarSeHaVazio(camposAChecar))
					new TelaAvisoGenerica("Há campos obrigatórios que não foram preenchidos.");
				else
				{
					int opcao = JOptionPane.showConfirmDialog(null , "Deseja realmente confirmar as alterações?");

					switch (opcao)
					{

					case JOptionPane.YES_OPTION:
						GerenciadorPacientes.alterarPaciente(
								paciente.getCpf(), 
								textFieldNome.getText(),
								(String) comboBoxSexo.getSelectedItem(),
								Integer.parseInt(textFieldIdade.getText()),
								textFieldDataNascimento.getText(),
								textFieldLogradouro.getText() ,
								Integer.parseInt(textFieldNumero.getText()),
								textFieldComplemento.getText(),
								textFieldBairro.getText(),
								textFieldCidade.getText(),
								(String)comboBoxUf.getSelectedItem(),
								textFieldCep.getText(),
								textFieldTelefone.getText(),
								textFieldTelefoneParente.getText());	

						GerenciadorSintomas.alterarSintoma(
								textFieldDataSintoma.getText(), 
								textFieldSintomas.getText(), 
								paciente.getCpf());

						
						textFieldNome.setEnabled(false);
						comboBoxSexo.setEnabled(false);
						textFieldDataNascimento.setEnabled(false);
						textFieldIdade.setEnabled(false);
						textFieldTelefoneParente.setEnabled(false);
						textFieldTelefone.setEnabled(false);
						textFieldLogradouro.setEnabled(false);
						textFieldBairro.setEnabled(false);
						textFieldCidade.setEnabled(false);
						textFieldCep.setEnabled(false);
						textFieldComplemento.setEnabled(false);
						textFieldNumero.setEnabled(false);
						comboBoxUf.setEnabled(false);
						textFieldDataSintoma.setEnabled(false);
						textFieldSintomas.setEnabled(false);


						botaoVoltar.setVisible(true);
						botaoAtualizar.setVisible(true);
						botaoConfirmar.setVisible(false);
						botaoCancelar.setVisible(false);

						break;
					case JOptionPane.NO_OPTION :
						new TelaAvisoGenerica("Revise as informações antes de continuar.");
						break;
						
					case JOptionPane.CANCEL_OPTION:
						textFieldNome.setEnabled(false);
						comboBoxSexo.setEnabled(false);
						textFieldDataNascimento.setEnabled(false);
						textFieldIdade.setEnabled(false);
						textFieldTelefoneParente.setEnabled(false);
						textFieldTelefone.setEnabled(false);
						textFieldLogradouro.setEnabled(false);
						textFieldBairro.setEnabled(false);
						textFieldCidade.setEnabled(false);
						textFieldCep.setEnabled(false);
						textFieldComplemento.setEnabled(false);
						textFieldNumero.setEnabled(false);
						comboBoxUf.setEnabled(false);
						textFieldDataSintoma.setEnabled(false);
						textFieldSintomas.setEnabled(false);


						botaoCancelar.setVisible(false);
						botaoConfirmar.setVisible(false);
						botaoAtualizar.setVisible(true);
						botaoVoltar.setVisible(true);
						new TelaAvisoGenerica("Atualização de dados Cancelada.");
						
						break;
					}
				}
			}
		});

		add(botaoConfirmar);

		/////////////////////////////////////////////////////////////////////
		botaoPesquisar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				paciente = PacienteDAO.buscarPorCpf(textFieldCpf.getText());
				
				if(paciente != null){
					sintoma = SintomaDAO.buscarPorCpf(textFieldCpf.getText());
	
					textFieldNome.setText(paciente.getNomeCompleto());
					comboBoxSexo.setSelectedItem(paciente.getSexo());
					textFieldDataNascimento.setText(paciente.getDataNascimento());
					textFieldIdade.setText(Integer.toString(paciente.getIdade()));
					textFieldTelefoneParente.setText(paciente.getTelefoneParente());
					textFieldTelefone.setText(paciente.getTelefone());
					textFieldLogradouro.setText(paciente.getLogradouro());
					textFieldBairro.setText(paciente.getBairro());
					textFieldCidade.setText(paciente.getCidade());
					textFieldCep.setText(paciente.getCep());
					textFieldNumero.setText(Integer.toString(paciente.getNumero()));
					textFieldComplemento.setText(paciente.getComplemento());
					comboBoxUf.setSelectedItem(paciente.getUf());
					textFieldDataSintoma.setText(sintoma.getDataDeInicio());
					textFieldSintomas.setText(sintoma.getTipoDeSintoma());
					
				}else{
					 new TelaAvisoGenerica("CPF não ecnontrado.");
				}

			}
		});


	}

}
