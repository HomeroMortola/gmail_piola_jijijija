package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MailTest {
    @Test
    public void testEnviarCorreo(){
        Contacto c1 = new Contacto("Nombre","nombre@outlook.com");
        Mail m1 = new Mail(c1);
        
        Correo co1 = new Correo("Asunto","Contenido",c1.getCorreo(),"Destinatarios");

        m1.enviarCorreo(co1, m1);

        assertEquals(m1.getBandejaEnviados().get(0), co1);
    }
    @Test
    public void testEnviarYRrecibirCorreo(){
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com");
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com");
        Mail m1 = new Mail(c1);
        Mail m2 = new Mail(c2);

        Correo co1 = new Correo("Asunto","Contenido",c1.getCorreo(),c2.getCorreo());

        m1.enviarCorreo(co1,m2);

        assertEquals(m2.getBandejaDeEntrada().get(0), co1);
    }
}
