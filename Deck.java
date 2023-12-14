import java.util.Random;
public class Deck {
    Card card = new Card();
    private Card[] Deck = new Card[40];
    Random r = new Random();

    public void CreateDeck() {

        int helper = r.nextInt(2);
        for (int i = 0; i < 10; i++) {

            Deck[i] = new Card("R", (i + 1));

        }

        for (int i = 10; i < 20; i++) {


            Deck[i] = new Card("Y", (i + 1) - 10);

        }

        for (int i = 20; i < 30; i++) {

            Deck[i] = new Card("B", (i + 1) - 20);

        }

        for (int i = 30; i < 40; i++) {

            Deck[i] = new Card("G", (i + 1) - 30);

        }

        Shuffle();


        //--------------------------------------------------------------------------
        Card[] deckplayer = new Card[10];
        Card[] deckcomp = new Card[10];
        Card[] deckplayerSeletcted = new Card[4];
        Card[] deckcompSeletcted = new Card[4];
        int cardhelper = r.nextInt(40);
        boolean x = true;
        int counter = 0;


        //------------------------------------------------------------DEALTOPLAYER
        /*
        for (int i =45;i<50;i++){

        deckplayer[counter]= Deck[i]}
        */

        while (x == true) {
            if (Deck[cardhelper].getNum() < 7) {
                deckplayer[counter] = Deck[cardhelper];
                counter++;
            }
            cardhelper = r.nextInt(40);

            if (deckplayer[2] != null) x = false;
        }

        cardhelper = r.nextInt(40);
        for (int i = 0; i < 2; i++) {
            x = true;
            while (x == true) {
                if (r.nextDouble() < 0.8) {
                    if (Deck[cardhelper].getNum() < 7) {
                        deckplayer[i + 3] = Deck[cardhelper];
                        x = false;
                    } else {
                        cardhelper = r.nextInt(40);
                    }
                } else {
                    if (cardhelper > 3) {
                        deckplayer[i + 3] = new Card(null, 0, "+/-");
                        x = false;
                    } else {
                        deckplayer[i + 3] = new Card(null, 0, "x2");
                        x = false;
                    }
                }
            }
        }
        counter = 0;
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(10);
            if(deckplayer[randomIndex]==null){
                  randomIndex = r.nextInt(10);}
            else {
                    deckplayerSeletcted[counter] = deckplayer[randomIndex];
                deckplayer[randomIndex]=null;
               counter++;
                }

        }


        //-----------------------------------------------------------DEALTOCOMP

/*
        for (int i =0;i<5;i++){

            deckplayer[counter]= Deck[i]}
            counter++; */
        cardhelper = r.nextInt(40);
        counter = 0;
        x = true;
        while (x == true) {
            if (Deck[cardhelper].getNum() < 7) {
                deckcomp[counter] = Deck[cardhelper];
                counter++;
            }
            cardhelper = r.nextInt(40);
            if (deckcomp[2] != null) x = false;
        }
        cardhelper = r.nextInt(40);
        for (int i = 0; i < 2; i++) {
            x = true;
            while (x == true) {
                if (r.nextDouble() < 0.8) {
                    if (Deck[cardhelper].getNum() < 7) {
                        deckcomp[i + 3] = Deck[cardhelper];
                        x = false;
                    } else {
                        cardhelper = r.nextInt(40);
                    }
                } else {
                    if (cardhelper > 2) {
                        deckcomp[i + 3] = new Card(null, 0, "+/-");
                        x = false;
                    } else {
                        deckcomp[i + 3] = new Card(null, 0, "x2");
                        x = false;
                    }
                }
            }
        }
        counter = 0;
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(10);
            if(deckcomp[randomIndex]==null){
                randomIndex = r.nextInt(10);}
            else {
                deckcompSeletcted[counter] = deckcomp[randomIndex];
                deckcomp[randomIndex]=null;
                counter++;
            }
        }
    }
    public void Shuffle() {

        for (int i = 0; i < Deck.length; i++) {
            int helper2 = r.nextInt(40);
            Card empty = Deck[i];
            Deck[i] = Deck[helper2];
            Deck[helper2] = empty;
        }
    }
}
