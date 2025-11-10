package com.mycompany.app;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BandejaTest {
    //Test de filtros

    @Test
    public void testDeFiltroDeAsunto() {
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        m1.crearCorreo("Asunto", "Contenido", c2);
        m1.enviarCorreo(c2);
        m1.crearCorreo("Asunto2", "Contenido2", c2);
        m1.enviarCorreo(c2);

        ArrayList<Correo> resultado = m2.getBandeja().buscarCorreo("Asunto");

        assertEquals("Debe devolver dos correos con el asunto 'asunto'", resultado.size(), 2);
        assertEquals("Asunto", resultado.get(0).getAsunto());
    }

    @Test
    public void testDeFiltroDeContenido() {
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        

        m1.crearCorreo("Asunto", "Contenido", c2);
        m1.enviarCorreo(c2);
        m1.crearCorreo("Asunto2", "Contenido2", c2);
        m1.enviarCorreo(c2);

        ArrayList<Correo> resultado = m2.getBandeja().buscarCorreo("Contenido");

        assertEquals("Debe devolver dos correos con el contenido 'contenido'", resultado.size(), 2);
        assertEquals("Contenido", resultado.get(0).getContenido());
    }

    @Test
    public void testDeFiltroDeRemitente() {
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        m1.crearCorreo("Asunto", "Contenido", c2);
        m1.enviarCorreo(c2);
        m1.crearCorreo("Asunto2", "Contenido2", c2);
        m1.enviarCorreo(c2);

        ArrayList<Correo> resultado = m2.getBandeja().buscarCorreo("nombre@outlook.com");

        assertEquals("Debe devolver dos correos con el remitente 'nombre@outlook.com'", resultado.size(), 2);
        assertEquals("nombre@outlook.com", resultado.get(0).getRemitente());
    }

    @Test
    public void testDeFiltroDeDestinatarios() {
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        m1.crearCorreo("Asunto", "Contenido", c2);
        m1.enviarCorreo(c2);
        m1.crearCorreo("Asunto2", "Contenido2", c2);
        m1.enviarCorreo(c2);

        ArrayList<Correo> resultado = m2.getBandeja().buscarCorreo("nombre2@outlook.com");

        assertEquals("Debe devolver dos correos con el destinatario 'nombre@outlook.com'", resultado.size(), 2);
        assertEquals("nombre2@outlook.com", resultado.get(0).getDestinatarios());
    }
}
