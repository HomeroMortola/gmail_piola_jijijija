package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
public class AlumnoTest {
    
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
    @Test
    public void nacionEn2006(){
        Alumno a1 = new Alumno();
        LocalDate fecha;
        a1.setFechaNacimiento(LocalDate.of(2006,2,2));
        fecha = a1.getFechaNacimiento();
        assertEquals("Error Fecha no coinside",LocalDate.of(2006,2,2),fecha); 
    }
    @Test
    public void edadEs19(){
        Alumno a1 = new Alumno();
        int edad;
        a1.setFechaNacimiento(LocalDate.of(2006,2,2));
        edad = a1.getEdad();
        assertEquals("Error, edad no coinside",19,edad);
    }

        
    }

