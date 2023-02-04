package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Acesso;

public class HomeAcesso extends JPanel {

	public HomeAcesso(AbaAcesso abaLogout) {
		
		setLayout(null);
		setPreferredSize(new Dimension(800 , 600));
		
		ImageIcon imageIconLogo = new ImageIcon("img/simcov_logo.jpg");
		
		// Redimensiona logo
		Image imageLogo = imageIconLogo.getImage();
		Image imageLogoResized = imageLogo.getScaledInstance(600 , 200 , Image.SCALE_SMOOTH);
		
		imageIconLogo = new ImageIcon(imageLogoResized);
		
		JLabel labelLogo = new JLabel(imageIconLogo);
		labelLogo.setBounds(100, 0, 600, 200);
		
		add(labelLogo);
		/////////////////////////////////////////////////////////////////////
		JLabel lblDadosDoFuncionrio = new JLabel("Dados do Funcion\u00E1rio: ");
		lblDadosDoFuncionrio.setBounds(0, 230, 800, 50);
		lblDadosDoFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDadosDoFuncionrio.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDadosDoFuncionrio);
		
		JLabel lblNome = new JLabel("Nome Completo: "+Acesso.getFuncionario().getNomeCompleto());
		lblNome.setBounds(0, 280, 800, 30);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNome);
		
		JLabel lblUsuario = new JLabel("Nome do Usuario: "+Acesso.getFuncionario().getNomeUsuario());
		lblUsuario.setBounds(0, 320, 800, 30);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblUsuario);
		
		JLabel lblNivel = new JLabel("Nível de Permissão: "+Acesso.getFuncionario().getNivelPermissao());
		lblNivel.setBounds(0, 360, 800, 30);
		lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNivel);
		
		/////////////////////////////////////////////////////////////////////
		JButton botaoLogout = new JButton("Logout");
		botaoLogout.setBounds(60 , 448 , 200 , 25);

		botaoLogout.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int opcao = JOptionPane.showConfirmDialog(null , "O Programa será fechado. Deseja realmente se desconectar?" ,
						"Selecione uma opção" , JOptionPane.YES_NO_OPTION);
				switch (opcao)
				{
				case JOptionPane.YES_OPTION:
					Acesso.logout();
					break;

				default:
					break;
				}
			}
		});
		add(botaoLogout);
		
		
	}
}
