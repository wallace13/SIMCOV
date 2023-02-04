package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Paciente;
import util.Conexao;

import java.util.LinkedList;
import java.util.List;

public class PacienteDAO {

	public static Paciente inserir(String cpf, String nomeCompleto, String sexo, int idade, String dataNascimento,
			String logradouro, int numero, String complemento, String bairro, String cidade, String uf, String cep,
			String cep2, String telefone, String telefoneParente) {
		Paciente paciente = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = "insert into paciente(cpf, nomeCompleto, sexo, idade, dataNascimento, "
					+  "logradouro , numero , complemento , bairro , cidade , uf , cep, "
					+  "telefone, telefoneParente) "
					+ " values (? , ? , ? , ? , ? , ? , ?, ? , ? , ? , ? , ? , ? , ?)";

			PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

			comando.setString(1 , cpf);
			comando.setString(2 , nomeCompleto);
			comando.setString(3 , sexo);
			comando.setInt(4 , idade);
			comando.setString(5 , dataNascimento);
			comando.setString(6 , logradouro);
			comando.setInt(7 , numero);
			comando.setString(8 , complemento);
			comando.setString(9 , bairro);
			comando.setString(10 , cidade);
			comando.setString(11 , uf);
			comando.setString(12 , cep);
			comando.setString(13, telefone);
			comando.setString(14, telefoneParente);

			if (comando.executeUpdate() > 0){
					paciente = new Paciente(cpf, nomeCompleto, sexo, idade, dataNascimento, 
							logradouro, numero, complemento , bairro , cidade , uf , cep, 
							telefone, telefoneParente);
				}
			comando.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
			e.printStackTrace();
		}
		finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println("Mensagem de Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
		return paciente;
	}
	public static List<Paciente> buscarTodos(){
		List<Paciente> pacientes = new LinkedList<Paciente>();

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = "select * from paciente";

			Statement comando = conn.createStatement();

			ResultSet rs = comando.executeQuery(sql);

			while (rs.next()){
				Paciente paciente = new Paciente();

				paciente.setCpf(rs.getString("cpf"));
				paciente.setNomeCompleto(rs.getString("nomeCompleto"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setIdade(rs.getInt("idade"));
				paciente.setDataNascimento(rs.getString("dataNascimento"));
				paciente.setLogradouro(rs.getString("logradouro"));
				paciente.setNumero(rs.getInt("numero"));
				paciente.setComplemento(rs.getString("complemento"));
				paciente.setBairro(rs.getString("bairro"));
				paciente.setCidade(rs.getString("cidade"));
				paciente.setUf(rs.getString("uf"));
				paciente.setCep(rs.getString("cep"));
				paciente.setTelefone(rs.getString("telefone"));
				paciente.setTelefoneParente(rs.getString("telefoneParente"));

				pacientes.add(paciente);
			}
			rs.close();
			comando.close();            
		}
		catch (Exception e){

		}
		finally{
			try{
				conn.close();
			}
			catch (Exception e){

			}
		}
		return pacientes;
	}
	public static Paciente buscarPorCpf(String cpf)
	{
		Paciente paciente = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try
		{
			String sql = "select * from paciente where cpf = ?";

			PreparedStatement comando = conn.prepareStatement(sql);
			comando.setString(1 , cpf);
			ResultSet rs = comando.executeQuery();

			while (rs.next())
			{
				paciente = new Paciente();

				paciente.setCpf(rs.getString("cpf"));
				paciente.setNomeCompleto(rs.getString("nomeCompleto"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setIdade(rs.getInt("idade"));
				paciente.setDataNascimento(rs.getString("dataNascimento"));
				paciente.setLogradouro(rs.getString("logradouro"));
				paciente.setNumero(rs.getInt("numero"));
				paciente.setComplemento(rs.getString("complemento"));
				paciente.setBairro(rs.getString("bairro"));
				paciente.setCidade(rs.getString("cidade"));
				paciente.setUf(rs.getString("uf"));
				paciente.setCep(rs.getString("cep"));
				paciente.setTelefone(rs.getString("telefone"));
				paciente.setTelefoneParente(rs.getString("telefoneParente"));

			}
			rs.close();
			comando.close();
		}
		catch (SQLException e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		finally{
			try{
				conn.close();
			}
			catch (Exception e){

			}
		}
		return paciente;
	}
	public static boolean atualizarEndereco(String logradouro, int numero, String complemento, String bairro,
			String cidade, String uf, String cep, String cpf){
		boolean ok = false;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		String sql = "update paciente set logradouro = ? , numero = ? , complemento = ? , bairro = ? , cidade = ? , "
				+ "uf = ? , cep = ? where cpf = ?";

		try{
			PreparedStatement comando = conn.prepareStatement(sql);

			comando.setString(1 , logradouro);
			comando.setInt(2 , numero);
			comando.setString(3 , complemento);
			comando.setString(4 , bairro);
			comando.setString(5 , cidade);
			comando.setString(6 , uf);
			comando.setString(7 , cep);
			comando.setString(8 , cpf);

			ok = comando.executeUpdate() > 0;

			comando.close();
			conn.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}

		return ok;
	}
	public static boolean atualizarDadosPrincipais(String cpf, String nomeCompleto, String sexo, 
			int idade, String dataNascimento, String telefone , String telefoneParente){
		boolean ok = false;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		String sql = "update paciente set nomeCompleto = ?, sexo = ?, idade = ?, dataNascimento = ?, telefone = ?, telefoneParente = ?"
				+ "where cpf = ?";

		try{
			PreparedStatement comando = conn.prepareStatement(sql);

			comando.setString(1 , nomeCompleto);
			comando.setString(2 , sexo);
			comando.setInt(3 , idade);
			comando.setString(4 , dataNascimento);
			comando.setString(5 , telefone);
			comando.setString(6 , telefoneParente);
			comando.setString(7 , cpf);

			ok = comando.executeUpdate() > 0;

			comando.close();
			conn.close();

		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}

		return ok;
	}


}
