package main.com.lottery.api;

import java.util.List;

public interface Lottery extends UnluckyNumbers {
    void generateNumbers();
    String getLotteryName();
}
