import br.ufpb.dcx.ayla.agenda.Contato;
import br.ufpb.dcx.ayla.agenda.GravadorDeDados;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class GravadorDeDadosTest {

    @Test
    public void testaGravacao() throws IOException {
        File arquivosContatos = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        if (arquivosContatos.exists()){
           arquivosContatos.delete();
        }
        GravadorDeDados gravadorDeDados = new GravadorDeDados();
        File arquivo = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        assertFalse(arquivo.exists());
        HashMap <String, Contato> contatosMap = HashMap<>();
        contatosMap.put("Isaac", new Contato("Isaac", 29, 9));
        gravadorDeDados.salvarContatos(contatosMap);
        assertTrue(arquivo.exists());
        arquivo.delete();
    }



    @Test
    public void testaRecuperacao() throws IOException {
        File arquivosContatos = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        if (arquivosContatos.exists()){
            arquivosContatos.delete();
        }
        GravadorDeDados gravadorDeDados = new GravadorDeDados();
        File arquivo = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        assertFalse(arquivo.exists());
        HashMap <String, Contato> contatosMap = HashMap<>();
        contatosMap.put("Isaac", new Contato("Isaac", 29, 9));
        gravadorDeDados.salvarContatos(contatosMap);
        assertTrue(arquivo.exists());
        HashMap<String, Contato> conatatosRecuperados = gravadorDeDados.recuperarContatos();
        Contato c1 = conatatosRecuperados.get("Isaac");
        assertEquals(29, c1.getDiaAniversario());
        assertEquals(9, c1.getMesAniversario());
        assertEquals("Isaac", c1.getNome());


        arquivo.delete();
    }
}
