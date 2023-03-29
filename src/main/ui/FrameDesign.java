package ui;

import model.Question;
import model.Quiz;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class FrameDesign extends JFrame {

    static final String JSON_STORE = "./data/myFile.json";

    private JPanel mainPanel;
    private JLabel menuTitle;
    private JButton loadQuizButton;
    private JButton addQuestionButton;
    private JButton saveQuizButton;
    private JButton deleteQuestionButton;
    private JTable questions;
    private JScrollPane questionPane;
    private JLabel questionsLabel;

    private static JsonReader jsonReader;
    static JsonWriter jsonWriter;

    private Quiz quiz;

    //EFFECT: Sets up frame where the quiz menu will be displayed
    public FrameDesign() {
        super("QuizGame Question Menu");
        setQuestionTable();
        setLoadQuizButton();
        setSaveQuizButton();
        setAddQuestionButton();
        setDeleteQuestionButton();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.quiz = new Quiz();
        ImageIcon icon = new ImageIcon("src/main/ui/FrameIcon.png");
        setIconImage(icon.getImage());
    }

    //EFFECT: Sets up table where questions will be displayed
    public void setQuestionTable() {
        questions.setModel(new DefaultTableModel(null, new String[]{"#", "Prompt", "Answer"}));
    }

    //MODIFIES: quiz
    //EFFECT: creates action for load quiz button, loads quiz from file when pressed
    public void setLoadQuizButton() {
        loadQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    quiz = jsonReader.read();
                    displayQuestions();

                    JOptionPane.showMessageDialog(null, "Loaded quiz from" + JSON_STORE);
                } catch (IOException ex) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        });
    }

    //MODIFIES: quiz
    //EFFECT: creates action for save quiz button, saves quiz to file when pressed
    public void setSaveQuizButton() {
        saveQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    jsonWriter.open();
                    jsonWriter.write(quiz);
                    jsonWriter.close();
                    JOptionPane.showMessageDialog(null, "Saved quiz to" + JSON_STORE);
                } catch (FileNotFoundException ex) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        });
    }

    //MODIFIES: quiz
    //EFFECT: creates action for add question button, prompts user to add question to quiz
    public void setAddQuestionButton() {
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prompt = JOptionPane.showInputDialog("Enter Prompt");
                String answer = JOptionPane.showInputDialog("Enter Answer");

//                ImageIcon p = new ImageIcon("./data/p.jpg");
//                Image scaledImage = p.getImage().getScaledInstance(120, 70, Image.SCALE_SMOOTH);
//                ImageIcon scaledP = new ImageIcon(scaledImage);
//
//                JPanel promptPanel = new JPanel(new BorderLayout());
//                promptPanel.add(new JLabel("Enter Prompt:"), BorderLayout.NORTH);
//                promptPanel.add(new JLabel(scaledP), BorderLayout.WEST);
//
//                String prompt = JOptionPane.showInputDialog(null, promptPanel, "Prompt",
//                        JOptionPane.PLAIN_MESSAGE);
//
//
//                ImageIcon a = new ImageIcon("./data/a.jpg");
//                Image scaledImage2 = a.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH);
//                ImageIcon scaledA = new ImageIcon(scaledImage2);
//
//                JPanel answerPanel = new JPanel(new BorderLayout());
//                answerPanel.add(new JLabel("Enter Answer:"), BorderLayout.NORTH);
//                answerPanel.add(new JLabel(scaledA), BorderLayout.WEST);
//
//                String answer = JOptionPane.showInputDialog(null, answerPanel, "Answer",
//                        JOptionPane.PLAIN_MESSAGE);

                if (prompt != null && answer != null) {
                    Question question = new Question();
                    question.setPrompt(prompt);
                    question.setAnswer(answer);
                    quiz.getQuestions().add(question);
                    displayQuestions();
                }
            }
        });
    }

    //MODIFIES: quiz
    //EFFECT: creates action for delete question button, prompts user to delete question
    public void setDeleteQuestionButton() {
        deleteQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the # of the question to be removed"));

                quiz.getQuestions().remove(num - 1);

                displayQuestions();
            }
        });
    }

    //EFFECT: displays questions on table
    public void displayQuestions() {
        setQuestionTable();
        DefaultTableModel questionTable = (DefaultTableModel) questions.getModel();

        for (Question q : quiz.getQuestions()) {
            questionTable.addRow(new Object[]{questionTable.getRowCount() + 1, q.getPrompt(), q.getAnswer()});
        }
    }


    public static void main(String[] args) {
        FrameDesign frame = new FrameDesign();
        frame.setContentPane(frame.mainPanel);
        frame.setTitle("Quiz Game");
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
