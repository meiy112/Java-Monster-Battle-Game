package model.EnemyTests;

import model.Enemies.MagicUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagicUserTest {

    MagicUser enemy;

    @BeforeEach
    void runBefore() {
        enemy = new MagicUser();
    }

    @Test
    void testConstructor() {
        assertEquals(3, enemy.getEnemyHp());
        assertEquals(3, enemy.getEnemyExp());
        assertEquals("A magic user appeared, they look very strong!",
                enemy.getEnemyDialogue());
    }
}
