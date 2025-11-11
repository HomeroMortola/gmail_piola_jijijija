package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CorreoTest {
    @Test
    public void testCorreoExiste(){
        Correo c1 = new Correo("Asunto","Contenido","Remitente","Destinatarios");
        assertNotNull(c1);
    }
    
    @Test
    public void testDatosDeUsuario(){
        Mail m1 = new Mail();
        Contacto c1 = new Contacto("Nombre","nombre@outlook.com",m1);
        m1.logIn(c1);

        assertEquals("Nombre", c1.getNombre());
        assertEquals("nombre@outlook.com", c1.getCorreo());
    }

}
