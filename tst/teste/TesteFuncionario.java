package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import model.DAO.*;

public class TesteFuncionario
{

	@Test
	public void testeCadastro() {
		assertTrue(FuncionarioDAO.inserir("Jo�o Carlos", "Jc", "123", 1) != null);
		assertEquals(FuncionarioDAO.buscarPorLoginESenha("Jc", "123").getNomeCompleto(),"Jo�o Carlos");
	}
	@Test
	public void testeAlterarNivelDePermissao() {
		assertTrue(FuncionarioDAO.atualizarNivelDePermissao(2, 1));
		assertEquals(FuncionarioDAO.buscarPorIdFuncionario(1).getNivelPermissao(),2);
	}
	@Test
	public void testeAlterarUsuarioESenha() {
		assertTrue(FuncionarioDAO.atualizarUsuarioESenha("JoaoCarlos", "1239", 1));
		assertEquals(FuncionarioDAO.buscarPorIdFuncionario(1).getNomeUsuario(),"JoaoCarlos");
	}
	
}