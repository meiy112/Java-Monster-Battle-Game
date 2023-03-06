package persistence;

import model.Quiz;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Quiz quiz = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testDefaultQuiz() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            Quiz quiz = reader.read();
            assertEquals(0, quiz.getQuestionNum());
            assertEquals(0, quiz.getScore());
            assertTrue(quiz.getContGame());
            assertEquals(3, quiz.getHp());
            assertEquals(0, quiz.getExp());
            assertEquals(0, quiz.getQuestions().size());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testEditedQuiz() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            WorkRoom wr = reader.read();
            assertEquals("My work room", wr.getName());
            List<Thingy> thingies = wr.getThingies();
            assertEquals(2, thingies.size());
            checkThingy("needle", Category.STITCHING, thingies.get(0));
            checkThingy("saw", Category.WOODWORK, thingies.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
