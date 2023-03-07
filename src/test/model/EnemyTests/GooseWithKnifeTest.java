package model.EnemyTests;

import model.Enemies.GooseWithKnife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GooseWithKnifeTest {

    GooseWithKnife enemy;

    @BeforeEach
    void runBefore() {
        enemy = new GooseWithKnife();
    }

    @Test
    void testConstructor() {
        assertEquals(1, enemy.getEnemyHp());
        assertEquals(1, enemy.getEnemyExp());
        assertEquals("A goose with a knife appeared! *Honk*",
                enemy.getEnemyDialogue());
    }
}
