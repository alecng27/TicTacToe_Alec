import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private Random random;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        random = new Random();
        initializeBoard();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;
        while (!isGameOver) {
            if (currentPlayer == 'X') {
                displayBoard();
                int[] move = getPlayerMove(scanner);
                makeMove(move);
                if (isWinningMove()) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " has won!");
                    isGameOver = true;
                } else if (isBoardFull()) {
                    displayBoard();
                    System.out.println("It's a tie!");
                    isGameOver = true;
                } else {
                    currentPlayer = 'O';
                }
            } else {
                displayBoard();
                int[] move = getComputerMove();
                System.out.println("Computer plays at row " + (move[0] + 1) + ", column " + (move[1] + 1));
                makeMove(move);
                if (isWinningMove()) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " has won!");
                    isGameOver = true;
                } else if (isBoardFull()) {
                    displayBoard();
                    System.out.println("It's a tie!");
                    isGameOver = true;
                } else {
                    currentPlayer = 'X';
                }
            }
        }
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    private void displayBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private int[] getPlayerMove(Scanner scanner) {
        int[] move = new int[2];
        boolean isValidMove = false;
        while (!isValidMove) {
            System.out.print("Enter row and column (e.g. 1 2): ");
            move[0] = scanner.nextInt() - 1;
            move[1] = scanner.nextInt() - 1;
            if (isValidMove(move)) {
                isValidMove = true;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        return move;
    }

    private boolean isValidMove(int[] move) {
        int row = move[0];
        int col = move[1];
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if (board[row][col] != '-') {
            return false;
        }
        return true;
    }

    private void makeMove(int[] move) {
        int row = move[0];
        int col = move[1];
        board[row][col] = currentPlayer;
    }
    
    private boolean isWinningMove() {
        // check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != '-' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }
    
        // check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != '-' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }
    
        // check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
    
        return false;
    }
    
    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int[] getComputerMove() {
        int[] bestMove = new int[2];
        int bestScore = Integer.MIN_VALUE;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    board[row][col] = 'O';
                    int score = minimax(0, false);
                    board[row][col] = '-';
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = row;
                        bestMove[1] = col;
                    }
                }
            }
        }
        return bestMove;
    }
    
    private int minimax(int depth, boolean isMaximizing) {
        if (isWinningMove()) {
            return isMaximizing ? -10 : 10;
        }
        if (isBoardFull()) {
            return 0;
        }
    
        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    board[row][col] = isMaximizing ? 'O' : 'X';
                    int score = minimax(depth + 1, !isMaximizing);
                    board[row][col] = '-';
                    if (isMaximizing) {
                        bestScore = Math.max(bestScore, score);
                    } else {
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
        }
        return bestScore;
    }
    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}    
