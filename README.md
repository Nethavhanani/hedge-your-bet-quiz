# Hedge Your Bet Quiz Game (South Africa Edition)

A Java Swing desktop quiz application built in NetBeans featuring a risk-reward scoring system and persistent score tracking. Players answer South African province trivia questions by checking 1, 2, or 3 options to hedge their bets, balancing high rewards with safety.

## 🎯 Features
* **Risk-Reward Scoring:** 
  * Select **1 option** (High Risk): **5 points** if correct, 0 if incorrect.
  * Select **2 options** (Medium Risk): **2 points** if the correct answer is included.
  * Select **3 options** (Low Risk): **1 point** guaranteed safety score.
* **South African Province Trivia:** 5 custom questions focused on Gauteng, KwaZulu-Natal, and Western Cape.
* **Score Persistence:** Uses Java File I/O (`previous_score.txt`) to automatically save player scores upon game completion and reload the previous high score on startup.
* **Performance Feedback:** Displays final total score out of 25 along with performance ratings (*Fantastic!*, *Very good*, *OK*).

## 🛠️ Tech Stack
* **Language:** Java 8+
* **GUI Framework:** Java Swing (`JFrame`, `JCheckBox`, `JButton`, `JOptionPane`)
* **File I/O:** `java.io.PrintWriter`, `java.io.FileWriter`, `java.util.Scanner`
* **IDE:** Apache NetBeans

## 🚀 How to Run

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/Nethavhanani/hedge-your-bet-quiz.git](https://github.com/Nethavhanani/hedge-your-bet-quiz.git)
