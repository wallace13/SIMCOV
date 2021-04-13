package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.GerenciadorLeitos;
import model.Registro;
import model.DAO.RegistroDAO;

public class PainelRegistraSaidaLeito extends JPanel {
	String cpf;
	JFormattedTextField textFieldCpf;

	public PainelRegistraSaidaLeito(JPanel painelPai) {

		setLayout(null);
		setPreferredSize(new Dimension(800 , 600));

		JPanel subPainel1 = new JPanel();
		subPainel1.setBounds(133 , 50 , 533 , 306);

		add(subPainel1);
		////////////////////////////////////////////////////////////////////////////////

		JLabel labelCaso = new JLabel("Registrar Saída de Paciente do Leito");
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
		/////////////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////////////

		JLabel labelNome = new JLabel("Nome Completo" , SwingConstants.LEFT);
		labelNome.setPreferredSize(new Dimension(100, 25));
		labelNome.setMinimumSize(new Dimension(200 , 25));
		labelNome.setMaximumSize(new Dimension(200 , 25));
		labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField textFieldNome = new JTextField();
		textFieldNome.setPreferredSize(new Dimension(400, 25));
		textFieldNome.setMinimumSize(new Dimension(200 , 25));
		textFieldNome.setMaximumSize(new Dimension(200 , 25));
		textFieldNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		textFieldNome.setEnabled(false);

		subPainel1.add(labelNome);
		subPainel1.add(textFieldNome);

		////////////////////////////////////////////////////////////////////////////////


		JLabel labelTipo = new JLabel("Tipo de Covid");
		labelTipo.setPreferredSize(new Dimension(100, 25));
		labelTipo.setBounds(0 , 0 , 200 , 25);

		JTextField textFieldTipo = new JTextField();
		textFieldTipo.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldTipo.setPreferredSize(new Dimension(140, 25));
		textFieldTipo.setBounds(0 , 0 , 100 , 25);
		textFieldTipo.setEnabled(false);

		JPanel painelTipo = new JPanel();
		painelTipo.setLayout(new BoxLayout(painelTipo , BoxLayout.PAGE_AXIS));
		painelTipo.setPreferredSize(new Dimension(200 , 50));
		painelTipo.setBounds(466 , 110 , 200 , 50);

		subPainel1.add(labelTipo);
		subPainel1.add(textFieldTipo);

		//////////////////////////////////////////////////////////////////////////////////


		JLabel labelNumero = new JLabel("Número do Leito");
		labelNumero.setPreferredSize(new Dimension(100, 25));
		labelNumero.setBounds(0 , 0 , 200 , 25);

		JTextField textFieldNumero = new JTextField();
		textFieldNumero.setPreferredSize(new Dimension(150, 25));
		textFieldNumero.setBounds(0 , 0 , 50 , 25);
		textFieldNumero.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldNumero.setEnabled(false);

		JPanel painelNumero = new JPanel();
		painelNumero.setLayout(new BoxLayout(painelNumero , BoxLayout.PAGE_AXIS));
		painelNumero.setPreferredSize(new Dimension(200 , 50));
		painelNumero.setBounds(466 , 240 , 200 , 50);

		subPainel1.add(labelNumero);
		subPainel1.add(textFieldNumero);


		///////////////////////////////////////////////////////////////////////////

		JLabel labelDataEntrada = new JLabel("Data da Entrada");
		labelDataEntrada.setPreferredSize(new Dimension(100, 25));
		labelDataEntrada.setBounds(0 , 0 , 200 , 25);

		JTextField textFieldDataEntrada = new JTextField();
		textFieldDataEntrada.setEditable(false);
		textFieldDataEntrada.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldDataEntrada.setPreferredSize(new Dimension(140, 25));
		textFieldDataEntrada.setBounds(0 , 0 , 200 , 25);

		subPainel1.add(labelDataEntrada);
		subPainel1.add(textFieldDataEntrada);

		///////////////////////////////////////////

		JLabel labelHoraEntrada = new JLabel("Hora da Entrada");
		labelHoraEntrada.setPreferredSize(new Dimension(100, 25));
		labelHoraEntrada.setBounds(0 , 0 , 100 , 25);

		JTextField textFieldHoraEntrada = new JTextField();
		textFieldHoraEntrada.setEditable(false);
		textFieldHoraEntrada.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldHoraEntrada.setPreferredSize(new Dimension(150, 25));
		textFieldHoraEntrada.setBounds(0 , 0 , 100 , 25);

		subPainel1.add(labelHoraEntrada);
		subPainel1.add(textFieldHoraEntrada);

		/////////////////////////////////////////////////////////

		JPanel painelDataHora = new JPanel();
		painelDataHora.setLayout(new BoxLayout(painelDataHora , BoxLayout.LINE_AXIS));
		painelDataHora.setPreferredSize(new Dimension(200 , 50));
		painelDataHora.setBounds(500 , 142 , 217 , 50);

		///////////////////////////////////////////////////
		
		JButton botaoRegistrar = new JButton("Registrar");
        botaoRegistrar.setPreferredSize(new Dimension(200 , 25));
        botaoRegistrar.setBounds(466 , 412 , 200 , 25);

        botaoRegistrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ( ! textFieldCpf.getText().trim().equals(""))
                {
                    // Checar por duplicidade
                    RegistroDAO.buscarPorCpf(textFieldCpf.getText());

                    GerenciadorLeitos.registrarSaida(RegistroDAO.buscarPorCpf(cpf));

                    new TelaAvisoGenerica("Registro efetuado com sucesso!");
                    painelPai.add(new HomeRegistro(painelPai));
                    setVisible(false);
                }
                else
                    new TelaAvisoGenerica("Há campos obrigatórios que não foram preenchidos!");
            }
        });
        
		///////////////////////////////////////////////////
        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(200 , 25));
        botaoVoltar.setBounds(133 , 412 , 200 , 25);

        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new HomeRegistro(painelPai));
                setVisible(false);
            }
        });
        
        botaoPesquisar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Registro registro = RegistroDAO.buscarPorCpf(textFieldCpf.getText());
                cpf = registro.getPaciente().getCpf();
                		
                SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatHoraEMinuto = new SimpleDateFormat("HH:mm");

                Date dataEntrada = registro.getDataEntrada();
                Time horaEntrada = registro.getHoraEntrada();

                ////////////////////////////////////////////////////////////////////////////
                textFieldNome.setText(registro.getPaciente().getNomeCompleto());
                textFieldDataEntrada.setText(formatData.format(dataEntrada));
                textFieldHoraEntrada.setText(formatHoraEMinuto.format(horaEntrada));
                textFieldTipo.setText(registro.getLeito().getTipoDeCovid());
                textFieldNumero.setText(Integer.toString(registro.getLeito().getIdLeito()));
            }
        });
        

        add(botaoVoltar);
        add(botaoRegistrar);
	}

}
