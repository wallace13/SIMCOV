package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.DAO.*;

public class TesteRegistro {

	@Test
	public void testeInserirRegistro() {
		assertTrue(RegistroDAO.inserir("199.999.999-99", FuncionarioDAO.buscarPorIdFuncionario(1), LeitoDAO.buscarPorIdLeito(1)) != null);
		assertEquals(RegistroDAO.buscarPorCpf("199.999.999-99").getPaciente().getCpf(), "199.999.999-99");
	}
	@Test
	public void testeBuscarRegistro() {
		assertEquals(RegistroDAO.buscarPorCpf("199.999.999-99").getPaciente().getCpf(), "199.999.999-99");
	}
	@Test
	public void testeAtualizar(){
		int idRegistro = RegistroDAO.buscarPorCpf("199.999.999-99").getIdRegistro();
		assertEquals(RegistroDAO.atualizar(idRegistro), true);
	}
	@Test
	public void testeInserirEmArquivoMorto(){
		int idRegistro = RegistroDAO.buscarPorCpf("199.999.999-99").getIdRegistro();
		assertEquals(RegistroDAO.inserirEmArquivoMorto(idRegistro), null);
	}
	@Test
	public void testerRemoverRegistro(){
		int idRegistro = RegistroDAO.buscarPorCpf("199.999.999-99").getIdRegistro();
		assertEquals(RegistroDAO.excluir(idRegistro), null);
	}

}
