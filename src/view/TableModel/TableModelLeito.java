package view.TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Leito;
import model.Registro;
import model.DAO.LeitoDAO;
import model.DAO.RegistroDAO;

public class TableModelLeito extends AbstractTableModel {

	private List<Leito> leitos;

	public TableModelLeito()
	{
		this.leitos = LeitoDAO.buscarTodos();
	}

	@Override
	public int getColumnCount()
	{
		return 3;
	}

	public String getColumnName(int index)
	{        
		switch (index)
		{
		case 0:
			return "Nº do Leito";

		case 1:
			return "Ocupante Atual";

		case 2:
			return "Tipo de Covid";
		}
		return null;
	}

	@Override
	public int getRowCount()
	{
		return this.leitos.size();
	}

	@Override
	public Object getValueAt(int linha , int coluna)
	{
		Leito leito = leitos.get(linha);

		switch (coluna)
		{
		case 0:
			return leito.getIdLeito();

		case 1:
			Registro registroOcupante = RegistroDAO.checarSeOcupada(leito.getIdLeito()); 

			if (registroOcupante != null)
				return registroOcupante.getPaciente().getNomeCompleto();

			return "Nenhum";         	


		case 2:
			return leito.getTipoDeCovid();

		default:
			break;
		}
		return null;
	}
}
