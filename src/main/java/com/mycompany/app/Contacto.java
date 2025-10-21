package com.mycompany.app;

public class Contacto {
    private String nombre;
    private String correo;

    public Contacto(String nombre, String correo) {
        setNombre(nombre);
        setCorreo(correo);
    }

    //Set
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setCorreo(String correo) {
        this.correo = correo;
    }

    //Get
    protected String getNombre() {
        return nombre;
    }

    protected String getCorreo() {
        return correo;
    }
    
}
