package main.com.lottery.api.eurojackpot;

import main.com.lottery.api.BaseLottery;
import main.com.lottery.exceptions.IncorrectRangeOfUnluckyNumber6from49;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EuroJackPot5From50 extends BaseLottery {

    final static String unluckyNumbers5from50 = "unluckyNumber5aus50.log";
    protected List<Integer> unluckyNumbers;

    protected EuroJackPot5From50(String lotteryName) {
        super(lotteryName);
    }

    @Override
    public List<Integer> generateNumbers() {

        return new Random()
                .ints(6,5,51)
                .filter(value -> !getUnluckyNumbers().contains(value))
                .distinct().boxed().sorted().collect(Collectors.toList());
    }

    @Override
    public List<Integer> getUnluckyNumbers() {

        String line = "";
        BufferedReader br = null;
        StringBuffer dataFromFile = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(unluckyNumbers5from50));
            while ((line = br.readLine()) != null){
                if (!line.isBlank())
                    dataFromFile.append(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };

        line = dataFromFile.toString();
        unluckyNumbers = Arrays.stream(line.split(" ")).map(s -> Integer.valueOf(s)).collect(Collectors.toList());

        return unluckyNumbers;
    }

    @Override
    public void addUnluckyNumbers() {

        System.out.println("enter unlucky numbers for 5aus50 and please split with blank:");
        Scanner readerFromConsole = new Scanner(System.in);

        String unluckyNumbers = "";
        boolean condition = true;

        while (condition) {
            unluckyNumbers = readerFromConsole.nextLine();
            try {
                if (!(Arrays.stream(unluckyNumbers.split(" ")).map(s -> Integer.valueOf(s))
                        .allMatch(integer -> integer <= 50 && integer >= 5)
                        && unluckyNumbers.split(" ").length <= 6))
                    throw new IncorrectRangeOfUnluckyNumber6from49("unlucky number should be in the range [5,50] and it is allowed maximum 6 unlucky numbers");
                else
                    condition = false;

            } catch (IncorrectRangeOfUnluckyNumber6from49 e) {
                System.out.println(e.getMessages());

            } catch (NumberFormatException e) {
                System.out.println("invalid format of numbers");
            }

        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(unluckyNumbers5from50));
            bw.write(unluckyNumbers);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeUnluckyNumbers() {

    }
}
