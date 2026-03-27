# ♟️ Tic-Tac-Toe — Two Player Console Game in Java

A strategic two-player console-based Tic-Tac-Toe game built in Java. Players compete turn-by-turn to align three symbols in a row, column, or diagonal on a 3×3 grid. Symbols are randomly assigned at the start of each game for fairness.

---

## 🎮 Features

- **Two-player mode** — Play against a friend on the same machine
- **Random symbol assignment** — X or O is randomly assigned to each player at the start
- **Input validation** — Rejects out-of-range numbers and already-occupied cells
- **Draw detection** — Automatically detects and announces a draw when all cells are filled
- **Clean board display** — The board refreshes after every move

---

## 🧠 Concepts Used

| Concept | Where Used |
|---|---|
| OOP & Static Methods | All methods in `Main.java` |
| 2D Arrays (`char[][]`) | Board representation |
| Loops (`for`, `while`) | Game loop, board display, validation |
| Switch Statements | Mapping player input to board position |
| Boolean Logic | Win detection, draw detection, input validation |
| `Random` class | Symbol assignment |
| `Scanner` class | Player input handling |

---

## 📁 Project Structure

```
TicTacToe/
├── Main.java       # All game logic — board, players, validation, win/draw detection
└── README.md
```

---

## ▶️ How to Run

### Option 1: Command Line
```bash
# Compile
javac Main.java

# Run
java Main
```

### Option 2: IntelliJ IDEA / Eclipse
1. Create a new Java project
2. Add `Main.java` to the `src/` folder
3. Run `Main.java`

---

## 🕹️ How to Play

When the game starts, you will see the position reference board:

```
 ___ ___ ___
| 1 | 2 | 3 |
 --- --- ---
 ___ ___ ___
| 4 | 5 | 6 |
 --- --- ---
 ___ ___ ___
| 7 | 8 | 9 |
 --- --- ---
```

Each player enters a number from **1 to 9** on their turn to place their symbol on the corresponding cell.

**Example game flow:**
```
The fate has decided!
⚔  Player 1 wields [ X ]
⚔  Player 2 wields [ O ]
May the best player win!

── Player 1's Turn ──
Select a position (1-9) to place your symbol on the board:
> 5
```

---

## ⚙️ Win Conditions

The game checks all **8 possible winning combinations** after every move:

- 3 horizontal rows
- 3 vertical columns
- 2 diagonals

If all 9 cells are filled and neither player has won, the game declares a **Draw**.

---

## 📊 Complexity Analysis

| Method | Time Complexity | Space Complexity |
|---|---|---|
| `validate_entry` | O(n) | O(1) |
| `player_1_win_check` / `player_2_win_check` | O(1) | O(1) |
| `isBlockRemaining` / `checkDraw` | O(n) | O(1) |
| **Overall Program** | **O(n)** | **O(n)** |

> Since the board is always a fixed 3×3 grid (n = 9), all operations are effectively **O(1)** in practice.

---

## 🚀 Future Improvements

- [ ] Add an AI opponent using the **Minimax algorithm**
- [ ] Add a score tracker across multiple rounds
- [ ] Build a GUI version using Java Swing or JavaFX
- [ ] Add difficulty levels (Easy / Hard AI)

---

## 👨‍💻 Author

Made with ❤️ as a 2nd Semester Java Project  
**[Your Name]** — [Your GitHub Profile Link]
