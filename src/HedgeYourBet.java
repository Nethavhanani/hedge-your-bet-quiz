/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author takalani
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HedgeYourBet extends JFrame implements ActionListener {
    // 5 trivia questions sharing the same 3 South African provinces
    private final String[] questions = {
        "Which province is home to Table Mountain and Cape Town?",
        "Which province is home to Johannesburg and Soweto?",
        "Which province is known for Durban and the Golden Mile beachfront?",
        "Which province has Pretoria as an executive capital city?",
        "Which province is famous for the Cape Winelands?"
    };
    
    // Correct answer indices: 0 = Gauteng, 1 = KwaZulu-Natal, 2 = Western Cape
    private final int[] answers = {2, 0, 1, 0, 2};
    private final String[] options = {"Gauteng", "KwaZulu-Natal", "Western Cape"};

    private int currentQuestion = 0;
    protected int totalScore = 0;

    // GUI Components
    private JLabel lblQuestion;
    private JCheckBox chkOpt0, chkOpt1, chkOpt2;
    private JButton btnSubmit;
    private JLabel lblScore;

    public HedgeYourBet() {
        setTitle("Hedge Your Bet Game - South Africa Edition");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        lblQuestion = new JLabel();
        chkOpt0 = new JCheckBox(options[0]);
        chkOpt1 = new JCheckBox(options[1]);
        chkOpt2 = new JCheckBox(options[2]);
        btnSubmit = new JButton("Submit Answer");
        lblScore = new JLabel("Score: 0");

        btnSubmit.addActionListener(this);

        add(lblQuestion);
        add(chkOpt0);
        add(chkOpt1);
        add(chkOpt2);
        add(btnSubmit);
        add(lblScore);

        loadQuestion();
        setVisible(true);
    }

    private void loadQuestion() {
        lblQuestion.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);
        chkOpt0.setSelected(false);
        chkOpt1.setSelected(false);
        chkOpt2.setSelected(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean[] selected = {chkOpt0.isSelected(), chkOpt1.isSelected(), chkOpt2.isSelected()};
        int selectedCount = 0;

        for (boolean b : selected) {
            if (b) selectedCount++;
        }

        if (selectedCount == 0) {
            JOptionPane.showMessageDialog(this, "Please select at least one box!");
            return;
        }

        int correctAnswerIndex = answers[currentQuestion];
        boolean isCorrect = selected[correctAnswerIndex];

        // Scoring Rules
        if (selectedCount == 1 && isCorrect) {
            totalScore += 5;
        } else if (selectedCount == 2 && isCorrect) {
            totalScore += 2;
        } else if (selectedCount == 3) {
            totalScore += 1;
        }

        lblScore.setText("Score: " + totalScore);
        currentQuestion++;

        if (currentQuestion < questions.length) {
            loadQuestion();
        } else {
            endGame();
        }
    }

    protected void endGame() {
        btnSubmit.setEnabled(false);
        String rating;

        if (totalScore > 21) {
            rating = "Fantastic!";
        } else if (totalScore > 15) {
            rating = "Very good";
        } else {
            rating = "OK";
        }

        JOptionPane.showMessageDialog(this, 
            "Game Over!\nFinal Score: " + totalScore + "/25\nPerformance: " + rating);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HedgeYourBet());
    }
}