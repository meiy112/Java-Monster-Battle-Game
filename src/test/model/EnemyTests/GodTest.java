package model.EnemyTests;

import model.Enemies.God;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GodTest {

    God enemy;

    @BeforeEach
    void runBefore() {
        enemy = new God();
    }

    @Test
    void testConstructor() {
        assertEquals(4, enemy.getEnemyHp());
        assertEquals(4, enemy.getEnemyExp());
        assertEquals("God appeared! This is what our god looks like.",
                enemy.getEnemyDialogue());
    }
}
