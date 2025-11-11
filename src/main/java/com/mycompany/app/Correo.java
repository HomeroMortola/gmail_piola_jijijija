package com.mycompany.app;

public class Correo {

    private String asunto; 
    private String contenido;
    private String remitente;
    private String destinatarios;
    private int ubicacion; //0 = niguna / 1 = entrada / 2 = enviados / 3 = borrador / 4 = eliminado 
    private int ubicacionPrevia;
    private boolean favorito;

    public Correo(String asunto, String contenido, String remitente, String destinatarios) {
        setAsunto(asunto);
        setContenido(contenido);
        setRemitente(remitente);
        setDestinatarios(destinatarios);
        setUbicacion(0);
        setUbicacionPrevia(0);
    }

    //set
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

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setUbicacionPrevia(int ubicacionPrevia){
        this.ubicacionPrevia = ubicacionPrevia;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    

    //get
    public String getAsunto() {
        return this.asunto;
    }

    public String getContenido() {
        return this.contenido;
    }

    public String getRemitente(){
        return this.remitente;
    }

    public String getDestinatarios() {
        return this.destinatarios;
    }

    public int getUbicacion() {
        return this.ubicacion;
    }

    public int getUbicacionPrevia() {
        return this.ubicacionPrevia;
    }

    public boolean getFavorito() {
        return this.favorito;
    }


    
}
