# NumberPredictionGame
🎲 A Java-based console game where players guess a random number with hints like "Too high" or "Too low".

---
## 🚀 Features
- Random number between 1 and 100
- Feedback on each guess (**Too high / Too low / Correct**)
- Option to limit the maximum number of attempts
- Tracks and displays your best score (fewest attempts)
- Allows quitting a round by typing `0`
- Simple, beginner-friendly, and interactive

---
## 🖥️ Example Run

🎲 **Welcome to Number Prediction Game!**

Do you want to set a maximum number of attempts? (yes/no): **yes**  
Enter maximum attempts (e.g., 5): **5**

---

🤖 I've picked a number between **1 and 100**.  
You have up to **5 attempt(s)** to guess it.

---

👉 Enter your guess (or type `0` to quit this round): **50**  
⬆️ Too low. Try again.

👉 Enter your guess (or type `0` to quit this round): **75**  
⬇️ Too high. Try again.

👉 Enter your guess (or type `0` to quit this round): **62**  
🎉 Correct! You guessed it in **3 attempt(s)**.

🏆 **New best score:** 3 attempts!

---

🔄 Do you want to play again? (yes/no): **no**  
✅ Thanks for playing! Goodbye 👋


---
## ⚙️ How to Run  
1. Clone this repository:
```bash
  git clone https://github.com/SaumikLaha/NumberPredictionGame.git
```

2. Open the project in IntelliJ IDEA (or any Java IDE).
3. Navigate to the src/ folder.
4. Compile and run:

javac NumberPredictionGame.java
java NumberPredictionGame
---
## 📚 Concepts Used

| Concept                     | Description |
|-----------------------------|-------------|
| **Random Class**            | Used to generate a random secret number within a range (1–100). |
| **Scanner Class**           | Handles user input from the console. |
| **if-else Conditions**      | Provides feedback to the user (`Too high`, `Too low`, `Correct`). |
| **Loops (while/do-while)**  | Repeats the guessing process until the correct number is guessed or user quits. |
| **Input Validation**        | Ensures valid input (numbers only, handles quit option `0`). |
| **Counters/Variables**      | Tracks number of attempts and best score. |
---
## ✨ Author

**👤 Saumik Laha**  
*Java Programming Intern – MotionCut*

- 🔗 [GitHub](https://github.com/SaumikLaha)
- 💼 [LinkedIn](https://www.linkedin.com/in/saumik-laha-530883381/)  
