import org.example.enums.CargoJunta;
import org.example.enums.DiaSalida;
import org.example.enums.TipoCuota;
import org.example.enums.TipoTitular;
import org.example.modelos.*;
import org.example.utilidades.UtilidadesSemanaSanta;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilidadesSemanaSantaTest {


    @Test
    public void testHermandadesConCuota() {
        // Creamos algunas hermandades de ejemplo de la Semana Santa de Sevilla
        Hermandad hermandad1 = new Hermandad("Hermandad de la Macarena", "Macarena", 50.0, TipoCuota.Mensual, 30.0, null, "Basílica de la Macarena", DiaSalida.MADRUGA, LocalTime.of(17, 0), LocalTime.of(1, 0), null, null, null);
        Hermandad hermandad2 = new Hermandad("Hermandad de la Redención", "Redención", 80.0, TipoCuota.Anual, 50.0, null, "Iglesia de Santiago", DiaSalida.LUNES_SANTO, LocalTime.of(6, 0), LocalTime.of(18, 0), null, null, null);
        Hermandad hermandad3 = new Hermandad("Hermandad de los Gitanos", "Gitanos", 100.0, TipoCuota.Mensual, 60.0, null, "Basílica de los Gitanos", DiaSalida.MADRUGA, LocalTime.of(18, 0), LocalTime.of(2, 0), null, null, null);

        // Creamos una lista de hermandades
        List<Hermandad> listaHermandades = new ArrayList<>();
        listaHermandades.add(hermandad1);
        listaHermandades.add(hermandad2);
        listaHermandades.add(hermandad3);

        // Llamamos al método que queremos probar
        List<Hermandad> resultado = UtilidadesSemanaSanta.hermandadesConCuota(listaHermandades, 90.0, TipoCuota.Mensual);

        // Creamos una lista con las hermandades que esperamos obtener como resultado
        List<Hermandad> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(hermandad1);

        // Verificamos que el resultado sea el esperado
        assertEquals(resultadoEsperado, resultado);
    }


    @Test
    public void testNumHermandadesPorDiaSalida() {
        // Creamos algunas hermandades de ejemplo de la Semana Santa de Sevilla
        Hermandad hermandad1 = new Hermandad("Hermandad de la Macarena", "Macarena", 50.0, TipoCuota.Mensual, 30.0, null, "Basílica de la Macarena", DiaSalida.MADRUGA, LocalTime.of(17, 0), LocalTime.of(1, 0), null, null, null);
        Hermandad hermandad2 = new Hermandad("Hermandad de la Redención", "Redención", 80.0, TipoCuota.Anual, 50.0, null, "Iglesia de Santiago", DiaSalida.LUNES_SANTO, LocalTime.of(6, 0), LocalTime.of(18, 0), null, null, null);
        Hermandad hermandad3 = new Hermandad("Hermandad de los Gitanos", "Gitanos", 100.0, TipoCuota.Mensual, 60.0, null, "Basílica de los Gitanos", DiaSalida.MADRUGA, LocalTime.of(18, 0), LocalTime.of(2, 0), null, null, null);
        Hermandad hermandad4 = new Hermandad("Hermandad de la Estrella", "Estrella", 70.0, TipoCuota.Anual, 40.0, null, "Capilla de la Estrella", DiaSalida.DOMINGO_RAMOS, LocalTime.of(20, 0), LocalTime.of(4, 0), null, null, null);
        Hermandad hermandad5 = new Hermandad("Hermandad del Gran Poder", "Gran Poder", 90.0, TipoCuota.Mensual, 55.0, null, "Basílica de Jesús del Gran Poder", DiaSalida.MADRUGA, LocalTime.of(18, 30), LocalTime.of(3, 0), null, null, null);

        // Creamos una lista de hermandades
        List<Hermandad> listaHermandades = new ArrayList<>();
        listaHermandades.add(hermandad1);
        listaHermandades.add(hermandad2);
        listaHermandades.add(hermandad3);
        listaHermandades.add(hermandad4);
        listaHermandades.add(hermandad5);

        // Llamamos al método que queremos probar
        Map<DiaSalida, Integer> resultado = UtilidadesSemanaSanta.numHermandadesPorDiaSalida(listaHermandades);

        // Creamos un mapa con el número esperado de hermandades por día de salida
        Map<DiaSalida, Integer> resultadoEsperado = new HashMap<>();
        resultadoEsperado.put(DiaSalida.MADRUGA, 3);
        resultadoEsperado.put(DiaSalida.DOMINGO_RAMOS, 1);
        resultadoEsperado.put(DiaSalida.LUNES_SANTO, 1);

        // Verificamos que el resultado sea el esperado
        assertEquals(resultadoEsperado, resultado);
    }


    @Test
    public void testHermanosConMayorAntiguedad() {
// Definimos la fecha actual
        LocalDate fechaActual = LocalDate.of(2024, 3, 14);

        // Creamos una hermandad de ejemplo
        Hermandad hermandad = new Hermandad("Hermandad de la Macarena", "Macarena", 50.0, TipoCuota.Mensual, 30.0, null, "Basílica de la Macarena", DiaSalida.MADRUGA, null, null, null, new ArrayList<>(), null);

        // Creamos algunos hermanos de ejemplo con fechas de inscripción
        Hermano hermano1 = new Hermano("Juan", "Pérez", "12345678A", LocalDate.of(1980, 5, 10), fechaActual.minusYears(10));
        Hermano hermano2 = new Hermano("María", "García", "87654321B", LocalDate.of(1975, 9, 20), fechaActual.minusYears(15));
        Hermano hermano3 = new Hermano("Pedro", "López", "98765432C", LocalDate.of(1982, 10, 15), fechaActual.minusYears(7));
        Hermano hermano4 = new Hermano("Ana", "Martínez", "54321678D", LocalDate.of(1978, 8, 5), fechaActual.minusYears(26));
        Hermano hermano5 = new Hermano("Luis", "Rodríguez", "23456789E", LocalDate.of(1985, 12, 30), fechaActual.minusYears(22));
        Hermano hermano6 = new Hermano("Elena", "Sánchez", "87654321F", LocalDate.of(1987, 2, 15), fechaActual.minusYears(9));
        Hermano hermano7 = new Hermano("Carlos", "Gómez", "98765432G", LocalDate.of(1983, 6, 8), fechaActual.minusYears(29));

        // Agregamos los hermanos a la hermandad
        hermandad.getHermanos().add(hermano1);
        hermandad.getHermanos().add(hermano2);
        hermandad.getHermanos().add(hermano3);
        hermandad.getHermanos().add(hermano4);
        hermandad.getHermanos().add(hermano5);
        hermandad.getHermanos().add(hermano6);
        hermandad.getHermanos().add(hermano7);

        // Llamamos al método que queremos probar
        Map<Hermano, Integer> resultado = UtilidadesSemanaSanta.hermanosConMayorAntiguedad(hermandad);

        // Creamos un mapa con los hermanos más antiguos esperados y su antigüedad en la hermandad
        Map<Hermano, Integer> resultadoEsperado = new HashMap<>();
        resultadoEsperado.put(hermano1, 10); // Juan Pérez lleva 10 años como hermano
        resultadoEsperado.put(hermano2, 15); // María García lleva 15 años como hermana
        resultadoEsperado.put(hermano4, 26); // Ana Martínez lleva 26 años como hermana
        resultadoEsperado.put(hermano5, 22); // Luis Rodríguez lleva 22 años como hermano
        resultadoEsperado.put(hermano7, 29); // Carlos Gómez lleva 29 años como hermano

        // Verificamos que el resultado sea el esperado
        assertEquals(resultadoEsperado, resultado);
    }



    @Test
    public void testElegirJuntaDeGobierno() {
            // Definimos la fecha actual
            LocalDate fechaActual = LocalDate.of(2024, 3, 15);

            // Creamos una hermandad de ejemplo
            Hermandad hermandad = new Hermandad("Hermandad de la Macarena", "Macarena", 50.0, TipoCuota.Mensual, 30.0, null, "Basílica de la Macarena", DiaSalida.MARTES_SANTO, null, null, null, new ArrayList<>(), null);

            // Creamos algunos hermanos de ejemplo con fechas de inscripción
            Hermano hermano1 = new Hermano("Juan", "Pérez", "12345678A", LocalDate.of(1980, 5, 10), fechaActual.minusYears(10));
            Hermano hermano2 = new Hermano("María", "García", "87654321B", LocalDate.of(1975, 9, 20), fechaActual.minusYears(15));
            Hermano hermano3 = new Hermano("Pedro", "López", "98765432C", LocalDate.of(1982, 10, 15), fechaActual.minusYears(7));
            Hermano hermano4 = new Hermano("Ana", "Martínez", "54321678D", LocalDate.of(1978, 8, 5), fechaActual.minusYears(26));
            Hermano hermano5 = new Hermano("Luis", "Rodríguez", "23456789E", LocalDate.of(1985, 12, 30), fechaActual.minusYears(22));
            Hermano hermano6 = new Hermano("Elena", "Sánchez", "87654321F", LocalDate.of(1987, 2, 15), fechaActual.minusYears(9));
            Hermano hermano7 = new Hermano("Carlos", "Gómez", "98765432G", LocalDate.of(1983, 6, 8), fechaActual.minusYears(29));
            Hermano hermano8 = new Hermano("Sofía", "Hernández", "12312312H", LocalDate.of(1981, 3, 18), fechaActual.minusYears(11));
            Hermano hermano9 = new Hermano("Pablo", "Fernández", "78945612I", LocalDate.of(1976, 7, 25), fechaActual.minusYears(16));
            Hermano hermano10 = new Hermano("Laura", "Díaz", "65498732J", LocalDate.of(1988, 11, 5), fechaActual.minusYears(8));
            Hermano hermano11 = new Hermano("Diego", "Álvarez", "15975346K", LocalDate.of(1977, 9, 3), fechaActual.minusYears(18));
            Hermano hermano12 = new Hermano("Carmen", "Jiménez", "96325874L", LocalDate.of(1986, 4, 12), fechaActual.minusYears(21));

            // Agregamos los hermanos a la hermandad
            hermandad.getHermanos().add(hermano1);
            hermandad.getHermanos().add(hermano2);
            hermandad.getHermanos().add(hermano3);
            hermandad.getHermanos().add(hermano4);
            hermandad.getHermanos().add(hermano5);
            hermandad.getHermanos().add(hermano6);
            hermandad.getHermanos().add(hermano7);
            hermandad.getHermanos().add(hermano8);
            hermandad.getHermanos().add(hermano9);
            hermandad.getHermanos().add(hermano10);
            hermandad.getHermanos().add(hermano11);
            hermandad.getHermanos().add(hermano12);



            // Llamamos al método que queremos probar
            JuntaGobierno juntaGobierno = UtilidadesSemanaSanta.elegirJuntaDeGobierno(hermandad);

            // Verificamos que la hermandad sea la esperada
            assertEquals(hermandad, juntaGobierno.getHermandad());

            // Verificamos que la fecha de inicio de mandato sea la fecha actual
            assertEquals(fechaActual, juntaGobierno.getFechaInicioMandato());

            // Verificamos que la fecha de fin de mandato sea la fecha actual + 4 años
            assertEquals(fechaActual.plusYears(4), juntaGobierno.getFechaFinMandato());


            Map<CargoJunta, Hermano> personalJunta = juntaGobierno.getPersonalJunta();
            assertEquals(CargoJunta.values().length, personalJunta.size());
            List<Hermano> hermanos = new ArrayList<>(hermandad.getHermanos());
            hermanos.sort((h1, h2) -> h1.getFechaInscripcionHermandad().compareTo(h2.getFechaInscripcionHermandad()));
            int i = 0;
            for (CargoJunta c: CargoJunta.values()) {
                Hermano hermanoAsignado = personalJunta.get(c);
                assertEquals(hermanos.get(i), hermanoAsignado);
                i++;
            }
    }


    @Test
    public void testInformeHermandad() {
        // Definimos la fecha actual
        LocalDate fechaActual = LocalDate.of(2024, 3, 16);

        // Creamos una hermandad de ejemplo
        Hermandad hermandad = new Hermandad("Hermandad de la Amargura", "La Amargura", 50.0, TipoCuota.Mensual, 30.0, null, "Igleisa de San Juan de la Palma", DiaSalida.DOMINGO_RAMOS, null, null, new ArrayList<>(), new ArrayList<>(), null);

        // Creamos algunos hermanos de ejemplo
        List<Hermano> hermanos = new ArrayList<>();
        Hermano hermano1 = new Hermano("Juan", "Pérez", "12345678A", LocalDate.of(1980, 5, 10), fechaActual.minusYears(10));
        Hermano hermano2 = new Hermano("María", "García", "87654321B", LocalDate.of(1975, 9, 20), fechaActual.minusYears(15));
        hermanos.add(hermano1);
        hermanos.add(hermano2);
        hermandad.setHermanos(hermanos);

        // Creamos algunos titulares de ejemplo
        Titular cristo = new Titular("Nuestro Padre Jesús del Silencio ante el desprecio de Herodes", "Silencio Blanco", LocalDate.of(1870, 1, 1), TipoTitular.CRISTO);
        Titular virgen = new Titular("María Santísima de la Amargura", "La Amargura", LocalDate.of(1650, 2, 2), TipoTitular.VIRGEN);

        hermandad.getTitulares().addAll(List.of(cristo,virgen));
        // Creamos algunos pasos de ejemplo
        List<Paso> pasos = new ArrayList<>();
        Paso paso1 = new Paso(new ArrayList<>(List.of(cristo)), 7, 50, 3, 1);
        Paso paso2 = new Paso(new ArrayList<>(List.of(virgen)), 1, 30, 3, 2);
        pasos.add(paso1);
        pasos.add(paso2);
        hermandad.setPasos(pasos);

        // Llamamos al método que queremos probar
        InformeHermandad informe = UtilidadesSemanaSanta.informeHermandad(hermandad);

        // Verificamos que la hermandad sea la esperada
        assert informe != null;
        assertEquals(hermandad, informe.getHermandad());

        // Verificamos el total de hermanos
        assertEquals(2, informe.getTotalHermanos());

        // Verificamos el total de titulares
        assertEquals(2, informe.getTotalTitulares());

        // Verificamos el total de pasos
        assertEquals(2, informe.getTotalPasos());

        // Verificamos el total de costaleros
        assertEquals(240, informe.getTotalCostaleros());

        // Verificamos los costaleros por paso
        Map<Paso, Integer> costalerosPorPaso = new HashMap<>();
        costalerosPorPaso.put(paso1, 150);
        costalerosPorPaso.put(paso2, 90);
        assertEquals(costalerosPorPaso, informe.getCostalerosPorPaso());

        // Verificamos el total de figuras por paso
        Map<Paso, Integer> pasoTotalFiguras = new HashMap<>();
        pasoTotalFiguras.put(paso1, 8);
        pasoTotalFiguras.put(paso2, 2);
        assertEquals(pasoTotalFiguras, informe.getPasoTotalFiguras());
    }


}
