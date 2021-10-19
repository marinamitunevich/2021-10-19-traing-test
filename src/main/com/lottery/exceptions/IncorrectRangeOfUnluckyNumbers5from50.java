package main.com.lottery.exceptions;

public class IncorrectRangeOfUnluckyNumbers5from50 extends Exception{

    private String messages;
    public IncorrectRangeOfUnluckyNumbers5from50(String s) {
        this.messages = s;
    }
    public String getMessages(){
        return messages;
    }
}
