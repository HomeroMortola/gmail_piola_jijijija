package com.mycompany.app;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ContactoTest {
    @Test
    public void testExistenciaDeCorreo() {
        Contacto c1 = new Contacto("Antonio Fernandez", "antoniofernandez@outlook.com");

        assertNotNull(c1);
    }
}
