package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModel.TableModelLeito;

public class HomeLeito extends JPanel {
	
TableModelLeito tableModelVaga;
    
    // TODO Exibir valores por hora
    public HomeLeito(JPanel painelPai){
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));

        // TODO Exibir tooltip com lista de Pacientes
        JTable tabelaLeitos = new JTable(new TableModelLeito());
        tabelaLeitos.getTableHeader().setReorderingAllowed(false);
        tabelaLeitos.getTableHeader().setResizingAllowed(false);
        tabelaLeitos.setFillsViewportHeight(true);
        tabelaLeitos.getColumnModel().getColumn(0).setPreferredWidth(20);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(350 , 500));
        scroll.setBounds(30 , 39 , 450 , 401);
        scroll.setViewportView(tabelaLeitos);
        
        add(scroll);
        
        JButton botaoRegistrarEntrada = new JButton ("Registrar Entrada de Paciente");
        botaoRegistrarEntrada.setPreferredSize(new Dimension(200 , 25));
        botaoRegistrarEntrada.setBounds(495 , 200 , 252 , 25);
        
        botaoRegistrarEntrada.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelRegistraEntradaLeito(painelPai));
                setVisible(false);
            }
        });
        
        JButton botaoRegistrarSaida = new JButton("Registrar Saída de Paciente");
        botaoRegistrarSaida.setPreferredSize(new Dimension(200 , 25));
        botaoRegistrarSaida.setBounds(495 , 315 , 252 , 25);
        
        botaoRegistrarSaida.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelRegistraSaidaLeito(painelPai));
                setVisible(false);
            }
        });
        
        add(botaoRegistrarEntrada);
        add(botaoRegistrarSaida);
    }

}
