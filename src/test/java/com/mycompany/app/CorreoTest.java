package com.mycompany.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CorreoTest {
    @Test
    public void testCorreoExiste(){
        Correo c1 = new Correo("Asunto","Contenido","Remitente","Destinatarios");
        assertNotNull(c1);
    }
    
}
