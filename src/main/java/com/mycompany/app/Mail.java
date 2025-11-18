package com.mycompany.app;

import java.util.ArrayList;

public class Mail {
    private Correo correoActual;
    private Bandeja bandejas;
    private Contacto contactoPropio;
    private ArrayList<Contacto> contactos;

    public Mail() {
        
        setBandejas();
        setContactos(new ArrayList<>());
        
    }

    private void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    private  void setContactoPropio(Contacto contactoPropio) {
        this.contactoPropio = contactoPropio;
    }

    public Contacto getContactoPropio() {
        return this.contactoPropio;
    }

    private void setCorreoActual(Correo correoActual) {
        this.correoActual = correoActual;
    }

    public Correo getCorreoActual() {
        return this.correoActual;
    }

    private void setBandejas() {
        this.bandejas = new Bandeja(){};
    }

    public Bandeja getBandeja() {
        return this.bandejas;
    }

    public ArrayList<Contacto> getContactos(){
        return this.contactos;
    }



    public void logIn(Contacto contactoPropio){
        setContactoPropio(contactoPropio);
    }

    public void crearCorreo(String asunto, String mensaje, Contacto destinatario){
        setCorreoActual(new Correo( asunto, 
                                    mensaje,
                                    getContactoPropio().getCorreo(),
                                    destinatario.getCorreo())); 
        enviarABorrador();                        
    }

    public void enviarABorrador(){
        this.bandejas.getBandejaBorradores().add(this.correoActual);
        getCorreoActual().setUbicacion(3);
    }

    public void enviarCorreo(Contacto... destinatarios) {
        for (Contacto n : destinatarios) {
            // Crear una copia del correo en lugar de enviar el original
            Correo copia = new Correo(getCorreoActual().getAsunto(),
                                      getCorreoActual().getContenido(),
                                      getCorreoActual().getRemitente(),
                                      n.getCorreo());
            n.getMail().recibirCorreo(copia);
        }
        getBandeja().mover(getCorreoActual(),getBandeja().getBandejaEnviados());
        getCorreoActual().setUbicacion(2);
        setCorreoActual(null);
        
    }

    public void enviarCorreo(Correo correo, Contacto... destinatarios) {
        for (Contacto n : destinatarios) {
            // Crear una copia del correo en lugar de enviar el original
            Correo copia = new Correo(correo.getAsunto(),
                                      correo.getContenido(),
                                      correo.getRemitente(),
                                      n.getCorreo());
            n.getMail().recibirCorreo(copia);
        }
        this.bandejas.getBandejaEnviados().add(correo);
        correo.setUbicacion(2);
    }

    public void recibirCorreo(Correo correo) {
        this.bandejas.getBandejaDeEntrada().add(correo);
        correo.setUbicacion(1);
    }

    public void marcarFavorito(Correo correo){
        this.bandejas.getBandejaFavoritos().add(correo);
        correo.setFavorito(true);
    }

    public void marcarNoFavorito(Correo correo){
        this.bandejas.getBandejaFavoritos().remove(correo);
        correo.setFavorito(false);
    }

    public void eliminarCorreos(Correo correo){ 
        correo.setUbicacionPrevia(correo.getUbicacion());
        getBandeja().mover(correo, getBandeja().getBandejaEliminados());
        correo.setUbicacion(4);
    }

    public void restaurarCorreos(Correo correo){ 
        
        switch (correo.getUbicacionPrevia()) {
            case 1:
                getBandeja().mover(correo, getBandeja().getBandejaDeEntrada());
                break;
            case 2:
                getBandeja().mover(correo, getBandeja().getBandejaEnviados());
                break;
            case 3:
                getBandeja().mover(correo, getBandeja().getBandejaBorradores());
                break;
            default:
                break;
        }
        correo.setUbicacion(correo.getUbicacionPrevia());   
        correo.setUbicacionPrevia(0);
        
    }

    public void leerCorreo(Correo correo){
        correo.setLeido(true);
    }
}
