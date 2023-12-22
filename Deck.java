import java.util.Random;
public class Deck {
    Card card = new Card();
    private static Card[] Deck = new Card[40];
    private Card[] DeckSign = new Card[48];
    private Card[] deckplayer = new Card[10];
    private Card[] deckcomp = new Card[10];
    private static Card[] deckplayerSeletcted = new Card[4];
    private static Card[] deckcompSeletcted = new Card[4];
    boolean x = true;
    int counter = 0;
    Random r = new Random();
    int cardhelper = r.nextInt(40);

    //--------------------------------------------------------------------------------
    public Card[] getDeckplayerSeletcted() {
        return deckplayerSeletcted;
    }

    public void setDeckplayerSeletcted(Card[] deckplayerSeletcted) {
        this.deckplayerSeletcted = deckplayerSeletcted;
    }

    public Card[] getDeckcompSeletcted() {
        return deckcompSeletcted;
    }

    public void setDeckcompSeletcted(Card[] deckcompSeletcted) {
        this.deckcompSeletcted = deckcompSeletcted;
    }

    public Card[] getDeck() {
        return Deck;
    }

    public void setDeck(Card[] deck) {
        Deck = deck;
    }

    public Card[] getDeckplayer() {
        return deckplayer;
    }

    public void setDeckplayer(Card[] deckplayer) {
        this.deckplayer = deckplayer;
    }

    public Card[] getDeckcomp() {
        return deckcomp;
    }

    public Card[] getDeckSign() {
        return DeckSign;
    }

    public void setDeckSign(Card[] deckSign) {
        DeckSign = deckSign;
    }

    public void setDeckcomp(Card[] deckcomp) {
        this.deckcomp = deckcomp;
    }
    //--------------------------------------------------------------------------------

    public void CreateDeck() {

        int helper = r.nextInt(2);
        for (int i = 0; i < 10; i++) {
            Deck[i] = new Card("R", (i + 1), "+");
        }

        for (int i = 10; i < 20; i++) {
            Deck[i] = new Card("Y", (i + 1) - 10, "+");
        }

        for (int i = 20; i < 30; i++) {
            Deck[i] = new Card("B", (i + 1) - 20, "+");
        }

        for (int i = 30; i < 40; i++) {
            Deck[i] = new Card("G", (i + 1) - 30, "+");
        }

        Shuffle();


        //-------------------------------------------------DealingToSecondDeck------------------------------------------------------------------------------------

        for (int i = 0; i < 6; i++) { DeckSign[i] = new Card("R", (i + 1), "+");}
        for (int i = 6; i < 12; i++) { DeckSign[i] = new Card("R", (i + 1)-6, "-");}

        for (int i = 12; i < 18; i++) {DeckSign[i] = new Card("Y", (i + 1) - 12, "+");}
        for (int i = 18; i < 24; i++) {DeckSign[i] = new Card("Y", (i + 1) - 18, "-");}

        for (int i = 24; i < 30; i++) {DeckSign[i] = new Card("B", (i + 1) - 24, "+");}
        for (int i = 30; i < 36; i++) {DeckSign[i] = new Card("B", (i + 1) - 30, "-");}

        for (int i = 36; i < 42; i++) {DeckSign[i] = new Card("G", (i + 1) - 36, "+");}
        for (int i = 42; i < 48; i++) {DeckSign[i] = new Card("G", (i + 1) - 42, "-");}

        //--------------------------------------------------------------------------








        //------------------------------------------------------------DEALTOPLAYER
        //---------------------------------------------------Dealingfirst5card---------------------------------
        while (x == true) {
            if(Deck[cardhelper] != null) {
                deckplayer[counter] = Deck[cardhelper];
                Deck[cardhelper] = null;
                counter++;
            }
            if(deckplayer[4] != null) {
                x= false;
            }
            cardhelper = r.nextInt(40);
        }
        //-----------------------------------------Dealing3More----------------------------------

        counter=5;
        x=true;
        while (x == true) {
            if (DeckSign[cardhelper].getNum() < 7) {
                deckplayer[counter] = DeckSign[cardhelper];
                counter++;
            }
            cardhelper = r.nextInt(48);

            if (deckplayer[7] != null){
                x = false;
            }
        }
        //------------------------------------Last2ForSpecial--------------------------
        cardhelper = r.nextInt(48);
        for (int i = 8; i < 10; i++) {
            x = true;
            while (x == true) {
                if (r.nextDouble() < 0.8) {
                    if (DeckSign[cardhelper].getNum() < 7) {
                        deckplayer[i] = DeckSign[cardhelper];
                        x = false;
                    } else {
                        cardhelper = r.nextInt(48);
                    }
                } else {
                    if (cardhelper >= 24) {
                        deckplayer[i] = new Card(null, 0, "+/-");
                        x = false;
                    } else {
                        deckplayer[i] = new Card(null, 0, "x2");
                        x = false;
                    }
                }
            }
        }

        //---------------------------------------------------------------------Choosing4Card
        counter = 0;
        x=true;
        while (x == true) {
            int randomIndex = r.nextInt(10);
            if (deckplayer[randomIndex] != null) {
                deckplayerSeletcted[counter] = deckplayer[randomIndex];
                deckplayer[randomIndex] = null;
                counter++;
            }
            if(counter == 4) {
                x=false;
            }
        }
        //-----------------------------------------------------------DEALTOCOMP



        cardhelper = r.nextInt(40);
        counter = 0;
        x = true;
        //---------------------------------------------------Dealingfirst5card------------------------------
        while (x == true) {
            if(Deck[cardhelper] != null) {
                deckcomp[counter] = Deck[cardhelper];
                Deck[cardhelper] = null;
                counter++;
            }
            if(deckcomp[4] != null) {
                x= false;
            }
            cardhelper = r.nextInt(40);
        }
        //-----------------------------------------Dealing3More-------------------------------------------
        counter=5;

        x=true;
        while (x == true) {
            if (DeckSign[cardhelper].getNum() < 7) {
                deckcomp[counter] = DeckSign[cardhelper];
                counter++;
            }
            cardhelper = r.nextInt(48);

            if (deckcomp[7] != null) x = false;
        }
        //------------------------------------Last2ForSpecial--------------------------
        cardhelper = r.nextInt(48);
        for (int i = 8; i < 10; i++) {
            x = true;
            while (x == true) {
                if (r.nextDouble() < 0.8) {
                    if (DeckSign[cardhelper].getNum() < 7) {
                        deckcomp[i] = DeckSign[cardhelper];
                        x = false;
                    } else {
                        cardhelper = r.nextInt(48);
                    }
                } else {
                    if (cardhelper >= 24) {
                        deckcomp[i] = new Card(null, 0, "+/-");
                        x = false;
                    } else {
                        deckcomp[i] = new Card(null, 0, "x2");
                        x = false;
                    }
                }
            }
        }

        //-----------------------------------------Choosing4Card---------------------------------
        x=true;
        counter=0;
        while (x == true) {
            int randomIndex = r.nextInt(10);
            if (deckcomp[randomIndex] != null) {
                deckcompSeletcted[counter] = deckcomp[randomIndex];
                deckcomp[randomIndex] = null;
                counter++;
            }
            if(counter == 4) {
                x=false;
            }
        }

        setDeckplayerSeletcted(deckplayerSeletcted);
        setDeckcompSeletcted(deckcompSeletcted);


    }
    public void Shuffle () {

        for (int i = 0; i < Deck.length; i++) {
            int helper2 = r.nextInt(40);
            Card empty = Deck[i];
            Deck[i] = Deck[helper2];
            Deck[helper2] = empty;
        }
    }
}