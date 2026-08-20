/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author takalani
 */
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class HedgeYourBetUsingFile extends HedgeYourBet {
    private static final String FILE_NAME = "previous_score.txt";
    private JLabel lblPreviousScore;

    public HedgeYourBetUsingFile() {
        super();
        
        int previousScore = readPreviousScore();
        lblPreviousScore = new JLabel("Previous Score: " + previousScore);
        
        add(lblPreviousScore);
        
        revalidate();
        repaint();
    }

    private int readPreviousScore() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                if (scanner.hasNextInt()) {
                    return scanner.nextInt();
                }
            } catch (IOException e) {
                System.err.println("Error reading score file: " + e.getMessage());
            }
        }
        return 0;
    }

    private void saveCurrentScore(int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println(score);
        } catch (IOException e) {
            System.err.println("Error saving score to file: " + e.getMessage());
        }
    }

    @Override
    protected void endGame() {
        saveCurrentScore(totalScore);
        super.endGame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HedgeYourBetUsingFile());
    }
}