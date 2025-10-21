package com.mycompany.app;

public class Correo {

    private String asunto; 
    private String contenido;
    private String remitente;
    private String destinatarios;

    public Correo(String asunto, String contenido, String remitente, String destinatarios) {
        setAsunto(asunto);
        setContenido(contenido);
        setRemitente(remitente);
        setDestinatarios(destinatarios);
    }

    private void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    private void setContenido(String contenido){
        this.contenido = contenido;
    }

    private void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    private void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public String getRemitente(){
        return remitente;
    }

    public String getDestinatarios() {
        return destinatarios;
    }


    
}
