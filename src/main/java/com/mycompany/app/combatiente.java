package com.mycompany.app;


public class combatiente {
    private float Vida = 100;
    private boolean Vivo = true;
    private boolean Escudo = false;
    private float PoderDelEscudo;
    private float Daño = 100;

    
    

    public void Disparar(combatiente ovjetivo){

    }
    public float getVida() {
        return Vida;
    }

    public void RescibirDisparo(){
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
        
    }

    
}
