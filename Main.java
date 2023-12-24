import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    private static final int MAX_GAMES = 10;
    private static final String FILENAME = "game_history.txt";

    private static String[] history;
    private static int gamesCounter;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.CreateDeck();
        Game game = new Game();
        Card card= new Card();

        history = new String[MAX_GAMES];
        gamesCounter = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Oyuncu ismini girin: ");
        String playerName = input.nextLine();

        loadGameHistory(); // Oyun geçmişini yükle

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


    }

    private static void gameFinished(String playerName, int playerScore, int computerScore) {
        LocalDate date = LocalDate.now();
        String gameResult = String.format("%s:%d - Computer:%d, %s", playerName, playerScore, computerScore, date);

        if (gamesCounter < MAX_GAMES) {
            history[gamesCounter] = gameResult;
            gamesCounter++;
        } else {
            shiftAndAdd(gameResult);
        }

        saveHistoryToFile();
    }

    private static void shiftAndAdd(String newGame) {
        for (int i = MAX_GAMES - 1; i > 0; i--) {
            history[i] = history[i - 1];
        }
        history[0] = newGame;

    }

    private static void saveHistoryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (int i = 0; i < gamesCounter; i++) {
                writer.write(history[i]);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadGameHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            
            
            
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null && i < MAX_GAMES) {
                history[i] = line;
                i++;
                gamesCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}