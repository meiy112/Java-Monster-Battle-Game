package persistence;

import model.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkQuestion(Question question, String prompt, String answer) {
        assertEquals(prompt, question.getPrompt());
        assertEquals(answer, question.getAnswer());
    }
}
