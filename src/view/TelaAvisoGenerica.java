package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaAvisoGenerica extends JPanel {

	public TelaAvisoGenerica(String texto){
        JOptionPane.showMessageDialog(null , texto , "Aviso" , JOptionPane.PLAIN_MESSAGE);
    }

}
