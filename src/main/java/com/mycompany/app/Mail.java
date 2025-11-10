package com.mycompany.app;
import java.util.ArrayList;

public class Mail {
    private Correo correoActual;
    private Bandeja bandejas;
    private Contacto contactoPropio;

    public Mail(Contacto contactoPropio) {
        setContactoPropio(contactoPropio);
    }

    public void setContactoPropio(Contacto contactoPropio) {
        this.contactoPropio = contactoPropio;
    }

    public Contacto getContactoPropio() {
        return contactoPropio;
    }

    public void setCorreoActual(Correo correoActual) {
        this.correoActual = correoActual;
    }

    public Correo getCorreoActual() {
        return correoActual;
    }

    public void crearCorreo(String asunto, String mensaje, Mail destinatario){
        setCorreoActual(new Correo( asunto, 
                                    mensaje,
                                    getContactoPropio().getCorreo(),
                                    destinatario.getContactoPropio().getCorreo())); 
    }

    public void enviarABorrador(){
        this.bandejas.getBandejaBorradores().add(correoActual);
    }


    public void enviarCorreo( Mail destinatario) {
        this.bandejas.getBandejaEnviados().add(getCorreoActual());
        destinatario.recibirCorreo(getCorreoActual());
    }

    public void enviarCorreo(Correo correo, Mail destinatario) {
        this.bandejas.getBandejaEnviados().add(correo);
        destinatario.recibirCorreo(correo);
    }

    public void recibirCorreo(Correo correo) {
        this.bandejas.getBandejaDeEntrada().add(correo);
    }


}
