package main.com.lottery.api;

import java.util.List;

public interface Lottery extends UnluckyNumbers {
    List<Integer> generateNumbers();
    String getLotteryName();
}
