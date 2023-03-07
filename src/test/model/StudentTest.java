package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    Student enemy;

    @BeforeEach
    void runBefore() {
        enemy = new Student();
    }

    @Test
    void testConstructor() {
        assertEquals(1, enemy.getEnemyHp());
        assertEquals(1, enemy.getEnemyExp());
        assertEquals("A student appeared! They look tired... as usual.",
                enemy.getEnemyDialogue());
    }
}
