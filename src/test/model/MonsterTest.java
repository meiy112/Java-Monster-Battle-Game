package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Monster.*;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {
    
    Monster smallMonster;
    Monster mediumMonster;
    Monster largeMonster;

    @BeforeEach
    void runBefore() {
        smallMonster = new Monster(1);
        mediumMonster = new Monster(2);
        largeMonster = new Monster(3);
    }

    @Test
    void testConstructor() {
        assertEquals(1, smallMonster.getMonsterHp());
        assertEquals(1, smallMonster.getMonsterExp());
        assertEquals(SMALL_MONSTER_DIALOGUE, smallMonster.getMonsterDialogue());

        assertEquals(2, mediumMonster.getMonsterHp());
        assertEquals(2, mediumMonster.getMonsterExp());
        assertEquals(MEDIUM_MONSTER_DIALOGUE, mediumMonster.getMonsterDialogue());

        assertEquals(3, largeMonster.getMonsterHp());
        assertEquals(3, largeMonster.getMonsterExp());
        assertEquals(LARGE_MONSTER_DIALOGUE, largeMonster.getMonsterDialogue());
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
