import java.util.InputMismatchException;
import java.util.Scanner;
public class Game {
    Deck deck = new Deck();
    Card win = new Card();
    private Card []boardplayer = new Card[9];
    private Card[] boardComp =new Card [9];
    private int playersum =0;
    private int compsum =0;
    private int counter =0;
    private int playerboardcounter = 0;
    private int compboardcounter = 0;
    private int playerhelp = 0;

    public int getPlayerhelp() {
        return playerhelp;
    }

    public void setPlayerhelp(int playerhelp) {
        this.playerhelp = playerhelp;
    }

    Scanner sc = new Scanner(System.in);
    public void Play() {
        System.out.println("GAME IS STARTING");
        System.out.println("-----------------------");
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


    }

    public void CardSelectPlayer() {
        Scanner sc = new Scanner(System.in);
        int selected;

        do {
            try {
                System.out.println();
                System.out.println("Choose a card position to play or enter '0' to take a card from the deck or enter 5 to stay");
                String input = sc.nextLine();
                selected = Integer.parseInt(input);

                if (selected == 0) {
                    setPlayerhelp(1);
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
                    while (selected >= 1 && selected <= 4) {
                        if (playerboardcounter == 0 && deck.getDeckplayerSeletcted()[selected - 1].getColor()== null) {
                            System.out.println("You can not play the special card as a first card");
                            selected = sc.nextInt();
                        } else {
                            break;
                        }
                    }

                    if (deck.getDeckplayerSeletcted()[selected - 1] == null) {
                        System.out.println("Your choice is null, please choose again.");
                    } else {
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

                    setPlayerhelp(5);

                    counter =0;
                    for(int i=0;i<deck.getDeckcompSeletcted().length;i++) {
                        if(deck.getDeckcompSeletcted()[i] != null) {
                            if(compsum + deck.getDeckcompSeletcted()[i].getNum() >17) {
                                boardComp[compboardcounter] = deck.getDeckcompSeletcted()[i];
                                compsum += deck.getDeckcompSeletcted()[i].getNum();
                                compboardcounter++;
                                deck.getDeckcompSeletcted()[i] = null;

                            }
                        }
                    }

                    if(compsum<16) {
                        boolean x = true;
                        while(x==true) {
                            if(deck.getDeck()[counter] != null) {
                                boardComp[compboardcounter] = deck.getDeck()[counter];
                                compsum += boardComp[compboardcounter].getNum();
                                deck.getDeck()[counter] = null;
                                compboardcounter++;
                                if (compsum>16) {
                                    x=false;
                                }
                            }
                            counter++;
                        }

                    }
                } else if(selected == 5){
                    setPlayerhelp(5);
                    counter =0;
                    for(int i=0;i<deck.getDeckcompSeletcted().length;i++) {
                        if(deck.getDeckcompSeletcted()[i] != null) {
                            if(compsum + deck.getDeckcompSeletcted()[i].getNum() >10) {
                                boardComp[compboardcounter] = deck.getDeckcompSeletcted()[i];
                                compsum += deck.getDeckcompSeletcted()[i].getNum();
                                compboardcounter++;
                                deck.getDeckcompSeletcted()[i] = null;
                            }
                        }
                    }
                    if(compsum<16) {

                        boolean x = true;
                        while(x==true) {
                            if(deck.getDeck()[counter] != null) {
                                boardComp[compboardcounter] = deck.getDeck()[counter];
                                compsum += boardComp[compboardcounter].getNum();
                                deck.getDeck()[counter] = null;
                                compboardcounter++;
                                if (compsum>16) {
                                    x=false;
                                }
                            }
                            counter++;
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
                    System.out.println("*************************");
                }else {
                    System.out.println("Please enter a valid input (0 to take a card or 1-4 to play a card)");
                    selected = -1; // Geçersiz giriş durumunda döngüyü tekrarlamak için -1 atıyoruz
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                selected = -1; // Geçersiz giriş durumunda döngüyü tekrarlamak için -1 atıyoruz
            }
        } while (selected < 0 || selected > 5); // Doğru giriş yapana kadar döngüyü devam ettir


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
        if(getPlayerhelp() != 5) {
            do {
                try {
                    System.out.println("Do you want to play a card or take a card from the deck?");
                    System.out.println("1) YES 2) NO");
                    String input = sc.nextLine();
                    yesno = Integer.parseInt(input);

                    if (yesno == 1) {
                        CardSelectPlayer();
                    } else if (yesno == 2) {

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
    }





    public void CardSelectComp() {
        counter =0;
        for(int i=0;i<deck.getDeckcompSeletcted().length;i++) {
            if(deck.getDeckcompSeletcted()[i] != null) {
                if(compsum + deck.getDeckcompSeletcted()[i].getNum() >17) {
                    boardComp[compboardcounter] = deck.getDeckcompSeletcted()[i];
                    compsum += deck.getDeckcompSeletcted()[i].getNum();
                    compboardcounter++;
                    deck.getDeckcompSeletcted()[i] = null;
                }
            }
        }

        if(compsum<16) {
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

        }
    }

    public void EndGame() {



        for (int i = 0;i<boardplayer.length;i++) {
            if(boardplayer[i] != null) {
                if(boardplayer[i].getSign() == "+") {
                    playersum+= boardplayer[i].getNum();
                } else {
                    playersum-= boardplayer[i].getNum();
                }
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
        //-------------------------------------------------------------------W--------------
        System.out.println();
        System.out.println("----------------------------");
        if(playersum == compsum) {
            win.setCompwin(win.getCompwin()+1);
            win.setPlayerwin(win.getPlayerwin()+1);
            System.out.println("IT IS DRAW");
            System.out.println(compsum);
            System.out.println(playersum);
        } else if(playersum > compsum && playersum < 21) {
            int bluecounter=0;
            int nullcounter =0;
            if(compsum == 20) {
                for(int i=0;i<boardplayer.length;i++) {
                    if (boardplayer[i] != null ) {
                        if(boardplayer[i].getColor().equals("B")){
                            bluecounter++;
                        }
                    } else {
                        nullcounter++;
                    }
                }
                if(bluecounter == boardplayer.length-nullcounter) win.setPlayerwin(3);
            } else{
                win.setPlayerwin(win.getPlayerwin()+1);
            }

            System.out.println("Summation is-> " + "Player: " + playersum + " Comp: " + compsum);
        } else if(compsum > playersum && compsum < 21) {
            int bluecounter=0;
            int nullcounter =0;
            if(compsum == 20) {
                for(int i=0;i<boardComp.length;i++) {
                    if (boardComp[i] != null ) {
                        if(boardComp[i].getColor().equals("B")){
                            bluecounter++;
                        }
                    } else {
                        nullcounter++;
                    }
                }
                if(bluecounter == boardComp.length-nullcounter) win.setCompwin(3);
                win.setCompwin(win.getCompwin()+1);
            } else{
                win.setCompwin(win.getCompwin()+1);
            }

            System.out.println("Summation is-> " + "Player: " + playersum + " Comp: " + compsum);
        } else if(compsum>20) {
            win.setPlayerwin(win.getPlayerwin()+1);
            System.out.println("Summation is-> " + "Player: " + playersum + " Comp: " + compsum);
        } else if(playersum>20) {
            win.setCompwin(win.getCompwin()+1);
            System.out.println("Summation is-> " + "Player: " + playersum + " Comp: " + compsum);
        }
        System.out.println("Player Win Total: " + win.getPlayerwin());
        System.out.println("Computer Win Total: " +win.getCompwin());


    }
    public void Clear()  {


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
    public void Finish() {
        if (win.getCompwin() == 3 || win.getPlayerwin() == 3) {
            if (win.getCompwin() > win.getPlayerwin()) {
                System.out.println("COMPUTER WON");
            } else {
                System.out.println("PLAYER WON");

            }
        }
    }

}
