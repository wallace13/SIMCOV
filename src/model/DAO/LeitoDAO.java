package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Leito;
import util.Conexao;

public class LeitoDAO {

	public static Leito inserir(String tipoDeCovid){
		Leito leito = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = "insert into leito(tipoDeCovid) values (?)";

			PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

			comando.setString(1 , tipoDeCovid);

			if (comando.executeUpdate() > 0){
				ResultSet rs = comando.getGeneratedKeys();

				if (rs.next()){
					int idLeito = rs.getInt(1);

					leito = new Leito();

					leito = LeitoDAO.buscarPorIdLeito(idLeito);
				}
				rs.close();
			}
			comando.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
			e.printStackTrace();
		}
		return leito;
	}



	public static List<Leito> buscarTodos() {
		List<Leito> leitos = new ArrayList<Leito>();

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = "select * from leito";
			Statement comando = conn.createStatement();
			ResultSet rs = comando.executeQuery(sql);

			while (rs.next()){
				Leito leito = new Leito();

				leito.setIdLeito(rs.getInt("idLeito"));
				leito.setDisponivel(rs.getBoolean("disponibilidade"));
				leito.setTipoDeCovid(rs.getString("tipoDeCovid"));

				leitos.add(leito);
			}
			rs.close();
			comando.close();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				conn.close();
			}
			catch (Exception e){

			}
		}
		return leitos;
	}
	public static Leito buscarPorIdLeito(int idLeito){
		Leito leito = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{

			String sql = "select * from leito where idLeito = ?";

			PreparedStatement comando = conn.prepareStatement(sql);

			comando.setInt(1 , idLeito);

			ResultSet rs = comando.executeQuery();

			if (rs.next()){
				leito = new Leito(rs.getInt("idLeito") , rs.getBoolean("disponibilidade") , rs.getString("tipoDeCovid"));
			}
			rs.close();
			comando.close();
			conn.close();
		}
		catch (Exception e)
		{
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		return leito;
	}
	public static List<Leito> buscarLivres(){
		List<Leito> leitos = new ArrayList<Leito>();

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = "select * from leito where disponibilidade = true";

			Statement comando = conn.createStatement();

			ResultSet rs = comando.executeQuery(sql);

			while (rs.next()){
				Leito leito = new Leito();

				leito.setIdLeito(rs.getInt("idVaga"));
				leito.setDisponivel(rs.getBoolean("disponibilidade"));
				leito.setTipoDeCovid(rs.getString("tipoDeCovid"));

				leitos.add(leito);
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
		return leitos;
	}
	public static boolean atualizarTipoDeCovid(String tipoDeCovid , int idLeito){
		boolean ok = false;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		String sql = "update leito set tipoDeCovid = ? where idLeito = ?";

		try{
			PreparedStatement comando = conn.prepareStatement(sql);
			
			comando.setString(1 , tipoDeCovid);
			comando.setInt(2 , idLeito);

			ok = comando.executeUpdate() > 0;

			comando.close();
			conn.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		return ok;
	}

	public static boolean alterarDisponibilidade(int idLeito){
		boolean ok = false;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		String sql = "update leito set disponibilidade = ?, tipoDeCovid = null  where idLeito = ?";

		try{
			PreparedStatement comando = conn.prepareStatement(sql);

			comando.setBoolean(1 , ! LeitoDAO.buscarPorIdLeito(idLeito).isDisponivel());
			comando.setInt(2 , idLeito);

			ok = comando.executeUpdate() > 0;

			comando.close();

		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		finally{
			try{
				conn.close();
			}
			catch (Exception e){

			}
		}
		return ok;
	}

	public static Leito excluir(int idLeito){
		Leito leito = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = "delete from leito where idLeito = ?";

			PreparedStatement comando = conn.prepareStatement(sql);

			comando.setInt(1 , idLeito);

			comando.executeUpdate();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return leito;
	}

	public static List<Leito> buscarLivresPorTipoDeCovid(){
		List<Leito> leitos = new ArrayList<Leito>();

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{

			String sql = "select * from leito where disponibilidade = true";

			PreparedStatement comando = conn.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()){
				Leito leito = new Leito(rs.getInt("idLeito") , rs.getBoolean("disponibilidade") , rs.getString("tipoDeCovid"));

				leitos.add(leito);
			}
			rs.close();
			comando.close();
			conn.close();
		}
		catch (Exception e)
		{
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		return leitos;
	}
	
	public static List<String> buscarTiposDeCovid(){
		List<String> tiposDeCovid = new ArrayList<String>();

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = "select tipoDeCovid from leito";

			Statement comando = conn.createStatement();

			ResultSet rs = comando.executeQuery(sql);

			while (rs.next()){
				String tipoDeCovid = rs.getString("tipoDeCovid");

				tiposDeCovid.add(tipoDeCovid);
			}
			rs.close();
			comando.close();
			conn.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		return tiposDeCovid;
	}
	
}
