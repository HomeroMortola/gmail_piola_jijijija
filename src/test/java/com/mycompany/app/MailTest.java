package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MailTest {
    @Test
    public void testEnviarCorreo(){
        Mail m1 = new Mail();
        Contacto c1 = new Contacto("Nombre","nombre@outlook.com",m1);
        m1.logIn(c1);
        
        
        Correo co1 = new Correo("Asunto","Contenido",c1.getCorreo(),"Destinatarios");

        m1.enviarCorreo(co1, c1);

        assertEquals(m1.getBandeja().getBandejaEnviados().get(0), co1);
    }
    @Test
    public void testEnviarYRrecibirCorreo(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);
        

        Correo co1 = new Correo("Asunto","Contenido",c1.getCorreo(),c2.getCorreo());

        m1.enviarCorreo(co1,m2.getContactoPropio());

        assertEquals(m1.getBandeja().getBandejaEnviados().get(0), co1);
        assertEquals(m2.getBandeja().getBandejaDeEntrada().size(),1 );
        
    }
    @Test
    public void testEnviarYRrecibirCorreoMultiple(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Mail m3 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        Contacto c3 = new Contacto("Nombre 3", "nombre3@outlook.com",m3);
        m1.logIn(c1);
        m2.logIn(c2);
        m3.logIn(c3);
        

        Correo co1 = new Correo("Asunto","Contenido",c1.getCorreo(),c2.getCorreo());

        m1.enviarCorreo(co1,c2,c3);

        assertEquals(m1.getBandeja().getBandejaEnviados().get(0), co1);
        assertEquals(m2.getBandeja().getBandejaDeEntrada().size(),1);
        assertEquals(m3.getBandeja().getBandejaDeEntrada().size(),1);
    }

    @Test
    public void testEnviarNoEsElMismoQueRecibir(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);
        

        Correo co1 = new Correo("Asunto","Contenido",c1.getCorreo(),c2.getCorreo());

        m1.enviarCorreo(co1,m2.getContactoPropio());
        m1.getBandeja().getBandejaEnviados().get(0).setFavorito(true);

        assertNotEquals(m2.getBandeja().getBandejaDeEntrada().get(0).getFavorito(), m1.getBandeja().getBandejaEnviados().get(0).getFavorito());
        
    }
    @Test
    public void testCrearCorreo(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        m1.crearCorreo("Asunto", "Contenido", m2.getContactoPropio());

        m1.enviarCorreo(m2.getContactoPropio());

        assertNotNull(m2.getBandeja().getBandejaDeEntrada().get(0));
    }
    @Test 
    public void testBandejaDeBorradores(){
        Mail m1 = new Mail();
        Contacto c1 = new Contacto("Nombre","nombre@outlook.com",m1);
        m1.logIn(c1);

        m1.crearCorreo("Asunto", "Contenido", c1);

        m1.enviarABorrador();

        assertNotNull(m1.getBandeja().getBandejaBorradores().get(0));
    }
    @Test
    public void testCorreoMantieneContenido(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        m1.crearCorreo("Asunto", "Contenido", c2);

        m1.enviarCorreo(c2);

        assertEquals(m2.getBandeja().getBandejaDeEntrada().get(0).getAsunto(),"Asunto");
        assertEquals(m2.getBandeja().getBandejaDeEntrada().get(0).getContenido(),"Contenido");
        assertEquals(m2.getBandeja().getBandejaDeEntrada().get(0).getRemitente(),"nombre@outlook.com");
        assertEquals(m2.getBandeja().getBandejaDeEntrada().get(0).getDestinatarios(),"nombre2@outlook.com");
    
    }
    @Test
    public void testCorreoVaABorrador(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        m1.crearCorreo("Asunto", "Contenido", c2);
        
        assertEquals(1,m1.getBandeja().getBandejaBorradores().size());
        m1.enviarCorreo(m1.getBandeja().getBandejaBorradores().get(0),c2);


        assertEquals(1,m2.getBandeja().getBandejaDeEntrada().size() );
        assertEquals(1,m1.getBandeja().getBandejaEnviados().size() );

    }
    @Test
    public void testMensajeLeido(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        Correo co1 = new Correo("Asunto","Contenido",c1.getCorreo(),c2.getCorreo());

        m1.enviarCorreo(co1,m2.getContactoPropio());
        assertFalse(co1.getLeido());
        m1.leerCorreo(m1.getBandeja().getBandejaEnviados().get(0));
        assertTrue(co1.getLeido());
        assertFalse((m2.getBandeja().getBandejaDeEntrada().get(0).getLeido()));
    }
}
