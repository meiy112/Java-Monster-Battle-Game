package model.EnemyTests;

import model.Enemies.Assassin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssassinTest {

    Assassin enemy;

    @BeforeEach
    void runBefore() {
        enemy = new Assassin();
    }

    @Test
    void testConstructor() {
        assertEquals(2, enemy.getEnemyHp());
        assertEquals(2, enemy.getEnemyExp());
        assertEquals("An assassin swiftly appeared, you never saw them coming!",
                enemy.getEnemyDialogue());
    }
}
