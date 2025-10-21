package com.mycompany.app;
import java.util.ArrayList;

public class Mail {
    private ArrayList<Correo> bandejaEnviados;

    public Mail() {
        bandejaEnviados = new ArrayList<Correo>();
    }

    public void setbandejaEnviados(ArrayList<Correo> bandejaEnviados) {
        this.bandejaEnviados = bandejaEnviados;
    }

    public ArrayList<Correo> getBandejaEnviados() {
        return bandejaEnviados;
    }



    public void enviarCorreo(Correo correo) {

        bandejaEnviados.add(correo);
    }
}
