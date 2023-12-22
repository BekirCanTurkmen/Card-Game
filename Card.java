public class Card {
    private String color;
    private int num;
    private String sign;

    private static  int playerwin;
    private static int compwin;


    public int getPlayerwin() {
        return playerwin;
    }
    public void setPlayerwin() {
        this.playerwin=playerwin++;
    }

    public int getCompwin() {
        return compwin;
    }
    public void setCompwin(int compwin) {
        this.compwin = compwin++;
    }

    public Card() {
        this.color="";
        this.num=0;
        this.sign="";
    }


    public Card(String color,int num, String sign) {
        this.color=color;
        this.num=num;
        this.sign=sign;
    }

    //------------------------------------SETANDGETCOLOR-----------------------------------

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    //------------------------------------SETANDGETSIGN-----------------------------------
    public String getSign() {return sign;}
    public void setSign(String sign) {this.sign = sign;}

    //------------------------------------SETANDGETNUM-----------------------------------
    public int getNum() {return num;}
    public void setNum(int num) {this.num = num;}
}
