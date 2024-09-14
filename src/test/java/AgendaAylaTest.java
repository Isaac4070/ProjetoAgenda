
import br.ufpb.dcx.ayla.agenda.AgendaAyla;
import br.ufpb.dcx.ayla.agenda.Contato;
import br.ufpb.dcx.ayla.agenda.ContatoInexistenteException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

        import java.util.Collection;

public class AgendaAylaTest {

    @Test
    public void testaCadastroPesquisaRemocao(){
        AgendaAyla agenda = new AgendaAyla();

        // Verificando se a pesquisa inicial encontra 0 aniversariantes
        Collection<Contato> contatosAchados = agenda.pesquisaAniversariantes(20, 8);
        assertTrue(contatosAchados.size() == 0, "Nenhum contato deveria ser encontrado");

        // Cadastrando novos contatos
        agenda.cadastraContato("Maria", 20, 8);
        agenda.cadastraContato("Jose", 20, 8);

        // Verificando se a pesquisa encontra os contatos cadastrados
        contatosAchados = agenda.pesquisaAniversariantes(20, 8);
        assertEquals(2, contatosAchados.size(), "Dois contatos deveriam ser encontrados");

        Contato jose = new Contato("Maria", 20, 8);

        // Verificando se o contato "Maria" está na lista de aniversariantes
        assertTrue(contatosAchados.contains(jose), "O contato Maria deveria estar presente");

        // Tentando remover o contato "Jose"
        try {
            boolean removeu = agenda.removeContato("Jose");
            assertTrue(removeu, "O contato Jose deveria ter sido removido");
        } catch (ContatoInexistenteException e) {
            fail("Lançou exceção quando não deveria");
        }
    }
}
