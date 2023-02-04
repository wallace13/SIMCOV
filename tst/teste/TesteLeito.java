package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.DAO.LeitoDAO;
import model.DAO.RegistroDAO;

public class TesteLeito {

	@Test
	public void testeInserir() {
		assertEquals(LeitoDAO.inserir("P1 Variante de Manaus"), null);
	}
	@Test
	public void testeBuscarPorIdLeito(){
		assertTrue(LeitoDAO.buscarPorIdLeito(1) != null);
	}
	@Test
	public void testeAlterarDisponibilidade(){
		int idLeito = RegistroDAO.buscarPorCpf("199.999.999-99").getLeito().getIdLeito();
		assertEquals(LeitoDAO.alterarDisponibilidade(idLeito), true);
	}

}
