package com.mycompany.app;
import java.util.ArrayList;

public class Mail {
    private ArrayList<Correo> bandejaEnviados; //convertir en clase con interfas "bandeja"
    private ArrayList<Correo> bandejaDeEntrada;
    private ArrayList<Correo> bandejaBorradores;
    private Correo correoActual;

    private Contacto contactoPropio;

    public Mail(Contacto contactoPropio) {
        setContactoPropio(contactoPropio);
        bandejaEnviados = new ArrayList<Correo>();
        bandejaDeEntrada = new ArrayList<Correo>();
        bandejaBorradores = new ArrayList<Correo>();
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
        bandejaBorradores.add(correoActual);
    }


    public void enviarCorreo( Mail destinatario) {
        bandejaEnviados.add(getCorreoActual());
        destinatario.recibirCorreo(getCorreoActual());
    }

    public void enviarCorreo(Correo correo, Mail destinatario) {
        bandejaEnviados.add(correo);
        destinatario.recibirCorreo(correo);
    }

    public void recibirCorreo(Correo correo) {
        bandejaDeEntrada.add(correo);
    }


}
