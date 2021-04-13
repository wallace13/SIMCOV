package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
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

import java.awt.Font;

public class PainelCadastraPaciente extends JPanel {

	JFormattedTextField textFieldCpf = new JFormattedTextField();
	private JTextField textFieldComplemento;
	private JFormattedTextField textFieldCep,textFieldDataNascimento, textFieldTelefone , textFieldTelefoneParente, textFieldDataSintoma;
	private JTextField textFieldSintomas;

	public PainelCadastraPaciente(JPanel painelPai) {

		setLayout(null);
		setPreferredSize(new Dimension(800 , 600));

		JPanel subPainel1 = new JPanel();
		subPainel1.setBounds(10 , 25 , 780 , 400);

		add(subPainel1);

		JLabel labelPaciente = new JLabel("Dados do Paciente");
		labelPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		labelPaciente.setPreferredSize(new Dimension(780, 25));
		labelPaciente.setMinimumSize(new Dimension(200 , 25));
		labelPaciente.setMaximumSize(new Dimension(200 , 25));
		labelPaciente.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPainel1.add(labelPaciente);

		/////////////////////////////////////////////////////////////////////

		JLabel labelNome = new JLabel("Nome Completo" , SwingConstants.LEFT);
		labelNome.setPreferredSize(new Dimension(100, 25));
		labelNome.setMinimumSize(new Dimension(200 , 25));
		labelNome.setMaximumSize(new Dimension(200 , 25));
		labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldNome = new JTextField();
		textFieldNome.setPreferredSize(new Dimension(650, 25));
		textFieldNome.setMinimumSize(new Dimension(200 , 25));
		textFieldNome.setMaximumSize(new Dimension(200 , 25));
		textFieldNome.setAlignmentX(Component.CENTER_ALIGNMENT);



		subPainel1.add(labelNome);
		subPainel1.add(textFieldNome);

		/////////////////////////////////////////////////////////////////////

		JLabel labelCpf = new JLabel("CPF" , SwingConstants.LEFT);
		labelCpf.setPreferredSize(new Dimension(100, 25));
		labelCpf.setMinimumSize(new Dimension(200 , 25));
		labelCpf.setMaximumSize(new Dimension(200 , 25));
		labelCpf.setAlignmentX(Component.CENTER_ALIGNMENT);
		try
		{
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");

			textFieldCpf = new JFormattedTextField(mascaraCpf);
			textFieldCpf.setPreferredSize(new Dimension(150, 25));
			textFieldCpf.setMinimumSize(new Dimension(200 , 25));
			textFieldCpf.setMaximumSize(new Dimension(200 , 25));
			textFieldCpf.setAlignmentX(Component.CENTER_ALIGNMENT);  
		}
		catch (Exception e)
		{

		}

		subPainel1.add(labelCpf);
		subPainel1.add(textFieldCpf);


		/////////////////////////////////////////////////////////////////////

		JLabel labelDataNascimento = new JLabel("Data de Nascimento");
		labelDataNascimento.setPreferredSize(new Dimension(100, 25));
		labelDataNascimento.setMinimumSize(new Dimension(200 , 25));
		labelDataNascimento.setMaximumSize(new Dimension(200 , 25));
		labelDataNascimento.setAlignmentX(Component.CENTER_ALIGNMENT);

		try
		{
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			textFieldDataNascimento = new JFormattedTextField(mascaraData);
			textFieldDataNascimento.setPreferredSize(new Dimension(140, 25));
			textFieldDataNascimento.setMinimumSize(new Dimension(200 , 25));
			textFieldDataNascimento.setMaximumSize(new Dimension(200 , 25));
		}
		catch (ParseException e1)
		{

		}

		subPainel1.add(labelDataNascimento);
		subPainel1.add(textFieldDataNascimento);

		/////////////////////////////////////////////////////////////////////

		JLabel labelIdade = new JLabel("Idade");
		labelIdade.setPreferredSize(new Dimension(100, 25));
		labelIdade.setMinimumSize(new Dimension(50 , 25));
		labelIdade.setMaximumSize(new Dimension(50 , 25));
		labelIdade.setAlignmentX(Component.CENTER_ALIGNMENT);		

		JTextField textFieldIdade = new JTextField();
		textFieldIdade.setPreferredSize(new Dimension(140, 25));
		textFieldIdade.setMinimumSize(new Dimension(50 , 25));
		textFieldIdade.setMaximumSize(new Dimension(50 , 25));
		textFieldIdade.setAlignmentX(Component.CENTER_ALIGNMENT);

		subPainel1.add(labelIdade);
		subPainel1.add(textFieldIdade);

		/////////////////////////////////////////////////////////////////////

		JLabel labelSexo = new JLabel("Sexo", SwingConstants.LEFT);
		labelSexo.setPreferredSize(new Dimension(100, 25));
		labelSexo.setMinimumSize(new Dimension(200 , 25));
		labelSexo.setMaximumSize(new Dimension(200 , 25));
		labelSexo.setAlignmentX(Component.CENTER_ALIGNMENT);		

		String[] sexos = {"Masculino" , "Feminino"}; 
		JComboBox comboBoxSexo = new JComboBox(sexos);
		comboBoxSexo.setPreferredSize(new Dimension(150, 25));
		comboBoxSexo.setMinimumSize(new Dimension(200 , 25));
		comboBoxSexo.setMaximumSize(new Dimension(200 , 25));
		comboBoxSexo.setAlignmentX(Component.CENTER_ALIGNMENT);  

		subPainel1.add(labelSexo);
		subPainel1.add(comboBoxSexo);

		/////////////////////////////////////////////////////////////////////

		JLabel labelTelefone = new JLabel("Telefone" , SwingConstants.LEFT);
		labelTelefone.setPreferredSize(new Dimension(100, 25));
		labelTelefone.setMinimumSize(new Dimension(200 , 25));
		labelTelefone.setMaximumSize(new Dimension(200 , 25));
		labelTelefone.setAlignmentX(Component.CENTER_ALIGNMENT);

		try
		{
			MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
			textFieldTelefone = new JFormattedTextField(mascaraTelefone);
			textFieldTelefone.setPreferredSize(new Dimension(140, 25));
			textFieldTelefone.setMinimumSize(new Dimension(200 , 25));
			textFieldTelefone.setMaximumSize(new Dimension(200 , 25));
			textFieldTelefone.setAlignmentX(Component.CENTER_ALIGNMENT);

		}
		catch (ParseException e1)
		{

		}

		subPainel1.add(labelTelefone);
		subPainel1.add(textFieldTelefone);

		/////////////////////////////////////////////////////////////////////


		JLabel labelTelefoneParente = new JLabel("Telefone Parente" , SwingConstants.LEFT);
		labelTelefoneParente.setPreferredSize(new Dimension(100, 25));
		labelTelefoneParente.setMinimumSize(new Dimension(200 , 25));
		labelTelefoneParente.setMaximumSize(new Dimension(200 , 25));
		labelTelefoneParente.setAlignmentX(Component.CENTER_ALIGNMENT);

		try
		{
			MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
			textFieldTelefoneParente = new JFormattedTextField(mascaraTelefone);
			textFieldTelefoneParente.setPreferredSize(new Dimension(140, 25));
			textFieldTelefoneParente.setMinimumSize(new Dimension(200 , 25));
			textFieldTelefoneParente.setMaximumSize(new Dimension(200 , 25));
			textFieldTelefoneParente.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		catch (ParseException e)
		{

		}

		subPainel1.add(labelTelefoneParente);
		subPainel1.add(textFieldTelefoneParente);

		/////////////////////////////////////////////////////////////////////

		JLabel labelEndereco = new JLabel("Dados do Endere\u00E7o");
		labelEndereco.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		labelEndereco.setPreferredSize(new Dimension(780, 25));
		labelEndereco.setMinimumSize(new Dimension(200 , 25));
		labelEndereco.setMaximumSize(new Dimension(200 , 25));
		labelEndereco.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPainel1.add(labelEndereco);

		/////////////////////////////////////////////////////////////////////

		JLabel labelLogradouro = new JLabel("Logradouro" , SwingConstants.LEFT);
		labelLogradouro.setPreferredSize(new Dimension(100, 25));
		labelLogradouro.setMinimumSize(new Dimension(200 , 25));
		labelLogradouro.setMaximumSize(new Dimension(200 , 25));
		labelLogradouro.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldLogradouro = new JTextField();
		textFieldLogradouro.setPreferredSize(new Dimension(650, 25));
		textFieldLogradouro.setMinimumSize(new Dimension(200 , 25));
		textFieldLogradouro.setMaximumSize(new Dimension(200 , 25));
		textFieldLogradouro.setAlignmentX(Component.CENTER_ALIGNMENT);

		subPainel1.add(labelLogradouro);
		subPainel1.add(textFieldLogradouro);

		/////////////////////////////////////////////////////////////////////

		JLabel labelComplemento = new JLabel("Complemento");
		labelComplemento.setPreferredSize(new Dimension(100, 25));
		labelComplemento.setMinimumSize(new Dimension(200 , 25));
		labelComplemento.setMaximumSize(new Dimension(200 , 25));
		labelComplemento.setAlignmentX(Component.CENTER_ALIGNMENT);

		textFieldComplemento = new JTextField();
		textFieldComplemento.setPreferredSize(new Dimension(150, 25));
		textFieldComplemento.setMinimumSize(new Dimension(200 , 25));
		textFieldComplemento.setMaximumSize(new Dimension(200 , 25));
		textFieldComplemento.setAlignmentX(Component.CENTER_ALIGNMENT);

		subPainel1.add(labelComplemento);
		subPainel1.add(textFieldComplemento);

		/////////////////////////////////////////////////////////////////////		

		JLabel labelNumero = new JLabel("Número" , SwingConstants.LEFT);
		labelNumero.setPreferredSize(new Dimension(100, 25));
		labelNumero.setMinimumSize(new Dimension(80 , 25));
		labelNumero.setMaximumSize(new Dimension(80 , 25));

		JTextField textFieldNumero = new JTextField();
		textFieldNumero.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldNumero.setPreferredSize(new Dimension(140, 25));
		textFieldNumero.setMinimumSize(new Dimension(80 , 25));
		textFieldNumero.setMaximumSize(new Dimension(80 , 25));

		subPainel1.add(labelNumero);
		subPainel1.add(textFieldNumero);

		/////////////////////////////////////////////////////////////////////

		JLabel labelBairro = new JLabel("Bairro" , SwingConstants.LEFT);
		labelBairro.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelBairro.setPreferredSize(new Dimension(100, 25));
		labelBairro.setMinimumSize(new Dimension(200 , 25));
		labelBairro.setMaximumSize(new Dimension(200 , 25));
		labelBairro.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldBairro = new JTextField();
		textFieldBairro.setPreferredSize(new Dimension(140, 25));
		textFieldBairro.setMinimumSize(new Dimension(200 , 25));
		textFieldBairro.setMaximumSize(new Dimension(200 , 25));
		textFieldBairro.setAlignmentX(Component.CENTER_ALIGNMENT);

		subPainel1.add(labelBairro);
		subPainel1.add(textFieldBairro);

		/////////////////////////////////////////////////////////////////////

		JLabel labelCidade = new JLabel("Cidade" , SwingConstants.LEFT);
		labelCidade.setPreferredSize(new Dimension(100, 25));
		labelCidade.setMinimumSize(new Dimension(200 , 25));
		labelCidade.setMaximumSize(new Dimension(200 , 25));
		labelCidade.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldCidade = new JTextField();
		textFieldCidade.setPreferredSize(new Dimension(150, 25));
		textFieldCidade.setMinimumSize(new Dimension(200 , 25));
		textFieldCidade.setMaximumSize(new Dimension(200 , 25));
		textFieldCidade.setAlignmentX(Component.CENTER_ALIGNMENT);

		subPainel1.add(labelCidade);
		subPainel1.add(textFieldCidade);

		/////////////////////////////////////////////////////////////////////

		JLabel labelCep = new JLabel("CEP" , SwingConstants.LEFT);
		labelCep.setVerticalAlignment(SwingConstants.TOP);
		labelCep.setPreferredSize(new Dimension(100, 25));
		labelCep.setMinimumSize(new Dimension(200 , 25));
		labelCep.setMaximumSize(new Dimension(200 , 25));
		labelCep.setAlignmentX(Component.CENTER_ALIGNMENT);

		try
		{
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");
			textFieldCep = new JFormattedTextField(mascaraCep);
			textFieldCep.setPreferredSize(new Dimension(140, 25));
			textFieldCep.setMinimumSize(new Dimension(200 , 25));
			textFieldCep.setMaximumSize(new Dimension(200 , 25));
			textFieldCep.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		catch (ParseException e1)
		{

		}

		textFieldCep.setPreferredSize(new Dimension(140 , 25));
		textFieldCep.setMinimumSize(new Dimension(200 , 25));
		textFieldCep.setMaximumSize(new Dimension(200 , 25));
		textFieldCep.setAlignmentX(Component.CENTER_ALIGNMENT);

		subPainel1.add(labelCep);
		subPainel1.add(textFieldCep);
		/////////////////////////////////////////////////////////////////////

		String[] estados = {"AC" , "AL" , "AM" , "AP" , "BA" , "CE" , "DF" , "ES" , "GO" , "MA" , "MG" , "MS" , "MT" ,
				"PA" , "PB" , "PE" , "PI" , "PR" , "RJ" , "RN" , "RO" , "RR" , "RS" , "SC" , "SE" , "SP" ,"TO"};

		JLabel textFieldUf = new JLabel("UF" , SwingConstants.LEFT);
		textFieldUf.setPreferredSize(new Dimension(100, 25));
		textFieldUf.setMinimumSize(new Dimension(80 , 25));
		textFieldUf.setMaximumSize(new Dimension(80 , 25));


		JComboBox comboBoxUf = new JComboBox(estados);
		comboBoxUf.setAlignmentX(Component.LEFT_ALIGNMENT);
		comboBoxUf.setPreferredSize(new Dimension(140, 25));
		comboBoxUf.setMinimumSize(new Dimension(50 , 25));
		comboBoxUf.setMaximumSize(new Dimension(50 , 25));

		subPainel1.add(textFieldUf);
		subPainel1.add(comboBoxUf);

		/////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////

		JLabel labelCaso = new JLabel("Dados do Caso");
		labelCaso.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCaso.setHorizontalAlignment(SwingConstants.CENTER);
		labelCaso.setPreferredSize(new Dimension(780, 25));
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

		try
		{
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");

			textFieldDataSintoma = new JFormattedTextField(mascaraData);
			textFieldDataSintoma.setHorizontalAlignment(SwingConstants.LEFT);
			textFieldDataSintoma.setPreferredSize(new Dimension(200, 25));
			textFieldDataSintoma.setMinimumSize(new Dimension(200 , 25));
			textFieldDataSintoma.setMaximumSize(new Dimension(200 , 25));
			textFieldDataSintoma.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		catch (ParseException e1)
		{

		}

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


		textFieldSintomas = new JTextField();
		textFieldSintomas.setPreferredSize(new Dimension(700, 50));
		textFieldSintomas.setMinimumSize(new Dimension(200 , 25));
		textFieldSintomas.setMaximumSize(new Dimension(200 , 25));
		textFieldSintomas.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPainel1.add(textFieldSintomas);


		JPanel painelAtual = this;

		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setPreferredSize(new Dimension(200 , 25));
		botaoCadastrar.setBounds(466 , 475 , 200 , 25);

		botaoCadastrar.addActionListener(new ActionListener()
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
					int opcao = JOptionPane.showConfirmDialog(null , "As informações inseridas estão corretas?" ,
							"Selecione uma opção" , JOptionPane.YES_NO_OPTION);

					switch (opcao)
					{
					case JOptionPane.YES_OPTION :

						String[] campos = {

								textFieldCpf.getText(),
								textFieldNome.getText(),
								(String) comboBoxSexo.getSelectedItem(),
								textFieldIdade.getText(),
								textFieldDataNascimento.getText(),
								textFieldLogradouro.getText() ,
								textFieldNumero.getText(),
								textFieldComplemento.getText(),
								textFieldBairro.getText(),
								textFieldCidade.getText(),
								(String)comboBoxUf.getSelectedItem(),
								textFieldCep.getText(),
								textFieldTelefone.getText(),
								textFieldTelefoneParente.getText()
						};

						try {							
							GerenciadorPacientes.cadastrarPaciente(campos , painelPai , painelAtual);
							GerenciadorSintomas.registrarSintoma(textFieldCpf.getText(), textFieldDataSintoma.getText(), textFieldSintomas.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						break;

					case JOptionPane.NO_OPTION :
						new TelaAvisoGenerica("Revise as informações antes de continuar.");
						break;
					}
				}
			}
		});

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setPreferredSize(new Dimension(200 , 25));
		botaoVoltar.setBounds(129 , 475 , 200 , 25);

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
		add(botaoCadastrar);


	}
}
