package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import model.Leito;
import model.Registro;
import util.Conexao;

public class RegistroDAO {

	public static Registro inserir(String cpf , Funcionario funcionario, Leito leito){
		Registro registro = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = "insert registro(dataEntrada , horaEntrada , dataSaida , horaSaida ,"
					+ " cpf ,idFuncionario, idLeito) values (now() , now() , null , null , ? , ? , ?)";

			PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

			comando.setString(1 , cpf);
			comando.setInt(2 , funcionario.getIdFuncionario());
			comando.setInt(3 , leito.getIdLeito());

			if (comando.executeUpdate() > 0){
				ResultSet rs = comando.getGeneratedKeys();

				if (rs.next()){
					registro = new Registro();

					int idRegistro = rs.getInt(1);

					registro = RegistroDAO.buscarPorIdRegistro(idRegistro);                                    
				}
				rs.close();
			}
			comando.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}
			catch (Exception e){

			}
		}
		return registro;
	}
	public static Registro buscarPorIdRegistro(int idRegistro){
		Registro registro = null;

		Conexao conex = new Conexao();
		Connection con = conex.obterConexao();

		try{

			String sql = "select * from registro where idRegistro = ?";

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1 , idRegistro);

			ResultSet rs = comando.executeQuery();

			while (rs.next()){
				registro = new Registro(rs.getInt("idRegistro") ,
						rs.getDate("dataEntrada") , rs.getDate("dataSaida") , rs.getTime("horaEntrada") ,
						rs.getTime("horaSaida") ,  PacienteDAO.buscarPorCpf(rs.getString("cpf")),
						LeitoDAO.buscarPorIdLeito(rs.getInt("idLeito")));
			}
			rs.close();
			comando.close();
			con.close();
		}
		catch (SQLException e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		return registro;
	}
	public static Registro buscarPorCpf(String cpf){
		Registro registro = null;

		Conexao conex = new Conexao();
		Connection con = conex.obterConexao();

		try{

			String sql = "select * from registro where cpf = ?";

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1 , cpf);

			ResultSet rs = comando.executeQuery();

			while (rs.next()){
				registro = new Registro(rs.getInt("idRegistro") ,
						rs.getDate("dataEntrada") , rs.getDate("dataSaida") , rs.getTime("horaEntrada") ,
						rs.getTime("horaSaida") , PacienteDAO.buscarPorCpf(rs.getString("cpf")),
						LeitoDAO.buscarPorIdLeito(rs.getInt("idLeito")));
			}
			rs.close();
			comando.close();
			con.close();
		}
		catch (SQLException e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		return registro;
	}
	public static boolean atualizar(int idRegistro){
		boolean ok = false;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		String sql = "update registro set dataSaida = now() , horaSaida = now() where idRegistro = ?";

		try{
			PreparedStatement comando = conn.prepareStatement(sql);

			comando.setInt(1 , idRegistro);

			ok = comando.executeUpdate() > 0;

			comando.close();
			conn.close();

		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
		}
		return ok;
	}
	public static Registro checarSeOcupada(int idLeito){
		Registro registro = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = "select * from Registro where dataSaida is null && idLeito = ?";

			PreparedStatement comando = conn.prepareStatement(sql);

			comando.setInt(1 , idLeito);

			ResultSet rs = comando.executeQuery();

			if (rs.next())
			{
				registro = new Registro();

				registro.setIdRegistro(rs.getInt("idRegistro"));
				registro.setDataEntrada(rs.getDate("dataEntrada"));
				registro.setHoraEntrada(rs.getTime("horaEntrada"));
				registro.setDataSaida(rs.getDate("dataSaida"));
				registro.setHoraSaida(rs.getTime("horaSaida"));
				registro.setPaciente(PacienteDAO.buscarPorCpf(rs.getString("cpf")));
				registro.setLeito(LeitoDAO.buscarPorIdLeito(rs.getInt("idLeito")));
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
		return registro;
	}
	public static Registro inserirEmArquivoMorto(int idRegistro){
		Registro registro = null;

		Conexao conexao = new Conexao();
		Connection conn = conexao.obterConexao();

		try{
			String sql = " insert into registroMorto select idRegistro, dataEntrada,horaEntrada,dataSaida,"
					+ " horaSaida,cpf,idFuncionario,idleito from registro where idRegistro = ?";

			PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

			comando.setInt(1 , idRegistro);

			if (comando.executeUpdate() > 0){
				ResultSet rs = comando.getGeneratedKeys();

				if (rs.next()){
					registro = new Registro();

					idRegistro = rs.getInt(1);

					registro = RegistroDAO.buscarPorIdRegistro(idRegistro);                                    
				}
				rs.close();
			}
			comando.close();
		}
		catch (Exception e){
			System.out.println("Mensagem de Erro: " + e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}
			catch (Exception e){

			}
		}
		return registro;
	}
	public static Registro excluir(int idRegistro)
    {
		Registro registro = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "delete from registro where idRegistro = ?";

            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1 , idRegistro);
            comando.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return registro;
    }
	public static List<Registro> buscarCpf(String string)
    {
		List<Registro> registros = new ArrayList<Registro>();
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        String sql = "select * from registro where cpf = ?";
        
        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);
            
            comando.setString(1 , string);
            
            ResultSet rs = comando.executeQuery();
            
            while (rs.next())
            {
                Registro registro = new Registro();
                
                registro.setIdRegistro(rs.getInt("idRegistro"));
                registro.setDataEntrada(rs.getDate("dataEntrada"));
				registro.setHoraEntrada(rs.getTime("horaEntrada"));
				registro.setDataSaida(rs.getDate("dataSaida"));
				registro.setHoraSaida(rs.getTime("horaSaida"));
                registro.setPaciente(PacienteDAO.buscarPorCpf(rs.getString("cpf")));
                registro.setLeito(LeitoDAO.buscarPorIdLeito(rs.getInt("idLeito")));
                
                registros.add(registro);
            }
            rs.close();
            comando.close();
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (Exception e)
            {
                
            }
        }
        return registros;
    }
	public static List<Registro> buscarCpfArquivado(String string)
    {
		List<Registro> registros = new ArrayList<Registro>();
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        String sql = "select * from registroMorto where cpf = ?";
        
        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);
            
            comando.setString(1 , string);
            
            ResultSet rs = comando.executeQuery();
            
            while (rs.next())
            {
                Registro registro = new Registro();
                
                registro.setIdRegistro(rs.getInt("idRegistro"));
                registro.setDataEntrada(rs.getDate("dataEntrada"));
				registro.setHoraEntrada(rs.getTime("horaEntrada"));
				registro.setDataSaida(rs.getDate("dataSaida"));
				registro.setHoraSaida(rs.getTime("horaSaida"));
                registro.setPaciente(PacienteDAO.buscarPorCpf(rs.getString("cpf")));
                registro.setLeito(LeitoDAO.buscarPorIdLeito(rs.getInt("idLeito")));
                
                registros.add(registro);
            }
            rs.close();
            comando.close();
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (Exception e)
            {
                
            }
        }
        return registros;
    }


}
