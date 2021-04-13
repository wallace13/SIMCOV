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
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import controller.GerenciadorLeitos;
import model.Paciente;
import model.Registro;
import model.DAO.RegistroDAO;

public class PainelRegistraEntradaLeito extends JPanel {
	JFormattedTextField textFieldCpf;
	Paciente paciente;
	Registro registro;
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

		////////////////////////////////////////////////////////////////////////////////

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
			textFieldCpf.setPreferredSize(new Dimension(400, 25));
			textFieldCpf.setMinimumSize(new Dimension(200 , 25));
			textFieldCpf.setMaximumSize(new Dimension(200, 25));
			textFieldCpf.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		catch (Exception e)
		{

		}

		subPainel1.add(labelCpf);
		subPainel1.add(textFieldCpf);


		/////////////////////////////////////////////////////////////////////

		JLabel labelTipo = new JLabel("Tipo de Covid");
		labelTipo.setPreferredSize(new Dimension(100, 25));
		labelTipo.setBounds(0 , 0 , 200 , 25);

		String[] variantes = {"P1 Variante de Manaus" , "P2 Variante do RJ", "VUI-NP13L Variante do RS"}; 
		comboBoxTipo = new JComboBox(variantes);
		comboBoxTipo.setAlignmentX(Component.LEFT_ALIGNMENT);
		comboBoxTipo.setPreferredSize(new Dimension(140, 25));
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
		comboBoxNumero.setPreferredSize(new Dimension(150, 25));
		comboBoxNumero.setBounds(0 , 0 , 50 , 25);
		comboBoxNumero.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel painelNumero = new JPanel();
		painelNumero.setLayout(new BoxLayout(painelNumero , BoxLayout.PAGE_AXIS));
		painelNumero.setPreferredSize(new Dimension(200 , 50));
		painelNumero.setBounds(466 , 240 , 200 , 50);

		subPainel1.add(labelNumero);
		subPainel1.add(comboBoxNumero);


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
					if (RegistroDAO.buscarPorCpf(textFieldCpf.getText()) == null)
					{
						GerenciadorLeitos.registrarEntrada((String) comboBoxNumero.getSelectedItem(), textFieldCpf.getText(), (String) comboBoxTipo.getSelectedItem());
						new TelaAvisoGenerica("Registro efetuado com sucesso!");
						painelPai.add(new HomeRegistro(painelPai));
						setVisible(false);
					}
					else
						new TelaAvisoGenerica("Já há um Paciente cadastrado com o mesmo CPF em um leito.");
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
				painelPai.add(new HomeRegistro(painelPai));
				setVisible(false);
			}
		});


		add(botaoVoltar);
		add(botaoRegistrar);

	}

}
