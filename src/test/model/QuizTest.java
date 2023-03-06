package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {

    Quiz quiz;
    Enemy smallEnemy;
    Enemy mediumEnemy;
    Enemy largeEnemy;
    Question question1;

    @BeforeEach
    void runBefore() {
        quiz = new Quiz();
        smallEnemy = new Almond();
        mediumEnemy = new Assassin();
        largeEnemy = new MagicUser();
        question1 = new Question();
    }

    @Test
    void testConstructor() {
        assertEquals(0, quiz.getScore());
        assertEquals(3, quiz.getHp());
        assertEquals(1, quiz.getLevel());
        assertEquals(0, quiz.getScore());
        assertEquals(0, quiz.getQuestions().size());
    }

    @Test
    void testAddOneQuestion() {
        assertEquals(0, quiz.getQuestions().size());
        quiz.addQuestion(question1);
        assertEquals(1, quiz.getQuestions().size());
    }

    @Test
    void testAddMultipleQuestions() {
        assertEquals(0, quiz.getQuestions().size());
        quiz.addQuestion(question1);
        quiz.addQuestion(question1);
        quiz.addQuestion(question1);
        assertEquals(3, quiz.getQuestions().size());
    }

//    @Test
//    void testAddOneEnemy() {
//        assertEquals(0, quiz.getEnemies().size());
//        quiz.addEnemy(smallEnemy);
//        assertEquals(1, quiz.getEnemies().size());
//        assertEquals(smallEnemy, quiz.getEnemy(0));
//    }
//
//    @Test
//    void testAddMultipleEnemies() {
//        assertEquals(0, quiz.getEnemies().size());
//        quiz.addEnemy(smallEnemy);
//        quiz.addEnemy(mediumEnemy);
//        quiz.addEnemy(largeEnemy);
//        assertEquals(3, quiz.getEnemies().size());
//        assertEquals(smallEnemy, quiz.getEnemy(0));
//        assertEquals(mediumEnemy, quiz.getEnemy(1));
//        assertEquals(largeEnemy, quiz.getEnemy(2));
//    }

    @Test
    void testDefeatSmallEnemy() {
        assertEquals(0, quiz.getScore());
        assertEquals(0, quiz.getExp());
        quiz.defeatEnemy(smallEnemy);
        assertEquals(1, quiz.getScore());
        assertEquals(1, quiz.getExp());
    }

    @Test
    void testDefeatMediumEnemy() {
        assertEquals(0, quiz.getScore());
        assertEquals(0, quiz.getExp());
        quiz.defeatEnemy(mediumEnemy);
        assertEquals(1, quiz.getScore());
        assertEquals(2, quiz.getExp());
    }

    @Test
    void testDefeatLargeEnemy() {
        assertEquals(0, quiz.getScore());
        assertEquals(0, quiz.getExp());
        quiz.defeatEnemy(largeEnemy);
        assertEquals(1, quiz.getScore());
        assertEquals(3, quiz.getExp());
    }

    @Test
    void testDefeatMultipleEnemies() {
        assertEquals(0, quiz.getScore());
        assertEquals(0, quiz.getExp());
        quiz.defeatEnemy(largeEnemy);
        quiz.defeatEnemy(smallEnemy);
        quiz.defeatEnemy(mediumEnemy);
        assertEquals(3, quiz.getScore());
        assertEquals(6, quiz.getExp());
    }

    @Test
    void testDecreaseHpByOne() {
        assertEquals(3, quiz.getHp());
        quiz.decreaseHpByOne();
        assertEquals(2, quiz.getHp());
    }

    @Test
    void testDecreaseHpMultipleTimes() {
        assertEquals(3, quiz.getHp());
        quiz.decreaseHpByOne();
        quiz.decreaseHpByOne();
        assertEquals(1, quiz.getHp());
    }

    @Test
    void testLevelUpOnce() {
        assertEquals(1, quiz.getLevel());
        quiz.defeatEnemy(largeEnemy);
        quiz.levelUp();
        assertEquals(2, quiz.getLevel());
    }

    @Test
    void testLevelUpMultipleTimes() {
        assertEquals(1, quiz.getLevel());
        quiz.defeatEnemy(largeEnemy);
        quiz.defeatEnemy(largeEnemy);
        quiz.levelUp();
        assertEquals(3, quiz.getLevel());
    }

    @Test
    void testIsGameOver() {
        assertFalse(quiz.isGameOver());
        quiz.decreaseHpByOne();
        quiz.decreaseHpByOne();
        quiz.decreaseHpByOne();
        assertTrue(quiz.isGameOver());
        quiz.decreaseHpByOne();
        assertTrue(quiz.isGameOver());
    }
}
