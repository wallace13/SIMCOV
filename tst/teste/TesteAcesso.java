package teste;
import static org.junit.Assert.*;

import org.junit.Test;

import controller.Acesso;

public class TesteAcesso
{
    @Test
    public void fazLoginComCredenciaisCorretas()
    {
        assertTrue(Acesso.login("sales" , "123"));

        assertEquals(Acesso.getFuncionario().getNomeUsuario() , "sales");
    }
    @Test
    public void fazLoginComNomeUsuarioIncorreto()
    {
        assertFalse(Acesso.login("sal" , "123"));
    }

    @Test
    public void fazLoginComSenhaIncorreta()
    {
        assertFalse(Acesso.login("sales" , "321"));
    }

}
