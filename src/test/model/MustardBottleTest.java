package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MustardBottleTest {

    MustardBottle enemy;

    @BeforeEach
    void runBefore() {
        enemy = new MustardBottle();
    }

    @Test
    void testConstructor() {
        assertEquals(1, enemy.getEnemyHp());
        assertEquals(1, enemy.getEnemyExp());
        assertEquals("A mustard bottle appeared! She sent a weather balloon down to earth and framed China.",
                enemy.getEnemyDialogue());
    }
}
