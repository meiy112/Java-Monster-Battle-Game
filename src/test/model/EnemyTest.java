package model;

import model.Enemies.Almond;
import model.Enemies.Assassin;
import model.Enemies.MagicUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {
    
    Enemy smallEnemy;
    Enemy mediumEnemy;
    Enemy largeEnemy;
    Enemy nullEnemy;

    @BeforeEach
    void runBefore() {
        smallEnemy = new Almond();
        mediumEnemy = new Assassin();
        largeEnemy = new MagicUser();
        nullEnemy = null;
    }

    @Test
    void testConstructor() {
        assertEquals(0, nullEnemy.getEnemyHp());
        assertEquals(0, nullEnemy.getEnemyExp());
        assertNull(nullEnemy.getEnemyDialogue());
    }

    @Test
    void testIsDefeated() {
        assertFalse(smallEnemy.isDefeated());
        smallEnemy.attackEnemy();
        assertTrue(smallEnemy.isDefeated());
    }

    @Test
    void testAttackEnemy() {
        assertEquals(1, smallEnemy.getEnemyHp());
        smallEnemy.attackEnemy();
        assertEquals(0, smallEnemy.getEnemyHp());
        
        assertEquals(3, largeEnemy.getEnemyHp());
        largeEnemy.attackEnemy();
        largeEnemy.attackEnemy();
        assertEquals(1, largeEnemy.getEnemyHp());
    }
}
