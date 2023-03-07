package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlmondTest {

    Almond enemy;

    @BeforeEach
    void runBefore() {
        enemy = new Almond();
    }

    @Test
    void testConstructor() {
        assertEquals(1, enemy.getEnemyHp());
        assertEquals(1, enemy.getEnemyExp());
        assertEquals("An almond appeared! She's a computer science major from a faraway land.",
                enemy.getEnemyDialogue());
    }
}
