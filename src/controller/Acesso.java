package controller;

import model.Funcionario;
import model.DAO.FuncionarioDAO;

public class Acesso {
	
	 // Armazena informacoes sobre o funcionario conectado
    private static Funcionario funcionario;
    
    public static Funcionario getFuncionario(){
        return funcionario;
    }
    
    public static void setFuncionario(Funcionario funcionario){
        Acesso.funcionario = funcionario;
    }
        
    // Busca e compara dados inseridos com os dados da tabela "Funcionario" no banco para validacao de login
    public static boolean login(String nomeUsuario , String senha){
        funcionario = FuncionarioDAO.buscarPorLoginESenha(nomeUsuario , senha);
        
        if (funcionario != null)
            return true;    
        return false;
    }
    
    // Encerra todas as tarefas e janelas e inicializa TelaLogin
    public static void logout(){
    	System.exit(0);
    }

}
