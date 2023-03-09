# My Personal Project

**Project Proposal:**

- My project is in the form of a game where the user answers self inserted questions to fight randomly generated 
opponents. The user will be able to set their own questions with their respective answers into the quiz. When the game
starts, questions and random opponents will pop up on the screen. Answering a question correctly will take one HP off
of the opponent's health, while answering a question incorrectly will damage the player's own health. Defeating
opponents will grant the player with a certain amount of exp depending on the strength of the opponent, which is used
to help the player level up and keep track of their progress. The game ends when the player either makes it through
the entire list of questions without their HP reaching 0, or when the player dies. 
- Those who will use this application might be students who like to study by quizzing themselves or using flashcards 
and are looking for a fun way to review the information they've learnt, or those who are simply bored. I am 
interested in this idea because I enjoy playing video games and am also currently working on developing a game outside 
of school. I also find it helpful to study by looking for ways to actively recall the information I've learnt, 
which is why I wanted to combine my interests and studying habits in my personal project. 

## User Stories
- As a user, I want to be able to add an arbitrary number of personalized questions into a quiz.
- As a user, I want to be able to start my quiz game.
- As a user, I want to be able to defeat randomly generated opponents by answering questions.
- As a user, I want to be able to view, add, and remove questions from my quiz.
- As a user, I want to be able to pause and unpause my quiz anytime it's running. 
- As a user, I want to be able to quit my quiz and return to the menu mid-game. 
- As a user, I want to be able to restart my quiz from the first question with all the default settings restored
if I so choose. 
- As a user, I want to be able to have the option to save the entire state of my quiz anytime. 
- As a user, I want to be able to have the option to load my saved quiz state from the menu.

*The methods in the JsonReader, JsonWriter class and the toJson() method with its respective Override methods have been
sampled from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git. The same applies to the tests in the
JsonReaderTest, JsonWriterTest, and JsonTest methods. 