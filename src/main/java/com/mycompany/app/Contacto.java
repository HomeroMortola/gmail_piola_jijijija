package com.mycompany.app;

public class Contacto {
    private String nombre;
    private String correo;
    private Mail mail;
    


    public Contacto(String nombre, String correo, Mail mail) {
        setNombre(nombre);
        setCorreo(correo);
        setMail(mail);
    }

    //Set
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setCorreo(String correo) {
        this.correo = correo;
    }

    private void setMail(Mail mail) {
        this.mail = mail;
    }

    

    //Get
    protected String getNombre() {
        return this.nombre;
    }

    protected String getCorreo() {
        return this.correo;
    }

    protected  Mail getMail() {
        return this.mail;
    }

    

    


    
    
}
