package controller;

import model.Sintoma;
import model.DAO.SintomaDAO;
import view.TelaAvisoGenerica;

public class GerenciadorSintomas {
	
	
	public static void registrarSintoma(String cpf , String dataDeInicio, String tipoDeSintoma)
    {
        
		Sintoma sintomaInserido = SintomaDAO.inserir(dataDeInicio, tipoDeSintoma, cpf);
		System.out.println(sintomaInserido);
    }

	public static void alterarSintoma(String dataSintoma, String tipoDeSintoma, String cpf) {
			
		if (SintomaDAO.atualizar(dataSintoma, tipoDeSintoma, cpf))
			new TelaAvisoGenerica("Atualização de dados concluída com sucesso.");
		else
			new TelaAvisoGenerica("Atualização não efetuada.");

		
	}

}
