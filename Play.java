import java.util.Scanner;

public class Play {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String playAgain = "y";

        while (playAgain.equalsIgnoreCase("y")) {

            TicTacToe game = new TicTacToe();
            game.play();
            
            System.out.println("Do you want to play again? (y/n)");
            playAgain = scanner.nextLine();

            if (playAgain.equalsIgnoreCase("n")) {
                System.out.println("-------Thank you for playing at Alec's!-------");
            }
        }
        scanner.close();
    }
}
