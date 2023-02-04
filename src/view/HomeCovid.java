package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.GerenciadorLeitos;
import model.Leito;
import model.DAO.LeitoDAO;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class HomeCovid extends JPanel{
	private JTextField textFieldVariante1;
	private JTextField textFieldVariante2;
	private JTextField textFieldVariante3;
	
	int v1, v2, v3, total;

	public HomeCovid(AbaCovid abaCovid) {

		setLayout(null);
		setPreferredSize(new Dimension(800 , 600));

		/////////////////////////////////////////////////////////////////////
		ImageIcon imageIconLogo = new ImageIcon("img/covid.jpg");

		// Redimensiona logo
		Image imageLogo = imageIconLogo.getImage();
		Image imageLogoResized = imageLogo.getScaledInstance(300 , 600 , Image.SCALE_SMOOTH);

		imageIconLogo = new ImageIcon(imageLogoResized);
		JLabel labelLogo = new JLabel(imageIconLogo);
		labelLogo.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelLogo.setBounds(0, 0, 300, 600);

		add(labelLogo);
		/////////////////////////////////////////////////////////////////////
		JLabel lblDadosDaCovid = new JLabel("Dados da Covid");
		lblDadosDaCovid.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosDaCovid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDadosDaCovid.setBounds(300, 30, 500, 50);
		add(lblDadosDaCovid);

		/////////////////////////////////////////////////////////////////////
		JPanel panelDados = new JPanel();
		panelDados.setBounds(310, 100, 480, 165);

		add(panelDados);

		/////////////////////////////////////////////////////////////////////

		JLabel labelTipo = new JLabel("Tipo de Covid");
		labelTipo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTipo.setPreferredSize(new Dimension(240, 50));

		JLabel lblQuantidadeDeCasos = new JLabel("Quantidade de Casos");
		lblQuantidadeDeCasos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantidadeDeCasos.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidadeDeCasos.setPreferredSize(new Dimension(230, 50));

		panelDados.add(labelTipo);
		panelDados.add(lblQuantidadeDeCasos);

		/////////////////////////////////////////////////////////////////////

		JLabel LabelVariante1 = new JLabel("P1 Variante de Manaus: ");
		LabelVariante1.setHorizontalAlignment(SwingConstants.CENTER);
		LabelVariante1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelVariante1.setPreferredSize(new Dimension(240, 25));

		textFieldVariante1 = new JTextField();
		textFieldVariante1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldVariante1.setEnabled(false);
		textFieldVariante1.setPreferredSize(new Dimension(230, 25));

		panelDados.add(LabelVariante1);
		panelDados.add(textFieldVariante1);
		/////////////////////////////////////////////////////////////////////

		JLabel labelPVariante2 = new JLabel("P2 Variante do RJ: ");
		labelPVariante2.setHorizontalAlignment(SwingConstants.CENTER);
		labelPVariante2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPVariante2.setPreferredSize(new Dimension(240, 25));

		textFieldVariante2 = new JTextField();
		textFieldVariante2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldVariante2.setEnabled(false);
		textFieldVariante2.setPreferredSize(new Dimension(230, 25));


		panelDados.add(labelPVariante2);
		panelDados.add(textFieldVariante2);

		/////////////////////////////////////////////////////////////////////

		JLabel labelVariante3 = new JLabel("VUI-NP13L Variante do RS: ");
		labelVariante3.setHorizontalAlignment(SwingConstants.CENTER);
		labelVariante3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelVariante3.setPreferredSize(new Dimension(240, 25));

		textFieldVariante3 = new JTextField();
		textFieldVariante3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldVariante3.setEnabled(false);
		textFieldVariante3.setPreferredSize(new Dimension(230, 25));


		panelDados.add(labelVariante3);
		panelDados.add(textFieldVariante3);

		/////////////////////////////////////////////////////////////////////

		JLabel lblTotalDeCasos = new JLabel("Total de Casos:");
		lblTotalDeCasos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalDeCasos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalDeCasos.setBounds(300, 283, 250, 25);
		add(lblTotalDeCasos);

		JLabel labelCasos = new JLabel();
		labelCasos.setForeground(new Color(255, 0, 0));
		labelCasos.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCasos.setHorizontalAlignment(SwingConstants.LEFT);
		labelCasos.setBounds(560, 283, 240, 25);
		add(labelCasos);

		JLabel lblTotalDePaciente = new JLabel("Total de Leitos Ocupados: ");
		lblTotalDePaciente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalDePaciente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalDePaciente.setBounds(300, 319, 250, 25);
		add(lblTotalDePaciente);

		JLabel labelPacientes = new JLabel();
		labelPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		labelPacientes.setForeground(Color.RED);
		labelPacientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPacientes.setBounds(560, 319, 240, 25);
		add(labelPacientes);

		JLabel lblTotalDeLeitos = new JLabel("Total de Leitos Livres: ");
		lblTotalDeLeitos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalDeLeitos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalDeLeitos.setBounds(300, 355, 250, 25);
		add(lblTotalDeLeitos);

		JLabel labelLeitos = new JLabel();
		labelLeitos.setHorizontalAlignment(SwingConstants.LEFT);
		labelLeitos.setForeground(Color.RED);
		labelLeitos.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelLeitos.setBounds(560, 355, 240, 25);
		add(labelLeitos);

		/////////////////////////////////////////////////////////////////////

		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(449, 405, 200 , 25);
		
		btnAtualizar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				v1 = GerenciadorLeitos.ContaOsTiposDeCovid("P1 Variante de Manaus");
				textFieldVariante1.setText(Integer.toString(v1));
				v2 = GerenciadorLeitos.ContaOsTiposDeCovid("P2 Variante do RJ");
				textFieldVariante2.setText(Integer.toString(v2));
				v3 = GerenciadorLeitos.ContaOsTiposDeCovid("VUI-NP13L Variante do RS");
				textFieldVariante3.setText(Integer.toString(v3));
				
				total = v1+v2+v3;
				labelCasos.setText(Integer.toString(total)+" casos");
				
				labelPacientes.setText(Integer.toString(total)+" Leitos Ocupados");
				
				labelLeitos.setText(GerenciadorLeitos.totalLeitosLivres()+" Leitos Livres");
				
			}
		});
		add(btnAtualizar);

		/////////////////////////////////////////////////////////////////////






	}
}
