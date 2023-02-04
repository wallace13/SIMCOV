package view.TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Registro;
import model.DAO.RegistroDAO;

public class TableModelRegistro extends AbstractTableModel  {

	List<Registro> registros;
	    
	public TableModelRegistro(String string)
	{
		registros = RegistroDAO.buscarCpf(string);
	}

    @Override
    public int getColumnCount()
    {
        return 8;
    }
    
    @Override
    public String getColumnName(int index)
    {
        switch (index)
        {
            case 0:
                return "Nome Completo";
            case 1:
                return "CPF";
            case 2:
                return "Entrada";
            case 3:
                return "Hora";
            case 4:
                return "Saída";
            case 5:
                return "Hora";
            case 6:
                return "Leito";
            case 7:
                return "Variante";
                
        }
        return null;
    }

    @Override
    public int getRowCount()
    {
        return registros.size();
    }

    @Override
    public Object getValueAt(int linha , int coluna)
    {
            Registro registro = registros.get(linha);
            
            switch (coluna)
            {
                case 0:
                    return registro.getPaciente().getNomeCompleto();
                case 1:
                    return registro.getPaciente().getCpf();
                case 2:
                    return registro.getDataEntrada();
                case 3:
                    return registro.getHoraEntrada();
                case 4:
                    return registro.getDataSaida();
                case 5:
                    return registro.getHoraSaida();
                case 6:
                    return registro.getLeito().getIdLeito();
                case 7:
                    return registro.getLeito().getTipoDeCovid();
                    
            }
        return null;
    }

}
