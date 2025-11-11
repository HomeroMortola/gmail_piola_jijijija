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
            Correo correo2 = getCorreoActual();
            this.bandejas.getBandejaEnviados().add(getCorreoActual());
            n.getMail().recibirCorreo(correo2);
            getCorreoActual().setUbicacion(2);
            
        }
        
    }

    public void enviarCorreo(Correo correo, Contacto... destinatarios) {
        for (Contacto n : destinatarios) {
            Correo correo2 = correo;
            this.bandejas.getBandejaEnviados().add(correo);
            n.getMail().recibirCorreo(correo2);
            correo.setUbicacion(2);
            
        }
    }

    public void recibirCorreo(Correo correo) {
        this.bandejas.getBandejaDeEntrada().add(correo);
        correo.setUbicacion(1);
    }


   

}
