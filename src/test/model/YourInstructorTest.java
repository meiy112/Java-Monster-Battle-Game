package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YourInstructorTest {

    YourInstructor enemy;

    @BeforeEach
    void runBefore() {
        enemy = new YourInstructor();
    }

    @Test
    void testConstructor() {
        assertEquals(2, enemy.getEnemyHp());
        assertEquals(2, enemy.getEnemyExp());
        assertEquals("Your instructor appeared! They tell you to study hard for your next exam.",
                enemy.getEnemyDialogue());
    }
}
