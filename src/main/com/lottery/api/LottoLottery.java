package main.com.lottery.api;

import main.com.lottery.exceptions.IncorrectRangeOfUnluckyNumber;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LottoLottery extends BaseLottery {


    public LottoLottery() {
        super("Lotto", 1, 49, 6, "unluckyNumber6aus49.log");
    }

//    @Override
//    public List<Integer> generateNumbers() {
//
//         return new Random()
//                 .ints(6,5,50)
//                 .filter(value -> !getUnluckyNumbers().contains(value))
//                 .distinct().boxed().sorted().collect(Collectors.toList());
//
//    }

    @Override
    public String getLotteryName() {
        return super.getLotteryName();
    }

}
