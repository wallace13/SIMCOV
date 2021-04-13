package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Sintoma;
import util.Conexao;

public class SintomaDAO {

	public static Sintoma inserir(String dataSintoma, String tipoDeSintoma, String cpf){
		Sintoma sintoma = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = "insert into sintoma(dataDeInicio, tipoDeSintoma, cpf) values (?, ?, ?)";

			PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

			comando.setString(1, dataSintoma);
			comando.setString(2 , tipoDeSintoma);
			comando.setString(3 , cpf);


			if (comando.executeUpdate() > 0){
				ResultSet rs = comando.getGeneratedKeys();

				if (rs.next()){
					int idSintoma = rs.getInt(1);

					sintoma = new Sintoma();

					sintoma = SintomaDAO.buscarPorIdSintoma(idSintoma);
				}
				rs.close();
			}
			comando.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
			e.printStackTrace();
		}
		return sintoma;
	}

	public static Sintoma buscarPorIdSintoma(int idSintoma) {
		Sintoma sintoma = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{

			String sql = "select * from sintoma where idSintoma = ?";

			PreparedStatement comando = conn.prepareStatement(sql);

			comando.setInt(1 , idSintoma);

			ResultSet rs = comando.executeQuery();

			if (rs.next()){
				sintoma = new Sintoma(rs.getInt("idSintoma") , 
						rs.getString("dataDeInicio") , 
						rs.getString("tipoDeSintoma"),
						PacienteDAO.buscarPorCpf(rs.getString("cpf")));
			}
			rs.close();
			comando.close();
			conn.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		return sintoma;
	}
	public static boolean atualizar(String dataSintoma, String tipoDeSintoma , String cpf){
		boolean ok = false;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		String sql = "update sintoma set dataDeInicio = ?, tipoDeSintoma = ? where cpf = ?";

		try{
			PreparedStatement comando = conn.prepareStatement(sql);

			comando.setString(1 , dataSintoma);
			comando.setString(2 , tipoDeSintoma);
			comando.setString(3 , cpf);

			ok = comando.executeUpdate() > 0;

			comando.close();
			conn.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		return ok;
	}
	public static Sintoma buscarPorCpf(String cpf) {
		Sintoma sintoma = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{

			String sql = "select * from sintoma where cpf = ?";

			PreparedStatement comando = conn.prepareStatement(sql);

			comando.setString(1 , cpf);

			ResultSet rs = comando.executeQuery();

			if (rs.next()){
				sintoma = new Sintoma(rs.getInt("idSintoma") , 
						rs.getString("dataDeInicio") , 
						rs.getString("tipoDeSintoma"),
						PacienteDAO.buscarPorCpf(rs.getString("cpf")));
			}
			rs.close();
			comando.close();
			conn.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		return sintoma;
	}

}
