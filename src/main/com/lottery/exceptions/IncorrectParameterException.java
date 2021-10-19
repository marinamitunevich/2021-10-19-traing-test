package main.com.lottery.exceptions;


public class IncorrectParameterException extends Exception {

    private String messages;
    public IncorrectParameterException(String s) {
        this.messages = s;
    }
    public String getMessages(){
        return messages;
    }
}
