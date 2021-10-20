package main.com.lottery.api;

import main.com.lottery.exceptions.IncorrectRangeOfUnluckyNumber;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public abstract class BaseLottery implements Lottery {

    private static Logger log = Logger.getLogger(BaseLottery.class.getName());

    protected final String lotteryName;
    protected final int minLotteryNumber;
    protected final int maxLotteryNumber;
    protected final int lotteryCountNumbers;
    protected final String unluckyNumbersFile;

    protected BaseLottery(String lotteryName, int minLotteryNumber, int maxLotteryNumber, int lotteryCountNumbers, String unluckyNumbersFile) {
        this.lotteryName = lotteryName;
        this.minLotteryNumber = minLotteryNumber;
        this.maxLotteryNumber = maxLotteryNumber;
        this.lotteryCountNumbers = lotteryCountNumbers;
        this.unluckyNumbersFile = unluckyNumbersFile;
    }

    @Override
    public List<Integer> getUnluckyNumbers() {

        List<Integer> unluckyNumbers = new LinkedList<>();

        String line = "";
        BufferedReader br = null;
        StringBuffer dataFromFile = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(unluckyNumbersFile));
            while ((line = br.readLine()) != null) {
                if (!line.isBlank())
                    dataFromFile.append(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.log(Level.SEVERE, "FileNotFoundException: ", e);
        } catch (IOException e) {
            e.printStackTrace();
            log.log(Level.SEVERE, "IOException: ", e);
        }
        ;

        line = dataFromFile.toString();
        unluckyNumbers = Arrays.stream(line.split(" ")).map(s -> Integer.valueOf(s)).collect(Collectors.toList());

        return unluckyNumbers;
    }

    @Override
    public String getLotteryName() {
        return lotteryName;
    }

    @Override
    public void generateNumbers() {

        List<Integer> generatedNumbers = new LinkedList<>();

        Random rand = new Random();
        while (generatedNumbers.size() < lotteryCountNumbers) {

            int randomNum = rand.nextInt((maxLotteryNumber - minLotteryNumber) + 1) + minLotteryNumber;

            if (!generatedNumbers.contains(randomNum) && !getUnluckyNumbers().contains(randomNum))
                generatedNumbers.add(randomNum);
        }

        System.out.println(generatedNumbers.stream().sorted().collect(Collectors.toList()));
    }

    @Override
    public void addUnluckyNumbers() {

        System.out.println("enter unlucky numbers for " + getLotteryName() + " and please split with blank:");
        Scanner readerFromConsole = new Scanner(System.in);

        String unluckyNumbers = "";
        boolean condition = true;

        while (condition) {
            unluckyNumbers = readerFromConsole.nextLine();
            try {
                if (!(Arrays.stream(unluckyNumbers.split(" ")).map(s -> Integer.valueOf(s))
                        .allMatch(integer -> integer <= maxLotteryNumber && integer >= minLotteryNumber)
                        && unluckyNumbers.split(" ").length <= 6))
                    throw new IncorrectRangeOfUnluckyNumber("unlucky number should be in the range [" + minLotteryNumber + "," +
                            maxLotteryNumber + "] and it is allowed maximum 6 unlucky numbers");
                else
                    condition = false;

            } catch (IncorrectRangeOfUnluckyNumber e) {
                System.out.println(e.getMessages());
                log.log(Level.SEVERE, "IncorrectRangeOfUnluckyNumber: ", e);

            } catch (NumberFormatException e) {
                System.out.println("invalid format of numbers");
                log.log(Level.SEVERE, "NumberFormatException: ", e);
            }

        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(unluckyNumbersFile));
            bw.write(unluckyNumbers);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            log.log(Level.SEVERE, "IOException: ", e);
        }
    }

    @Override
    public void removeUnluckyNumbers() {

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(unluckyNumbersFile));
            bw.write("");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            log.log(Level.SEVERE, "IOException: ", e);
        }
        System.out.println("Attention unlucky numbers for "+getLotteryName()+" are deleted");
    }
}
