import org.example.eduechinnovators.model.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoTest {
    @Test
    void testConstructorYGetters() {
        Curso curso = new Curso(1, "Matemáticas", "2025", "Juan Pérez", "S");

        assertEquals(1, curso.getId());
        assertEquals("Matemáticas", curso.getNombre());
        assertEquals("2025", curso.getGestion());
        assertEquals("Juan Pérez", curso.getInstructores());
        assertEquals("S", curso.getEvaluar());
    }

    @Test
    void testSetters() {
        Curso curso = new Curso();
        curso.setId(2);
        curso.setNombre("Ciencias");
        curso.setGestion("2024");
        curso.setInstructores("Ana Torres");
        curso.setEvaluar("N");

        assertEquals(2, curso.getId());
        assertEquals("Ciencias", curso.getNombre());
        assertEquals("2024", curso.getGestion());
        assertEquals("Ana Torres", curso.getInstructores());
        assertEquals("N", curso.getEvaluar());
    }
}
