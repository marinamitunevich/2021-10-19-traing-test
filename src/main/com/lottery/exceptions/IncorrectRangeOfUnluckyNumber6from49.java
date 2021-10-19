package main.com.lottery.exceptions;

public class IncorrectRangeOfUnluckyNumber6from49 extends Exception{

    private String messages;
    public IncorrectRangeOfUnluckyNumber6from49(String s) {
        this.messages = s;
    }
    public String getMessages(){
        return messages;
    }
}
