package com.mycompany.app;
import java.util.ArrayList;

public class Mail {
    private ArrayList<Correo> bandejaEnviados;
    private ArrayList<Correo> bandejaDeEntrada;
    private Contacto contactoPropio;

    public Mail(Contacto contactoPropio) {
        setContactoPropio(contactoPropio);
        bandejaEnviados = new ArrayList<Correo>();
        bandejaDeEntrada = new ArrayList<Correo>();
    }

    public void setbandejaEnviados(ArrayList<Correo> bandejaEnviados) {
        this.bandejaEnviados = bandejaEnviados;
    }

    public ArrayList<Correo> getBandejaEnviados() {
        return bandejaEnviados;
    }

    public void setbandejaDeEntrada(ArrayList<Correo> bandejaDeEntrada) {
        this.bandejaDeEntrada = bandejaDeEntrada;
    }

    public ArrayList<Correo> getBandejaDeEntrada() {
        return bandejaDeEntrada;
    }

    public void setContactoPropio(Contacto contactoPropio) {
        this.contactoPropio = contactoPropio;
    }

    public Contacto getContactoPropio() {
        return contactoPropio;
    }

    public void crearCorreo(String asunto, String mensaje){
        
    }

    public void enviarCorreo(Correo correo, Mail destinatario) {

        bandejaEnviados.add(correo);
        destinatario.recibirCorreo(correo);
    }

    public void recibirCorreo(Correo correo) {
        bandejaDeEntrada.add(correo);
    }


}
