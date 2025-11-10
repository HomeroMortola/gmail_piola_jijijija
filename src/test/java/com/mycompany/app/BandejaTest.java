package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class BandejaTest {
    //Test de filtros

    @Test
    public void testDeFiltroDeAsunto() {
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com");
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com");
        Mail m1 = new Mail(c1);
        Mail m2 = new Mail(c2);

        m1.crearCorreo("Asunto", "Contenido", m2);
        m1.enviarCorreo(m2);
        m1.crearCorreo("Asunto2", "Contenido2", m2);
        m1.enviarCorreo(m2);

        ArrayList<Correo> resultado = m2.getBandeja().buscarCorreoPorAsunto("Asunto");

        assertEquals("Debe devolver dos correos con el asunto 'asunto'", resultado.size(), 2);
        assertEquals("Asunto", resultado.get(0).getAsunto());
    }

    @Test
    public void testDeFiltroDeContenido() {
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com");
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com");
        Mail m1 = new Mail(c1);
        Mail m2 = new Mail(c2);

        m1.crearCorreo("Asunto", "Contenido", m2);
        m1.enviarCorreo(m2);
        m1.crearCorreo("Asunto2", "Contenido2", m2);
        m1.enviarCorreo(m2);

        ArrayList<Correo> resultado = m2.getBandeja().buscarCorreoPorContenido("Contenido");

        assertEquals("Debe devolver dos correos con el contenido 'contenido'", resultado.size(), 2);
        assertEquals("Contenido", resultado.get(0).getContenido());
    }

    @Test
    public void testDeFiltroDeRemitente() {
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com");
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com");
        Mail m1 = new Mail(c1);
        Mail m2 = new Mail(c2);

        m1.crearCorreo("Asunto", "Contenido", m2);
        m1.enviarCorreo(m2);
        m1.crearCorreo("Asunto2", "Contenido2", m2);
        m1.enviarCorreo(m2);

        ArrayList<Correo> resultado = m2.getBandeja().buscarCorreoPorRemitente("nombre@outlook.com");

        assertEquals("Debe devolver dos correos con el remitente 'nombre@outlook.com'", resultado.size(), 2);
        assertEquals("nombre@outlook.com", resultado.get(0).getRemitente());
    }

    @Test
    public void testDeFiltroDeDestinatarios() {
        Contacto c1 = new Contacto("Nombre", "nombre@outlook.com");
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com");
        Mail m1 = new Mail(c1);
        Mail m2 = new Mail(c2);

        m1.crearCorreo("Asunto", "Contenido", m2);
        m1.enviarCorreo(m2);
        m1.crearCorreo("Asunto2", "Contenido2", m2);
        m1.enviarCorreo(m2);

        ArrayList<Correo> resultado = m2.getBandeja().buscarCorreoPorDestinatarios("nombre2@outlook.com");

        assertEquals("Debe devolver dos correos con el destinatario 'nombre@outlook.com'", resultado.size(), 2);
        assertEquals("nombre2@outlook.com", resultado.get(0).getDestinatarios());
    }
}
