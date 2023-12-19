import java.util.InputMismatchException;
import java.util.Scanner;
public class Game {
    Deck deck = new Deck();
    Main win = new Main();
    private Card []boardplayer = new Card[9];
    private Card[] boardComp =new Card [9];
    private int playersum =0;
    private int compsum =0;
    private int counter =0;
    private int playerboardcounter = 0;
    private int compboardcounter = 0;
    private int gameFinisher = 0;



    Scanner sc = new Scanner(System.in);
    public void Play() {

        //---------------------------------ShowingCardsToPlayerAndComp-------------------------------
        System.out.println("Your cards are: ");
        for (int i = 0; i < deck.getDeckplayerSeletcted().length ; i++) {
            if(deck.getDeckplayerSeletcted()[i] != null) {
                if (deck.getDeckplayerSeletcted()[i].getColor() == null) {
                    System.out.print((i+1) + ")"+deck.getDeckplayerSeletcted()[i].getSign()+ " ");
                } else {
                    System.out.print((i+1) + ")"+ deck.getDeckplayerSeletcted()[i].getColor() + deck.getDeckplayerSeletcted()[i].getNum() + deck.getDeckplayerSeletcted()[i].getSign()+ " ");
                }
            } else {
                System.out.print((i+1) + ") ");
            }
        }
        System.out.println("");
        System.out.println("---------------------------");
        System.out.println("Player Board");



        for (int i = 0; i < boardplayer.length ; i++) {
            if(boardplayer[i] != null) {
                if (boardplayer[i].getColor() == null) {
                    System.out.print(boardplayer[i].getSign()+ " ");
                }
                System.out.print(boardplayer[i].getColor() + boardplayer[i].getNum() + boardplayer[i].getSign()+" ");
            }
        }

        System.out.println();
        System.out.println("***************************");
        System.out.println("Computer Board");
        System.out.println("---------------------------");
        for (int i = 0; i < boardComp.length ; i++) {
            if(boardComp[i] != null) {
                if (boardComp[i].getColor() == null) {
                    System.out.print(boardComp[i].getSign()+ " ");
                }
                System.out.print(boardComp[i].getColor() + boardComp[i].getNum() + boardComp[i].getSign()+" ");
            }
        }

        System.out.println();
        System.out.println("Computer cards are: ");

        for (int i = 0; i < deck.getDeckcompSeletcted().length ; i++) {
            if (deck.getDeckplayerSeletcted()[i] == null) {
                System.out.print((i+1) + ")"+"O ");
            } else {
                System.out.print((i+1) + ")"+"X ");
            }
        }
        CardSelectPlayer();
    }

