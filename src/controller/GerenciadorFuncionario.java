package controller;
import model.Funcionario;
import model.DAO.FuncionarioDAO;
import view.TelaAvisoGenerica;

public class GerenciadorFuncionario
{
    public static void cadastrarFuncionario(String nomeCompleto , String nomeUsuario , String senha , String nivelPermissao)
    {
        Funcionario funcionario = null;
        
        switch (nivelPermissao)
        {
            case "Diretor":
                funcionario = FuncionarioDAO.inserir(nomeCompleto , nomeUsuario , senha , 0);
                break;
            case "Funcion�rio":
                funcionario = FuncionarioDAO.inserir(nomeCompleto , nomeUsuario , senha , 1);
                break;
                
            default:
                break;
        }
        
        if (funcionario != null)
            new TelaAvisoGenerica("Cadastro efetuado com sucesso!");
        else
            new TelaAvisoGenerica("Falha ao cadastrar.");
    }
}