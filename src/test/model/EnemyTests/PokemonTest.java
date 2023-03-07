package model.EnemyTests;

import model.Enemies.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTest {

    Pokemon enemy;

    @BeforeEach
    void runBefore() {
        enemy = new Pokemon();
    }

    @Test
    void testConstructor() {
        assertEquals(2, enemy.getEnemyHp());
        assertEquals(2, enemy.getEnemyExp());
        assertEquals("A pokemon appeared! Who's that pokemon?!",
                enemy.getEnemyDialogue());
    }
}
