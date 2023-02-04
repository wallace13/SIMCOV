package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

import view.TableModel.TableModelRegistro;
import view.TableModel.TableModelRegistroArquivado;

public class HomeRegistro extends JPanel {
	JFormattedTextField textField;
	int opcao;

	public HomeRegistro(JPanel painelPai) {
		setLayout(null);
		setPreferredSize(new Dimension(800 , 600));

		JTable tabelaRegistros = new JTable();
		tabelaRegistros.getTableHeader().setReorderingAllowed(false);
		tabelaRegistros.getTableHeader().setResizingAllowed(false);
		tabelaRegistros.setBounds(340 , 205 , 1000 , 350);	        
		tabelaRegistros.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaRegistros.setFillsViewportHeight(true);

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(75 , 77 , 650 , 353);
		scroll.setViewportView(tabelaRegistros);

		try
		{
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			textField = new JFormattedTextField(mascaraCpf);
			textField.setBounds(323 , 41 , 292 , 25);
		}
		catch (Exception e){
		}
		JRadioButton radioPf = new JRadioButton("Registro Ativo");
		radioPf.setSelected(true);

		radioPf.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				opcao = 0;
			}
		});

		JRadioButton radioPj = new JRadioButton("Registro Arquivado");

		radioPj.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				opcao = 1;
			}
		});

		ButtonGroup bgRadio = new ButtonGroup();

		bgRadio.add(radioPf);
		bgRadio.add(radioPj);

		JPanel painelRadio = new JPanel();

		painelRadio.setLayout(new BoxLayout(painelRadio , BoxLayout.LINE_AXIS));
		painelRadio.setPreferredSize(new Dimension(200 , 25));
		painelRadio.setBounds(75 , 41 , 238 , 25);

		painelRadio.add(radioPf);
		painelRadio.add(radioPj);

		add(painelRadio);

		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setBounds(625 , 41 , 100 , 25);

		botaoPesquisar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (! textField.getText().isEmpty())
				{
					switch (opcao)
					{
					case 0:
						tabelaRegistros.setModel(new TableModelRegistro(textField.getText()));
						tabelaRegistros.getColumnModel().getColumn(0).setPreferredWidth(250);
						tabelaRegistros.getColumnModel().getColumn(1).setPreferredWidth(100);
						tabelaRegistros.getColumnModel().getColumn(6).setPreferredWidth(50);
						tabelaRegistros.getColumnModel().getColumn(7).setPreferredWidth(200);
						break;
					case 1:
						tabelaRegistros.setModel(new TableModelRegistroArquivado(textField.getText()));
						tabelaRegistros.getColumnModel().getColumn(0).setPreferredWidth(250);
						tabelaRegistros.getColumnModel().getColumn(1).setPreferredWidth(100);
						tabelaRegistros.getColumnModel().getColumn(6).setPreferredWidth(50);
						tabelaRegistros.getColumnModel().getColumn(7).setPreferredWidth(200);
						break;
					}
					scroll.setVisible(true);
				}
			}
		});


		add(textField);
		add(botaoPesquisar);
		add(scroll);
	}

}
