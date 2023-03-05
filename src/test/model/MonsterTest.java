package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {
    
    Enemy smallMonster;
    Enemy mediumMonster;
    Enemy largeMonster;
    Enemy nullMonster;

    @BeforeEach
    void runBefore() {
        smallMonster = new Enemy(1);
        mediumMonster = new Enemy(2);
        largeMonster = new Enemy(3);
        nullMonster = new Enemy(0);
    }

    @Test
    void testConstructor() {
        assertEquals(1, smallMonster.getMonsterHp());
        assertEquals(1, smallMonster.getMonsterSize());
        assertEquals(1, smallMonster.getMonsterExp());
        assertEquals("a small monster appeared!", smallMonster.getMonsterDialogue());

        assertEquals(2, mediumMonster.getMonsterHp());
        assertEquals(2, mediumMonster.getMonsterSize());
        assertEquals(2, mediumMonster.getMonsterExp());
        assertEquals("a moderate sized monster appeared!", mediumMonster.getMonsterDialogue());

        assertEquals(3, largeMonster.getMonsterHp());
        assertEquals(3, largeMonster.getMonsterSize());
        assertEquals(3, largeMonster.getMonsterExp());
        assertEquals("uh-oh... a large monster appeared!", largeMonster.getMonsterDialogue());

        assertEquals(0, nullMonster.getMonsterHp());
        assertEquals(0, nullMonster.getMonsterSize());
        assertEquals(0, nullMonster.getMonsterExp());
        assertNull(nullMonster.getMonsterDialogue());
    }

    @Test
    void testIsDefeated() {
        assertFalse(smallMonster.isDefeated());
        smallMonster.attackMonster();
        assertTrue(smallMonster.isDefeated());
    }

    @Test
    void testAttackMonster() {
        assertEquals(1, smallMonster.getMonsterHp());
        smallMonster.attackMonster();
        assertEquals(0, smallMonster.getMonsterHp());
        
        assertEquals(3, largeMonster.getMonsterHp());
        largeMonster.attackMonster();
        largeMonster.attackMonster();
        assertEquals(1, largeMonster.getMonsterHp());
    }
}
