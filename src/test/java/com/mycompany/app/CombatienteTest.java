package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CombatienteTest {
    @Test
    public void CombatienteMuere(){
        Combatiente c1 = new Combatiente();
        c1.RecibirDisparo();
        assertFalse(c1.getVivo());
    }
    @Test 
    public void EscudoFunciona(){
        Combatiente c1 = new Combatiente();
        c1.ActivarEscudo();
        c1.RecibirDisparo();
        assertTrue(c1.getVivo());
        /*assertEquals("los valores no son iguales",50.0, c1.getVida());*/
    }
    @Test 
    public void DarEscudo(){
        Combatiente c1 = new Combatiente();
        Combatiente c2 = new Combatiente();
        c1.DarEscudo(c2);
        c2.RecibirDisparo();
        assertTrue(c2.getVivo());
        /*assertEquals("los valores no son iguales",50.0,c2.getVida());*/
    }
    @Test 
    public void DispararCotraOtro(){
        Combatiente c1 = new Combatiente();
        Combatiente c2 = new Combatiente();
        c1.Disparar(c2);
        assertFalse(c2.getVivo());
    }
}
