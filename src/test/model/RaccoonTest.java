package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaccoonTest {

    Raccoon enemy;

    @BeforeEach
    void runBefore() {
        enemy = new Raccoon();
    }

    @Test
    void testConstructor() {
        assertEquals(1, enemy.getEnemyHp());
        assertEquals(1, enemy.getEnemyExp());
        assertEquals("A raccoon appeared! He wants to colonize your land with his cousins.",
                enemy.getEnemyDialogue());
    }
}