    public void CardSelectPlayer() {
        Scanner sc = new Scanner(System.in);
        /*System.out.println();
        System.out.println("Choose a card position to play or enter '0' to take card from the deck");
        int selected = sc.nextInt();
        // TRY CATCH YAZ 0 DEN KÜCÜK VEYA 4TEN BUYUKSE veya stringse TEKRAR İSTESİN
        if(selected == 0) {
            while (true) {
                if(deck.getDeck()[counter] != null) {
                    boardplayer[playerboardcounter] = deck.getDeck()[counter];
                    deck.getDeck()[counter] = null;
                    playerboardcounter++;
                    break;
                }
                counter++;
            }
        } else if ( selected-1>=0 && selected-1<4 ) {
            //NULL MU KONTROL ET NULL SE NULL SECMEYENE KADAR TEKRAR İSTE(WHİLE DA KULLANABİLİRSİN)

            if (deck.getDeckplayerSeletcted()[selected - 1] == null ) {
                System.out.println("your choice is null may u choose again");
                 }

            else{
                if (deck.getDeckplayerSeletcted()[selected - 1].getSign().equals("x2")) {
                    boardplayer[playerboardcounter] = boardplayer[playerboardcounter - 1];
                    deck.getDeckplayerSeletcted()[selected - 1] = null;
                    playerboardcounter++;
                } else if (deck.getDeckplayerSeletcted()[selected - 1].getSign().equals("+/-")) {
                    if (boardplayer[playerboardcounter - 1].getSign().equals("+")) {
                        boardplayer[playerboardcounter - 1].setSign("-");
                    } else if (boardplayer[playerboardcounter - 1].getSign().equals("-")) {
                        boardplayer[playerboardcounter - 1].setSign("+");
                    }
                    deck.getDeckplayerSeletcted()[selected - 1] = null;
                } else {
                    boardplayer[playerboardcounter] = deck.getDeckplayerSeletcted()[selected - 1];
                    deck.getDeckplayerSeletcted()[selected - 1] = null;
                    playerboardcounter++;
                }

            } }

         */
        int selected;

        do {
            try {
                System.out.println();
                System.out.println("Choose a card position to play or enter '0' to take a card from the deck");
                String input = sc.nextLine();
                selected = Integer.parseInt(input);

                if (selected == 0) {
                    // 0 seçeneğinde kart al
                    while (true) {
                        if (deck.getDeck()[counter] != null) {
                            boardplayer[playerboardcounter] = deck.getDeck()[counter];
                            deck.getDeck()[counter] = null;
                            playerboardcounter++;
                            break;
                        }
                        counter++;
                    }
                } else if (selected >= 1 && selected <= 4) {
                    // Seçilen kartın null olup olmadığını kontrol et
                    if (deck.getDeckplayerSeletcted()[selected - 1] == null) {
                        System.out.println("Your choice is null, please choose again.");
                    } else {
                        // Kartın özelliklerine göre işlem yap
                        if (deck.getDeckplayerSeletcted()[selected - 1].getSign().equals("x2")) {
                            boardplayer[playerboardcounter] = boardplayer[playerboardcounter - 1];
                            deck.getDeckplayerSeletcted()[selected - 1] = null;
                            playerboardcounter++;
                        } else if (deck.getDeckplayerSeletcted()[selected - 1].getSign().equals("+/-")) {
                            if (boardplayer[playerboardcounter - 1].getSign().equals("+")) {
                                boardplayer[playerboardcounter - 1].setSign("-");
                            } else if (boardplayer[playerboardcounter - 1].getSign().equals("-")) {
                                boardplayer[playerboardcounter - 1].setSign("+");
                            }
                            deck.getDeckplayerSeletcted()[selected - 1] = null;
                        } else {
                            boardplayer[playerboardcounter] = deck.getDeckplayerSeletcted()[selected - 1];
                            deck.getDeckplayerSeletcted()[selected - 1] = null;
                            playerboardcounter++;
                        }
                    }
                } else {
                    System.out.println("Please enter a valid input (0 to take a card or 1-4 to play a card)");
                    selected = -1; // Geçersiz giriş durumunda döngüyü tekrarlamak için -1 atıyoruz
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                selected = -1; // Geçersiz giriş durumunda döngüyü tekrarlamak için -1 atıyoruz
            }
        } while (selected < 0 || selected > 4); // Doğru giriş yapana kadar döngüyü devam ettir


        for (int i = 0;i<boardplayer.length;i++) {
            if(boardplayer[i] != null) {
                playersum+= boardplayer[i].getNum();
            }
        }
        System.out.println("---------------------------");
        System.out.println("Player Board");



        for (int i = 0; i < boardplayer.length ; i++) {
            if(boardplayer[i] != null) {
                if (boardplayer[i].getColor() == null) {
                    System.out.print(boardplayer[i].getSign()+ " ");
                }
                System.out.print(boardplayer[i].getColor() + boardplayer[i].getNum() + boardplayer[i].getSign()+" ");
            }
        }

        // KONTROL ET
        int yesno;
        System.out.println();
        do {
            try {
                System.out.println("Do you want to play a card or take a card from the deck?");
                System.out.println("1) YES 2) NO");
                String input = sc.nextLine();
                yesno = Integer.parseInt(input);

                if (yesno == 1) {
                    CardSelectPlayer();
                } else if (yesno == 2) {
                    CardSelectComp();
                    EndGame();
                    return;
                } else {
                    System.out.println("Please enter a valid option (1 for YES, 2 for NO).");
                    yesno = -1; // Set invalid input to repeat the loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1 for YES, 2 for NO).");
                yesno = -1; // Set invalid input to repeat the loop
            }
        } while (yesno < 1 || yesno > 2);
    }
        /*System.out.println("Do you want to play card or take a card from the deck");
        System.out.println("1)YES 2)NO ");
        int yesno = sc.nextInt();
        if(yesno == 1) {
            CardSelectPlayer();
        } else {
            CardSelectComp();
            EndGame();
            return;
        }
        CardSelectComp();
    }

         */

    public void CardSelectComp() {
        //BILGISAYAR ATMAMASI GEREKEN YERDE KART ATIYO KONTROL ET

        counter =0;
        for(int i=0;i<deck.getDeckcompSeletcted().length;i++) {
            if(deck.getDeckcompSeletcted()[i] != null) {
                if(compsum + deck.getDeckcompSeletcted()[i].getNum() == 20 || compsum + deck.getDeckcompSeletcted()[i].getNum() ==19) {
                    boardComp[compboardcounter] = deck.getDeckcompSeletcted()[i];
                    compsum += deck.getDeckcompSeletcted()[i].getNum();
                    compboardcounter++;
                    deck.getDeckcompSeletcted()[i] = null;
                    EndGame();
                    return;
                }
            }
        }
        boolean x = true;
        while(x==true) {
            if(deck.getDeck()[counter] != null) {
                boardComp[compboardcounter] = deck.getDeck()[counter];
                compsum += boardComp[compboardcounter].getNum();
                deck.getDeck()[counter] = null;
                compboardcounter++;
                x=false;
            }
            counter++;
        }
        System.out.println();
        System.out.println("***************************");
        System.out.println("Computer Board");
        System.out.println("---------------------------");
        for (int i = 0; i < boardComp.length ; i++) {
            if(boardComp[i] != null) {
                if (boardComp[i].getColor() == null) {
                    System.out.print(boardComp[i].getSign()+ " ");
                }
                System.out.print(boardComp[i].getColor() + boardComp[i].getNum() + boardComp[i].getSign()+" ");
            }
        }
        System.out.println();
        System.out.println("*************************");
        if(compsum > 16) {
            EndGame();
        } else {
            Play();
        }
    }

    public void EndGame() {
        if(playersum == compsum) {
            win.setCompwin(1);
            win.setPlayerwin(1);
            System.out.println("IT IS DRAW");
            System.out.println("NEW GAME IS STARTING");
        } else if(playersum > compsum && playersum < 21) {
            win.setPlayerwin(1);
        } else if(compsum > playersum && compsum < 21) {
            win.setCompwin(1);
        }
        if(win.getCompwin()==3 || win.getPlayerwin()==3) {
            if (win.getCompwin()> win.getPlayerwin()) {
                System.out.println("Computer won the game");
            } else {
                System.out.println("You won the game");

            }

        }
        playersum =0;
        compsum=0;
        counter =0;
        compboardcounter=0;
        playerboardcounter=0;

        for (int i = 0;i<boardplayer.length;i++) {
            boardplayer[i] = null;
            boardComp[i]=null;
        }

    }
}
