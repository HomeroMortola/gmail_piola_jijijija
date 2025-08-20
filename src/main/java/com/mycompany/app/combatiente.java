package com.mycompany.app;


public class combatiente {
    private float Vida;
    private boolean Vivo;
    private boolean Escudo;
    private float PoderDelEscudo;
    private float daño = 100;

    public void InicialisarCombatiente(){

    }
    

    public void Disparar(combatiente ovjetivo){

    }
    public float getVida() {
        return Vida;
    }

    public void RescibirDisparo(){
        if (Escudo) {
            this.Vida -= (daño/PoderDelEscudo);
        }
        else{
            this.Vida -= daño;
        }
        if (Vida < 1){
            this.Vivo = false;
        }
        

    }
    public boolean getVivo(){
        return Vivo;
    }

    
}
