package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MailTest {
    @Test
    public void testEnviarCorreo(){
        Mail m1 = new Mail();
        
        Correo c1 = new Correo("Asunto","Contenido","Remitente","Destinatarios");

        m1.enviarCorreo(c1, m1);

        assertEquals(m1.getBandejaEnviados().get(0), c1);
    }
    @Test
    public void testEnviarYRrecibirCorreo(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();

        Correo c1 = new Correo("Asunto","Contenido","Remitente","Destinatarios");

        m1.enviarCorreo(c1,m2);

        assertEquals(m2.getBandejaDeEntrada().get(0), c1);
    }
}
