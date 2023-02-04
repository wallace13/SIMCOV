package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModel.TableModelFuncionario;

public class HomeGerencia extends JPanel
{
	public HomeGerencia(JPanel painelPai)
	{

		setLayout(null);
		setPreferredSize(new Dimension(800 , 600));

		JTable tabelaFuncionarios = new JTable(new TableModelFuncionario());
		tabelaFuncionarios.setFillsViewportHeight(true);

		tabelaFuncionarios.getTableHeader().setReorderingAllowed(false);
		tabelaFuncionarios.getTableHeader().setResizingAllowed(false);

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tabelaFuncionarios);
		scroll.setBounds(102 , 49 , 374 , 346);

		add(scroll);

		JButton botaoCadastrar = new JButton("Cadastrar Novo Usuário");
		botaoCadastrar.setBounds(551 , 127 , 200 , 25);

		botaoCadastrar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				painelPai.add(new PainelCadastroFuncionario(painelPai));
				setVisible(false);
			}
		});
		

		add(botaoCadastrar);
		

	}
}