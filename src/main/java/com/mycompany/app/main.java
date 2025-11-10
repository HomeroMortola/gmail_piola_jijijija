package com.mycompany.app;

public class main {
    Contacto contactoPropio;
    Mail mail;

    public main(String nombre, String correo) {
        setContactoPropio(new Contacto(nombre, correo));
        setMail(new Mail(this.contactoPropio));
    }

    //set
    private  void setContactoPropio(Contacto propio) {
        this.contactoPropio = propio;
    }

    private void setMail(Mail mail) {
        this.mail = mail;
    }


    //get
    public Contacto getContactoPropio() {
        return contactoPropio;
    }

    public Mail getMail() {
        return mail;
    }
    
    
}
