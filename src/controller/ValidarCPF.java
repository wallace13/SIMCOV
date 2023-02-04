package controller;

import model.DAO.PacienteDAO;

public class ValidarCPF {
	
	public static boolean validar(String cpf)
    {
    	if (checarSeCpfEUnico(cpf)){
    		return true;
    	}else{
		    return false;
    	}
    }
    
    private static boolean checarSeCpfEUnico(String cpf)
    {
        return PacienteDAO.buscarPorCpf(cpf) == null;          
    }
    

}
