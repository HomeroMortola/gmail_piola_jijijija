package com.mycompany.app;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bandeja {
    private ArrayList<Correo> bandejaEnviados; //convertir en clase con interfas "bandeja"
    private ArrayList<Correo> bandejaDeEntrada;
    private ArrayList<Correo> bandejaBorradores;

    public Bandeja() {
        setbandejaDeEntrada();
        setbandejaEnviados();
        setBandejaBorradores();
    }

    private void setbandejaDeEntrada() {
        this.bandejaDeEntrada = new ArrayList<Correo>();
    }

    private void setbandejaEnviados() {
        this.bandejaEnviados = new ArrayList<Correo>();
    }

    private void setBandejaBorradores() {
        this.bandejaBorradores = new ArrayList<Correo>();
    }

    public ArrayList<Correo> getBandejaEnviados() {
        return bandejaEnviados;
    }


    public ArrayList<Correo> getBandejaDeEntrada() {
        return bandejaDeEntrada;
    }
    
    public ArrayList<Correo> getBandejaBorradores() {
        return bandejaBorradores;
    }

    //Filtro con asunto
    public Predicate<Correo> considerarAsuntoDelCorreo(String asunto) {
        return a -> a.getAsunto().toLowerCase().contains(asunto.toLowerCase());
    }

    public ArrayList<Correo> buscarCorreoPorAsunto(String asunto) {
        ArrayList<Correo> correo = new ArrayList<>(this.bandejaDeEntrada.stream()
                                                                        .filter(considerarAsuntoDelCorreo(asunto))
                                                                        .collect(Collectors.toList()));
        return correo;
    }

    //Filtro con contenido
    public Predicate<Correo> considerarContenidoDelCorreo(String contenido) {
        return a -> a.getContenido().toLowerCase().contains(contenido.toLowerCase());
    }

    public ArrayList<Correo> buscarCorreoPorContenido(String contenido) {
        ArrayList<Correo> correo = new ArrayList<>(this.bandejaDeEntrada.stream()
                                                                        .filter(considerarContenidoDelCorreo(contenido))
                                                                        .collect(Collectors.toList()));
        return correo;
    }

    //Filtro con remitente
    public Predicate<Correo> considerarRemitenteDelCorreo(String remitente) {
        return a -> a.getRemitente().toLowerCase().contains(remitente.toLowerCase());
    }

    public ArrayList<Correo> buscarCorreoPorRemitente(String remitente) {
        ArrayList<Correo> correo = new ArrayList<>(this.bandejaDeEntrada.stream()
                                                                        .filter(considerarRemitenteDelCorreo(remitente))
                                                                        .collect(Collectors.toList()));
        return correo;
    }

    //Filtro con destinatario
    public Predicate<Correo> considerarDestinatariosDelCorreo(String destinatarios) {
        return a -> a.getDestinatarios().toLowerCase().contains(destinatarios.toLowerCase());
    }

    public ArrayList<Correo> buscarCorreoPorDestinatarios(String destinatarios) {
        ArrayList<Correo> correo = new ArrayList<>(this.bandejaDeEntrada.stream()
                                                                        .filter(considerarDestinatariosDelCorreo(destinatarios))
                                                                        .collect(Collectors.toList()));
        return correo;
    }
}
