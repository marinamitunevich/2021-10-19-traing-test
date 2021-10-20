package main.com.lottery.api.eurojackpot;

import main.com.lottery.api.BaseLottery;
import main.com.lottery.exceptions.IncorrectRangeOfUnluckyNumber;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EuroJackPot5From50 extends BaseLottery {

    protected EuroJackPot5From50(String lotteryName) {
        super(lotteryName, 1, 50, 5, "unluckyNumber5aus50.log");
    }
}
