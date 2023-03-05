package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {

    Quiz quiz;
    Enemy smallMonster;
    Enemy mediumMonster;
    Enemy largeMonster;
    Question question1;

    @BeforeEach
    void runBefore() {
        quiz = new Quiz();
        smallMonster = new Enemy(1);
        mediumMonster = new Enemy(2);
        largeMonster = new Enemy(3);
        question1 = new Question();
    }

    @Test
    void testConstructor() {
        assertEquals(0, quiz.getScore());
        assertEquals(3, quiz.getHp());
        assertEquals(1, quiz.getLevel());
        assertEquals(0, quiz.getScore());
        assertEquals(0, quiz.getMonsters().size());
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

    @Test
    void testAddOneMonster() {
        assertEquals(0, quiz.getMonsters().size());
        quiz.addMonster(smallMonster);
        assertEquals(1, quiz.getMonsters().size());
        assertEquals(smallMonster, quiz.getMonster(0));
    }

    @Test
    void testAddMultipleMonsters() {
        assertEquals(0, quiz.getMonsters().size());
        quiz.addMonster(smallMonster);
        quiz.addMonster(mediumMonster);
        quiz.addMonster(largeMonster);
        assertEquals(3, quiz.getMonsters().size());
        assertEquals(smallMonster, quiz.getMonster(0));
        assertEquals(mediumMonster, quiz.getMonster(1));
        assertEquals(largeMonster, quiz.getMonster(2));
    }

    @Test
    void testDefeatSmallMonster() {
        assertEquals(0, quiz.getScore());
        assertEquals(0, quiz.getExp());
        quiz.defeatMonster(smallMonster);
        assertEquals(1, quiz.getScore());
        assertEquals(1, quiz.getExp());
    }

    @Test
    void testDefeatMediumMonster() {
        assertEquals(0, quiz.getScore());
        assertEquals(0, quiz.getExp());
        quiz.defeatMonster(mediumMonster);
        assertEquals(1, quiz.getScore());
        assertEquals(2, quiz.getExp());
    }

    @Test
    void testDefeatLargeMonster() {
        assertEquals(0, quiz.getScore());
        assertEquals(0, quiz.getExp());
        quiz.defeatMonster(largeMonster);
        assertEquals(1, quiz.getScore());
        assertEquals(3, quiz.getExp());
    }

    @Test
    void testDefeatMultipleMonsters() {
        assertEquals(0, quiz.getScore());
        assertEquals(0, quiz.getExp());
        quiz.defeatMonster(largeMonster);
        quiz.defeatMonster(smallMonster);
        quiz.defeatMonster(mediumMonster);
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
        quiz.defeatMonster(largeMonster);
        quiz.levelUp();
        assertEquals(2, quiz.getLevel());
    }

    @Test
    void testLevelUpMultipleTimes() {
        assertEquals(1, quiz.getLevel());
        quiz.defeatMonster(largeMonster);
        quiz.defeatMonster(largeMonster);
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
