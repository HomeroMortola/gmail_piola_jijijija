package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MailTest {
    @Test
    public void testEnviarCorreo(){
        Mail m1 = new Mail();
        Correo c1 = new Correo("Asunto","Contenido","Remitente","Destinatarios");

        m1.enviarCorreo(c1);

        assertEquals(m1.getBandejaEnviados().get(0), c1);
    }
}
