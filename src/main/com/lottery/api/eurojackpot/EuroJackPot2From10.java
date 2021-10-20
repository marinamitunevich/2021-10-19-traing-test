package main.com.lottery.api.eurojackpot;

import main.com.lottery.api.BaseLottery;
import main.com.lottery.exceptions.IncorrectRangeOfUnluckyNumber;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EuroJackPot2From10 extends BaseLottery {

    protected EuroJackPot2From10(String lotteryName) {
        super(lotteryName, 1, 10, 2, "unluckyNumber2aus10.log");
    }

}
