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
    public static void registrarEntrada(String idLeito, String cpf, String tipoDeCovid)
    {
    	int idFuncionario = Acesso.getFuncionario().getIdFuncionario();
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
    public static int ContaOsTiposDeCovid(String valorProcurado){
    	List<String> tiposDeCovid = LeitoDAO.buscarTiposDeCovid();
	    int contador = 0;
	    
	    if (tiposDeCovid != null){
	        for (Object item : tiposDeCovid){
	        	
	            if (item != null && item.equals(valorProcurado)){
	                contador++;
	            }
	        }
	    }
	    return contador;
	  
	}
    public static int totalLeitosLivres()
    {
    	List<Leito> LeitosLivres = LeitoDAO.buscarLivresPorTipoDeCovid();
    	int leitos = LeitosLivres.size();
    	return leitos;
    }
	
}
