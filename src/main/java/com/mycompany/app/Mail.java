package com.mycompany.app;

public class Mail {
    private Correo correoActual;
    private Bandeja bandejas;
    private Contacto contactoPropio;

    public Mail(Contacto contactoPropio) {
        setContactoPropio(contactoPropio);
        setBandejas();
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

    private void setBandejas() {
        this.bandejas = new Bandeja(){};
    }

    public Bandeja getBandeja() {
        return bandejas;
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
        Correo correo2 = getCorreoActual();
        this.bandejas.getBandejaEnviados().add(getCorreoActual());
        destinatario.recibirCorreo(correo2);
    }

    public void enviarCorreo(Correo correo, Mail destinatario) {
        Correo correo2 = correo;
        this.bandejas.getBandejaEnviados().add(correo);
        destinatario.recibirCorreo(correo2);
    }

    public void recibirCorreo(Correo correo) {
        this.bandejas.getBandejaDeEntrada().add(correo);
    }
   

}
