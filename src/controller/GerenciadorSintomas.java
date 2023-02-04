package controller;

import model.DAO.SintomaDAO;
import view.TelaAvisoGenerica;

public class GerenciadorSintomas {
	
	
	public static void registrarSintoma(String cpf , String dataDeInicio, String tipoDeSintoma)
    {
        
		SintomaDAO.inserir(dataDeInicio, tipoDeSintoma, cpf);
    }

	public static void alterarSintoma(String dataSintoma, String tipoDeSintoma, String cpf) {
			
		if (SintomaDAO.atualizar(dataSintoma, tipoDeSintoma, cpf))
			new TelaAvisoGenerica("Atualiza��o de dados conclu�da com sucesso.");
		else
			new TelaAvisoGenerica("Atualiza��o n�o efetuada.");

		
	}

}
