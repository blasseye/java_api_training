
package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class LauncherTest {
    @Test
    public void mauvais_taille_port() {
        Assertions.assertThrows( Exception.class, () -> Launcher.main(new String[] {"012345"}));
    }

    @Test
    public void mauvais_type_port() {
        Assertions.assertThrows( Exception.class, () -> Launcher.main(new String[] {"port_sous_forme_de_string"}));
    }

    @Test
    public void port_vide() {
        Assertions.assertThrows( Exception.class, () -> Launcher.main(new String[] {""}));
    }

}
