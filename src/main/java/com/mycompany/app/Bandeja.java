package com.mycompany.app;
import java.util.ArrayList;

public abstract class Bandeja {
    private ArrayList<Correo> bandejaEnviados; //convertir en clase con interfas "bandeja"
    private ArrayList<Correo> bandejaDeEntrada;
    private ArrayList<Correo> bandejaBorradores;

    public Bandeja() {
        setbandejaDeEntrada();
        setbandejaEnviados();
        setBandejaBorradores();
    }

    private void setbandejaDeEntrada() {
        this.bandejaDeEntrada = new ArrayList<Correo>();
    }

    private void setbandejaEnviados() {
        this.bandejaEnviados = new ArrayList<Correo>();
    }

    private void setBandejaBorradores() {
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
}
