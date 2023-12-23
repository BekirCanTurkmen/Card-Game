import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final int MAX_GAMES = 10;
    private static final String FILENAME = "game_history.txt";

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.CreateDeck();
        Game game = new Game();
        Card card=new Card();

        Scanner input = new Scanner(System.in);
        System.out.print("Oyuncu ismini girin: ");
        String playerName = input.nextLine();


        while(true) {

            game.Play();
            game.CardSelectPlayer();
            if(game.getPlayerhelp()==5) {

            } else if(game.getPlayerhelp()==1) {
                while(game.getPlayerhelp()==1){
                    game.CardSelectComp();
                    game.CardSelectPlayer();
                }
            } else {
                game.CardSelectComp();
            }
            game.EndGame();
            game.Clear();
            if(card.getPlayerwin()==3|| card.getCompwin() ==3) {
                break;
            }

        }
        game.Finish();



        gameFinished(playerName, card.getPlayerwin(), card.getCompwin());


        printGameHistory();
    }

    private static void gameFinished(String playerName, int playerScore, int computerScore) {
        LocalDate date = LocalDate.now();
        String gameResult = String.format("%s:%d - Bilgisayar:%d, %s", playerName, playerScore, computerScore, date);

        saveHistoryToFile(gameResult);
    }

    private static void saveHistoryToFile(String newGame) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            writer.write(newGame);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printGameHistory() {
        // Geçmişi oku ve yazdır
    }
}