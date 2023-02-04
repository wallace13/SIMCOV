package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.DAO.PacienteDAO;
import model.DAO.SintomaDAO;

public class TesteSintoma {

	
	@Test
	public void testeInserir() {
		String paciente = PacienteDAO.buscarPorCpf("199.999.999-99").getCpf();		
		assertTrue(SintomaDAO.inserir("16/04/2021", "Febre", paciente) != null);
	}
	@Test
	public void testeBuscarSintoma() {
		String paciente = PacienteDAO.buscarPorCpf("199.999.999-99").getCpf();		
		assertTrue(SintomaDAO.buscarPorCpf(paciente) != null);
	}@Test
	public void testeAlterarSintoma() {
		String paciente = PacienteDAO.buscarPorCpf("199.999.999-99").getCpf();		
		assertEquals(SintomaDAO.atualizar("15/04/2021", "Febre e Dor de Cabeça", paciente), true);
		
	}

}
