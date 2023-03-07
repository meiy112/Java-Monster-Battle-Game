package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkTest {

    Link enemy;

    @BeforeEach
    void runBefore() {
        enemy = new Link();
    }

    @Test
    void testConstructor() {
        assertEquals(2, enemy.getEnemyHp());
        assertEquals(2, enemy.getEnemyExp());
        assertEquals("Zelda appeared! ... Or is it Link?",
                enemy.getEnemyDialogue());
    }
}
