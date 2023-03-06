package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PirateTest {

    Pirate enemy;

    @BeforeEach
    void runBefore() {
        enemy = new Pirate();
    }

    @Test
    void testConstructor() {
        assertEquals(3, enemy.getEnemyHp());
        assertEquals(3, enemy.getEnemyExp());
        assertEquals("A pirate appeared, they look very strong!",
                enemy.getEnemyDialogue());
    }
}
