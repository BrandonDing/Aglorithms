package ag.basic;

/**
 * Created by Abner on 3/30/2017.
 */
public class Card {
    private String color;
    private int number;

    public Card(){

    }

    public Card(String color, int number){
        this.color = color;
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return this.color + "\t" + this.number;
    }
}
