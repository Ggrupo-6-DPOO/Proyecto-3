package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Atracciones.Espectaculo;
import Atracciones.NivelExclusividad;
import Atracciones.TipoEspectaculo;

import java.util.Calendar;
import java.util.Date;

class EspectaculoTest {

    private Espectaculo espectaculo;
    private Date inicio;

    @BeforeEach
    void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.MAY, 5, 14, 0, 0);
        inicio = cal.getTime();

        espectaculo = new Espectaculo(
                "Show Acrobático",
                "Zona Show",
                100,
                5,
                NivelExclusividad.ORO,
                inicio,
                60,
                "Acrobacias con fuego y música",
                TipoEspectaculo.ACROBACIA
        );
    }

    @Test
    void testAgregarArtista() {
        espectaculo.agregarArtista("Circo X");
        assertTrue(espectaculo.getArtistas().contains("Circo X"), "El artista 'Circo X' debería estar en la lista de artistas");
    }

    @Test
    void testEstaEnCurso() {
        Calendar testTime = Calendar.getInstance();
        testTime.set(2025, Calendar.MAY, 5, 14, 30, 0); // dentro del show
        assertTrue(espectaculo.estaEnCurso(testTime.getTime()), "El espectáculo debería estar en curso a las 14:30");

        testTime.set(2025, Calendar.MAY, 5, 16, 0, 0); // fuera del show
        assertFalse(espectaculo.estaEnCurso(testTime.getTime()), "El espectáculo no debería estar en curso a las 16:00");
    }

    @Test
    void testReprogramar() {
        Calendar nuevaHora = Calendar.getInstance();
        nuevaHora.set(2025, Calendar.MAY, 6, 17, 0, 0);
        espectaculo.reprogramar(nuevaHora.getTime(), 90);

        assertEquals(nuevaHora.getTime(), espectaculo.getHoraInicio(), "La hora de inicio debería ser la nueva hora programada");
        assertEquals(90, espectaculo.getDuracionMinutos(), "La duración del espectáculo debería ser de 90 minutos");
    }
}