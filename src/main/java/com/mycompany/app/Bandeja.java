package com.mycompany.app;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bandeja {
    private ArrayList<Correo> bandejaEnviados; //convertir en clase con interfas "bandeja"
    private ArrayList<Correo> bandejaDeEntrada;
    private ArrayList<Correo> bandejaBorradores;
    private ArrayList<Correo> bandejaEliminados;
    private ArrayList<Correo> bandejaFavoritos;

    
    public Bandeja() {
        setBandejaDeEntrada(new ArrayList<>());
        setBandejaBorradores(new ArrayList<>());
        setBandejaEnviados(new ArrayList<>());
        setBandejaEliminados(new ArrayList<>());
        setBandejaFavoritos(new ArrayList<>());
    }

    //set
    private void setBandejaBorradores(ArrayList<Correo> bandejaBorradores) {
        this.bandejaBorradores = bandejaBorradores;
    }

    private void setBandejaDeEntrada(ArrayList<Correo> bandejaDeEntrada) {
        this.bandejaDeEntrada = bandejaDeEntrada;
    }

    private void setBandejaEnviados(ArrayList<Correo> bandejaEnviados) {
        this.bandejaEnviados = bandejaEnviados;
    }

    private void setBandejaEliminados(ArrayList<Correo> bandejaEliminados) {
        this.bandejaEliminados = bandejaEliminados;
    }

    private void setBandejaFavoritos(ArrayList<Correo> bandejaFavoritos) {
        this.bandejaFavoritos = bandejaFavoritos;
    }

    //get
    public ArrayList<Correo> getBandejaEnviados() {
        return this.bandejaEnviados;
    }


    public ArrayList<Correo> getBandejaDeEntrada() {
        return this.bandejaDeEntrada;
    }
    
    public ArrayList<Correo> getBandejaBorradores() {
        return this.bandejaBorradores;
    }

    public ArrayList<Correo> getBandejaEliminados() {
        return this.bandejaEliminados;
    }

    public ArrayList<Correo> getBandejaFavoritos() {
        return this.bandejaFavoritos;
    }

    

    

    //Filtro con asunto
    public Predicate<Correo> considerarAsuntoDelCorreo(String asunto) {
        return a -> a.getAsunto().toLowerCase().contains(asunto.toLowerCase());
    }

    //Filtro con contenido
    public Predicate<Correo> considerarContenidoDelCorreo(String contenido) {
        return a -> a.getContenido().toLowerCase().contains(contenido.toLowerCase());
    }

    //Filtro con remitente
    public Predicate<Correo> considerarRemitenteDelCorreo(String remitente) {
        return a -> a.getRemitente().toLowerCase().contains(remitente.toLowerCase());
    }

    //Filtro con destinatario
    public Predicate<Correo> considerarDestinatariosDelCorreo(String destinatarios) {
        return a -> a.getDestinatarios().toLowerCase().contains(destinatarios.toLowerCase());
    }

    //Filtro Todo
    public Predicate<Correo> considerarTodo(String texto) {
        return  considerarContenidoDelCorreo(texto)
                                .or(considerarRemitenteDelCorreo(texto))
                                .or(considerarAsuntoDelCorreo(texto))
                                .or(considerarDestinatariosDelCorreo(texto));
    }


    public ArrayList<Correo> buscarCorreo(String texto) {
        ArrayList<Correo> correo = new ArrayList<>(this.bandejaDeEntrada.stream()
                                                                        .filter(considerarTodo(texto))
                                                                        .collect(Collectors.toList()));
        return correo;
    }

    //Filtro ignorar a la AFIP
    public ArrayList<Correo> filtroIgnorarAAFIP() {
        ArrayList<Correo> correo = new ArrayList<>(this.bandejaDeEntrada.stream()
                                                                        .filter(considerarRemitenteDelCorreo("@afip.gob.ar"))
                                                                        .filter(considerarAsuntoDelCorreo("impuestos"))
                                                                        .collect(Collectors.toList()));
        return correo;
    }
    
    //Filtro ignorar a Hugo
    public ArrayList<Correo> filtroIgnorarAHugo() {
        ArrayList<Correo> correo = new ArrayList<>(this.bandejaDeEntrada.stream()
                                                                        .filter(considerarRemitenteDelCorreo("hugo@hotmail.com")
                                                                            .or(considerarContenidoDelCorreo("devolveme la plata")))
                                                                        .collect(Collectors.toList()));
        return correo;
    }

    //Filtro descuento de Steam
    public ArrayList<Correo> filtroDescuentoSteam() {
        ArrayList<Correo> correo = new ArrayList<>(this.bandejaDeEntrada.stream()
                                                                        .filter(considerarRemitenteDelCorreo("noreply@steampowered.com"))
                                                                        .filter(considerarAsuntoDelCorreo("oferta"))
                                                                        .collect(Collectors.toList()));
        return correo;
    }

    //Filtro correos UCP
    public ArrayList<Correo> filtroCorreoUCP() {
        ArrayList<Correo> correo = new ArrayList<>(this.bandejaDeEntrada.stream()
                                                                        .filter(considerarRemitenteDelCorreo("@ucp.edu.ar"))
                                                                        .collect(Collectors.toList()));
        return correo;
    }

    public void mober(Correo correo, ArrayList<Correo> destino){
        switch (correo.getUbicacion()) {
            case 1:
                getBandejaDeEntrada().remove(correo);
                break;
            case 2:
                getBandejaEnviados().remove(correo);
                break;
            case 3:
                getBandejaBorradores().remove(correo);
                break;
            case 4:
                getBandejaEliminados().remove(correo);
                break;
            default:
                break;
        }
        destino.add(correo);
        
            
    }

    
        
    

}
