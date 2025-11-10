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
        return contactoPropio;
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
    }

    public void enviarCorreo(Contacto destinatario) {
        Correo correo2 = getCorreoActual();
        this.bandejas.getBandejaEnviados().add(getCorreoActual());
        destinatario.getMail().recibirCorreo(correo2);
    }

    public void enviarCorreo(Correo correo, Contacto destinatario) {
        Correo correo2 = correo;
        this.bandejas.getBandejaEnviados().add(correo);
        destinatario.getMail().recibirCorreo(correo2);
    }

    public void recibirCorreo(Correo correo) {
        this.bandejas.getBandejaDeEntrada().add(correo);
    }
   

}
