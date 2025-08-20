package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class AlumnoTest {
    public AlumnoTest() {
    }
    @Test
    public void testDemo1() {
        assertTrue(true);
    }
    @Test
    public void debeTenerNombreParadigmas2() {
       
        Alumno a1;
        a1 = new Alumno();
        a1.setNombre("Paradigmas 2");
        String nombre = a1.getNombre();
        assertEquals("Error nomnbre incorrecto",
                    "Paradigmas 2",
                     nombre);
    }

}