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
    @Test
    public void testCrearCorreo(){
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com");
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com");
        Mail m1 = new Mail(c1);
        Mail m2 = new Mail(c2);

        m1.crearCorreo("Asunto", "Contenido", m2);

        m1.enviarCorreo(m2);

        assertNotNull(m2.getBandejaDeEntrada().get(0));
    }
    @Test 
    public void testBandejaDeBorradores(){
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com");
        Mail m1 = new Mail(c1);

        m1.crearCorreo("Asunto", "Contenido", m1);

        m1.enviarABorrador();

        assertNotNull(m1.getBandejaBorradores().get(0));
    }
    @Test
    public void testCorreoMantieneContenido(){
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com");
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com");
        Mail m1 = new Mail(c1);
        Mail m2 = new Mail(c2);

        m1.crearCorreo("Asunto", "Contenido", m2);

        m1.enviarCorreo(m2);

        assertEquals(m2.getBandejaDeEntrada().get(0).getAsunto(),"Asunto");
        assertEquals(m2.getBandejaDeEntrada().get(0).getContenido(),"Contenido");
        assertEquals(m2.getBandejaDeEntrada().get(0).getRemitente(),"nombre@outlook.com");
        assertEquals(m2.getBandejaDeEntrada().get(0).getDestinatarios(),"nombre2@outlook.com");
    
    }
}
