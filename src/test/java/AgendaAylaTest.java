import br.ufpb.dcx.ayla.agenda.AgendaAyla;
import br.ufpb.dcx.ayla.agenda.Contato;
import br.ufpb.dcx.ayla.agenda.ContatoInexistenteException;

import org.junit.jupiter.api.Test;

import java.util.Collection;

public class AgendaAylaTest {

    @Test
    public void testaCadastroPesquisaRemocao(){
        AgendaAyla agenda = new AgendaAyla();
        agenda.pesquisaAniversariantes(20,8);
        Collection<Contato> contatosAchados =
                agenda.pesquisaAniversariantes(20, 8);
        AssertTrue(contatosAchados.size()==0);
        agenda.cadastraContato("Maria", 20, 8);
        agenda.cadastraContato("Jose",20, 8);
        contatosAchados =
                agenda.pesquisaAniversariantes(20,8);
        assertEquals(2, contatosAchados.size());
        Contato jose = new Contato("Maria", 20,8);
        assertTrue(contatosAchados.contains(jose));

        try{
            boolean removeu = agenda.removeContato("Jose");
            assertTrue(removeu);
        } catch (ContatoInexistenteException e) {
            fail ("Lançou exceção quando não deveria");

        }
    }
}
