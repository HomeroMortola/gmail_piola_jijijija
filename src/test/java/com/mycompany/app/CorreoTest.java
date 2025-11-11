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

    @Test
    public void testAdministracionDeContactos(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre","nombre@outlook.com",m1);
        m1.logIn(c1);

        assertEquals(0, m1.getContactos().size());

        Contacto c2 = new Contacto("Nombre2","nombre2@outlook.com",m2);
        m1.getContactos().add(c2);
        assertEquals(1, m1.getContactos().size());

        m1.getContactos().remove(c2);
        assertEquals(0, m1.getContactos().size());

    }

    

}
