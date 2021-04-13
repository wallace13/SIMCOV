package view;

import javax.swing.JPanel;

public class AbaPaciente extends JPanel{    
    public AbaPaciente(){
        add(new HomePaciente(this));
    }

}
