package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import controller.GerenciadorLeitos;
import model.Paciente;
import model.Registro;
import model.Sintoma;
import model.DAO.PacienteDAO;
import model.DAO.RegistroDAO;
import model.DAO.SintomaDAO;

public class PainelRegistraEntradaLeito extends JPanel {
	JFormattedTextField textFieldCpf;
	String cpf;
	Paciente paciente;
	Registro registro;
	Sintoma sintoma;
	JComboBox comboBoxTipo = new JComboBox();
	JComboBox comboBoxNumero = new JComboBox();

	public PainelRegistraEntradaLeito(JPanel painelPai) {

		setLayout(null);
		setPreferredSize(new Dimension(800 , 600));

		JPanel subPainel1 = new JPanel();
		subPainel1.setBounds(133 , 50 , 533 , 306);

		add(subPainel1);


		////////////////////////////////////////////////////////////////////////////////

		JLabel labelCaso = new JLabel("Registrar Paciente no Leito");
		labelCaso.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCaso.setHorizontalAlignment(SwingConstants.CENTER);
		labelCaso.setPreferredSize(new Dimension(500, 100));
		labelCaso.setMinimumSize(new Dimension(200 , 25));
		labelCaso.setMaximumSize(new Dimension(200 , 25));
		labelCaso.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPainel1.add(labelCaso);

		/////////////////////////////////////////////////////////////////////

		JLabel labelCpf = new JLabel("CPF do Paciente");
		labelCpf.setPreferredSize(new Dimension(100, 25));
		labelCpf.setMinimumSize(new Dimension(200 , 25));
		labelCpf.setMaximumSize(new Dimension(200 , 25));
		labelCpf.setAlignmentX(Component.CENTER_ALIGNMENT);

		textFieldCpf = new JFormattedTextField();
		textFieldCpf.setPreferredSize(new Dimension(200, 25));
		textFieldCpf.setMinimumSize(new Dimension(200 , 25));
		textFieldCpf.setMaximumSize(new Dimension(200 , 25));
		textFieldCpf.setAlignmentX(Component.CENTER_ALIGNMENT);

		try
		{
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");

			textFieldCpf = new JFormattedTextField(mascaraCpf);
			textFieldCpf.setPreferredSize(new Dimension(200, 25));
			textFieldCpf.setMinimumSize(new Dimension(200 , 25));
			textFieldCpf.setMaximumSize(new Dimension(200 , 25));
			textFieldCpf.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		catch (Exception e)
		{

		}

		subPainel1.add(labelCpf);
		subPainel1.add(textFieldCpf);
		
		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setPreferredSize(new Dimension(195, 25));
		botaoPesquisar.setMinimumSize(new Dimension(200 , 25));
		botaoPesquisar.setMaximumSize(new Dimension(200 , 25));
		botaoPesquisar.setAlignmentX(Component.CENTER_ALIGNMENT);
		subPainel1.add(botaoPesquisar);
		////////////////////////////////////////////////////////////////////////////////
		JLabel labelNome = new JLabel("Nome Completo" , SwingConstants.LEFT);
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
		JLabel labelSintoma = new JLabel("Sintomas" , SwingConstants.LEFT);
		labelSintoma.setPreferredSize(new Dimension(100, 50));
		labelSintoma.setMinimumSize(new Dimension(200 , 25));
		labelSintoma.setMaximumSize(new Dimension(200 , 25));
		labelSintoma.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldSintoma = new JTextField();
		textFieldSintoma.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldSintoma.setPreferredSize(new Dimension(400, 50));
		textFieldSintoma.setMinimumSize(new Dimension(200 , 25));
		textFieldSintoma.setMaximumSize(new Dimension(200 , 25));
		textFieldSintoma.setAlignmentX(Component.CENTER_ALIGNMENT);
		textFieldSintoma.setEnabled(false);

		subPainel1.add(labelSintoma);
		subPainel1.add(textFieldSintoma);

		////////////////////////////////////////////////////////////////////////////////

		JLabel labelTipo = new JLabel("Tipo de Covid");
		labelTipo.setPreferredSize(new Dimension(100, 25));
		labelTipo.setBounds(0 , 0 , 200 , 25);

		String[] variantes = {"P1 Variante de Manaus" , "P2 Variante do RJ", "VUI-NP13L Variante do RS"}; 
		comboBoxTipo = new JComboBox(variantes);
		comboBoxTipo.setAlignmentX(Component.LEFT_ALIGNMENT);
		comboBoxTipo.setPreferredSize(new Dimension(240, 25));
		comboBoxTipo.setBounds(0 , 0 , 100 , 25);

		JPanel painelTipo = new JPanel();
		painelTipo.setLayout(new BoxLayout(painelTipo , BoxLayout.PAGE_AXIS));
		painelTipo.setPreferredSize(new Dimension(200 , 50));
		painelTipo.setBounds(466 , 110 , 200 , 50);

		subPainel1.add(labelTipo);
		subPainel1.add(comboBoxTipo);

		//////////////////////////////////////////////////////////////////////////////////
		
		JLabel labelNumero = new JLabel("Número do Leito");
		labelNumero.setPreferredSize(new Dimension(100, 25));
		labelNumero.setBounds(0 , 0 , 200 , 25);

		String[] leitos = GerenciadorLeitos.buscarLeitosLivres();

		comboBoxNumero = new JComboBox(leitos);
		comboBoxNumero.setPreferredSize(new Dimension(50, 25));
		comboBoxNumero.setBounds(0 , 0 , 50 , 25);
		comboBoxNumero.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel painelNumero = new JPanel();
		painelNumero.setLayout(new BoxLayout(painelNumero , BoxLayout.PAGE_AXIS));
		painelNumero.setPreferredSize(new Dimension(200 , 50));
		painelNumero.setBounds(466 , 240 , 200 , 50);

		subPainel1.add(labelNumero);
		subPainel1.add(comboBoxNumero);


		///////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////

		JButton botaoRegistrar = new JButton("Registrar");
		botaoRegistrar.setPreferredSize(new Dimension(200 , 25));
		botaoRegistrar.setBounds(466 , 364 , 200 , 25);

		botaoRegistrar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (! textFieldCpf.getText().trim().equals(""))
				{
					if (RegistroDAO.buscarPorCpf(textFieldCpf.getText()) == null && PacienteDAO.buscarPorCpf(textFieldCpf.getText()) != null)
					{
						GerenciadorLeitos.registrarEntrada((String) comboBoxNumero.getSelectedItem(), textFieldCpf.getText(), (String) comboBoxTipo.getSelectedItem());
						new TelaAvisoGenerica("Registro efetuado com sucesso!");
						painelPai.add(new HomeLeito(painelPai));
						setVisible(false);
					}
					else
						new TelaAvisoGenerica("Paciente não cadastrado ou CPF já cadastrado em um leito. Verifique o CPF e tente Novamente");
						painelPai.add(new HomeLeito(painelPai));
						setVisible(false);
				}
				else
					new TelaAvisoGenerica("Há campos obrigatórios que não foram preenchidos!");
			}
		});

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setPreferredSize(new Dimension(200 , 25));
		botaoVoltar.setBounds(133 , 364 , 200 , 25);

		botaoVoltar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				painelPai.add(new HomeLeito(painelPai));
				setVisible(false);
			}
		});
		botaoPesquisar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                paciente = PacienteDAO.buscarPorCpf(textFieldCpf.getText());
                sintoma = SintomaDAO.buscarPorCpf(textFieldCpf.getText());
                
                if(paciente != null && sintoma != null)
                {
                	
                textFieldNome.setText(paciente.getNomeCompleto());
				textFieldSintoma.setText(sintoma.getTipoDeSintoma());
                }else{
                	new TelaAvisoGenerica("CPF não Encontrado ou Paciente não cadastrado em leito. Verifique o CPF e tente Novamente");
					painelPai.add(new HomeLeito(painelPai));
					setVisible(false);
                }
                
            }
        });


		add(botaoVoltar);
		add(botaoRegistrar);

	}

}
