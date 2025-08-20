package com.mycompany.app;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class combatienteTest {
    @Test
    public void CombatienteMuere(){
        combatiente c1 = new combatiente();
        c1.RescibirDisparo();
        assertFalse(c1.getVivo());
    }
}
