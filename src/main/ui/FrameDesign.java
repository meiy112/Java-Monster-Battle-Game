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

    public FrameDesign() {
        super("Quiz Game");
        setQuestionTable();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        loadQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Quiz quiz = jsonReader.read();

                    setQuestionTable();
                    DefaultTableModel questionTable = (DefaultTableModel) questions.getModel();

                    for (Question q : quiz.getQuestions()) {
                        String prompt = q.getPrompt();
                        String answer = q.getAnswer();
                        questionTable.addRow(new Object[]{questionTable.getRowCount() + 1, prompt, answer});
                    }

                    System.out.println("Loaded quiz from " + JSON_STORE);
                } catch (IOException ex) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        });


        saveQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Quiz quiz = new Quiz();

                DefaultTableModel questionTable = (DefaultTableModel) questions.getModel();
                for (int i = 0; i < questionTable.getRowCount(); i++) {
                    String prompt = questionTable.getValueAt(i, 1).toString();
                    String answer = questionTable.getValueAt(i, 1).toString();
                    Question question = new Question();
                    question.setAnswer(answer);
                    question.setPrompt(prompt);
                    quiz.addQuestion(question);
                }

                try {
                    jsonWriter.open();
                    jsonWriter.write(quiz);
                    jsonWriter.close();
                    System.out.println("Saved quiz to " + JSON_STORE);
                } catch (FileNotFoundException ex) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        });


        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String prompt = JOptionPane.showInputDialog("Enter Prompt");
//                String answer = JOptionPane.showInputDialog("Enter Answer");

                ImageIcon p = new ImageIcon("./data/p.jpg");
                Image scaledImage = p.getImage().getScaledInstance(120, 70, Image.SCALE_SMOOTH);
                ImageIcon scaledP = new ImageIcon(scaledImage);

                JPanel promptPanel = new JPanel(new BorderLayout());
                promptPanel.add(new JLabel("Enter Prompt:"), BorderLayout.NORTH);
                promptPanel.add(new JLabel(scaledP), BorderLayout.WEST);

                String prompt = JOptionPane.showInputDialog(null, promptPanel, "Prompt",
                        JOptionPane.PLAIN_MESSAGE);


                ImageIcon a = new ImageIcon("./data/a.jpg");
                Image scaledImage2 = a.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH);
                ImageIcon scaledA = new ImageIcon(scaledImage2);

                JPanel answerPanel = new JPanel(new BorderLayout());
                answerPanel.add(new JLabel("Enter Answer:"), BorderLayout.NORTH);
                answerPanel.add(new JLabel(scaledA), BorderLayout.WEST);

                String answer = JOptionPane.showInputDialog(null, answerPanel, "Answer",
                        JOptionPane.PLAIN_MESSAGE);

                DefaultTableModel questionTable = (DefaultTableModel) questions.getModel();
                questionTable.addRow(new Object[]{questionTable.getRowCount() + 1, prompt, answer});
            }
        });


        deleteQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = Integer.parseInt(JOptionPane.showInputDialog("Enter the # of the question to be removed"));

                DefaultTableModel questionTable = (DefaultTableModel) questions.getModel();
                questionTable.removeRow(row - 1);
                for (int i = 0; i < questionTable.getRowCount(); i++) {
                    int value = Integer.parseInt(questionTable.getValueAt(i, 0).toString());
                    if (i + 1 != value) {
                        questionTable.setValueAt(new Integer(i + 1), i, 0);
                    }
                }
            }
        });
    }

    public void setQuestionTable() {
        questions.setModel(new DefaultTableModel(null, new String[]{"#", "Prompt", "Answer"}));
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
