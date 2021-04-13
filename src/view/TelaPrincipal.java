package view;

import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controller.Acesso;
import util.Posicionamento;

public class TelaPrincipal extends JFrame
{
    public TelaPrincipal()
    {
        // Define o titulo a partir do metodo construtor da superclasse
        super("SIMCOV: Sistema de Monitoramento dos Casos de Covid");
        
        //Define o icone da janela
        ImageIcon icone = new ImageIcon("img/simcov.png");
        setIconImage(icone.getImage());
        
        // Instancia lista de abas
        JTabbedPane abas = new JTabbedPane();
        
        // Define lista de abas
        abas.addTab("Leito" , new AbaRegistro());
        abas.addTab("Paciente" , new AbaPaciente());
        abas.addTab("Gerência" , new AbaGerencia());
        
        // Condicao para a aba Gerência estar acessivel
        if (Acesso.getFuncionario().getNivelPermissao() != 0)
            abas.setEnabledAt(4 , false);
        
        // Adiciona lista de abas ao painel da tela
        add(abas);
        
        // Define configuracoes da janela
        setSize(800 , 600);
        setLocation(Posicionamento.tamanhoDaTela.width / 2 - this.getSize().width / 2 ,
                        Posicionamento.tamanhoDaTela.height / 2 - this.getSize().height / 2); 
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
}