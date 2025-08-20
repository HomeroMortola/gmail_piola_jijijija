package com.mycompany.app;


public class Combatiente {
    private float Vida = 100;
    private boolean Vivo = true;
    private boolean Escudo = false;
    private float PoderDelEscudo = 2;
    private float Daño = 100;

    
    

    public void Disparar(Combatiente _ovjetivo){
        _ovjetivo.RecibirDisparo();
    }
    public float getVida() {
        return Vida;
    }

    public void RecibirDisparo(){
        if (Escudo) {
            this.Vida -= (Daño/PoderDelEscudo);
        }
        else{
            this.Vida -= Daño;
        }
        if (Vida < 1){
            this.Vivo = false;
        }
        

    }
    public boolean getVivo(){
        return Vivo;
    }
    public void ActivarEscudo(){
        this.Escudo = true;
    }
    public void DarEscudo(Combatiente _ovjetivo){
        _ovjetivo.ActivarEscudo();
    }
    

    
}
