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

    @Test
    public void testDeFiltroIgnorarCorreosDeLaAFIP() {
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("AFIP", "nombre@afip.gob.ar",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        m1.crearCorreo("Impuestos adeudados 05/11/2025", "Contenido", c2);
        m1.enviarCorreo(c2);
        m1.crearCorreo("Asunto2", "Contenido2", c2);
        m1.enviarCorreo(c2);

        ArrayList<Correo> resultado = m2.getBandeja().filtroIgnorarAAFIP();

        assertEquals("Debe devolver dos correos con el remitente 'nombre@afip.gob.ar' y con asunto 'Impuestos'", resultado.size(), 1);
        assertEquals("nombre@afip.gob.ar", resultado.get(0).getRemitente());
        assertEquals("Impuestos adeudados 05/11/2025", resultado.get(0).getAsunto());
    }

    @Test
    public void testDeFiltroIgnorarCorreosDeHugo() {
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Hugo Ibáñez", "hugo@hotmail.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        m1.crearCorreo("Devolveme la plata infelíz", "Dale, devolveme la plata que necesito urgente esos $600.000", c2);
        m1.enviarCorreo(c2);
        m1.crearCorreo("Asunto2", "Contenido2", c2);
        m1.enviarCorreo(c2);

        ArrayList<Correo> resultado = m2.getBandeja().filtroIgnorarAHugo();

        assertEquals("Debe devolver dos correos con el remitente 'nombre@afip.gob.ar' y con asunto 'Impuestos'", resultado.size(), 2);
        assertEquals("hugo@hotmail.com", resultado.get(0).getRemitente());
        assertEquals("Devolveme la plata infelíz", resultado.get(0).getAsunto());
    }

    @Test
    public void testDeFiltroDescuentoDeSteam() {
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Steam", "noreply@steampowered.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        m1.crearCorreo("¡Enshrouded, 3 y otros artículos de tu lista de deseados de Steam ahora están en oferta!", "¡AHORRA YA EN 4 JUEGOS QUE DESEAS!", c2);
        m1.enviarCorreo(c2);
        m1.crearCorreo("Asunto2", "Contenido2", c2);
        m1.enviarCorreo(c2);

        ArrayList<Correo> resultado = m2.getBandeja().filtroDescuentoSteam();

        assertEquals("Debe devolver dos correos con el remitente 'noreply@steampowered.com' y con asunto 'Oferta'", resultado.size(), 1);
        assertEquals("noreply@steampowered.com", resultado.get(0).getRemitente());
        assertEquals("¡Enshrouded, 3 y otros artículos de tu lista de deseados de Steam ahora están en oferta!", resultado.get(0).getAsunto());
    }

    @Test
    public void testDeFiltroCorreosUCP() {
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Mail m3 = new Mail();
        Contacto c1 = new Contacto("UCP Avisos", "nombre@ucp.edu.ar",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        Contacto c3 = new Contacto("Nombre 3", "nombre3@outlook.com",m3);
        m1.logIn(c1);
        m2.logIn(c2);
        m2.logIn(c3);

        m1.crearCorreo("Avisos eventos 08/11-06/12", "Contenido", c3);
        m1.enviarCorreo(c3);
        m2.crearCorreo("Asunto2", "Contenido2", c3);
        m2.enviarCorreo(c3);

        ArrayList<Correo> resultado = m3.getBandeja().filtroCorreoUCP();

        assertEquals("Debe devolver un correo con el remitente 'nombre@ucp.edu.ar'", resultado.size(), 1);
        assertEquals("nombre@ucp.edu.ar", resultado.get(0).getRemitente());
        assertEquals("Avisos eventos 08/11-06/12", resultado.get(0).getAsunto());
    }

    @Test
    public void testDeFiltroCorreosImportantes() {
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Mail m3 = new Mail();
        Contacto c1 = new Contacto("UCP Avisos", "nombre@laburo.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        Contacto c3 = new Contacto("Nombre 3", "nombre3@outlook.com",m3);
        m1.logIn(c1);
        m2.logIn(c2);
        m2.logIn(c3);

        m1.crearCorreo("[Importante] Recibo de sueldo 01/11/25", "Contenido", c3);
        m1.enviarCorreo(c3);
        m2.crearCorreo("Dale amigo en serio", "En serio te lo estoy pidiendo, devolveme la plata!", c3);
        m2.enviarCorreo(c3);

        ArrayList<Correo> resultado = m3.getBandeja().filtroCorreosImportantes();

        assertEquals("Debe devolver un correo con el asunto 'Importante'", resultado.size(), 1);
        assertEquals("nombre@laburo.com", resultado.get(0).getRemitente());
        assertEquals("[Importante] Recibo de sueldo 01/11/25", resultado.get(0).getAsunto());
    }

    @Test
    public void testMarcarFavorito(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Steam", "noreply@steampowered.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);
        
        Correo co1 = new Correo("Asunto","Contenido",c1.getCorreo(),c2.getCorreo());
        m1.enviarCorreo(co1,m2.getContactoPropio());
        m1.marcarFavorito(co1);

        assertEquals("Los correos deven ser el mismo",co1,m1.getBandeja().getBandejaFavoritos().get(0));

        m1.marcarNoFavorito(co1);
        assertEquals("El tamaño de la bandeja de favoritos deve ser 0",0,m1.getBandeja().getBandejaFavoritos().size());

    }
    @Test
    public void testBorradoYRecuperacionDeCorreo(){
        Mail m1 = new Mail();
        Mail m2 = new Mail();
        Contacto c1 = new Contacto("Steam", "noreply@steampowered.com",m1);
        Contacto c2 = new Contacto("Nombre 2", "nombre2@outlook.com",m2);
        m1.logIn(c1);
        m2.logIn(c2);

        Correo co1 = new Correo("Asunto","Contenido",c1.getCorreo(),c2.getCorreo());
        m1.enviarCorreo(co1,c2);
        
        m1.eliminarCorreos(co1);

        assertEquals("Los correos deven ser el mismo",co1,m1.getBandeja().getBandejaEliminados().get(0));   
        assertEquals("Los correos deven ser el mismo",co1,m2.getBandeja().getBandejaDeEntrada().get(0));     
        assertEquals("El tamaño de la bandeja de enviados deve ser 0",0,m1.getBandeja().getBandejaEnviados().size());

        m1.restaurarCorreos(co1);
   
        assertEquals("El tamaño de la bandeja de enviados deve ser 0",0,m1.getBandeja().getBandejaEliminados().size());
        assertEquals("Los correos deven ser el mismo",co1,m1.getBandeja().getBandejaEnviados().get(0));  
        
    }

}
