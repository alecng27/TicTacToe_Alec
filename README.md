Tic Tac Toe Game

This is a simple command line Tic Tac Toe game implemented in Java. The game allows the user to play against a computer player that makes decisions based on a simple AI algorithm.

How to Run the Game

Clone the repository to your local machine using git clone https://github.com/your-username/tic-tac-toe.git.
Navigate to the project directory using the terminal or command prompt.
Compile the Java code using the command javac TicTacToe.java.
Run the game using the command java TicTacToe.
How the Game Works

When you run the game, you will be prompted to enter your name. Once you have entered your name, the game board will be displayed and you will be asked to choose a cell to place your mark (X) in.

The game will then alternate turns between you and the computer player, until either someone wins or the game board is full. The computer player uses a simple AI algorithm to make decisions on where to place its mark.

If you win, the game will display a message congratulating you. If the computer wins, the game will display a message telling you that you lost. If the game board is full and there is no winner, the game will display a message saying that it's a tie.

How the AI Algorithm Works

The computer player uses a simple AI algorithm called minimax to make decisions on where to place its mark. The algorithm works by exploring all possible future moves and choosing the one that leads to the best outcome.

The minimax algorithm assigns a score to each possible move based on the outcome of the game that would result from that move. If the move leads to a win for the computer player, it gets a score of 10. If it leads to a win for the human player, it gets a score of -10. If it leads to a tie, it gets a score of 0.

The algorithm recursively explores all possible future moves, alternating between maximizing the computer player's score and minimizing the human player's score. The final score for a given move is the maximum score for the computer player if it's the computer player's turn, or the minimum score for the human player if it's the human player's turn.

The computer player chooses the move with the highest score. If there are multiple moves with the same highest score, it chooses one at random.
