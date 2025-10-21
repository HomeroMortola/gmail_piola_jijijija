package com.mycompany.app;
import java.util.ArrayList;

public class Mail {
    private ArrayList<Correo> bandejaEnviados;
    private ArrayList<Correo> bandejaDeEntrada;

    public Mail() {
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

    public void enviarCorreo(Correo correo, Mail destinatario) {

        bandejaEnviados.add(correo);
        destinatario.recibirCorreo(correo);
    }

    public void recibirCorreo(Correo correo) {
        bandejaDeEntrada.add(correo);
    }
}
