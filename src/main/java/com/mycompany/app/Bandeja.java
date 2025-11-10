package com.mycompany.app;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bandeja {
    private ArrayList<Correo> bandejaEnviados; //convertir en clase con interfas "bandeja"
    private ArrayList<Correo> bandejaDeEntrada;
    private ArrayList<Correo> bandejaBorradores;

    
    public Bandeja() {
        setBandejaDeEntrada(new ArrayList<>());
        setBandejaBorradores(new ArrayList<>());
        setBandejaEnviados(new ArrayList<>());

    }

    private void setBandejaBorradores(ArrayList<Correo> bandejaBorradores) {
        this.bandejaBorradores = bandejaBorradores;
    }

    private void setBandejaDeEntrada(ArrayList<Correo> bandejaDeEntrada) {
        this.bandejaDeEntrada = bandejaDeEntrada;
    }

    private void setBandejaEnviados(ArrayList<Correo> bandejaEnviados) {
        this.bandejaEnviados = bandejaEnviados;
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

    

}
