/*import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
public class Main {

    private static   int MAX_GAMES = 10;
    private static   String FILENAME = "game_history.txt";

    private static String[] history;
    private static int gamesCounter;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.CreateDeck();
        Game game = new Game();
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
            Card card=new Card();
            if(card.getPlayerwin()==3|| card.getCompwin() ==3) {
                break;
            }

        }
        game.Finish();

        history = new String[MAX_GAMES];
        gamesCounter = 0;
        Scanner sc =new Scanner(System.in);
        // Oyun geçmişini temsil eden history adında bir dizi oluşturuyoruz.
        // gamesCounter, oyun sayısını izlemek için kullanılacak.
        System.out.println("enter your name");

        String name4player = sc.nextLine();

        while (true) {
            // Oyun döngüsü - mevcut oyun döngüsü kodu

            // Oyun bittikten sonra aşağıdaki kodu ekleyin:
            Card card=new Card();
            gameFinished(name4player, card.getPlayerwin(), card.getCompwin());

            // Game sınıfındaki Finish() metodunu çağırın ve ardından döngüyü sonlandırın.
            game.Finish();
            break; // Döngüyü sonlandırma koşulu
        }

        printGameHistory();
    }

    private static void gameFinished(String playerName, int playerScore, int computerScore) {
        LocalDate date = LocalDate.now();
        String gameResult = String.format("%s:%d - Bilgisayar:%d, %s", playerName, playerScore, computerScore, date);

        if (gamesCounter < MAX_GAMES) {
            history[gamesCounter] = gameResult;
            gamesCounter++;
        } else {
            shiftAndAdd(gameResult);
        }

        saveHistoryToFile();
    }

    private static void shiftAndAdd(String newGame) {
        for (int i = 0; i < MAX_GAMES - 1; i++) {
            history[i] = history[i + 1];
        }
        history[MAX_GAMES - 1] = newGame;
    }

    private static void saveHistoryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (String game : history) {
                if (game != null) {
                    writer.write(game);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printGameHistory() {
        System.out.println("Oyun Geçmişi:");
        for (String game : history) {
            if (game != null) {
                System.out.println(game);
            }
        }
    }
}
/*



  import java.io.BufferedWriter;
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

        history = new String[MAX_GAMES];
        gamesCounter = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Oyuncu ismini girin: ");
        String playerName = input.nextLine();

        while (true) {
            // Oyun döngüsü
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
                Card card=new Card();
                if(card.getPlayerwin()==3|| card.getCompwin() ==3) {
                    break;
                }

            }
            game.Finish();
            // Oyun bittikten sonra aşağıdaki kodu ekleyin:
            Card card= new Card();
            gameFinished(playerName, card.getPlayerwin(), card.getCompwin());

            game.Finish();
            break; // Döngüyü sonlandırma koşulu
        }

        printGameHistory();
    }

    private static void gameFinished(String playerName, int playerScore, int computerScore) {
        LocalDate date = LocalDate.now();
        String gameResult = String.format("%s:%d - Bilgisayar:%d, %s", playerName, playerScore, computerScore, date);

        if (gamesCounter < MAX_GAMES) {
            history[gamesCounter] = gameResult;
            gamesCounter++;
        } else {
            shiftAndAdd(gameResult);
        }

        saveHistoryToFile();
    }

    private static void shiftAndAdd(String newGame) {
        for (int i = 0; i < MAX_GAMES - 1; i++) {
            history[i] = history[i + 1];
        }
        history[MAX_GAMES - 1] = newGame;
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

    private static void printGameHistory() {
        System.out.println("Oyun Geçmişi:");
        for (int i = 0; i < gamesCounter; i++) {
            System.out.println(history[i]);
        }
    }
}
*/import java.io.BufferedWriter;
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
