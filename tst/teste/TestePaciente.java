package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Paciente;

public class TestePaciente {
	
	Paciente[] arrayPacientes;

	Paciente paciente;

	@Before
	public void instancia(){
		arrayPacientes = new Paciente[4];
		paciente = new Paciente();
	}

	@Test
	public void cadastraPaciente() {
		paciente.setCpf("172.000.000-10");
		paciente.setNomeCompleto("Wallace");
		paciente.setSexo("Masculino");
		paciente.setIdade(24);
		paciente.setDataNascimento("13/06/0000");
		paciente.setLogradouro("Avenida Senhor dos Passos");
        paciente.setNumero(541);
        paciente.setComplemento("Loja A");
        paciente.setBairro("Centro");
        paciente.setCidade("Rio de Janeiro");
        paciente.setUf("RJ");
        paciente.setCep("21000-000");
        paciente.setTelefone("(21) 0000-0000");
        paciente.setTelefoneParente("(21) 0000-0000");
        

        inserir(paciente);

        assertEquals("Centro" , arrayPacientes[0].getBairro());
    }
    @Test
    public void alteraEndereco()
    {
        cadastraPaciente();
        
        assertEquals("Avenida Senhor dos Passos" , arrayPacientes[0].getLogradouro());

        arrayPacientes[0].setLogradouro("Avenida Senhor das Pisadas");

        assertNotEquals("Avenida Senhor dos Passos" , arrayPacientes[0].getLogradouro());
    }

    @Test
    public void alteraDadosPrincipais()
    {
        cadastraPaciente();
      
        assertEquals("(21) 0000-0000" , arrayPacientes[0].getTelefone());
        assertEquals("(21) 0000-0000" , arrayPacientes[0].getTelefoneParente());

        arrayPacientes[0].setTelefone("(21) 0000-0000");
        arrayPacientes[0].setTelefoneParente("(21) 9-9999-9999");

        assertEquals("(21) 0000-0000" , arrayPacientes[0].getTelefone());
        assertEquals("(21) 9-9999-9999" , arrayPacientes[0].getTelefoneParente());
    }
	public void inserir(Paciente paciente)
    {
        arrayPacientes[0] = paciente;
    }
	


}
