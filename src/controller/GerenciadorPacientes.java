package controller;

import java.text.ParseException;
import javax.swing.JPanel;
import model.Paciente;
import model.DAO.PacienteDAO;
import view.HomePaciente;
import view.TelaAvisoGenerica;

public class GerenciadorPacientes {


	public static void cadastrarPaciente(String[] campos , JPanel painelPai , JPanel painelCadastro) throws ParseException
	{
		Paciente paciente = new Paciente();

		paciente.setCpf(campos[0]);
		paciente.setNomeCompleto(campos[1]);
		paciente.setSexo(campos[2]);
		paciente.setIdade(Integer.parseInt(campos[3]));
		paciente.setDataNascimento(campos[4]);
		paciente.setLogradouro(campos[5]);
		paciente.setNumero(Integer.parseInt(campos[6]));
		paciente.setComplemento(campos[7]);
		paciente.setBairro(campos[8]);
		paciente.setCidade(campos[9]);
		paciente.setUf(campos[10]);
		paciente.setCep(campos[11]);        
		paciente.setTelefone(campos[12]);
		paciente.setTelefoneParente(campos[13]);

		Paciente PacienteInserido = PacienteDAO.inserir(paciente.getCpf(), 
				paciente.getNomeCompleto(), paciente.getSexo(), paciente.getIdade(), paciente.getDataNascimento(), 
				paciente.getLogradouro(), paciente.getNumero(), paciente.getComplemento(), paciente.getBairro(), 
				paciente.getCidade(), paciente.getUf(),paciente.getCep(),paciente.getCep(), 
				paciente.getTelefone(), paciente.getTelefoneParente());

		if (PacienteInserido != null)
		{
			new TelaAvisoGenerica("Cadastro concluído com sucesso!");
			painelCadastro.setVisible(false);
			painelPai.add(new HomePaciente(painelPai));
		}else{
			new TelaAvisoGenerica("Cadastro mal sucedido.");
			painelCadastro.setVisible(false);
			painelPai.add(new HomePaciente(painelPai));
		}

	}
	public static void alterarPaciente(String cpf, String nomeCompleto, String sexo, int idade, String dataNascimento, 
			String logradouro ,int numero ,  String complemento , String bairro ,
			String cidade , String uf , String cep , String telefone , String telefoneParente){

		if (PacienteDAO.atualizarDadosPrincipais(cpf, nomeCompleto, sexo, idade, dataNascimento, telefone, telefoneParente) &&
				PacienteDAO.atualizarEndereco(logradouro, numero, complemento, bairro, cidade, uf, cep, cpf))
			new TelaAvisoGenerica("Atualização de dados concluída com sucesso.");
		else
			new TelaAvisoGenerica("Atualização não efetuada.");

	}

}
