package model.EnemyTests;

import model.Enemies.GrimReaper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrimReaperTest {

    GrimReaper enemy;

    @BeforeEach
    void runBefore() {
        enemy = new GrimReaper();
    }

    @Test
    void testConstructor() {
        assertEquals(3, enemy.getEnemyHp());
        assertEquals(3, enemy.getEnemyExp());
        assertEquals("The grim reaper appeared, they look very strong!",
                enemy.getEnemyDialogue());
    }
}
