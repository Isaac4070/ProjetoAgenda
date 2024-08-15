

import br.ufpb.dcx.ayla.agenda.Contato;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContatoTest {

    @Test
    public void testaConstrutor(){
        Contato c1 = new Contato("Isaac", 29, 9);
        assertEquals("isaac",c1.getNome());
        assertEquals(29, c1.getDiaAniversario());
        assertEquals(9, c1.getMesAniversario());
    }

}
