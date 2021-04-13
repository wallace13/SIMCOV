package controller;

import java.util.List;

import model.Leito;
import model.Registro;
import model.DAO.FuncionarioDAO;
import model.DAO.LeitoDAO;
import model.DAO.RegistroDAO;
import controller.Acesso;

public class GerenciadorLeitos {

	// Recolhe apenas os Leitos livres
    public static String[] buscarLeitosLivres()
    {
    	List<Leito> LeitosLivres = LeitoDAO.buscarLivresPorTipoDeCovid();
        String[] numerosLivres = new String[LeitosLivres.size()];
        
        for (int i = 0 ; i < numerosLivres.length ; i ++)
        {
            numerosLivres[i] = Integer.toString(LeitosLivres.get(i).getIdLeito());
        }
        return numerosLivres;
    }
    
    // Recolhe os tipos de covid existentes
    public static String[] buscarTiposDeCovid()
    {
        List<String> tiposDeCovid = LeitoDAO.buscarTiposDeCovid();
        String[] tipos = new String[tiposDeCovid.size()];
        
        for (int i = 0 ; i < tipos.length ; i ++)
        {
            tipos[i] = tiposDeCovid.get(i);
        }
        
        return tipos;
    }
    public static void registrarEntrada(String idLeito, String cpf, String tipoDeCovid)
    {
    	int idFuncionario = Acesso.getFuncionario().getIdFuncionario();
    	
    	System.out.println(idFuncionario);
    	
    	
    	LeitoDAO.alterarDisponibilidade(Integer.parseInt(idLeito));
    	
    	RegistroDAO.inserir(cpf, FuncionarioDAO.buscarPorIdFuncionario(idFuncionario),LeitoDAO.buscarPorIdLeito(Integer.parseInt(idLeito)));
    	LeitoDAO.atualizarTipoDeCovid(tipoDeCovid, Integer.parseInt(idLeito));
    }

	public static void registrarSaida(Registro registro)
    {
    	RegistroDAO.atualizar(registro.getIdRegistro());
    	
    	Leito leito = RegistroDAO.buscarPorIdRegistro(registro.getIdRegistro()).getLeito();
        
    	LeitoDAO.alterarDisponibilidade(leito.getIdLeito());
    	
    	//ADICIONA O REGISTRO DO PACIENTE QUE ACABOU DE RECEBER ALTA AO ARQUIVO MORTO    	
    	RegistroDAO.inserirEmArquivoMorto(registro.getIdRegistro());
    	//REMOVE O PACIENETE QUE RECEBEU ALTA DO REGISTRO ATIVO.
    	RegistroDAO.excluir(registro.getIdRegistro());

    }
    
    public static String[] todasOsLeitos()
    {
        List<Leito> lista = LeitoDAO.buscarTodos();
        
        String[] listaLeitos = new String[lista.size()];
        
        for (int i = 0 ; i < listaLeitos.length ; i ++)
        {
            listaLeitos[i] = Integer.toString(lista.get(i).getIdLeito());
        }
        
        return listaLeitos;
    }
}
