package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    Question question;

    @BeforeEach
    void runBefore() {
        question = new Question();
    }

    @Test
    void testQuestion() {
        assertEquals(null, question.getAnswer());
        assertEquals(null, question.getPrompt());
        question.setAnswer("a");
        question.setPrompt("p");
        assertEquals("a", question.getAnswer());
        assertEquals("p", question.getPrompt());
    }
}
