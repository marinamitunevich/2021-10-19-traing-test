package main.com.lottery.exceptions;

public class IncorrectRangeOfUnluckyNumbers2from10 extends Exception{

    private String messages;
    public IncorrectRangeOfUnluckyNumbers2from10(String s) {
        this.messages = s;
    }
    public String getMessages(){
        return messages;
    }
}
