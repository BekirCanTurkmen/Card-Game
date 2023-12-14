public class Card{
    private String color;
    private int num;
    private String sign;

    public Card() {
        this.color=color;
        this.num=num;
        this.sign=sign;
    }

    public Card(String color,int num, String sign) {
        this.color=color;
        this.num=num;
        this.sign=sign;
    }
    public Card(String color,int num) {
        this.color=color;
        this.num=num;

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