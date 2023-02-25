package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Quiz.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {

    Quiz quiz;
    Monster smallMonster;
    Monster mediumMonster;
    Monster largeMonster;
    Question question1;

    @BeforeEach
    void runBefore() {
        quiz = new Quiz();
        smallMonster = new Monster(1);
        mediumMonster = new Monster(2);
        largeMonster = new Monster(3);
        question1 = new Question();
    }

    @Test
    void testConstructor() {
        assertEquals(INITIAL_SCORE, quiz.getScore());
        assertEquals(INITIAL_HP, quiz.getHp());
        assertEquals(INITIAL_LEVEL, quiz.getLevel());
        assertEquals(INITIAL_EXP, quiz.getScore());
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
    }

    @Test
    void testAddMultipleMonsters() {
        assertEquals(0, quiz.getMonsters().size());
        quiz.addMonster(smallMonster);
        quiz.addMonster(smallMonster);
        quiz.addMonster(smallMonster);
        assertEquals(3, quiz.getMonsters().size());
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
